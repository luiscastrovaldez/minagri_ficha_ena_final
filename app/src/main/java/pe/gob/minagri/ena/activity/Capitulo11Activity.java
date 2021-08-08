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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.ListCustomAdapter;
import pe.gob.minagri.ena.util.ListCustomAdapter.customButtonListener;
import pe.gob.minagri.ena.util.Util;

public class Capitulo11Activity extends AppCompatActivity implements customButtonListener {

    private FloatingActionButton btnGuardar11,btnPersona, btnSalir;
    private String segmentoEmpresa, nroParcela, dni;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private String formulario;

    private LinearLayout Bloque1112, Bloque1114, Bloque1116;
    private Spinner P1109,P1110,P1111,P1113,P1116;
    private List<String> P1114, P1116a, P1117;
    private CheckBox P1114_1, P1114_2, P1114_3, P1114_4, P1114_5, P1114_6, P1114_7, P1114_8, P1114_9, P1114_10, P1114_11, P1114_12, P1114_13;
    private CheckBox P1116a_1, P1116a_2, P1116a_3, P1116a_4, P1116a_5, P1116a_6, P1116a_7, P1116a_8, P1116a_9, P1116a_10, P1116a_11;
    private CheckBox P1117_1, P1117_2, P1117_3, P1117_4, P1117_5, P1117_6, P1117_7, P1117_8, P1117_9, P1117_10, P1117_11, P1117_12, P1117_13;
    private EditText P1109_otro,P1114_otro,P1116a_otro,P1117_otro;

    private ListView listViewPersona;
    private String size;
    private List<String> lstPersona;
    private ListCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo11);
        inicializarCapitulo();
        obternerFormulario();

        btnGuardar11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                AlertDialog alertDialog = new AlertDialog.Builder(Capitulo11Activity.this)
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
        btnPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PersonaActivity.class);
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

        P1109.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Combo combo = (Combo) adapterView.getItemAtPosition(i);
                if (combo.getId().equals("8")) {
                    P1109_otro.setVisibility(View.VISIBLE);

                } else {
                    P1109_otro.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(Capitulo6Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });
        P1111.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Combo combo = (Combo) adapterView.getItemAtPosition(i);
                if (combo.getId().equals("1")) {
                    Bloque1112.setVisibility(View.VISIBLE);

                } else {
                    Bloque1112.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(Capitulo6Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });
        P1113.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Combo combo = (Combo) adapterView.getItemAtPosition(i);
                if (combo.getId().equals("1")) {
                    Bloque1114.setVisibility(View.VISIBLE);

                } else {
                    Bloque1114.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(Capitulo6Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });
        P1116.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Combo combo = (Combo) adapterView.getItemAtPosition(i);
                if (combo.getId().equals("1")) {
                    Bloque1116.setVisibility(View.VISIBLE);

                } else {
                    Bloque1116.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(Capitulo6Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });

        listViewPersona.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int itemPosition = position;

                Intent intent = new Intent(getApplicationContext(), PersonaActivity.class);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra(Constants.INDEX, "" + itemPosition);
                intent.putExtra(Constants.SIZE, "" + size);

                startActivity(intent);
            }
        });
        listViewPersona.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                final int posicion=i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Capitulo11Activity.this);
                dialogo1.setTitle(getResources().getString(R.string.titulo_eliminar));
                dialogo1.setMessage(getResources().getString(R.string.titulo_eliminar_dato));
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton(getResources().getString(R.string.si), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        try{
                            lstPersona.remove(posicion);
                            adapter.notifyDataSetChanged();
                            if (enaForm != null) {
                                formulario = enaForm.getCapitulo11();
                                if(formulario != null){
                                    JSONObject object = new JSONObject(formulario);
                                    JSONArray json_array = object.getJSONArray("p1101");
                                    Object o = json_array.remove(posicion);
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
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Capitulo11Activity.this);
        dialogo1.setTitle(getResources().getString(R.string.titulo_eliminar));
        dialogo1.setMessage(getResources().getString(R.string.titulo_eliminar_dato));
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton(getResources().getString(R.string.si), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                try{
                    lstPersona.remove(position);
                    adapter.notifyDataSetChanged();
                    if (enaForm != null) {
                        formulario = enaForm.getCapitulo11();
                        if(formulario != null){
                            JSONObject object = new JSONObject(formulario);
                            JSONArray json_array = object.getJSONArray("p1101");
                            Object o = json_array.remove(position);
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
        P1114 = new ArrayList<>();
        P1116a = new ArrayList<>();
        P1117 = new ArrayList<>();

        P1109 = (Spinner) findViewById(R.id.p1109);
        P1110 = (Spinner) findViewById(R.id.p1110);
        P1111 = (Spinner) findViewById(R.id.p1111);
        P1113 = (Spinner) findViewById(R.id.p1113);
        P1116 = (Spinner) findViewById(R.id.p1116);

        P1109_otro = (EditText) findViewById(R.id.p1109_otro);
        P1114_1 = (CheckBox) findViewById(R.id.p1114_1);
        P1114_2 = (CheckBox) findViewById(R.id.p1114_2);
        P1114_3 = (CheckBox) findViewById(R.id.p1114_3);
        P1114_4 = (CheckBox) findViewById(R.id.p1114_4);
        P1114_5 = (CheckBox) findViewById(R.id.p1114_5);
        P1114_6 = (CheckBox) findViewById(R.id.p1114_6);
        P1114_7 = (CheckBox) findViewById(R.id.p1114_7);
        P1114_8 = (CheckBox) findViewById(R.id.p1114_8);
        P1114_9 = (CheckBox) findViewById(R.id.p1114_9);
        P1114_10 = (CheckBox) findViewById(R.id.p1114_10);
        P1114_11 = (CheckBox) findViewById(R.id.p1114_11);
        P1114_12 = (CheckBox) findViewById(R.id.p1114_12);
        P1114_13 = (CheckBox) findViewById(R.id.p1114_13);
        P1114_otro = (EditText) findViewById(R.id.p1114_otro);

        P1116a_1 = (CheckBox) findViewById(R.id.p1116_1);
        P1116a_2 = (CheckBox) findViewById(R.id.p1116_2);
        P1116a_3 = (CheckBox) findViewById(R.id.p1116_3);
        P1116a_4 = (CheckBox) findViewById(R.id.p1116_4);
        P1116a_5 = (CheckBox) findViewById(R.id.p1116_5);
        P1116a_6 = (CheckBox) findViewById(R.id.p1116_6);
        P1116a_7 = (CheckBox) findViewById(R.id.p1116_7);
        P1116a_8 = (CheckBox) findViewById(R.id.p1116_8);
        P1116a_9 = (CheckBox) findViewById(R.id.p1116_9);
        P1116a_10 = (CheckBox) findViewById(R.id.p1116_10);
        P1116a_11 = (CheckBox) findViewById(R.id.p1116_11);
        P1116a_otro = (EditText) findViewById(R.id.p1116a_otro);

        P1117_1 = (CheckBox) findViewById(R.id.p1117_1);
        P1117_2 = (CheckBox) findViewById(R.id.p1117_2);
        P1117_3 = (CheckBox) findViewById(R.id.p1117_3);
        P1117_4 = (CheckBox) findViewById(R.id.p1117_4);
        P1117_5 = (CheckBox) findViewById(R.id.p1117_5);
        P1117_6 = (CheckBox) findViewById(R.id.p1117_6);
        P1117_7 = (CheckBox) findViewById(R.id.p1117_7);
        P1117_8 = (CheckBox) findViewById(R.id.p1117_8);
        P1117_9 = (CheckBox) findViewById(R.id.p1117_9);
        P1117_10 = (CheckBox) findViewById(R.id.p1117_10);
        P1117_11 = (CheckBox) findViewById(R.id.p1117_11);
        P1117_12 = (CheckBox) findViewById(R.id.p1117_12);
        P1117_13 = (CheckBox) findViewById(R.id.p1117_13);
        P1117_otro = (EditText) findViewById(R.id.p1117_otro);

        P1109_otro.setVisibility(View.GONE);
        P1114_otro.setVisibility(View.GONE);
        P1116a_otro.setVisibility(View.GONE);
        P1117_otro.setVisibility(View.GONE);

        Bloque1112 = (LinearLayout) findViewById(R.id.Bloque1112);
        Bloque1114 = (LinearLayout) findViewById(R.id.Bloque1114);
        Bloque1116 = (LinearLayout) findViewById(R.id.Bloque1116);

        Bloque1112.setVisibility(View.GONE);
        Bloque1114.setVisibility(View.GONE);
        Bloque1116.setVisibility(View.GONE);

        btnGuardar11 = (FloatingActionButton) findViewById(R.id.btnGuardar11);
        btnPersona = (FloatingActionButton) findViewById(R.id.btnPersona) ;
        btnSalir = (FloatingActionButton) findViewById(R.id.btnSalirCap11);

        listViewPersona = (ListView) findViewById(R.id.listViewPers);
        size = "0";
        lstPersona = new ArrayList<>();

        addNiveles();
        addRazas();

        Intent intent = getIntent();
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        this.sqlHelper = new SqlHelper(getApplicationContext());
    }
    private void obternerFormulario() {
        try {
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm != null) {
                this.formulario = enaForm.getCapitulo11();
                String p1109Value = Util.getJsonValue(this.formulario, "p1109");
                if (!p1109Value.contains("_value")) {
                    LinearLayout layout = findViewById(R.id.capitulo11);
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

                    String p1111Value = Util.getJsonValue(this.formulario, "p1111");
                    String p1113Value = Util.getJsonValue(this.formulario, "p1113");
                    String p1116Value = Util.getJsonValue(this.formulario, "p1116");
                    String p1114Value = Util.getJsonValue(this.formulario, "p1114");
                    String p1116aValue = Util.getJsonValue(this.formulario, "p1116a");
                    String p1117Value = Util.getJsonValue(this.formulario, "p1117");
                    List<String> pCheckValues;

                    if(p1109Value.equals("8")){
                        P1109_otro.setVisibility(View.VISIBLE);
                    }
                    if(p1111Value.equals("1")){
                        Bloque1112.setVisibility(View.VISIBLE);
                    }
                    if(p1113Value.equals("1")){
                        if (!p1114Value.contains("_value")) {
                            P1114 = new LinkedList<>(Arrays.asList(p1114Value.split("\\s*,\\s*")));
                            pCheckValues = Arrays.asList(p1114Value.split("\\s*,\\s*"));
                            P1114_otro.setVisibility(View.GONE);
                            if (pCheckValues.contains("1")) {
                                P1114_1.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("2")) {
                                P1114_2.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("3")) {
                                P1114_3.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("4")) {
                                P1114_4.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("5")) {
                                P1114_5.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("6")) {
                                P1114_6.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("7")) {
                                P1114_7.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("8")) {
                                P1114_8.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("9")) {
                                P1114_9.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("10")) {
                                P1114_10.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("11")) {
                                P1114_11.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("12")) {
                                P1114_12.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("13")) {
                                P1114_13.setChecked(Boolean.TRUE);
                                P1114_otro.setVisibility(View.VISIBLE);
                            }
                        }
                        Bloque1114.setVisibility(View.VISIBLE);
                    }
                    if(p1116Value.equals("1")){
                        if (!p1116aValue.contains("_value")) {
                            P1116a = new LinkedList<>(Arrays.asList(p1116aValue.split("\\s*,\\s*")));
                            pCheckValues = Arrays.asList(p1116aValue.split("\\s*,\\s*"));
                            P1116a_otro.setVisibility(View.GONE);

                            if (pCheckValues.contains("1")) {
                                P1116a_1.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("2")) {
                                P1116a_2.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("3")) {
                                P1116a_3.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("4")) {
                                P1116a_4.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("5")) {
                                P1116a_5.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("6")) {
                                P1116a_6.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("7")) {
                                P1116a_7.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("8")) {
                                P1116a_8.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("9")) {
                                P1116a_9.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("10")) {
                                P1116a_10.setChecked(Boolean.TRUE);
                            }
                            if (pCheckValues.contains("11")) {
                                P1116a_11.setChecked(Boolean.TRUE);
                                P1116a_otro.setVisibility(View.VISIBLE);
                            }
                        }
                        Bloque1116.setVisibility(View.VISIBLE);
                    }
                    if (!p1117Value.contains("_value")) {
                        P1117 = new LinkedList<>(Arrays.asList(p1117Value.split("\\s*,\\s*")));
                        pCheckValues = Arrays.asList(p1117Value.split("\\s*,\\s*"));
                        P1117_otro.setVisibility(View.GONE);

                        if (pCheckValues.contains("1")) {
                            P1117_1.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("2")) {
                            P1117_2.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("3")) {
                            P1117_3.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("4")) {
                            P1117_4.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("5")) {
                            P1117_5.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("6")) {
                            P1117_6.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("7")) {
                            P1117_7.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("8")) {
                            P1117_8.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("9")) {
                            P1117_9.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("10")) {
                            P1117_10.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("11")) {
                            P1117_11.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("12")) {
                            P1117_12.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("13")) {
                            P1117_13.setChecked(Boolean.TRUE);
                            P1117_otro.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        try {
            formulario = Util.loadData(getAssets(), Constants.CAPITULO11_FORMULARIO_JSON);
            LinearLayout layout = findViewById(R.id.capitulo11);
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

            this.formulario = this.formulario.replace("p1114_value", String.join(",", P1114));
            this.formulario = this.formulario.replace("p1116a_value", String.join(",", P1116a));
            this.formulario = this.formulario.replace("p1117_value", String.join(",", P1117));

            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm == null) {
                enaForm = new EnaForm();
            }

            String jsonCap11 = enaForm.getCapitulo11();
            if(jsonCap11 != null){
                JSONObject dato = new JSONObject(this.formulario);
                JSONObject object = new JSONObject(jsonCap11);
                JSONArray json_array = object.getJSONArray("p1101");
                if(json_array.length() > 0){
                    dato.put("p1101",json_array);
                    this.formulario = dato.toString();
                }
            }

            grabarCapitulo();
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void cargarDatosLista(){
        try {
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm != null) {
                this.formulario = enaForm.getCapitulo11();
                if(this.formulario != null){
                    if (lstPersona.size() > 0) {
                        lstPersona.clear();
                    }
                    JSONObject object = new JSONObject(this.formulario);
                    JSONArray json_array = object.getJSONArray("p1101");
                    int tamano = json_array.length();
                    if(tamano != 0){
                        for (int i = 0; i < tamano; i++) {
                            JSONObject dato = json_array.getJSONObject(i);
                            lstPersona.add(/*dato.getString("p1101_num")*/(i+1) + " - " + dato.getString("p1101_nombre"));
                        }
                        size = tamano + "";
                        adapter = new ListCustomAdapter(Capitulo11Activity.this, lstPersona);
                        adapter.setCustomButtonListner(Capitulo11Activity.this);
                        listViewPersona.setAdapter(adapter);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void  grabarCapitulo(){
        enaForm.setCapitulo11(this.formulario);
        enaForm.setSegmentoEmpresa(segmentoEmpresa);
        enaForm.setNroParcela(nroParcela);
        enaForm.setDni(dni);
        sqlHelper.saveInformation(enaForm);
    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        int index = 0;
        switch (view.getId()) {
            case R.id.p1114_1:
                if (checked) {
                    P1114.add("1");
                } else {
                    if (P1114.contains("1")) {
                        P1114.remove("1");
                    }
                }
                break;
            case R.id.p1114_2:
                if (checked) {
                    P1114.add("2");
                } else {
                    if (P1114.contains("2")) {
                        P1114.remove("2");
                    }
                }
                break;
            case R.id.p1114_3:
                if (checked) {
                    P1114.add("3");
                } else {
                    if (P1114.contains("3")) {
                        P1114.remove("3");
                    }
                }
                break;
            case R.id.p1114_4:
                if (checked) {
                    P1114.add("4");
                } else {
                    if (P1114.contains("4")) {
                        P1114.remove("4");
                    }
                }
                break;
            case R.id.p1114_5:
                if (checked) {
                    P1114.add("5");
                } else {
                    if (P1114.contains("5")) {
                        P1114.remove("5");
                    }
                }
                break;
            case R.id.p1114_6:
                if (checked) {
                    P1114.add("6");
                } else {
                    if (P1114.contains("6")) {
                        P1114.remove("6");
                    }
                }
                break;

            case R.id.p1114_7:
                if (checked) {
                    P1114.add("7");
                } else {
                    if (P1114.contains("7")) {
                        P1114.remove("7");
                    }
                }
                break;

            case R.id.p1114_8:
                if (checked) {
                    P1114.clear();
                    P1114.add("8");
                } else {
                    if (P1114.contains("8")) {
                        P1114.remove("8");
                    }
                }
                break;
            case R.id.p1114_9:
                if (checked) {
                    P1114.add("9");
                } else {
                    if (P1114.contains("9")) {
                        P1114.remove("9");
                    }
                }
                break;
            case R.id.p1114_10:
                if (checked) {
                    P1114.add("10");
                } else {
                    if (P1114.contains("10")) {
                        P1114.remove("10");
                    }
                }
                break;
            case R.id.p1114_11:
                if (checked) {
                    P1114.add("11");
                } else {
                    if (P1114.contains("11")) {
                        P1114.remove("11");
                    }
                }
                break;
            case R.id.p1114_12:
                if (checked) {
                    P1114.add("12");
                } else {
                    if (P1114.contains("12")) {
                        P1114.remove("12");
                    }
                }
                break;
            case R.id.p1114_13:
                if (checked) {
                    P1114.add("13");
                    P1114_otro.setVisibility(View.VISIBLE);
                } else {
                    if (P1114.contains("13")) {
                        P1114.remove("13");
                        P1114_otro.setText("");
                        P1114_otro.setVisibility(View.GONE);
                    }
                }
                break;

            case R.id.p1116_1:
                if (checked) {
                    P1116a.add("1");
                } else {
                    if (P1116a.contains("1")) {
                        P1116a.remove("1");
                    }
                }
                break;
            case R.id.p1116_2:
                if (checked) {
                    P1116a.add("2");
                } else {
                    if (P1116a.contains("2")) {
                        P1116a.remove("2");
                    }
                }
                break;
            case R.id.p1116_3:
                if (checked) {
                    P1116a.add("3");
                } else {
                    if (P1116a.contains("3")) {
                        P1116a.remove("3");
                    }
                }
                break;
            case R.id.p1116_4:
                if (checked) {
                    P1116a.add("4");
                } else {
                    if (P1116a.contains("4")) {
                        P1116a.remove("4");
                    }
                }
                break;
            case R.id.p1116_5:
                if (checked) {
                    P1116a.add("5");
                } else {
                    if (P1116a.contains("5")) {
                        P1116a.remove("5");
                    }
                }
                break;
            case R.id.p1116_6:
                if (checked) {
                    P1116a.add("6");
                } else {
                    if (P1116a.contains("6")) {
                        P1116a.remove("6");
                    }
                }
                break;

            case R.id.p1116_7:
                if (checked) {
                    P1116a.add("7");
                } else {
                    if (P1116a.contains("7")) {
                        P1116a.remove("7");
                    }
                }
                break;
            case R.id.p1116_8:
                if (checked) {
                    P1116a.add("8");
                } else {
                    if (P1116a.contains("8")) {
                        P1116a.remove("8");
                    }
                }
                break;
            case R.id.p1116_9:
                if (checked) {
                    P1116a.add("9");
                } else {
                    if (P1116a.contains("9")) {
                        P1116a.remove("9");
                    }
                }
                break;
            case R.id.p1116_10:
                if (checked) {
                    P1116a.add("10");
                } else {
                    if (P1116a.contains("10")) {
                        P1116a.remove("10");
                    }
                }
                break;
            case R.id.p1116_11:
                if (checked) {
                    P1116a.add("11");
                    P1116a_otro.setVisibility(View.VISIBLE);
                } else {
                    if (P1116a.contains("11")) {
                        P1116a.remove("11");
                        P1116a_otro.setText("");
                        P1116a_otro.setVisibility(View.GONE);
                    }
                }
                break;

            case R.id.p1117_1:
                if (checked) {
                    P1117.add("1");
                } else {
                    if (P1117.contains("1")) {
                        P1117.remove("1");
                    }
                }
                break;
            case R.id.p1117_2:
                if (checked) {
                    P1117.add("2");
                } else {
                    if (P1117.contains("2")) {
                        P1117.remove("2");
                    }
                }
                break;
            case R.id.p1117_3:
                if (checked) {
                    P1117.add("3");
                } else {
                    if (P1117.contains("3")) {
                        P1117.remove("3");
                    }
                }
                break;
            case R.id.p1117_4:
                if (checked) {
                    P1117.add("4");
                } else {
                    if (P1117.contains("4")) {
                        P1117.remove("4");
                    }
                }
                break;
            case R.id.p1117_5:
                if (checked) {
                    P1117.add("5");
                } else {
                    if (P1117.contains("5")) {
                        P1117.remove("5");
                    }
                }
                break;
            case R.id.p1117_6:
                if (checked) {
                    P1117.add("6");
                } else {
                    if (P1117.contains("6")) {
                        P1117.remove("6");
                    }
                }
                break;
            case R.id.p1117_7:
                if (checked) {
                    P1117.add("7");
                } else {
                    if (P1117.contains("7")) {
                        P1117.remove("7");
                    }
                }
                break;
            case R.id.p1117_8:
                if (checked) {
                    P1117.add("8");
                } else {
                    if (P1117.contains("8")) {
                        P1117.remove("8");
                    }
                }
                break;
            case R.id.p1117_9:
                if (checked) {
                    P1117.add("9");
                } else {
                    if (P1117.contains("9")) {
                        P1117.remove("9");
                    }
                }
                break;
            case R.id.p1117_10:
                if (checked) {
                    P1117.add("10");
                } else {
                    if (P1117.contains("10")) {
                        P1117.remove("10");
                    }
                }
                break;
            case R.id.p1117_11:
                if (checked) {
                    P1117.add("11");
                } else {
                    if (P1117.contains("11")) {
                        P1117.remove("11");
                    }
                }
                break;
            case R.id.p1117_12:
                if (checked) {
                    P1117.add("12");
                } else {
                    if (P1117.contains("12")) {
                        P1117.remove("12");
                    }
                }
                break;
            case R.id.p1117_13:
                if (checked) {
                    P1117.add("13");
                    P1117_otro.setVisibility(View.VISIBLE);
                } else {
                    if (P1117.contains("13")) {
                        P1117.remove("13");
                        P1117_otro.setText("");
                        P1117_otro.setVisibility(View.GONE);
                    }
                }
                break;
        }
    }
    private void addNiveles() {
        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0","Seleccionar"));
        list.add(new Combo("1","Si"));
        list.add(new Combo("2","No"));
        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        P1110.setAdapter(dataAdapter);
        P1111.setAdapter(dataAdapter);
        P1113.setAdapter(dataAdapter);
        P1116.setAdapter(dataAdapter);
    }
    private void addRazas() {
        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0","Seleccionar"));
        list.add(new Combo("1","Quechua"));
        list.add(new Combo("2","Aimara"));
        list.add(new Combo("3","Nativo o indigena del amazonas"));
        list.add(new Combo("4","Perteneciente o parte de otro pueblo indigena u originario"));
        list.add(new Combo("5","Negro, moreno,zambo, mulato/ afroperuano o afrodescendiente"));
        list.add(new Combo("6","Blanco"));
        list.add(new Combo("7","Mestizo"));
        list.add(new Combo("8","Otro"));
        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        P1109.setAdapter(dataAdapter);;
    }
}