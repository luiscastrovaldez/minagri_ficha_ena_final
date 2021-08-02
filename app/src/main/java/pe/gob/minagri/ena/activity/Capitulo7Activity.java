package pe.gob.minagri.ena.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
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

public class Capitulo7Activity extends AppCompatActivity {

    private Spinner p603, p604, p607, p608, p609;

    private FloatingActionButton guardar, salir;
    private String segmentoEmpresa, nroParcela, dni;
    private String formulario;

    private EnaForm enaForm;
    private SqlHelper sqlHelper;

    private List<String> p601, p602, p605, p606, p610;
    private CheckBox p601_1, p601_2, p601_3, p601_4, p601_5, p601_6, p601_7;
    private CheckBox p602_1, p602_2, p602_3, p602_4, p602_5, p602_6, p602_7;
    private CheckBox p605_1, p605_2, p605_3, p605_4, p605_5, p605_6;
    private CheckBox p606_1, p606_2, p606_3, p606_4, p606_5;
    private CheckBox p610_1, p610_2, p610_3, p610_4, p610_5, p610_6, p610_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo6);
        Intent intent = getIntent();
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        this.sqlHelper = new SqlHelper(getApplicationContext());
        guardar = findViewById(R.id.guardar6);
        p603 = (Spinner) findViewById(R.id.p603);
        p604 = (Spinner) findViewById(R.id.p604);
        p607 = (Spinner) findViewById(R.id.p607);
        p608 = (Spinner) findViewById(R.id.p608);
        p609 = (Spinner) findViewById(R.id.p609);
        guardar = (FloatingActionButton) findViewById(R.id.guardar6);
        salir = (FloatingActionButton) findViewById(R.id.salirCapitulo6);

        p601 = new ArrayList<>();
        p602 = new ArrayList<>();
        p605 = new ArrayList<>();
        p606 = new ArrayList<>();
        p610 = new ArrayList<>();

        p601_1 = (CheckBox) findViewById(R.id.p601_1);
        p601_2 = (CheckBox) findViewById(R.id.p601_2);
        p601_3 = (CheckBox) findViewById(R.id.p601_3);
        p601_2 = (CheckBox) findViewById(R.id.p601_2);
        p601_4 = (CheckBox) findViewById(R.id.p601_4);
        p601_5 = (CheckBox) findViewById(R.id.p601_5);
        p601_6 = (CheckBox) findViewById(R.id.p601_6);
        p601_7 = (CheckBox) findViewById(R.id.p601_7);

        p602_1 = (CheckBox) findViewById(R.id.p602_1);
        p602_2 = (CheckBox) findViewById(R.id.p602_2);
        p602_3 = (CheckBox) findViewById(R.id.p602_3);
        p602_2 = (CheckBox) findViewById(R.id.p602_2);
        p602_4 = (CheckBox) findViewById(R.id.p602_4);
        p602_5 = (CheckBox) findViewById(R.id.p602_5);
        p602_6 = (CheckBox) findViewById(R.id.p602_6);
        p602_7 = (CheckBox) findViewById(R.id.p602_7);

        p605_1 = (CheckBox) findViewById(R.id.p605_1);
        p605_2 = (CheckBox) findViewById(R.id.p605_2);
        p605_3 = (CheckBox) findViewById(R.id.p605_3);
        p605_2 = (CheckBox) findViewById(R.id.p605_2);
        p605_4 = (CheckBox) findViewById(R.id.p605_4);
        p605_5 = (CheckBox) findViewById(R.id.p605_5);
        p605_6 = (CheckBox) findViewById(R.id.p605_6);

        p606_1 = (CheckBox) findViewById(R.id.p606_1);
        p606_2 = (CheckBox) findViewById(R.id.p606_2);
        p606_3 = (CheckBox) findViewById(R.id.p606_3);
        p606_2 = (CheckBox) findViewById(R.id.p606_2);
        p606_4 = (CheckBox) findViewById(R.id.p606_4);
        p606_5 = (CheckBox) findViewById(R.id.p606_5);

        p610_1 = (CheckBox) findViewById(R.id.p610_1);
        p610_2 = (CheckBox) findViewById(R.id.p610_2);
        p610_3 = (CheckBox) findViewById(R.id.p610_3);
        p610_2 = (CheckBox) findViewById(R.id.p610_2);
        p610_4 = (CheckBox) findViewById(R.id.p610_4);
        p610_5 = (CheckBox) findViewById(R.id.p610_5);
        p610_6 = (CheckBox) findViewById(R.id.p610_6);
        p610_7 = (CheckBox) findViewById(R.id.p610_7);

        agregarp603();
        agregarp604();
        agregarp607();
        agregarp608();
        agregarp609();
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(Capitulo7Activity.this)
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

    private void obternerFormulario() {
        try {
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm != null) {
                this.formulario = enaForm.getCapitulo6();
                LinearLayout layout = findViewById(R.id.capitulo6);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    Util.setearInformacion(getResources(), view, this.formulario);
                }
            }

            String p601Value = Util.getJsonValue(this.formulario, "p601");
            p601 = new LinkedList<>(Arrays.asList(p601Value.split("\\s*,\\s*")));
            List<String> p601Values = Arrays.asList(p601Value.split("\\s*,\\s*"));

            String p602Value = Util.getJsonValue(this.formulario, "p602");
            p602 = new LinkedList<>(Arrays.asList(p602Value.split("\\s*,\\s*")));
            List<String> p602Values = Arrays.asList(p602Value.split("\\s*,\\s*"));

            String p605Value = Util.getJsonValue(this.formulario, "p605");
            p605 = new LinkedList<>(Arrays.asList(p605Value.split("\\s*,\\s*")));
            List<String> p605Values = Arrays.asList(p605Value.split("\\s*,\\s*"));

            String p606Value = Util.getJsonValue(this.formulario, "p606");
            p606 = new LinkedList<>(Arrays.asList(p606Value.split("\\s*,\\s*")));
            List<String> p606Values = Arrays.asList(p606Value.split("\\s*,\\s*"));

            String p610Value = Util.getJsonValue(this.formulario, "p610");
            p610 = new LinkedList<>(Arrays.asList(p610Value.split("\\s*,\\s*")));
            List<String> p610Values = Arrays.asList(p610Value.split("\\s*,\\s*"));


            if (p601Values.contains("1")) {
                p601_1.setChecked(Boolean.TRUE);
            }
            if (p601Values.contains("2")) {
                p601_2.setChecked(Boolean.TRUE);
            }

            if (p601Values.contains("3")) {
                p601_3.setChecked(Boolean.TRUE);
            }

            if (p601Values.contains("4")) {
                p601_4.setChecked(Boolean.TRUE);
            }

            if (p601Values.contains("5")) {
                p601_5.setChecked(Boolean.TRUE);
            }

            if (p601Values.contains("6")) {
                p601_6.setChecked(Boolean.TRUE);
            }

            if (p601Values.contains("7")) {
                p601_7.setChecked(Boolean.TRUE);
            }


            if (p602Values.contains("1")) {
                p602_1.setChecked(Boolean.TRUE);
            }
            if (p602Values.contains("2")) {
                p602_2.setChecked(Boolean.TRUE);
            }

            if (p602Values.contains("3")) {
                p602_3.setChecked(Boolean.TRUE);
            }

            if (p602Values.contains("4")) {
                p602_4.setChecked(Boolean.TRUE);
            }

            if (p602Values.contains("5")) {
                p602_5.setChecked(Boolean.TRUE);
            }

            if (p602Values.contains("6")) {
                p602_6.setChecked(Boolean.TRUE);
            }

            if (p602Values.contains("7")) {
                p602_7.setChecked(Boolean.TRUE);
            }


            if (p605Values.contains("1")) {
                p605_1.setChecked(Boolean.TRUE);
            }
            if (p605Values.contains("2")) {
                p605_2.setChecked(Boolean.TRUE);
            }

            if (p605Values.contains("3")) {
                p605_3.setChecked(Boolean.TRUE);
            }

            if (p605Values.contains("4")) {
                p605_4.setChecked(Boolean.TRUE);
            }

            if (p605Values.contains("5")) {
                p605_5.setChecked(Boolean.TRUE);
            }
            if (p605Values.contains("6")) {
                p605_6.setChecked(Boolean.TRUE);
            }

            if (p606Values.contains("1")) {
                p606_1.setChecked(Boolean.TRUE);
            }
            if (p606Values.contains("2")) {
                p606_2.setChecked(Boolean.TRUE);
            }

            if (p606Values.contains("3")) {
                p606_3.setChecked(Boolean.TRUE);
            }

            if (p606Values.contains("4")) {
                p606_4.setChecked(Boolean.TRUE);
            }

            if (p606Values.contains("5")) {
                p606_5.setChecked(Boolean.TRUE);
            }

            if (p610Values.contains("1")) {
                p610_1.setChecked(Boolean.TRUE);
            }
            if (p610Values.contains("2")) {
                p610_2.setChecked(Boolean.TRUE);
            }

            if (p610Values.contains("3")) {
                p610_3.setChecked(Boolean.TRUE);
            }

            if (p610Values.contains("4")) {
                p610_4.setChecked(Boolean.TRUE);
            }

            if (p610Values.contains("5")) {
                p610_5.setChecked(Boolean.TRUE);
            }

            if (p610Values.contains("6")) {
                p610_6.setChecked(Boolean.TRUE);
            }

            if (p610Values.contains("7")) {
                p610_7.setChecked(Boolean.TRUE);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        formulario = Util.loadData(getAssets(), Constants.CAPITULO6_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.capitulo6);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
        }
        enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
        if (enaForm == null) {
            enaForm = new EnaForm();
        }
        this.formulario = this.formulario.replace("p601_value", String.join(",", p601));
        this.formulario = this.formulario.replace("p602_value", String.join(",", p602));
        this.formulario = this.formulario.replace("p605_value", String.join(",", p605));
        this.formulario = this.formulario.replace("p606_value", String.join(",", p606));
        this.formulario = this.formulario.replace("p610_value", String.join(",", p610));
        enaForm.setCapitulo6(this.formulario);
        enaForm.setSegmentoEmpresa(segmentoEmpresa);
        enaForm.setNroParcela(nroParcela);
        enaForm.setDni(dni);
        sqlHelper.saveInformation(enaForm);
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
    }

    public void onCheckboxClicked6(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked

        int index = 0;
        switch (view.getId()) {
            case R.id.p601_1:
                if (checked) {
                    p601.add("1");
                } else {
                    if (p601.contains("1")) {
                        p601.remove("1");
                    }
                }
                break;
            case R.id.p601_2:
                if (checked) {
                    p601.add("2");
                } else {
                    if (p601.contains("2")) {
                        p601.remove("2");
                    }
                }
                break;
            case R.id.p601_3:
                if (checked) {
                    p601.add("3");
                } else {
                    if (p601.contains("3")) {
                        p601.remove("3");
                    }
                }
                break;
            case R.id.p601_4:
                if (checked) {
                    p601.add("4");
                } else {
                    if (p601.contains("4")) {
                        p601.remove("4");
                    }
                }
                break;
            case R.id.p601_5:
                if (checked) {
                    p601.add("5");
                } else {
                    if (p601.contains("5")) {
                        p601.remove("5");
                    }
                }
                break;
            case R.id.p601_6:
                if (checked) {
                    p601.add("6");
                } else {
                    if (p601.contains("6")) {
                        p601.remove("6");
                    }
                }
                break;

            case R.id.p601_7:
                if (checked) {
                    p601.add("7");

                } else {
                    if (p601.contains("7")) {
                        p601.remove("7");

                    }
                }
                break;
            case R.id.p602_1:
                if (checked) {
                    p602.add("1");
                } else {
                    if (p602.contains("1")) {
                        p602.remove("1");
                    }
                }
                break;
            case R.id.p602_2:
                if (checked) {
                    p602.add("2");
                } else {
                    if (p602.contains("2")) {
                        p602.remove("2");
                    }
                }
                break;
            case R.id.p602_3:
                if (checked) {
                    p602.add("3");
                } else {
                    if (p602.contains("3")) {
                        p602.remove("3");
                    }
                }
                break;
            case R.id.p602_4:
                if (checked) {
                    p602.add("4");
                } else {
                    if (p602.contains("4")) {
                        p602.remove("4");
                    }
                }
                break;
            case R.id.p602_5:
                if (checked) {
                    p602.add("5");
                } else {
                    if (p602.contains("5")) {
                        p602.remove("5");
                    }
                }
                break;
            case R.id.p602_6:
                if (checked) {
                    p602.add("6");
                } else {
                    if (p602.contains("6")) {
                        p602.remove("6");
                    }
                }
                break;

            case R.id.p602_7:
                if (checked) {
                    p602.add("7");

                } else {
                    if (p602.contains("7")) {
                        p602.remove("7");

                    }
                }
                break;

            case R.id.p605_1:
                if (checked) {
                    p605.add("1");
                } else {
                    if (p605.contains("1")) {
                        p605.remove("1");
                    }
                }
                break;
            case R.id.p605_2:
                if (checked) {
                    p605.add("2");
                } else {
                    if (p605.contains("2")) {
                        p605.remove("2");
                    }
                }
                break;
            case R.id.p605_3:
                if (checked) {
                    p605.add("3");
                } else {
                    if (p605.contains("3")) {
                        p605.remove("3");
                    }
                }
                break;
            case R.id.p605_4:
                if (checked) {
                    p605.add("4");
                } else {
                    if (p605.contains("4")) {
                        p605.remove("4");
                    }
                }
                break;
            case R.id.p605_5:
                if (checked) {
                    p605.add("5");
                } else {
                    if (p605.contains("5")) {
                        p605.remove("5");
                    }
                }
                break;
            case R.id.p605_6:
                if (checked) {
                    p605.add("6");
                } else {
                    if (p605.contains("6")) {
                        p605.remove("6");
                    }
                }
                break;


            case R.id.p606_1:
                if (checked) {
                    p606.add("1");
                } else {
                    if (p606.contains("1")) {
                        p606.remove("1");
                    }
                }
                break;
            case R.id.p606_2:
                if (checked) {
                    p606.add("2");
                } else {
                    if (p606.contains("2")) {
                        p606.remove("2");
                    }
                }
                break;
            case R.id.p606_3:
                if (checked) {
                    p606.add("3");
                } else {
                    if (p606.contains("3")) {
                        p606.remove("3");
                    }
                }
                break;
            case R.id.p606_4:
                if (checked) {
                    p606.add("4");
                } else {
                    if (p606.contains("4")) {
                        p606.remove("4");
                    }
                }
                break;
            case R.id.p606_5:
                if (checked) {
                    p606.add("4");
                } else {
                    if (p606.contains("4")) {
                        p606.remove("4");
                    }
                }
                break;


            case R.id.p610_1:
                if (checked) {
                    p610.add("1");
                } else {
                    if (p610.contains("1")) {
                        p610.remove("1");
                    }
                }
                break;
            case R.id.p610_2:
                if (checked) {
                    p610.add("2");
                } else {
                    if (p610.contains("2")) {
                        p610.remove("2");
                    }
                }
                break;
            case R.id.p610_3:
                if (checked) {
                    p610.add("3");
                } else {
                    if (p610.contains("3")) {
                        p610.remove("3");
                    }
                }
                break;
            case R.id.p610_4:
                if (checked) {
                    p610.add("4");
                } else {
                    if (p602.contains("4")) {
                        p610.remove("4");
                    }
                }
                break;
            case R.id.p610_5:
                if (checked) {
                    p610.add("5");
                } else {
                    if (p610.contains("5")) {
                        p610.remove("5");
                    }
                }
                break;
            case R.id.p610_6:
                if (checked) {
                    p610.add("6");
                } else {
                    if (p610.contains("6")) {
                        p610.remove("6");
                    }
                }
                break;

            case R.id.p610_7:
                if (checked) {
                    p610.add("7");
                } else {
                    if (p610.contains("7")) {
                        p610.remove("7");
                    }
                }
                break;
        }
    }

    public void agregarp603() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p603.setAdapter(dataAdapter);
    }

    public void agregarp604() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p604.setAdapter(dataAdapter);
    }

    public void agregarp607() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p607.setAdapter(dataAdapter);
    }

    public void agregarp608() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p608.setAdapter(dataAdapter);
    }

    public void agregarp609() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Productor/a?"));
        list.add(new Combo("2", "Asociación/cooperativa/comité (grupal)?"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p609.setAdapter(dataAdapter);
    }
}