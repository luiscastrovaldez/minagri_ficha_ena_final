package pe.gob.minagri.ena.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
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
import android.widget.ListView;
import android.widget.Spinner;
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
import pe.gob.minagri.ena.envio.Envio;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.DatePickerFragment;
import pe.gob.minagri.ena.util.ListCustomAdapter;
import pe.gob.minagri.ena.util.ListCustomAdapter.customButtonListener;
import pe.gob.minagri.ena.util.Util;

public class Capitulo12Activity extends AppCompatActivity implements customButtonListener, DatePickerDialog.OnDateSetListener {

    private FloatingActionButton btnGuardar12,btnVisita, btnSalir;
    private String segmentoEmpresa, nroParcela, dni;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private String formulario;

    private EditText fecha_resultado_encuesta,resultado_encuesta_otro;
    private Spinner resultado_encuesta;

    private ListView listViewVisita;
    private String size;
    private List<String> lstVisita;
    private ListCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo12);
        inicializarCapitulo();
        obternerFormulario();

        btnGuardar12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                AlertDialog alertDialog = new AlertDialog.Builder(Capitulo12Activity.this)
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
        btnVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VisitaActivity.class);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra(Constants.INDEX, "-1");
                intent.putExtra(Constants.SIZE, "" + size);
                startActivity(intent);
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        resultado_encuesta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int dato = new Integer(((Combo) adapterView.getItemAtPosition(i)).getId());
                if (dato == 6) {
                    resultado_encuesta_otro.setVisibility(View.VISIBLE);

                } else {
                    resultado_encuesta_otro.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        listViewVisita.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int itemPosition = position;

                Intent intent = new Intent(getApplicationContext(), VisitaActivity.class);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra(Constants.INDEX, "" + itemPosition);
                intent.putExtra(Constants.SIZE, "" + size);

                startActivity(intent);
            }
        });
        listViewVisita.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                final int posicion=i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Capitulo12Activity.this);
                dialogo1.setTitle(getResources().getString(R.string.titulo_eliminar));
                dialogo1.setMessage(getResources().getString(R.string.titulo_eliminar_dato));
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton(getResources().getString(R.string.si), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        try {
                            lstVisita.remove(posicion);
                            adapter.notifyDataSetChanged();
                            if (enaForm != null) {
                                formulario = enaForm.getCapitulo12();
                                if(formulario != null){
                                    JSONObject object = new JSONObject(formulario);
                                    JSONArray json_array = object.getJSONArray("visita");
                                    Object o = json_array.remove(posicion);
                                    int tamano = json_array.length();
                                    for (int i = 0; i < tamano; i++) {
                                        JSONObject dato= json_array.getJSONObject(i);
                                        dato.put("num_visita",(i+1)+"");
                                    }
                                    size = tamano + "";
                                    formulario = object.toString();
                                    grabarCapitulo();
                                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
                dialogo1.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });
    }
    @Override
    public void onButtonClickListner(int position, String value) {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Capitulo12Activity.this);
        dialogo1.setTitle(getResources().getString(R.string.titulo_eliminar));
        dialogo1.setMessage(getResources().getString(R.string.titulo_eliminar_dato));
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton(getResources().getString(R.string.si), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                try {
                    lstVisita.remove(position);
                    adapter.notifyDataSetChanged();
                    if (enaForm != null) {
                        formulario = enaForm.getCapitulo12();
                        if(formulario != null){
                            JSONObject object = new JSONObject(formulario);
                            JSONArray json_array = object.getJSONArray("visita");
                            Object o = json_array.remove(position);
                            int tamano = json_array.length();
                            for (int i = 0; i < tamano; i++) {
                                JSONObject dato= json_array.getJSONObject(i);
                                dato.put("num_visita",(i+1)+"");
                            }
                            size = tamano + "";
                            formulario = object.toString();
                            grabarCapitulo();
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        dialogo1.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });
        dialogo1.show();
    }
    @Override
    public void onResume(){
        super.onResume();
        cargarDatosLista();
    }

    private void inicializarCapitulo(){
        btnGuardar12 = (FloatingActionButton) findViewById(R.id.btnGuardar12);
        btnVisita = (FloatingActionButton) findViewById(R.id.btnVisita) ;
        btnSalir = (FloatingActionButton) findViewById(R.id.btnSalirCap12);

        fecha_resultado_encuesta = (EditText) findViewById(R.id.fecha_final);
        resultado_encuesta = (Spinner) findViewById(R.id.resultado_visita_final);
        resultado_encuesta_otro = (EditText) findViewById(R.id.resultado_visita_final_otro);

        listViewVisita = (ListView) findViewById(R.id.listViewVisitas);
        size = "0";
        lstVisita = new ArrayList<>();

        agregarEstado();

        resultado_encuesta_otro.setVisibility(View.GONE);

        Intent intent = getIntent();
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        this.sqlHelper = new SqlHelper(getApplicationContext());
    }
    private void obternerFormulario(){
        try {
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm != null) {
                this.formulario = enaForm.getCapitulo12();
                String fechaValue = Util.getJsonValue(this.formulario, "fecha_final");
                if (!fechaValue.contains("_value")) {
                    LinearLayout layout = findViewById(R.id.capitulo12);
                    for (int i = 0; i < layout.getChildCount(); i++) {
                        View view = layout.getChildAt(i);
                        Util.setearInformacion(getResources(), view, this.formulario);
                    }
                    if(Util.getJsonValue(this.formulario, "resultado_visita_final").equals("6")){
                        resultado_encuesta_otro.setVisibility(View.VISIBLE);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        try {
            formulario = Util.loadData(getAssets(), Constants.CAPITULO12_FORMULARIO_JSON);
            LinearLayout layout = findViewById(R.id.capitulo12);
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

            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm == null) {
                enaForm = new EnaForm();
            }

            String jsonCap12 = enaForm.getCapitulo12();
            if(jsonCap12 != null){
                JSONObject dato = new JSONObject(this.formulario);
                JSONObject object = new JSONObject(jsonCap12);
                JSONArray json_array = object.getJSONArray("visita");
                if(json_array.length() > 0){
                    dato.put("visita",json_array);
                    this.formulario = dato.toString();
                }
            }
            grabarCapitulo();
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void cargarDatosLista(){
        try {
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm != null) {
                this.formulario = enaForm.getCapitulo12();
                if(this.formulario != null){
                    if (lstVisita.size() > 0) {
                        lstVisita.clear();
                    }
                    JSONObject object = new JSONObject(this.formulario);
                    JSONArray json_array = object.getJSONArray("visita");
                    int tamano = json_array.length();
                    if(tamano != 0){
                        for (int i = 0; i < tamano; i++) {
                            JSONObject dato = json_array.getJSONObject(i);
                            lstVisita.add("Visita " + (i+1) + " - " + dato.getString("fecha_encuesta"));
                        }
                        size = tamano + "";
                        adapter = new ListCustomAdapter(Capitulo12Activity.this, lstVisita);
                        adapter.setCustomButtonListner(Capitulo12Activity.this);
                        listViewVisita.setAdapter(adapter);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void  grabarCapitulo(){
        enaForm.setCapitulo12(this.formulario);
        enaForm.setSegmentoEmpresa(segmentoEmpresa);
        enaForm.setNroParcela(nroParcela);
        enaForm.setDni(dni);
        sqlHelper.saveInformation(enaForm);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        fecha_resultado_encuesta.setText(format.format(c.getTime()));
    }
    public void showDatePickerDialog(View v) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getSupportFragmentManager(), "datepicker");
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
        resultado_encuesta.setAdapter(dataAdapter);
    }
}