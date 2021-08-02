package pe.gob.minagri.ena.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.EnaForm;

import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class ModuloKCapitulo5Activity extends AppCompatActivity {

    private Spinner p540, p536, p538;
    private FloatingActionButton guardar5k, salirLoteCapitulo5k;
    private EditText p536a_otro, p541_observacion;
    private String segmentoEmpresa, nroParcela, dni;
    private Intent intent;
    private SqlHelper sqlHelper;
    private String formulario;
    private EnaForm enaForm;
    private CheckBox p537_1, p537_2, p537_3;
    private List<String> p537;

    private CheckBox p536a_1, p536a_2, p536a_3, p536a_4, p536a_5, p536a_6, p536a_7, p536a_8, p536a_9;

    private CheckBox p539_1, p539_2, p539_3, p539_4, p539_5;
    private List<String> p536a;

    private List<String> p539;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_k_capitulo5);
        p540 = findViewById(R.id.p540);
        p536 = findViewById(R.id.p536);
        p538 = findViewById(R.id.p538);
        p536a_otro = findViewById(R.id.p536a_otro);
        p541_observacion = findViewById(R.id.p541_observacion);

        guardar5k = findViewById(R.id.guardar5k);
        salirLoteCapitulo5k = findViewById(R.id.salirLoteCapitulo5k);
        agregarP540();
        agregarP536();
        agregarP538();
        p537 = new ArrayList<>();
        this.sqlHelper = new SqlHelper(getApplicationContext());
        intent = getIntent();
        p537_1 = (CheckBox) findViewById(R.id.p537_1);
        p537_2 = (CheckBox) findViewById(R.id.p537_2);
        p537_3 = (CheckBox) findViewById(R.id.p537_3);

        p536a = new ArrayList<>();

        p539 = new ArrayList<>();


        p536a_1 = (CheckBox) findViewById(R.id.p536a_1);
        p536a_2 = (CheckBox) findViewById(R.id.p536a_2);
        p536a_3 = (CheckBox) findViewById(R.id.p536a_3);
        p536a_4 = (CheckBox) findViewById(R.id.p536a_4);
        p536a_5 = (CheckBox) findViewById(R.id.p536a_5);
        p536a_6 = (CheckBox) findViewById(R.id.p536a_6);
        p536a_7 = (CheckBox) findViewById(R.id.p536a_7);
        p536a_8 = (CheckBox) findViewById(R.id.p536a_8);
        p536a_9 = (CheckBox) findViewById(R.id.p536a_9);


        p539_1 = (CheckBox) findViewById(R.id.p539_1);
        p539_2 = (CheckBox) findViewById(R.id.p539_2);
        p539_3 = (CheckBox) findViewById(R.id.p539_3);
        p539_4 = (CheckBox) findViewById(R.id.p539_4);
        p539_5 = (CheckBox) findViewById(R.id.p539_5);


        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);

        salirLoteCapitulo5k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        guardar5k.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(ModuloKCapitulo5Activity.this)
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

        obternerFormulario();
    }


    public void onCheckboxClicked5k(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.p537_1:
                if (checked) {
                    p537.add("1");
                } else {
                    if (p537.contains("1")) {
                        p537.remove("1");
                    }
                }
                break;

            case R.id.p537_2:
                if (checked) {
                    p537.add("2");
                } else {
                    if (p537.contains("2")) {
                        p537.remove("2");
                    }
                }
                break;

            case R.id.p537_3:
                if (checked) {
                    p537.add("3");
                } else {
                    if (p537.contains("3")) {
                        p537.remove("3");
                    }
                }
                break;
            case R.id.p536a_1:
                if (checked) {
                    p536a.add("1");
                } else {
                    if (p536a.contains("1")) {
                        p536a.remove("1");
                    }
                }
                break;
            case R.id.p536a_2:
                if (checked) {
                    p536a.add("2");
                } else {
                    if (p536a.contains("2")) {
                        p536a.remove("2");
                    }
                }
                break;
            case R.id.p536a_3:
                if (checked) {
                    p536a.add("3");
                } else {
                    if (p536a.contains("3")) {
                        p536a.remove("3");
                    }
                }
                break;
            case R.id.p536a_4:
                if (checked) {
                    p536a.add("4");
                } else {
                    if (p536a.contains("4")) {
                        p536a.remove("4");
                    }
                }
                break;
            case R.id.p536a_5:
                if (checked) {
                    p536a.add("5");
                } else {
                    if (p536a.contains("5")) {
                        p536a.remove("5");
                    }
                }
                break;
            case R.id.p536a_6:
                if (checked) {
                    p536a.add("6");
                } else {
                    if (p536a.contains("6")) {
                        p536a.remove("6");
                    }
                }
                break;
            case R.id.p536a_7:
                if (checked) {
                    p536a.add("7");
                } else {
                    if (p536a.contains("7")) {
                        p536a.remove("7");
                    }
                }
                break;
            case R.id.p536a_8:
                if (checked) {
                    p536a.add("8");
                } else {
                    if (p536a.contains("8")) {
                        p536a.remove("8");
                    }
                }
                break;
            case R.id.p536a_9:
                if (checked) {
                    p536a.add("9");
                } else {
                    if (p536a.contains("9")) {
                        p536a.remove("9");
                    }
                }
                break;


            case R.id.p539_1:
                if (checked) {
                    p539.add("1");
                } else {
                    if (p539.contains("1")) {
                        p539.remove("1");
                    }
                }
                break;
            case R.id.p539_2:
                if (checked) {
                    p539.add("2");
                } else {
                    if (p539.contains("2")) {
                        p539.remove("2");
                    }
                }
                break;
            case R.id.p539_3:
                if (checked) {
                    p539.add("3");
                } else {
                    if (p539.contains("3")) {
                        p539.remove("3");
                    }
                }
                break;
            case R.id.p539_4:
                if (checked) {
                    p539.add("4");
                } else {
                    if (p539.contains("4")) {
                        p539.remove("4");
                    }
                }
                break;
            case R.id.p539_5:
                if (checked) {
                    p539.add("5");
                } else {
                    if (p539.contains("5")) {
                        p539.remove("5");
                    }
                }
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        formulario = Util.loadData(getAssets(), Constants.CAPITULO5_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.nodulokcapitulo5);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
        }
        enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
        if (enaForm == null) {
            enaForm = new EnaForm();
        }
        this.formulario = this.formulario.replace("p537_value", String.join(",", p537));
        this.formulario = this.formulario.replace("p536a_value", String.join(",", p536a));
        this.formulario = this.formulario.replace("p539_value", String.join(",", p539));
        enaForm.setCapitulo5(this.formulario);
        enaForm.setSegmentoEmpresa(segmentoEmpresa);
        enaForm.setNroParcela(nroParcela);
        enaForm.setDni(dni);
        sqlHelper.saveInformation(enaForm);
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
    }

    public void agregarP540() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p540.setAdapter(dataAdapter);
    }

    public void agregarP536() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p536.setAdapter(dataAdapter);
    }

    public void agregarP538() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p538.setAdapter(dataAdapter);
    }

    private void obternerFormulario() {
        try {
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm != null) {
                this.formulario = enaForm.getCapitulo5();
                LinearLayout layout = findViewById(R.id.nodulokcapitulo5);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    Util.setearInformacion(getResources(), view, this.formulario);
                }
            }
            String p537Value = Util.getJsonValue(this.formulario, "p537");
            p537 = new LinkedList<>(Arrays.asList(p537Value.split("\\s*,\\s*")));

            if (p537.contains("1")) {
                p537_1.setChecked(Boolean.TRUE);
            }
            if (p537.contains("2")) {
                p537_2.setChecked(Boolean.TRUE);
            }
            if (p537.contains("3")) {
                p537_3.setChecked(Boolean.TRUE);
            }

            String p536aValue = Util.getJsonValue(this.formulario, "p536a");
            p536a = new LinkedList<>(Arrays.asList(p536aValue.split("\\s*,\\s*")));

            if (p536a.contains("1")) {
                p536a_1.setChecked(Boolean.TRUE);
            }
            if (p536a.contains("2")) {
                p536a_2.setChecked(Boolean.TRUE);
            }
            if (p536a.contains("3")) {
                p536a_3.setChecked(Boolean.TRUE);
            }
            if (p536a.contains("4")) {
                p536a_4.setChecked(Boolean.TRUE);
            }
            if (p536a.contains("5")) {
                p536a_5.setChecked(Boolean.TRUE);
            }
            if (p536a.contains("6")) {
                p536a_6.setChecked(Boolean.TRUE);
            }
            if (p536a.contains("7")) {
                p536a_7.setChecked(Boolean.TRUE);
            }
            if (p536a.contains("8")) {
                p536a_8.setChecked(Boolean.TRUE);
            }
            if (p536a.contains("9")) {
                p536a_9.setChecked(Boolean.TRUE);
            }

            String p539Value = Util.getJsonValue(this.formulario, "p539");
            p539 = new LinkedList<>(Arrays.asList(p539Value.split("\\s*,\\s*")));

            if (p539.contains("1")) {
                p539_1.setChecked(Boolean.TRUE);
            }
            if (p539.contains("2")) {
                p539_2.setChecked(Boolean.TRUE);
            }
            if (p539.contains("3")) {
                p539_3.setChecked(Boolean.TRUE);
            }
            if (p539.contains("4")) {
                p539_4.setChecked(Boolean.TRUE);
            }

            if (p539.contains("5")) {
                p539_5.setChecked(Boolean.TRUE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}