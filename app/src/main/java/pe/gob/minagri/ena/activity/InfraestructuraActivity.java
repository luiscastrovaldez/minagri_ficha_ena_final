package pe.gob.minagri.ena.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.envio.Capitulo10;
import pe.gob.minagri.ena.envio.Envio;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class InfraestructuraActivity extends AppCompatActivity {

    private FloatingActionButton guardarInfra, btnSalir;
    private String segmentoEmpresa, nroParcela, dni;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private String formulario;
    private Spinner P1001,P1003;

    private String index,size;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infraestructura);
        inicializarCapitulo();
        obternerFormulario();
        guardarInfra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                AlertDialog alertDialog = new AlertDialog.Builder(InfraestructuraActivity.this)
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
    }

    private void inicializarCapitulo(){
        P1001 = (Spinner)findViewById(R.id.p1001);
        P1003 = (Spinner) findViewById(R.id.p1003);
        guardarInfra = (FloatingActionButton) findViewById(R.id.btnGuardarInfra);
        btnSalir = (FloatingActionButton) findViewById(R.id.btnSalirInfra);
        agregarDatos();
        agregarDatosInfra();
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
                if (enaForm != null) {
                    this.formulario = enaForm.getCapitulo10();
                    JSONArray json_array = new JSONArray(this.formulario);
                    JSONObject dato = json_array.getJSONObject(new Integer(index.trim()));
                    this.formulario = dato.toString();
                    LinearLayout layout = findViewById(R.id.infraestructuras);
                    for (int i = 0; i < layout.getChildCount(); i++) {
                        View view = layout.getChildAt(i);
                        Util.setearInformacion(getResources(), view, this.formulario);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        try {
            formulario = Util.loadData(getAssets(), Constants.INFRAESTRUCTURA_FORMULARIO_JSON);
            LinearLayout layout = findViewById(R.id.infraestructuras);
            for (int i = 0; i < layout.getChildCount(); i++) {
                View view = layout.getChildAt(i);
                this.formulario = Util.generarJson(getResources(), view, this.formulario);
            }
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm == null) {
                enaForm = new EnaForm();
            }
            String jsonCap10 = enaForm.getCapitulo10();
            JSONObject dato = new JSONObject(this.formulario);
            if(jsonCap10 != null){
                JSONArray json_array = new JSONArray(jsonCap10);
                if (index.equals("-1")){
                    json_array.put(dato);
                }else {
                    json_array.put(new Integer(index), dato);
                }
                this.formulario = json_array.toString();
            } else {
                JSONArray json_array = new JSONArray();
                json_array.put(dato);
                this.formulario = json_array.toString();
            }

            enaForm.setCapitulo10(this.formulario);
            enaForm.setSegmentoEmpresa(segmentoEmpresa);
            enaForm.setNroParcela(nroParcela);
            enaForm.setDni(dni);
            sqlHelper.saveInformation(enaForm);
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
        }catch (Exception e){

        }
    }

    public void agregarDatos() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Buena"));
        list.add(new Combo("2", "Regular"));
        list.add(new Combo("3", "Mala"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        P1003.setAdapter(dataAdapter);
    }
    public void agregarDatosInfra() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Almácigo"));
        list.add(new Combo("2", "Andenes  y  Terrazas"));
        list.add(new Combo("3", "Aprisco"));
        list.add(new Combo("4", "Área de empaque"));
        list.add(new Combo("5", "Área de entrenamiento animal"));
        list.add(new Combo("6", "Área de rampas de embarque y desembarque "));
        list.add(new Combo("7", "Área de manejo de residuos sólidos"));
        list.add(new Combo("8", "Bañaderos (área de duchas y viester)"));
        list.add(new Combo("9", "Bebedero"));
        list.add(new Combo("10", "Bodega, almacen de alimentos e insumos"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this, android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        P1001.setAdapter(dataAdapter);
    }
}