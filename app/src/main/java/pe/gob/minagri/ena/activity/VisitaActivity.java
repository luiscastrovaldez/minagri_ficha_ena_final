package pe.gob.minagri.ena.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.DatePickerFragment;
import pe.gob.minagri.ena.util.TimePickerFragment;
import pe.gob.minagri.ena.util.Util;

public class VisitaActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private FloatingActionButton btnGuardarVisita, btnSalir;
    private String segmentoEmpresa, nroParcela, dni;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private String formulario;

    private EditText fecha_encuesta,hora_inicio,hora_fin,fecha_proxima,hora_proxima,resultado_otro;
    private Spinner resultado;
    private LinearLayout Bloque1204;

    private Integer campoHora;
    private Integer campoFecha;
    private String index,size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);
        inicializarCapitulo();
        obternerFormulario();
        btnGuardarVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(VisitaActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setTitle(getResources().getString(R.string.titulo_guardar))
                        .setMessage(getResources().getString(R.string.titulo_guardar_pregunta))
                        .setPositiveButton(getResources().getString(R.string.si), new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                guardarFormulario();
                            }
                        })
                        .setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_cancelar_confirmacion), Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }


        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        resultado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int dato = new Integer(((Combo) adapterView.getItemAtPosition(i)).getId());
                if(dato == 0 || dato == 1){
                    Bloque1204.setVisibility(View.GONE);
                }else{
                    Bloque1204.setVisibility(View.VISIBLE);
                    if (dato == 6) {
                        resultado_otro.setVisibility(View.VISIBLE);
                    } else {
                        resultado_otro.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void inicializarCapitulo(){
        fecha_encuesta = (EditText) findViewById(R.id.fecha_encuesta);
        hora_inicio = (EditText) findViewById(R.id.hora_inicio);
        hora_fin = (EditText) findViewById(R.id.hora_fin);
        fecha_proxima = (EditText) findViewById(R.id.fecha_proxima);
        hora_proxima = (EditText) findViewById(R.id.hora_proxima);
        resultado = (Spinner) findViewById(R.id.resultado_visita);
        resultado_otro = (EditText) findViewById(R.id.resultado_visita_otro);

        Bloque1204 = (LinearLayout) findViewById(R.id.Bloque1204);

        btnGuardarVisita = (FloatingActionButton) findViewById(R.id.btnGuardarVisita);
        btnSalir = (FloatingActionButton) findViewById(R.id.btnSalirVisita);

        agregarEstado();
        campoHora = 0;
        campoFecha = 0;
        resultado_otro.setVisibility(View.GONE);
        Bloque1204.setVisibility(View.GONE);

        Intent intent = getIntent();
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        index = intent.getStringExtra(Constants.INDEX);
        size = intent.getStringExtra(Constants.SIZE);
        this.sqlHelper = new SqlHelper(getApplicationContext());
    }
    private void obternerFormulario(){
        if (!index.equals("-1")) {
            try {
                enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
                String jsonCap12 = enaForm.getCapitulo12();
                JSONObject object = new JSONObject(jsonCap12);
                JSONArray json_array = object.getJSONArray("visita");
                JSONObject dato = json_array.getJSONObject(new Integer(index.trim()));
                this.formulario = dato.toString();
                LinearLayout layout = findViewById(R.id.visitas);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    if (view instanceof LinearLayout) {
                        LinearLayout child = (LinearLayout) view;
                        for (int j = 0; j < child.getChildCount(); j++) {
                            View v = child.getChildAt(j);
                            Util.setearInformacion(getResources(), v, this.formulario);
                        }
                    } else {
                        Util.setearInformacion(getResources(), view, this.formulario);
                    }
                }
                String resultado = dato.getString("resultado_visita");
                if(!resultado.equals("1")){
                    Bloque1204.setVisibility(View.VISIBLE);
                    if(resultado.equals("6")){
                        resultado_otro.setVisibility(View.VISIBLE);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        try {
            formulario = Util.loadData(getAssets(), Constants.VISITA_FORMULARIO_JSON);
            LinearLayout layout = findViewById(R.id.visitas);
            for (int i = 0; i < layout.getChildCount(); i++) {
                View view = layout.getChildAt(i);
                if (view instanceof LinearLayout) {
                    LinearLayout child = (LinearLayout) view;
                    for (int x = 0; x < child.getChildCount(); x++) {
                        View v = child.getChildAt(x);
                        this.formulario = Util.generarJson(getResources(), v, this.formulario);
                    }
                } else {
                    this.formulario = Util.generarJson(getResources(), view, this.formulario);
                }
            }
            this.formulario = this.formulario.replace("codigo_usuario_value", "0");
            this.formulario = this.formulario.replace("modifico_value", "0");

            if (index.equals("-1")) {
                if (size.equals("0")) {
                    this.formulario = this.formulario.replace("num_visita_value", "1");
                } else {
                    this.formulario = this.formulario.replace("num_visita_value", (new Integer(size.trim()) + 1) + "");
                }
            } else {
                this.formulario = this.formulario.replace("num_visita_value", size);
            }

            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm == null) {
                enaForm = new EnaForm();
            }

            String jsonCap12 = enaForm.getCapitulo12();
            JSONObject dato = new JSONObject(this.formulario);
            if(jsonCap12 != null){
                JSONObject object = new JSONObject(jsonCap12);
                JSONArray json_array = object.getJSONArray("visita");
                if (index.equals("-1")){
                    json_array.put(dato);
                }else {
                    json_array.put(new Integer(index), dato);
                }
                this.formulario = object.toString();
            } else {
                jsonCap12 = Util.loadData(getAssets(), Constants.CAPITULO12_FORMULARIO_JSON);
                JSONObject object = new JSONObject(jsonCap12);
                JSONArray json_array = object.getJSONArray("visita");
                json_array.put(dato);
                this.formulario = object.toString();
            }

            enaForm.setCapitulo12(this.formulario);
            enaForm.setSegmentoEmpresa(segmentoEmpresa);
            enaForm.setNroParcela(nroParcela);
            enaForm.setDni(dni);
            sqlHelper.saveInformation(enaForm);
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        if(campoFecha == 1){
            fecha_encuesta.setText(format.format(c.getTime()));
        }else if (campoFecha == 2){
            fecha_proxima.setText(format.format(c.getTime()));
        }
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        String hora = formatoDosDigitos(hourOfDay) + ":" + formatoDosDigitos(minute);
        if(campoHora == 1){
            hora_inicio.setText(hora);
        }else if (campoHora == 2){
            hora_fin.setText(hora);
        }else if(campoHora == 3){
            hora_proxima.setText(hora);
        }
    }

    public void showDatePickerDialog(View v) {
        switch (v.getId()) {
            case R.id.fecha_encuesta:
                campoFecha = 1;
                break;
            case R.id.fecha_proxima:
                campoFecha = 2;
                break;
        }
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getSupportFragmentManager(), "datepicker");
    }
    public void showTimePickerDialog(View v) {
        switch (v.getId()) {
            case R.id.hora_inicio:
                campoHora = 1;
                break;
            case R.id.hora_fin:
                campoHora = 2;
                break;
            case R.id.hora_proxima:
                campoHora = 3;
                break;
        }
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
    private String formatoDosDigitos(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }
    private void agregarEstado() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Completa"));
        list.add(new Combo("2", "Incompleta"));
        list.add(new Combo("3", "Rechazo"));
        list.add(new Combo("4", "Ausente"));
        list.add(new Combo("5", "No se inició la entrevista"));
        list.add(new Combo("6", "Otro"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resultado.setAdapter(dataAdapter);
    }
}