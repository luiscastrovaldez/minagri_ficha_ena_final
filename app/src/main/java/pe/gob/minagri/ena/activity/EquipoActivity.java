package pe.gob.minagri.ena.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class EquipoActivity extends AppCompatActivity {

    private FloatingActionButton btnGuardarEquipo, btnSalir;
    private String segmentoEmpresa, nroParcela, dni;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private String formulario;

    private LinearLayout Bloque902M,Bloque902E, Bloque902Otro, Bloque904Otro,Bloque903, Bloque905;
    private Spinner P902_S,P902M, P902E,P904,P907;

    private String index,size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);
        inicializarCapitulo();
        obternerFormulario();

        P902_S.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int dato = new Integer(((Combo) adapterView.getItemAtPosition(i)).getId());
                if (dato == 1) {
                    Bloque902E.setVisibility(View.GONE);
                    Bloque902Otro.setVisibility(View.GONE);
                    Bloque902M.setVisibility(View.VISIBLE);
                    Bloque903.setVisibility(View.VISIBLE);

                } else if(dato == 2) {
                    Bloque902E.setVisibility(View.VISIBLE);
                    Bloque902Otro.setVisibility(View.GONE);
                    Bloque902M.setVisibility(View.GONE);
                    Bloque903.setVisibility(View.GONE);
                }else {
                    Bloque902M.setVisibility(View.GONE);
                    Bloque902E.setVisibility(View.GONE);
                    Bloque902Otro.setVisibility(View.GONE);
                    Bloque903.setVisibility(View.GONE);
                    Bloque904Otro.setVisibility(View.GONE);
                    Bloque905.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(Capitulo6Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });
        P902M.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int dato = new Integer(((Combo) adapterView.getItemAtPosition(i)).getId());
                if (dato == 888 || dato == 889) {
                    Bloque902Otro.setVisibility(View.VISIBLE);

                } else {
                    Bloque902Otro.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(Capitulo6Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });
        P902E.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int dato = new Integer(((Combo) adapterView.getItemAtPosition(i)).getId());
                if (dato == 888 || dato == 889) {
                    Bloque902Otro.setVisibility(View.VISIBLE);

                } else {
                    Bloque902Otro.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(Capitulo6Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });
        P904.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int dato = new Integer(((Combo) adapterView.getItemAtPosition(i)).getId());
                if (dato == 5) {
                    Bloque904Otro.setVisibility(View.VISIBLE);

                } else {
                    Bloque904Otro.setVisibility(View.GONE);
                }
                if (dato == 2 || dato == 3 || dato == 4) {
                    Bloque905.setVisibility(View.VISIBLE);

                } else {
                    Bloque905.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(Capitulo6Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });

        btnGuardarEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                AlertDialog alertDialog = new AlertDialog.Builder(EquipoActivity.this)
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
        btnGuardarEquipo = (FloatingActionButton) findViewById(R.id.btnGuardarEquipo);
        btnSalir = (FloatingActionButton) findViewById(R.id.btnSalirEquipo);

        P902_S = (Spinner) findViewById(R.id.p902);
        P902M = (Spinner) findViewById(R.id.p902M);
        P902E = (Spinner) findViewById(R.id.p902E);
        P904 = (Spinner) findViewById(R.id.p904);
        P907 = (Spinner) findViewById(R.id.p907);

        Bloque902M = (LinearLayout) findViewById(R.id.Bloque902M);
        Bloque902E = (LinearLayout) findViewById(R.id.Bloque902E);
        Bloque902Otro = (LinearLayout) findViewById(R.id.Bloque902Otro);
        Bloque903 = (LinearLayout) findViewById(R.id.Bloque903);
        Bloque904Otro = (LinearLayout) findViewById(R.id.Bloque904Otro);
        Bloque905 = (LinearLayout) findViewById(R.id.Bloque905);

        Bloque902M.setVisibility(View.GONE);
        Bloque902E.setVisibility(View.GONE);
        Bloque902Otro.setVisibility(View.GONE);
        Bloque903.setVisibility(View.GONE);
        Bloque904Otro.setVisibility(View.GONE);
        Bloque905.setVisibility(View.GONE);

        agregarDatos902();
        agregarDatos904();
        agregarDatos907();
        agregarDatos(1);
        agregarDatos(2);

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
            try{
                String jsonCap9;
                enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
                jsonCap9 = enaForm.getCapitulo9();
                JSONObject object = new JSONObject(jsonCap9);
                JSONArray json_array = object.getJSONArray("p902");
                JSONObject dato = json_array.getJSONObject(new Integer(index.trim()));

                this.formulario = dato.toString();
                LinearLayout layout = findViewById(R.id.equipos);
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

                String cod = "0";
                String est = "0";

                if(!dato.getString("p902a").equals("0")){
                    cod = dato.getString("p902a");
                    agregarDatos(1);
                    P902_S.setSelection(Util.getIndex(P902_S, "1"));
                    P902M.setSelection(Util.getIndex(P902M, cod));
                    Bloque902M.setVisibility(View.VISIBLE);
                    Bloque903.setVisibility(View.VISIBLE);
                }else {
                    cod = dato.getString("p902b");
                    agregarDatos(2);
                    P902_S.setSelection(Util.getIndex(P902_S, "2"));
                    P902E.setSelection(Util.getIndex(P902E, cod));
                    Bloque902E.setVisibility(View.VISIBLE);
                    Bloque903.setVisibility(View.GONE);
                }

                if (cod.equals("888")  || cod.equals("889")) {
                    Bloque902Otro.setVisibility(View.VISIBLE);
                }

                est = dato.getString("p904");
                //P904.setSelection(Util.getIndex(P904, est));
                if (est.equals("5")) {
                    Bloque904Otro.setVisibility(View.VISIBLE);
                }
                if (est.equals("2") || est.equals("3") || est.equals("4")) {
                    Bloque905.setVisibility(View.VISIBLE);
                }
                //P907.setSelection(Util.getIndex(P907, dato.getString("p907")));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        formulario = Util.loadData(getAssets(), Constants.EQUIPO_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.equipos);
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

        String codigo = "";
        int tipo  = new Integer(((Combo) P902_S.getSelectedItem()).getId());

        if(tipo == 1){
            codigo = ((Combo) P902M.getSelectedItem()).getId();
            this.formulario = this.formulario.replace("p902a_value", codigo);
            this.formulario = this.formulario.replace("p902b_value", "0");
            //this.formulario = this.formulario.replace("p903_value", codigo);
        }else {
            codigo = ((Combo) P902E.getSelectedItem()).getId();
            this.formulario = this.formulario.replace("p902a_value", "0");
            this.formulario = this.formulario.replace("p902b_value", codigo);
            //this.formulario = this.formulario.replace("p903_value", "0");
        }

        enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
        if (enaForm == null) {
            enaForm = new EnaForm();
        }

        try {
            String jsonCap9 = enaForm.getCapitulo9();
            JSONObject dato = new JSONObject(this.formulario);
            if(jsonCap9 != null){
                JSONObject object = new JSONObject(jsonCap9);
                JSONArray json_array = object.getJSONArray("p902");
                if (index.equals("-1")){
                    json_array.put(dato);
                }else {
                    json_array.put(new Integer(index), dato);
                }
                this.formulario = object.toString();
            } else {
                jsonCap9 = Util.loadData(getAssets(), Constants.CAPITULO9_FORMULARIO_JSON);
                jsonCap9 = jsonCap9.replace("p901_value", "1");
                JSONObject object = new JSONObject(jsonCap9);
                JSONArray json_array = object.getJSONArray("p902");
                json_array.put(dato);
                this.formulario = object.toString();
            }

            enaForm.setCapitulo9(this.formulario);
            enaForm.setSegmentoEmpresa(segmentoEmpresa);
            enaForm.setNroParcela(nroParcela);
            enaForm.setDni(dni);
            sqlHelper.saveInformation(enaForm);
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void agregarDatos902() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Maquinaria"));
        list.add(new Combo("2", "Equipo"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        P902_S.setAdapter(dataAdapter);
    }
    private void agregarDatos904() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Propia"));
        list.add(new Combo("2", "Propiedad de la organización"));
        list.add(new Combo("3", "Alquilada"));
        list.add(new Combo("4", "Alquilada de la DRA"));
        list.add(new Combo("5", "Otro"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        P904.setAdapter(dataAdapter);
    }
    private void agregarDatos907() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Buena"));
        list.add(new Combo("2", "Regular"));
        list.add(new Combo("3", "Mala"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        P907.setAdapter(dataAdapter);
    }

    private void agregarDatos(int dato){
        List<Combo> list = new ArrayList<>();
        if(dato == 1){
            list = cargarMaquinaria();
        }else{
            list = cargarEquipo();
        }

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if(dato == 1){
            P902M.setAdapter(dataAdapter);
        }else{
            P902E.setAdapter(dataAdapter);
        }
    }
    private List<Combo> cargarMaquinaria(){

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Ahoyadora"));
        list.add(new Combo("2", "Aporcadora con motor"));
        list.add(new Combo("3", "Atomizador Futur motor"));
        list.add(new Combo("4", "Avioneta"));
        list.add(new Combo("5", "Cable vía"));
        list.add(new Combo("888", "Otro"));
        return list;
    }
    private List<Combo> cargarEquipo(){

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("62", "Aireador"));
        list.add(new Combo("63", "Aplastadora rolo cuchillas"));
        list.add(new Combo("64", "Aporcadora"));
        list.add(new Combo("65", "Arado de chuzo con tracción animal"));
        list.add(new Combo("66", "Atomizador Futur"));
        list.add(new Combo("889", "Otro"));
        return list;
    }
}