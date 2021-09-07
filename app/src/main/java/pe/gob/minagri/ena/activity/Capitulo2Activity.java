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
import android.widget.Toast;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.entity.Ubigeo;
import pe.gob.minagri.ena.envio.Envio;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class Capitulo2Activity extends AppCompatActivity {

    private Spinner p201_tipo_productor, p202, p207_cargo, p211, p218_cargo, p215_cod_ccpp, p216_tipo_via, p210;
    private FloatingActionButton guardar, salir, validar;
    private SqlHelper sqlHelper;
    private EnaForm enaForm;
    private String formulario;

    private String codDepartamento;
    private String codProvincia;
    private String codDistrito;
    private String segmentoEmpresa, nroParcela, dni;

    private Spinner departamentos1;
    private Spinner provincias1;
    private Spinner distritos1, p210_cod_ccpp;
    private Boolean noAgricola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo2);
        p201_tipo_productor = findViewById(R.id.p201_tipo_productor);
        p202 = findViewById(R.id.p202);
        p207_cargo = findViewById(R.id.p207_cargo);
        p211 = findViewById(R.id.p211);
        p218_cargo = findViewById(R.id.p218_cargo);
        p215_cod_ccpp = findViewById(R.id.p215_cod_ccpp);
        p216_tipo_via = findViewById(R.id.p216_tipo_via);
        departamentos1 = findViewById(R.id.departamentos1);
        provincias1 = findViewById(R.id.provincias1);
        distritos1 = findViewById(R.id.distritos1);

        p210_cod_ccpp = findViewById(R.id.p210_cod_ccpp);
        p210 = findViewById(R.id.p210);
        Intent intent = getIntent();
        codDepartamento = intent.getStringExtra(Constants.DEPARTAMENTO);
        codProvincia = intent.getStringExtra(Constants.PROVINCIA);
        codDistrito = intent.getStringExtra(Constants.DISTRITO);
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        dni = intent.getStringExtra(Constants.DNI);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        noAgricola = intent.getBooleanExtra("noAgricola", false);
        guardar = findViewById(R.id.guardar2);
        salir = findViewById(R.id.salirCapitulo2);
        validar = findViewById(R.id.validar2);
        this.sqlHelper = new SqlHelper(getApplicationContext());
        formulario = Util.loadData(getAssets(), Constants.CAPITULO2_FORMULARIO_JSON);
        agregarP201();
        agregarP202();
        agregarP207();
        agregarP211();
        agregarP218();
        agregarCentroPoblados215(codDepartamento, codProvincia, codDistrito, segmentoEmpresa);
        agregarP216();
        agregarP210();
        agregarDepartamentos();
        agregarProvincias(codDepartamento);
        agregarDistritos(codDepartamento, codProvincia);
        agregarCentroPoblados210(codDepartamento, codProvincia, codDistrito, segmentoEmpresa);
        findViewById(R.id.p207_otro).setVisibility(View.GONE);
        findViewById(R.id.departamentos1).setVisibility(View.GONE);
        findViewById(R.id.provincias1).setVisibility(View.GONE);
        findViewById(R.id.distritos1).setVisibility(View.GONE);
        findViewById(R.id.p210_cod_ccpp).setVisibility(View.GONE);
        findViewById(R.id.p216_otra_via).setVisibility(View.GONE);
        findViewById(R.id.p218_otro_cargo).setVisibility(View.GONE);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        p211.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Get the spinner selected item text
                Combo combo = (Combo) adapterView.getItemAtPosition(i);

                if (combo.getId().equals("2")) {
                    findViewById(R.id.p211_observacion).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.p211_observacion).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Capitulo2Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });

        p216_tipo_via.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Get the spinner selected item text
                Combo combo = (Combo) adapterView.getItemAtPosition(i);

                if (combo.getId().equals("6")) {
                    findViewById(R.id.p216_otra_via).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.p216_otra_via).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Capitulo2Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });



        p218_cargo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Get the spinner selected item text
                Combo combo = (Combo) adapterView.getItemAtPosition(i);

                if (combo.getId().equals("5")) {
                    findViewById(R.id.p218_otro_cargo).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.p218_otro_cargo).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Capitulo2Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });

        p210.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Get the spinner selected item text
                Combo combo = (Combo) adapterView.getItemAtPosition(i);

                if (combo.getId().equals("3")) {
                    findViewById(R.id.departamentos1).setVisibility(View.VISIBLE);
                    findViewById(R.id.provincias1).setVisibility(View.VISIBLE);
                    findViewById(R.id.distritos1).setVisibility(View.VISIBLE);
                    findViewById(R.id.p210_cod_ccpp).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.departamentos1).setVisibility(View.GONE);
                    findViewById(R.id.provincias1).setVisibility(View.GONE);
                    findViewById(R.id.distritos1).setVisibility(View.GONE);
                    findViewById(R.id.p210_cod_ccpp).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Capitulo2Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });

        p207_cargo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Get the spinner selected item text
                Combo combo = (Combo) adapterView.getItemAtPosition(i);

                findViewById(R.id.p207_otro).setVisibility(View.GONE);

                if (combo.getId().equals("1")) {
                    ((EditText) findViewById(R.id.p208_apellidos)).setText(((EditText) findViewById(R.id.p203_apellidos)).getText());
                    findViewById(R.id.p208_apellidos).setEnabled(Boolean.FALSE);

                    ((EditText) findViewById(R.id.p208_nombres)).setText(((EditText) findViewById(R.id.p203_nombres)).getText());
                    findViewById(R.id.p208_nombres).setEnabled(Boolean.FALSE);

                    ((EditText) findViewById(R.id.p209_celular)).setText(((EditText) findViewById(R.id.p205_celular)).getText());
                    findViewById(R.id.p209_celular).setEnabled(Boolean.FALSE);
                    ((EditText) findViewById(R.id.p209_fijo)).setText(((EditText) findViewById(R.id.p205_fijo)).getText());
                    findViewById(R.id.p209_fijo).setEnabled(Boolean.FALSE);
                } else {

                    ((EditText) findViewById(R.id.p208_apellidos)).setText(null);
                    findViewById(R.id.p208_apellidos).setEnabled(Boolean.TRUE);

                    ((EditText) findViewById(R.id.p208_nombres)).setText(null);
                    findViewById(R.id.p208_nombres).setEnabled(Boolean.TRUE);

                    ((EditText) findViewById(R.id.p209_celular)).setText(null);
                    findViewById(R.id.p209_celular).setEnabled(Boolean.TRUE);
                    ((EditText) findViewById(R.id.p209_fijo)).setText(null);
                    findViewById(R.id.p209_fijo).setEnabled(Boolean.FALSE);


                }

                if (combo.getId().equals("6")) {
                    findViewById(R.id.p207_otro).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.p207_otro).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Capitulo2Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(Capitulo2Activity.this)
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
                                Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });


        p201_tipo_productor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Get the spinner selected item text
                Combo combo = (Combo) adapterView.getItemAtPosition(i);
                switch (combo.getId()) {
                    case "0":
                        enabledNatutal(View.GONE);
                        enabledJuridico(View.GONE);
                        findViewById(R.id.p201_otro).setVisibility(View.GONE);
                        //TABLE_221.setVisibility(View.GONE);
                        //TABLE_208.setVisibility(View.GONE);
                        findViewById(R.id.p221_titulo).setVisibility(View.GONE);
                        findViewById(R.id.p221).setVisibility(View.GONE);
                        findViewById(R.id.p221_observaciones).setVisibility(View.GONE);
                        break;
                    case "1":
                        enabledNatutal(View.VISIBLE);
                        enabledJuridico(View.GONE);
                        findViewById(R.id.p201_otro).setVisibility(View.GONE);
                        findViewById(R.id.p221_titulo).setVisibility(View.VISIBLE);
                        findViewById(R.id.p221).setVisibility(View.VISIBLE);
                        findViewById(R.id.p221_observaciones).setVisibility(View.VISIBLE);
                        //TABLE_208.setVisibility(View.VISIBLE);
                        break;

                    case "2":
                        enabledNatutal(View.GONE);
                        enabledJuridico(View.VISIBLE);
                        findViewById(R.id.p201_otro).setVisibility(View.GONE);
                        findViewById(R.id.p221_titulo).setVisibility(View.VISIBLE);
                        findViewById(R.id.p221).setVisibility(View.VISIBLE);
                        findViewById(R.id.p221_observaciones).setVisibility(View.VISIBLE);
                        //TABLE_208.setVisibility(View.GONE);
                        break;
                    case "3":
                        enabledNatutal(View.VISIBLE);
                        enabledJuridico(View.VISIBLE);
                        findViewById(R.id.p201_otro).setVisibility(View.VISIBLE);
                        findViewById(R.id.p221_titulo).setVisibility(View.VISIBLE);
                        findViewById(R.id.p221).setVisibility(View.VISIBLE);
                        findViewById(R.id.p221_observaciones).setVisibility(View.VISIBLE);
                        //TABLE_221.setVisibility(View.VISIBLE);
                        //TABLE_208.setVisibility(View.VISIBLE);
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Capitulo2Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });

        obternerFormulario();
    }

    private void enabledJuridico(int enable) {
        findViewById(R.id.p212).setVisibility(enable);
        findViewById(R.id.p213).setVisibility(enable);
        findViewById(R.id.p214_nombres).setVisibility(enable);
        findViewById(R.id.p214_apellidos).setVisibility(enable);
        findViewById(R.id.p215_cod_ccpp).setVisibility(enable);
        findViewById(R.id.p216_tipo_via).setVisibility(enable);
//        findViewById(R.id.p216_otra_via).setVisibility(enable);
        findViewById(R.id.p216_nombre_avenida).setVisibility(enable);
        findViewById(R.id.p216_puerta).setVisibility(enable);
        findViewById(R.id.p216_block).setVisibility(enable);
        findViewById(R.id.p216_interior).setVisibility(enable);
        findViewById(R.id.p216_piso).setVisibility(enable);
        findViewById(R.id.p216_manzana).setVisibility(enable);
        findViewById(R.id.p216_lote).setVisibility(enable);
        findViewById(R.id.p217_nombres).setVisibility(enable);
        findViewById(R.id.p217_apellidos).setVisibility(enable);
        findViewById(R.id.p218_cargo).setVisibility(enable);
        //findViewById(R.id.p218_otro_cargo).setVisibility(enable);
        findViewById(R.id.p219_fijo).setVisibility(enable);
        findViewById(R.id.p219_celular).setVisibility(enable);
        findViewById(R.id.p220).setVisibility(enable);
        findViewById(R.id.moduloB).setVisibility(enable);

        findViewById(R.id.p212_titulo).setVisibility(enable);
        findViewById(R.id.p213_titulo).setVisibility(enable);
        findViewById(R.id.p214_titulo).setVisibility(enable);
        findViewById(R.id.p215_titulo).setVisibility(enable);
        findViewById(R.id.p216_titulo).setVisibility(enable);
        findViewById(R.id.p217_titulo).setVisibility(enable);
        findViewById(R.id.p218_titulo).setVisibility(enable);
        findViewById(R.id.p219_titulo).setVisibility(enable);
        findViewById(R.id.p220_titulo).setVisibility(enable);
    }

    private void enabledNatutal(int enable) {


        findViewById(R.id.moduloA).setVisibility(enable);
        findViewById(R.id.p201_otro).setVisibility(enable);
        findViewById(R.id.p202_titulo).setVisibility(enable);
        findViewById(R.id.p202).setVisibility(enable);
        findViewById(R.id.p203_titulo).setVisibility(enable);
        findViewById(R.id.p203_nombres).setVisibility(enable);
        findViewById(R.id.p203_apellidos).setVisibility(enable);
        findViewById(R.id.p204_titulo).setVisibility(enable);
        findViewById(R.id.p204).setVisibility(enable);
        findViewById(R.id.p205_titulo).setVisibility(enable);
        findViewById(R.id.p206_titulo).setVisibility(enable);
        findViewById(R.id.p207_cargo_titulo).setVisibility(enable);
        findViewById(R.id.p208_titulo).setVisibility(enable);
        findViewById(R.id.p209_titulo).setVisibility(enable);
        findViewById(R.id.p210_titulo).setVisibility(enable);
        findViewById(R.id.p211_titulo).setVisibility(enable);
        findViewById(R.id.p212_titulo).setVisibility(enable);
        findViewById(R.id.p205_fijo).setVisibility(enable);
        findViewById(R.id.p205_celular).setVisibility(enable);
        findViewById(R.id.p206).setVisibility(enable);
        findViewById(R.id.p207_cargo).setVisibility(enable);

        findViewById(R.id.p208_nombres).setVisibility(enable);
        findViewById(R.id.p208_apellidos).setVisibility(enable);
        findViewById(R.id.p209_fijo).setVisibility(enable);
        findViewById(R.id.p209_celular).setVisibility(enable);
        findViewById(R.id.p210).setVisibility(enable);
        //findViewById(R.id.departamentos1).setVisibility(enable);
        //findViewById(R.id.provincias1).setVisibility(enable);
        //findViewById(R.id.distritos1).setVisibility(enable);
        //findViewById(R.id.p210_cod_ccpp).setVisibility(enable);
        findViewById(R.id.p211).setVisibility(enable);
        findViewById(R.id.p211_observacion).setVisibility(enable);
    }


    private void obternerFormulario() {
        try {
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm != null) {
                this.formulario = enaForm.getCapitulo2();
                LinearLayout layout = findViewById(R.id.capitulo2);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    Util.setearInformacion(getResources(), view, this.formulario);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void guardarFormulario() {
        formulario = Util.loadData(getAssets(), Constants.CAPITULO2_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.capitulo2);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm == null) {
                enaForm = new EnaForm();
            }

            enaForm.setCapitulo2(this.formulario);
            enaForm.setSegmentoEmpresa(segmentoEmpresa);
            enaForm.setNroParcela(nroParcela);
            enaForm.setDni(dni);
            sqlHelper.saveInformation(enaForm);
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
        }
    }


    public void agregarP218() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar Cargo"));
        list.add(new Combo("1", "¿Representante legal?"));
        list.add(new Combo("2", "¿Directivo del área administrativa y/o financiera?"));
        list.add(new Combo("3", "¿Jefe de campo?"));
        list.add(new Combo("4", "¿Ingeniero de campo?"));
        list.add(new Combo("5", "Otro:"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p218_cargo.setAdapter(dataAdapter);
    }

    public void agregarP211() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p211.setAdapter(dataAdapter);
    }


    public void agregarP207() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "¿Productor(a) agrario(a)?"));
        list.add(new Combo("2", "¿Administrador(a)?"));
        list.add(new Combo("3", "¿Empleado(a)?"));
        list.add(new Combo("4", "¿Familiar?"));
        list.add(new Combo("5", "¿Encargado?"));
        list.add(new Combo("6", "Otro:"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p207_cargo.setAdapter(dataAdapter);
    }

    public void agregarP201() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "¿Persona Natural?"));
        list.add(new Combo("2", "¿Persona Jurídica?"));
        list.add(new Combo("3", "Otro:"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p201_tipo_productor.setAdapter(dataAdapter);
    }

    public void agregarP202() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "¿El productor?"));
        list.add(new Combo("2", "¿La productora?"));
        list.add(new Combo("3", "¿Conjunto?(Esposo-esposa; Esposo-hijo/hija; Esposa-hijo/hija, otro)"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p202.setAdapter(dataAdapter);
    }

    public void agregarCentroPoblados215(String codDepartamento, String codProvincia, String codDistrito, String cod_segmento_empresa) {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar Centro Poblado"));
        List<Ubigeo> centroPobladosList = sqlHelper.buscarCentroPoblados(codDepartamento, codProvincia, codDistrito, cod_segmento_empresa);
        for (Ubigeo ubigeo : centroPobladosList) {
            list.add(new Combo(ubigeo.getCod_ccpp(), ubigeo.getCcpp()));
        }


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p215_cod_ccpp.setAdapter(dataAdapter);

    }

    public void agregarP216() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar Tipo Via"));
        list.add(new Combo("1", "Avenida"));
        list.add(new Combo("2", "Calle"));
        list.add(new Combo("3", "Jirón"));
        list.add(new Combo("4", "Pasaje"));
        list.add(new Combo("5", "Carretera"));
        list.add(new Combo("6", "Otro:"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p216_tipo_via.setAdapter(dataAdapter);
    }

    public void agregarP210() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "¿En esta parcela?"));
        list.add(new Combo("2", "¿En otra parcela dentro del distrito?"));
        list.add(new Combo("3", "Otro:"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p210.setAdapter(dataAdapter);
    }

    public void agregarDepartamentos() {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar Departamento"));
        List<Ubigeo> departamentosList = sqlHelper.buscarDepartamentos();
        for (Ubigeo ubigeo : departamentosList) {
            list.add(new Combo(ubigeo.getCod_departamento(), ubigeo.getDepartamento()));
        }


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departamentos1.setAdapter(dataAdapter);
    }

    public void agregarProvincias(String codDepartamento) {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar Provincia"));
        List<Ubigeo> provinciasList = sqlHelper.buscarProvincias(codDepartamento);
        for (Ubigeo ubigeo : provinciasList) {
            list.add(new Combo(ubigeo.getCod_provincia(), ubigeo.getProvincia()));
        }


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provincias1.setAdapter(dataAdapter);
    }

    public void agregarDistritos(String codDepartamento, String codProvincia) {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar Distrito"));
        List<Ubigeo> distritosList = sqlHelper.buscarDistritos(codDepartamento, codProvincia);
        for (Ubigeo ubigeo : distritosList) {
            list.add(new Combo(ubigeo.getCod_distrito(), ubigeo.getDistrito()));
        }


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distritos1.setAdapter(dataAdapter);
    }

    public void agregarCentroPoblados210(String codDepartamento, String codProvincia, String codDistrito, String cod_segmento_empresa) {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar Centro Poblado"));
        List<Ubigeo> centroPobladosList = sqlHelper.buscarCentroPoblados(codDepartamento, codProvincia, codDistrito, cod_segmento_empresa);
        for (Ubigeo ubigeo : centroPobladosList) {
            list.add(new Combo(ubigeo.getCod_ccpp(), ubigeo.getCcpp()));
        }

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p210_cod_ccpp.setAdapter(dataAdapter);

    }
}