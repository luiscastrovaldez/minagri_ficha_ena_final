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
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.envio.Capitulo11;
import pe.gob.minagri.ena.envio.Envio;
import pe.gob.minagri.ena.envio.capitulo11.P1101;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class PersonaActivity extends AppCompatActivity {

    private FloatingActionButton btnGuardarPersona, btnSalir;
    private String segmentoEmpresa, nroParcela, dni;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private String formulario;

    private LinearLayout Bloque1107a;
    private EditText P1107_Otro;
    private Spinner P1102,P1103,P1105,P1106,P1107;
    private CheckBox P1107_1, P1107_2, P1107_3, P1107_4, P1107_5, P1107_6, P1107_7, P1107_8, P1107_9,
            P1107_10, P1107_11, P1107_12, P1107_13, P1107_14, P1107_15, P1107_16, P1107_17,
            P1107_18;
    private List<String> lst1107;
    private String index,size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);
        inicializarCapitulo();
        obternerFormulario();

        P1107.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int dato = new Integer(((Combo) adapterView.getItemAtPosition(i)).getId());
                if (dato == 1) {
                    Bloque1107a.setVisibility(View.VISIBLE);

                } else {
                    Bloque1107a.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(Capitulo6Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });

        btnGuardarPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(PersonaActivity.this)
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
        lst1107 = new ArrayList<>();
        P1107_Otro = (EditText)findViewById(R.id.p1107a_otro);

        P1102 = (Spinner) findViewById(R.id.p1102);
        P1103 = (Spinner) findViewById(R.id.p1103);
        P1105 = (Spinner) findViewById(R.id.p1105);
        P1106 = (Spinner) findViewById(R.id.p1106);
        P1107 = (Spinner) findViewById(R.id.p1107);

        P1107_1 = (CheckBox) findViewById(R.id.p1107_1);
        P1107_2 = (CheckBox) findViewById(R.id.p1107_2);
        P1107_3 = (CheckBox) findViewById(R.id.p1107_3);
        P1107_4 = (CheckBox) findViewById(R.id.p1107_4);
        P1107_5 = (CheckBox) findViewById(R.id.p1107_5);
        P1107_6 = (CheckBox) findViewById(R.id.p1107_6);
        P1107_7 = (CheckBox) findViewById(R.id.p1107_7);
        P1107_8 = (CheckBox) findViewById(R.id.p1107_8);
        P1107_9 = (CheckBox) findViewById(R.id.p1107_9);
        P1107_10 = (CheckBox) findViewById(R.id.p1107_10);
        P1107_11 = (CheckBox) findViewById(R.id.p1107_11);
        P1107_12 = (CheckBox) findViewById(R.id.p1107_12);
        P1107_13 = (CheckBox) findViewById(R.id.p1107_13);
        P1107_14 = (CheckBox) findViewById(R.id.p1107_14);
        P1107_15 = (CheckBox) findViewById(R.id.p1107_15);
        P1107_16 = (CheckBox) findViewById(R.id.p1107_16);
        P1107_17 = (CheckBox) findViewById(R.id.p1107_17);
        P1107_18 = (CheckBox) findViewById(R.id.p1107_18);

        btnGuardarPersona = (FloatingActionButton) findViewById(R.id.btnGuardarPersona);
        btnSalir = (FloatingActionButton) findViewById(R.id.btnSalirPersona);

        Bloque1107a = (LinearLayout) findViewById(R.id.Bloque1107a);
        Bloque1107a.setVisibility(View.GONE);
        P1107_Otro.setVisibility(View.GONE);

        agregarRelacion();
        agregarSexo();
        agregarNivelAcademico();
        agregarIdiomas();
        agregarOpciones();

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
                String jsonCap11 = enaForm.getCapitulo11();
                JSONObject object = new JSONObject(jsonCap11);
                JSONArray json_array = object.getJSONArray("p1101");
                JSONObject dato = json_array.getJSONObject(new Integer(index.trim()));
                this.formulario = dato.toString();
                LinearLayout layout = findViewById(R.id.personas);
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
                if(dato.getString("p1107").equals("1")){
                    String p1107Value = Util.getJsonValue(this.formulario, "p1107a");
                    List<String> pCheckValues;
                    if (!p1107Value.contains("_value")){
                        lst1107 = new ArrayList<>(Arrays.asList(p1107Value.split("\\s*,\\s*")));
                        pCheckValues = Arrays.asList(p1107Value.split("\\s*,\\s*"));

                        if (pCheckValues.contains("1")) {
                            P1107_1.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("2")) {
                            P1107_2.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("3")) {
                            P1107_3.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("4")) {
                            P1107_4.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("5")) {
                            P1107_5.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("6")) {
                            P1107_6.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("7")) {
                            P1107_7.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("8")) {
                            P1107_8.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("9")) {
                            P1107_9.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("10")) {
                            P1107_10.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("11")) {
                            P1107_11.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("12")) {
                            P1107_12.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("13")) {
                            P1107_13.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("14")) {
                            P1107_14.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("15")) {
                            P1107_15.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("16")) {
                            P1107_16.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("17")) {
                            P1107_17.setChecked(Boolean.TRUE);
                        }
                        if (pCheckValues.contains("18")) {
                            P1107_18.setChecked(Boolean.TRUE);
                            P1107_Otro.setVisibility(View.VISIBLE);
                        }
                        Bloque1107a.setVisibility(View.VISIBLE);
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
            formulario = Util.loadData(getAssets(), Constants.PERSONA_FORMULARIO_JSON);
            LinearLayout layout = findViewById(R.id.personas);
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
            this.formulario = this.formulario.replace("p1107a_value", String.join(",", lst1107));

            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm == null) {
                enaForm = new EnaForm();
            }
            String jsonCap11 = enaForm.getCapitulo11();
            JSONObject dato = new JSONObject(this.formulario);
            if(jsonCap11 != null){
                JSONObject object = new JSONObject(jsonCap11);
                JSONArray json_array = object.getJSONArray("p1101");
                if (index.equals("-1")){
                    json_array.put(dato);
                }else {
                    json_array.put(new Integer(index), dato);
                }
                this.formulario = object.toString();
            } else {
                jsonCap11 = Util.loadData(getAssets(), Constants.CAPITULO11_FORMULARIO_JSON);
                JSONObject object = new JSONObject(jsonCap11);
                JSONArray json_array = object.getJSONArray("p1101");
                json_array.put(dato);
                this.formulario = object.toString();
            }

            enaForm.setCapitulo11(this.formulario);
            enaForm.setSegmentoEmpresa(segmentoEmpresa);
            enaForm.setNroParcela(nroParcela);
            enaForm.setDni(dni);
            sqlHelper.saveInformation(enaForm);
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void agregarRelacion() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Productor/a"));
        list.add(new Combo("2", "Esposo/a"));
        list.add(new Combo("3", "Hijo/a"));
        list.add(new Combo("4", "Yerno/Nuera"));
        list.add(new Combo("5", "Nieto/a"));
        list.add(new Combo("6", "Padre/Suegro/a"));
        list.add(new Combo("7", "Hermano/a"));
        list.add(new Combo("8", "Otros parientes"));
        list.add(new Combo("9", "Otros no parientes"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        P1102.setAdapter(dataAdapter);
    }
    private void agregarSexo() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Hombre"));
        list.add(new Combo("2", "Mujer"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        P1103.setAdapter(dataAdapter);
    }
    private void agregarNivelAcademico() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Sin nivel"));
        list.add(new Combo("2", "Inicial"));
        list.add(new Combo("3", "Primaria incompleta"));
        list.add(new Combo("4", "Primaria completa"));
        list.add(new Combo("5", "Secundaria incompleta"));
        list.add(new Combo("6", "Secundaria completa"));
        list.add(new Combo("7", "Educación Basica Especial"));
        list.add(new Combo("8", "Superior no universitaria incompleta"));
        list.add(new Combo("9", "Superior no universitaria completa"));
        list.add(new Combo("10", "Superior universitaria incompleta"));
        list.add(new Combo("11", "Superior universitaria completa"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        P1105.setAdapter(dataAdapter);
    }
    private void agregarIdiomas() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Quechua"));
        list.add(new Combo("2", "Aymara"));
        list.add(new Combo("3", "Otra lengua nativa"));
        list.add(new Combo("4", "Castellano"));
        list.add(new Combo("5", "Portugués"));
        list.add(new Combo("6", "Inglés"));
        list.add(new Combo("7", "Otra lengua extranjera"));
        list.add(new Combo("8", "No escuha no habla"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        P1106.setAdapter(dataAdapter);
    }
    private void agregarOpciones() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0","Seleccionar"));
        list.add(new Combo("1","Si"));
        list.add(new Combo("2","No"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        P1107.setAdapter(dataAdapter);
    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        int index = 0;
        switch (view.getId()) {
            case R.id.p1107_1:
                if (checked) {
                    lst1107.add("1");
                } else {
                    if (lst1107.contains("1")) {
                        lst1107.remove("1");
                    }
                }
                break;
            case R.id.p1107_2:
                if (checked) {
                    lst1107.add("2");
                } else {
                    if (lst1107.contains("2")) {
                        lst1107.remove("2");
                    }
                }
                break;
            case R.id.p1107_3:
                if (checked) {
                    lst1107.add("3");
                } else {
                    if (lst1107.contains("3")) {
                        lst1107.remove("3");
                    }
                }
                break;
            case R.id.p1107_4:
                if (checked) {
                    lst1107.add("4");
                } else {
                    if (lst1107.contains("4")) {
                        lst1107.remove("4");
                    }
                }
                break;
            case R.id.p1107_5:
                if (checked) {
                    lst1107.add("5");
                } else {
                    if (lst1107.contains("5")) {
                        lst1107.remove("5");
                    }
                }
                break;
            case R.id.p1107_6:
                if (checked) {
                    lst1107.add("6");
                } else {
                    if (lst1107.contains("6")) {
                        lst1107.remove("6");
                    }
                }
                break;
            case R.id.p1107_7:
                if (checked) {
                    lst1107.add("7");
                } else {
                    if (lst1107.contains("7")) {
                        lst1107.remove("7");
                    }
                }
                break;
            case R.id.p1107_8:
                if (checked) {
                    lst1107.add("8");
                } else {
                    if (lst1107.contains("8")) {
                        lst1107.remove("8");
                    }
                }
                break;
            case R.id.p1107_9:
                if (checked) {
                    lst1107.add("9");
                } else {
                    if (lst1107.contains("9")) {
                        lst1107.remove("9");
                    }
                }
                break;
            case R.id.p1107_10:
                if (checked) {
                    lst1107.add("10");
                } else {
                    if (lst1107.contains("10")) {
                        lst1107.remove("10");
                    }
                }
                break;
            case R.id.p1107_11:
                if (checked) {
                    lst1107.add("11");
                } else {
                    if (lst1107.contains("11")) {
                        lst1107.remove("11");
                    }
                }
                break;
            case R.id.p1107_12:
                if (checked) {
                    lst1107.add("12");
                } else {
                    if (lst1107.contains("12")) {
                        lst1107.remove("12");
                    }
                }
                break;
            case R.id.p1107_13:
                if (checked) {
                    lst1107.add("13");
                } else {
                    if (lst1107.contains("13")) {
                        lst1107.remove("13");
                    }
                }
                break;
            case R.id.p1107_14:
                if (checked) {
                    lst1107.add("14");
                } else {
                    if (lst1107.contains("14")) {
                        lst1107.remove("14");
                    }
                }
                break;
            case R.id.p1107_15:
                if (checked) {
                    lst1107.add("15");
                } else {
                    if (lst1107.contains("15")) {
                        lst1107.remove("15");
                    }
                }
                break;
            case R.id.p1107_16:
                if (checked) {
                    lst1107.add("16");
                } else {
                    if (lst1107.contains("16")) {
                        lst1107.remove("16");
                    }
                }
                break;
            case R.id.p1107_17:
                if (checked) {
                    lst1107.add("17");
                } else {
                    if (lst1107.contains("17")) {
                        lst1107.remove("17");
                    }
                }
                break;
            case R.id.p1107_18:
                if (checked) {
                    lst1107.add("18");
                    P1107_Otro.setVisibility(View.VISIBLE);
                } else {
                    if (lst1107.contains("18")) {
                        lst1107.remove("18");
                        P1107_Otro.setText("");
                        P1107_Otro.setVisibility(View.GONE);
                    }
                }
                break;
        }
    }
}