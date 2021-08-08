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

public class Capitulo7Activity extends AppCompatActivity {


    private FloatingActionButton guardar, salir;
    private String segmentoEmpresa, nroParcela, dni;
    private String formulario;

    private EnaForm enaForm;
    private SqlHelper sqlHelper;

    private Spinner p710, p724, p725, p728, p730;

    private CheckBox p714_1, p714_2, p714_3, p714_4, p714_5, p714_6, p714_7,
            p715_1, p715_2, p715_3, p715_4, p715_5, p715_6, p715_7,
            p716_1, p716_2, p716_3, p716_4, p716_5, p716_6, p716_7,
            p717_1, p717_2, p717_3, p717_4, p717_5, p717_6, p717_7,
            p718_1, p718_2, p718_3, p718_4, p718_5, p718_6, p718_7,
            p719_1, p719_2, p719_3, p719_4, p719_5, p719_6,
            p726_1, p726_2, p726_3, p726_4, p726_5, p726_6, p726_7, p726_8, p726_9, p726_10, p726_11,
            p727_1, p727_2, p727_3, p727_4, p727_5, p727_6, p727_7, p727_8, p727_9, p727_10,
            p729_1, p729_2, p729_3, p729_4, p729_5,
            p731_1, p731_2, p731_3, p731_4, p731_5, p731_6;

    private List<String> p714, p715, p716, p717, p718, p719, p731, p729, p727, p726;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo7);
        Intent intent = getIntent();
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        p710 = findViewById(R.id.p710);
        p724 = findViewById(R.id.p724);
        p725 = findViewById(R.id.p725);
        p728 = findViewById(R.id.p728);
        p730 = findViewById(R.id.p730);

        p714 = new ArrayList<>();
        p715 = new ArrayList<>();
        p716 = new ArrayList<>();
        p717 = new ArrayList<>();
        p719 = new ArrayList<>();
        p718 = new ArrayList<>();
        p731 = new ArrayList<>();
        p729 = new ArrayList<>();
        p727 = new ArrayList<>();
        p726 = new ArrayList<>();

        p727_1 = (CheckBox) findViewById(R.id.p727_1);
        p727_2 = (CheckBox) findViewById(R.id.p727_2);
        p727_3 = (CheckBox) findViewById(R.id.p727_3);
        p727_4 = (CheckBox) findViewById(R.id.p727_4);
        p727_5 = (CheckBox) findViewById(R.id.p727_5);
        p727_6 = (CheckBox) findViewById(R.id.p727_6);
        p727_7 = (CheckBox) findViewById(R.id.p727_7);
        p727_8 = (CheckBox) findViewById(R.id.p727_8);
        p727_9 = (CheckBox) findViewById(R.id.p727_9);
        p727_10 = (CheckBox) findViewById(R.id.p727_10);
        p729_1 = (CheckBox) findViewById(R.id.p729_1);
        p729_2 = (CheckBox) findViewById(R.id.p729_2);
        p729_3 = (CheckBox) findViewById(R.id.p729_3);
        p729_4 = (CheckBox) findViewById(R.id.p729_4);
        p729_5 = (CheckBox) findViewById(R.id.p729_5);
        p731_1 = (CheckBox) findViewById(R.id.p731_1);
        p731_2 = (CheckBox) findViewById(R.id.p731_2);
        p731_3 = (CheckBox) findViewById(R.id.p731_3);
        p731_4 = (CheckBox) findViewById(R.id.p731_4);
        p731_5 = (CheckBox) findViewById(R.id.p731_5);
        p731_6 = (CheckBox) findViewById(R.id.p731_6);

        p714_1 = (CheckBox) findViewById(R.id.p714_1);
        p714_2 = (CheckBox) findViewById(R.id.p714_2);
        p714_3 = (CheckBox) findViewById(R.id.p714_3);
        p714_4 = (CheckBox) findViewById(R.id.p714_4);
        p714_5 = (CheckBox) findViewById(R.id.p714_5);
        p714_6 = (CheckBox) findViewById(R.id.p714_6);
        p714_7 = (CheckBox) findViewById(R.id.p714_7);

        p715_1 = (CheckBox) findViewById(R.id.p715_1);
        p715_2 = (CheckBox) findViewById(R.id.p715_2);
        p715_3 = (CheckBox) findViewById(R.id.p715_3);
        p715_4 = (CheckBox) findViewById(R.id.p715_4);
        p715_5 = (CheckBox) findViewById(R.id.p715_5);
        p715_6 = (CheckBox) findViewById(R.id.p715_6);
        p715_7 = (CheckBox) findViewById(R.id.p715_7);
        p716_1 = (CheckBox) findViewById(R.id.p716_1);
        p716_2 = (CheckBox) findViewById(R.id.p716_2);
        p716_3 = (CheckBox) findViewById(R.id.p716_3);
        p716_4 = (CheckBox) findViewById(R.id.p716_4);
        p716_5 = (CheckBox) findViewById(R.id.p716_5);
        p716_6 = (CheckBox) findViewById(R.id.p716_6);
        p716_7 = (CheckBox) findViewById(R.id.p716_7);

        p717_1 = (CheckBox) findViewById(R.id.p717_1);
        p717_2 = (CheckBox) findViewById(R.id.p717_2);
        p717_3 = (CheckBox) findViewById(R.id.p717_3);
        p717_4 = (CheckBox) findViewById(R.id.p717_4);
        p717_5 = (CheckBox) findViewById(R.id.p717_5);
        p717_6 = (CheckBox) findViewById(R.id.p717_6);
        p717_7 = (CheckBox) findViewById(R.id.p717_7);

        p718_1 = (CheckBox) findViewById(R.id.p718_1);
        p718_2 = (CheckBox) findViewById(R.id.p718_2);
        p718_3 = (CheckBox) findViewById(R.id.p718_3);
        p718_4 = (CheckBox) findViewById(R.id.p718_4);
        p718_5 = (CheckBox) findViewById(R.id.p718_5);
        p718_6 = (CheckBox) findViewById(R.id.p718_6);
        p718_7 = (CheckBox) findViewById(R.id.p718_7);

        p719_1 = (CheckBox) findViewById(R.id.p719_1);
        p719_2 = (CheckBox) findViewById(R.id.p719_2);
        p719_3 = (CheckBox) findViewById(R.id.p719_3);
        p719_4 = (CheckBox) findViewById(R.id.p719_4);
        p719_5 = (CheckBox) findViewById(R.id.p719_5);
        p719_6 = (CheckBox) findViewById(R.id.p719_6);

        p724 = (Spinner) findViewById(R.id.p724);
        p725 = (Spinner) findViewById(R.id.p725);
        p726_1 = (CheckBox) findViewById(R.id.p726_1);
        p726_2 = (CheckBox) findViewById(R.id.p726_2);
        p726_3 = (CheckBox) findViewById(R.id.p726_3);
        p726_4 = (CheckBox) findViewById(R.id.p726_4);
        p726_5 = (CheckBox) findViewById(R.id.p726_5);
        p726_7 = (CheckBox) findViewById(R.id.p726_6);
        p726_6 = (CheckBox) findViewById(R.id.p726_7);
        p726_8 = (CheckBox) findViewById(R.id.p726_8);
        p726_9 = (CheckBox) findViewById(R.id.p726_9);
        p726_10 = (CheckBox) findViewById(R.id.p726_10);
        p726_11 = (CheckBox) findViewById(R.id.p726_11);
        p728 = (Spinner) findViewById(R.id.p728);
        p730 = (Spinner) findViewById(R.id.p730);

        p727_1 = (CheckBox) findViewById(R.id.p727_1);
        p727_2 = (CheckBox) findViewById(R.id.p727_2);
        p727_3 = (CheckBox) findViewById(R.id.p727_3);
        p727_4 = (CheckBox) findViewById(R.id.p727_4);
        p727_5 = (CheckBox) findViewById(R.id.p727_5);
        p727_6 = (CheckBox) findViewById(R.id.p727_6);
        p727_7 = (CheckBox) findViewById(R.id.p727_7);
        p727_8 = (CheckBox) findViewById(R.id.p727_8);
        p727_9 = (CheckBox) findViewById(R.id.p727_9);
        p727_10 = (CheckBox) findViewById(R.id.p727_10);
        p729_1 = (CheckBox) findViewById(R.id.p729_1);
        p729_2 = (CheckBox) findViewById(R.id.p729_2);
        p729_3 = (CheckBox) findViewById(R.id.p729_3);
        p729_4 = (CheckBox) findViewById(R.id.p729_4);
        p729_5 = (CheckBox) findViewById(R.id.p729_5);
        p731_1 = (CheckBox) findViewById(R.id.p731_1);
        p731_2 = (CheckBox) findViewById(R.id.p731_2);
        p731_3 = (CheckBox) findViewById(R.id.p731_3);
        p731_4 = (CheckBox) findViewById(R.id.p731_4);
        p731_5 = (CheckBox) findViewById(R.id.p731_5);
        p731_6 = (CheckBox) findViewById(R.id.p731_6);

        this.sqlHelper = new SqlHelper(getApplicationContext());
        guardar = (FloatingActionButton) findViewById(R.id.guardar7);
        salir = (FloatingActionButton) findViewById(R.id.salirCapitulo7);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        addNiveles();
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
                this.formulario = enaForm.getCapitulo7();
                LinearLayout layout = findViewById(R.id.capitulo7);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    Util.setearInformacion(getResources(), view, this.formulario);
                }


                String p714Value = Util.getJsonValue(this.formulario, "p714");
                p714 = new LinkedList<>(Arrays.asList(p714Value.split("\\s*,\\s*")));

                if (p714.contains("1")) {
                    p714_1.setChecked(Boolean.TRUE);
                }
                if (p714.contains("2")) {
                    p714_2.setChecked(Boolean.TRUE);
                }
                if (p714.contains("3")) {
                    p714_3.setChecked(Boolean.TRUE);
                }
                if (p714.contains("4")) {
                    p714_4.setChecked(Boolean.TRUE);
                }
                if (p714.contains("5")) {
                    p714_5.setChecked(Boolean.TRUE);
                }
                if (p714.contains("6")) {
                    p714_6.setChecked(Boolean.TRUE);
                }
                if (p714.contains("7")) {
                    p714_7.setChecked(Boolean.TRUE);
                }

                String p715Value = Util.getJsonValue(this.formulario, "p715");
                p715 = new LinkedList<>(Arrays.asList(p715Value.split("\\s*,\\s*")));

                if (p715.contains("1")) {
                    p715_1.setChecked(Boolean.TRUE);
                }
                if (p715.contains("2")) {
                    p715_2.setChecked(Boolean.TRUE);
                }
                if (p715.contains("3")) {
                    p715_3.setChecked(Boolean.TRUE);
                }
                if (p715.contains("4")) {
                    p715_4.setChecked(Boolean.TRUE);
                }
                if (p715.contains("5")) {
                    p715_5.setChecked(Boolean.TRUE);
                }
                if (p715.contains("6")) {
                    p715_6.setChecked(Boolean.TRUE);
                }
                if (p715.contains("7")) {
                    p715_7.setChecked(Boolean.TRUE);
                }

                String p716Value = Util.getJsonValue(this.formulario, "p716");
                p716 = new LinkedList<>(Arrays.asList(p716Value.split("\\s*,\\s*")));

                if (p716.contains("1")) {
                    p716_1.setChecked(Boolean.TRUE);
                }
                if (p716.contains("2")) {
                    p716_2.setChecked(Boolean.TRUE);
                }
                if (p716.contains("3")) {
                    p716_3.setChecked(Boolean.TRUE);
                }
                if (p716.contains("4")) {
                    p716_4.setChecked(Boolean.TRUE);
                }
                if (p716.contains("5")) {
                    p716_5.setChecked(Boolean.TRUE);
                }
                if (p716.contains("6")) {
                    p716_6.setChecked(Boolean.TRUE);
                }
                if (p716.contains("7")) {
                    p716_7.setChecked(Boolean.TRUE);
                }

                String p717Value = Util.getJsonValue(this.formulario, "p717");
                p717 = new LinkedList<>(Arrays.asList(p717Value.split("\\s*,\\s*")));

                if (p717.contains("1")) {
                    p717_1.setChecked(Boolean.TRUE);
                }
                if (p717.contains("2")) {
                    p717_2.setChecked(Boolean.TRUE);
                }
                if (p717.contains("3")) {
                    p717_3.setChecked(Boolean.TRUE);
                }
                if (p717.contains("4")) {
                    p717_4.setChecked(Boolean.TRUE);
                }
                if (p717.contains("5")) {
                    p717_5.setChecked(Boolean.TRUE);
                }
                if (p717.contains("6")) {
                    p717_6.setChecked(Boolean.TRUE);
                }
                if (p717.contains("7")) {
                    p717_7.setChecked(Boolean.TRUE);
                }

                String p719Value = Util.getJsonValue(this.formulario, "p719");
                p719 = new LinkedList<>(Arrays.asList(p719Value.split("\\s*,\\s*")));

                if (p719.contains("1")) {
                    p719_1.setChecked(Boolean.TRUE);
                }
                if (p719.contains("2")) {
                    p719_2.setChecked(Boolean.TRUE);
                }
                if (p719.contains("3")) {
                    p719_3.setChecked(Boolean.TRUE);
                }
                if (p719.contains("4")) {
                    p719_4.setChecked(Boolean.TRUE);
                }
                if (p719.contains("5")) {
                    p719_5.setChecked(Boolean.TRUE);
                }
                if (p719.contains("6")) {
                    p719_6.setChecked(Boolean.TRUE);
                }

                String p718Value = Util.getJsonValue(this.formulario, "p718");
                p718 = new LinkedList<>(Arrays.asList(p718Value.split("\\s*,\\s*")));

                if (p718.contains("1")) {
                    p718_1.setChecked(Boolean.TRUE);
                }
                if (p718.contains("2")) {
                    p718_2.setChecked(Boolean.TRUE);
                }
                if (p718.contains("3")) {
                    p718_3.setChecked(Boolean.TRUE);
                }
                if (p718.contains("4")) {
                    p718_4.setChecked(Boolean.TRUE);
                }
                if (p718.contains("5")) {
                    p729_5.setChecked(Boolean.TRUE);
                }
                if (p718.contains("6")) {
                    p718_6.setChecked(Boolean.TRUE);
                }
                if (p718.contains("7")) {
                    p718_7.setChecked(Boolean.TRUE);
                }


                String p726Value = Util.getJsonValue(this.formulario, "p726");
                p726 = new LinkedList<>(Arrays.asList(p726Value.split("\\s*,\\s*")));

                if (p726.contains("1")) {
                    p726_1.setChecked(Boolean.TRUE);
                }
                if (p726.contains("2")) {
                    p726_2.setChecked(Boolean.TRUE);
                }
                if (p726.contains("3")) {
                    p726_3.setChecked(Boolean.TRUE);
                }
                if (p726.contains("4")) {
                    p726_4.setChecked(Boolean.TRUE);
                }
                if (p726.contains("5")) {
                    p726_5.setChecked(Boolean.TRUE);
                }
                if (p726.contains("6")) {
                    p726_6.setChecked(Boolean.TRUE);
                }
                if (p726.contains("7")) {
                    p726_7.setChecked(Boolean.TRUE);
                }

                if (p726.contains("8")) {
                    p726_8.setChecked(Boolean.TRUE);
                }

                if (p726.contains("9")) {
                    p726_9.setChecked(Boolean.TRUE);
                }

                if (p726.contains("10")) {
                    p726_10.setChecked(Boolean.TRUE);
                }

                if (p726.contains("11")) {
                    p726_11.setChecked(Boolean.TRUE);
                }

                String p727Value = Util.getJsonValue(this.formulario, "p727");
                p727 = new LinkedList<>(Arrays.asList(p727Value.split("\\s*,\\s*")));

                if (p727.contains("1")) {
                    p727_1.setChecked(Boolean.TRUE);
                }
                if (p727.contains("2")) {
                    p727_2.setChecked(Boolean.TRUE);
                }
                if (p727.contains("3")) {
                    p727_3.setChecked(Boolean.TRUE);
                }
                if (p727.contains("4")) {
                    p727_4.setChecked(Boolean.TRUE);
                }
                if (p727.contains("5")) {
                    p727_5.setChecked(Boolean.TRUE);
                }
                if (p727.contains("6")) {
                    p727_6.setChecked(Boolean.TRUE);
                }
                if (p727.contains("7")) {
                    p727_7.setChecked(Boolean.TRUE);
                }

                if (p727.contains("8")) {
                    p727_8.setChecked(Boolean.TRUE);
                }

                if (p727.contains("9")) {
                    p727_9.setChecked(Boolean.TRUE);
                }

                if (p727.contains("10")) {
                    p727_10.setChecked(Boolean.TRUE);
                }

                String p729Value = Util.getJsonValue(this.formulario, "p729");
                p729 = new LinkedList<>(Arrays.asList(p729Value.split("\\s*,\\s*")));

                if (p729.contains("1")) {
                    p729_1.setChecked(Boolean.TRUE);
                }
                if (p729.contains("2")) {
                    p729_2.setChecked(Boolean.TRUE);
                }
                if (p729.contains("3")) {
                    p729_3.setChecked(Boolean.TRUE);
                }
                if (p729.contains("4")) {
                    p729_4.setChecked(Boolean.TRUE);
                }
                if (p729.contains("5")) {
                    p729_5.setChecked(Boolean.TRUE);
                }


                String p731Value = Util.getJsonValue(this.formulario, "p731");
                p731 = new LinkedList<>(Arrays.asList(p731Value.split("\\s*,\\s*")));
                if (p731.contains("1")) {
                    p731_1.setChecked(Boolean.TRUE);
                }
                if (p731.contains("2")) {
                    p731_2.setChecked(Boolean.TRUE);
                }
                if (p731.contains("3")) {
                    p731_3.setChecked(Boolean.TRUE);
                }
                if (p731.contains("4")) {
                    p731_4.setChecked(Boolean.TRUE);
                }
                if (p731.contains("5")) {
                    p731_5.setChecked(Boolean.TRUE);
                }
                if (p731.contains("6")) {
                    p731_6.setChecked(Boolean.TRUE);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        formulario = Util.loadData(getAssets(), Constants.CAPITULO7_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.capitulo7);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
        }
        enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
        if (enaForm == null) {
            enaForm = new EnaForm();
        }

        this.formulario = this.formulario.replace("p714_value", String.join(",", p714));
        this.formulario = this.formulario.replace("p715_value", String.join(",", p715));
        this.formulario = this.formulario.replace("p716_value", String.join(",", p716));
        this.formulario = this.formulario.replace("p717_value", String.join(",", p717));
        this.formulario = this.formulario.replace("p718_value", String.join(",", p718));
        this.formulario = this.formulario.replace("p719_value", String.join(",", p719));
        this.formulario = this.formulario.replace("p731_value", String.join(",", p731));
        this.formulario = this.formulario.replace("p727_value", String.join(",", p727));
        this.formulario = this.formulario.replace("p726_value", String.join(",", p726));
        this.formulario = this.formulario.replace("p729_value", String.join(",", p729));

        enaForm.setCapitulo7(this.formulario);
        enaForm.setSegmentoEmpresa(segmentoEmpresa);
        enaForm.setNroParcela(nroParcela);
        enaForm.setDni(dni);
        sqlHelper.saveInformation(enaForm);
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
    }

    public void addNiveles() {
        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Si"));
        list.add(new Combo("2", "No"));
        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p710.setAdapter(dataAdapter);
        p724.setAdapter(dataAdapter);
        p725.setAdapter(dataAdapter);
        p728.setAdapter(dataAdapter);
        p730.setAdapter(dataAdapter);

    }

    public void onCheckboxClicked7(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked

        int index = 0;
        switch (view.getId()) {
            case R.id.p714_1:
                if (checked) {
                    p714.add("1");
                } else {
                    if (p714.contains("1")) {
                        p714.remove("1");
                    }
                }
                break;
            case R.id.p714_2:
                if (checked) {
                    p714.add("2");
                } else {
                    if (p714.contains("2")) {
                        p714.remove("2");
                    }
                }
                break;
            case R.id.p714_3:
                if (checked) {
                    p714.add("3");
                } else {
                    if (p714.contains("3")) {
                        p714.remove("3");
                    }
                }
                break;
            case R.id.p714_4:
                if (checked) {
                    p714.add("4");
                } else {
                    if (p714.contains("4")) {
                        p714.remove("4");
                    }
                }
                break;
            case R.id.p714_5:
                if (checked) {
                    p714.add("5");
                } else {
                    if (p714.contains("5")) {
                        p714.remove("5");
                    }
                }
                break;
            case R.id.p714_6:
                if (checked) {
                    p714.add("6");
                } else {
                    if (p714.contains("6")) {
                        p714.remove("6");
                    }
                }
                break;
            case R.id.p714_7:
                if (checked) {
                    p714.add("7");
                } else {
                    if (p714.contains("7")) {
                        p714.remove("7");
                    }
                }
                break;
            case R.id.p715_1:
                if (checked) {
                    p715.add("1");
                } else {
                    if (p715.contains("1")) {
                        p715.remove("1");
                    }
                }
                break;
            case R.id.p715_2:
                if (checked) {
                    p715.add("2");
                } else {
                    if (p715.contains("2")) {
                        p715.remove("2");
                    }
                }
                break;
            case R.id.p715_3:
                if (checked) {
                    p715.add("3");
                } else {
                    if (p715.contains("3")) {
                        p715.remove("3");
                    }
                }
                break;
            case R.id.p715_4:
                if (checked) {
                    p715.add("4");
                } else {
                    if (p715.contains("4")) {
                        p715.remove("4");
                    }
                }
                break;
            case R.id.p715_5:
                if (checked) {
                    p715.add("5");
                } else {
                    if (p715.contains("5")) {
                        p715.remove("5");
                    }
                }
                break;
            case R.id.p715_6:
                if (checked) {
                    p715.add("6");
                } else {
                    if (p715.contains("6")) {
                        p715.remove("6");
                    }
                }
                break;
            case R.id.p715_7:
                if (checked) {
                    p715.add("7");
                } else {
                    if (p715.contains("7")) {
                        p715.remove("7");
                    }
                }
                break;

            case R.id.p716_1:
                if (checked) {
                    p716.add("1");
                } else {
                    if (p716.contains("1")) {
                        p716.remove("1");
                    }
                }
                break;
            case R.id.p716_2:
                if (checked) {
                    p716.add("2");
                } else {
                    if (p716.contains("2")) {
                        p716.remove("2");
                    }
                }
                break;
            case R.id.p716_3:
                if (checked) {
                    p716.add("3");
                } else {
                    if (p716.contains("3")) {
                        p716.remove("3");
                    }
                }
                break;
            case R.id.p716_4:
                if (checked) {
                    p716.add("4");
                } else {
                    if (p716.contains("4")) {
                        p716.remove("4");
                    }
                }
                break;
            case R.id.p716_5:
                if (checked) {
                    p716.add("5");
                } else {
                    if (p716.contains("5")) {
                        p716.remove("5");
                    }
                }
                break;
            case R.id.p716_6:
                if (checked) {
                    p716.add("6");
                } else {
                    if (p716.contains("6")) {
                        p716.remove("6");
                    }
                }
                break;
            case R.id.p716_7:
                if (checked) {
                    p716.add("7");
                } else {
                    if (p716.contains("7")) {
                        p716.remove("7");
                    }
                }
                break;

            case R.id.p717_1:
                if (checked) {
                    p717.add("1");
                } else {
                    if (p717.contains("1")) {
                        p717.remove("1");
                    }
                }
                break;
            case R.id.p717_2:
                if (checked) {
                    p717.add("2");
                } else {
                    if (p717.contains("2")) {
                        p717.remove("2");
                    }
                }
                break;
            case R.id.p717_3:
                if (checked) {
                    p717.add("3");
                } else {
                    if (p717.contains("3")) {
                        p717.remove("3");
                    }
                }
                break;
            case R.id.p717_4:
                if (checked) {
                    p717.add("4");
                } else {
                    if (p717.contains("4")) {
                        p717.remove("4");
                    }
                }
                break;
            case R.id.p717_5:
                if (checked) {
                    p717.add("5");
                } else {
                    if (p717.contains("5")) {
                        p717.remove("5");
                    }
                }
                break;
            case R.id.p717_6:
                if (checked) {
                    p717.add("6");
                } else {
                    if (p717.contains("6")) {
                        p717.remove("6");
                    }
                }
                break;
            case R.id.p717_7:
                if (checked) {
                    p717.add("7");
                } else {
                    if (p717.contains("7")) {
                        p717.remove("7");
                    }
                }
                break;

            case R.id.p719_1:
                if (checked) {
                    p719.add("1");
                } else {
                    if (p719.contains("1")) {
                        p719.remove("1");
                    }
                }
                break;
            case R.id.p719_2:
                if (checked) {
                    p719.add("2");
                } else {
                    if (p719.contains("2")) {
                        p719.remove("2");
                    }
                }
                break;
            case R.id.p719_3:
                if (checked) {
                    p719.add("3");
                } else {
                    if (p719.contains("3")) {
                        p719.remove("3");
                    }
                }
                break;
            case R.id.p719_4:
                if (checked) {
                    p719.add("4");
                } else {
                    if (p719.contains("4")) {
                        p719.remove("4");
                    }
                }
                break;
            case R.id.p719_5:
                if (checked) {
                    p719.add("5");
                } else {
                    if (p719.contains("5")) {
                        p719.remove("5");
                    }
                }
                break;
            case R.id.p719_6:
                if (checked) {
                    p719.add("6");
                } else {
                    if (p719.contains("6")) {
                        p719.remove("6");
                    }
                }
                break;

            case R.id.p726_1:
                if (checked) {
                    p726.add("1");
                } else {
                    if (p726.contains("1")) {
                        p726.remove("1");
                    }
                }
                break;
            case R.id.p726_2:
                if (checked) {
                    p726.add("2");
                } else {
                    if (p726.contains("2")) {
                        p726.remove("2");
                    }
                }
                break;
            case R.id.p726_3:
                if (checked) {
                    p726.add("3");
                } else {
                    if (p726.contains("3")) {
                        p726.remove("3");
                    }
                }
                break;
            case R.id.p726_4:
                if (checked) {
                    p726.add("4");
                } else {
                    if (p726.contains("4")) {
                        p726.remove("4");
                    }
                }
                break;
            case R.id.p726_5:
                if (checked) {
                    p726.add("5");
                } else {
                    if (p726.contains("5")) {
                        p726.remove("5");
                    }
                }
                break;
            case R.id.p726_6:
                if (checked) {
                    p726.add("6");
                } else {
                    if (p726.contains("6")) {
                        p726.remove("6");
                    }
                }
                break;
            case R.id.p726_7:
                if (checked) {
                    p726.add("7");
                } else {
                    if (p726.contains("7")) {
                        p726.remove("7");
                    }
                }
                break;
            case R.id.p726_8:
                if (checked) {
                    p726.add("8");
                } else {
                    if (p726.contains("8")) {
                        p726.remove("8");
                    }
                }
                break;
            case R.id.p726_9:
                if (checked) {
                    p726.add("9");
                } else {
                    if (p726.contains("9")) {
                        p726.remove("9");
                    }
                }
                break;
            case R.id.p726_10:
                if (checked) {
                    p726.add("10");
                } else {
                    if (p726.contains("10")) {
                        p726.remove("10");
                    }
                }
                break;
            case R.id.p726_11:
                if (checked) {
                    p726.add("11");
                } else {
                    if (p726.contains("11")) {
                        p726.remove("11");
                    }
                }
                break;
            case R.id.p727_1:
                if (checked) {
                    p727.add("1");
                } else {
                    if (p727.contains("1")) {
                        p727.remove("1");
                    }
                }
                break;
            case R.id.p727_2:
                if (checked) {
                    p727.add("2");
                } else {
                    if (p727.contains("2")) {
                        p727.remove("2");
                    }
                }
                break;
            case R.id.p727_3:
                if (checked) {
                    p727.add("3");
                } else {
                    if (p727.contains("3")) {
                        p727.remove("3");
                    }
                }
                break;
            case R.id.p727_4:
                if (checked) {
                    p727.add("4");
                } else {
                    if (p727.contains("4")) {
                        p727.remove("4");
                    }
                }
                break;
            case R.id.p727_5:
                if (checked) {
                    p727.add("5");
                } else {
                    if (p727.contains("5")) {
                        p727.remove("5");
                    }
                }
                break;
            case R.id.p727_6:
                if (checked) {
                    p727.add("6");
                } else {
                    if (p727.contains("6")) {
                        p727.remove("6");
                    }
                }
                break;
            case R.id.p727_7:
                if (checked) {
                    p727.add("7");
                } else {
                    if (p727.contains("7")) {
                        p727.remove("7");
                    }
                }
                break;
            case R.id.p727_8:
                if (checked) {
                    p727.add("8");
                } else {
                    if (p727.contains("8")) {
                        p727.remove("8");
                    }
                }
                break;
            case R.id.p727_9:
                if (checked) {
                    p727.add("9");
                } else {
                    if (p727.contains("9")) {
                        p727.remove("9");
                    }
                }
                break;
            case R.id.p727_10:
                if (checked) {
                    p727.add("10");
                } else {
                    if (p727.contains("10")) {
                        p727.remove("10");
                    }
                }
                break;
            case R.id.p731_1:
                if (checked) {
                    p731.add("1");
                } else {
                    if (p731.contains("1")) {
                        p731.remove("1");
                    }
                }
                break;
            case R.id.p731_2:
                if (checked) {
                    p731.add("2");
                } else {
                    if (p731.contains("2")) {
                        p731.remove("2");
                    }
                }
                break;
            case R.id.p731_3:
                if (checked) {
                    p731.add("3");
                } else {
                    if (p731.contains("3")) {
                        p731.remove("3");
                    }
                }
                break;
            case R.id.p731_4:
                if (checked) {
                    p731.add("4");
                } else {
                    if (p731.contains("4")) {
                        p731.remove("4");
                    }
                }
                break;
            case R.id.p731_5:
                if (checked) {
                    p731.add("5");
                } else {
                    if (p731.contains("5")) {
                        p731.remove("5");
                    }
                }
                break;
            case R.id.p731_6:
                if (checked) {
                    p731.add("6");
                } else {
                    if (p731.contains("6")) {
                        p731.remove("6");
                    }
                }
                break;

            case R.id.p729_1:
                if (checked) {
                    p729.add("1");
                } else {
                    if (p729.contains("1")) {
                        p729.remove("1");
                    }
                }
                break;
            case R.id.p729_2:
                if (checked) {
                    p729.add("2");
                } else {
                    if (p729.contains("2")) {
                        p729.remove("2");
                    }
                }
                break;
            case R.id.p729_3:
                if (checked) {
                    p729.add("3");
                } else {
                    if (p729.contains("3")) {
                        p729.remove("3");
                    }
                }
                break;
            case R.id.p729_4:
                if (checked) {
                    p729.add("4");
                } else {
                    if (p729.contains("4")) {
                        p729.remove("4");
                    }
                }
                break;
            case R.id.p729_5:
                if (checked) {
                    p729.add("5");
                } else {
                    if (p729.contains("5")) {
                        p729.remove("5");
                    }
                }
                break;


        }
    }
}