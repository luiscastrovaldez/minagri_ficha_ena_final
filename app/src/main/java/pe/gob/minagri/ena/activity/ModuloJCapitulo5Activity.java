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
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.envio.Capitulo5;
import pe.gob.minagri.ena.envio.Envio;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class ModuloJCapitulo5Activity extends AppCompatActivity {

    private Spinner p534a, p535;

    private String segmentoEmpresa, nroParcela, dni;
    private Intent intent;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private Envio envio;

    private FloatingActionButton guardar5j, validar5j, salirLoteCapitulo5j;

    private CheckBox p534b_pollo_1, p534b_pollo_2, p534b_pollo_3, p534b_pollo_4, p534b_pollo_5, p534b_pollo_6;
    private CheckBox p534b_pavos_7, p534b_pavos_8, p534b_pavos_9, p534b_pavos_10, p534b_pavos_11, p534b_pavos_12;
    private CheckBox p534b_gallinas_13, p534b_gallinas_14, p534b_gallinas_15, p534b_gallinas_16, p534b_gallinas_17, p534b_gallinas_18, p534b_gallinas_19;
    private CheckBox p535a_vacuno_1, p535a_vacuno_2, p535a_ovino, p535b_ave, p535b_porcino, p535b_vacuno_1, p535b_vacuno_2;
    private List<String> p534bPollos;
    private List<String> p534bPavos;
    private List<String> p534bGallinas;

    private List<String> p535aVacuno;
    private List<String> p535aOvino;
    private List<String> p535bAve;
    private List<String> p535bPorcino;
    private List<String> p535bVacuno;

    EditText p534b_pollo_otro, p534b_pavo_otro, p534b_gallina_otro, p534b_vacuno_otro, p534b_porcino_otro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_j_capitulo5);
        this.sqlHelper = new SqlHelper(getApplicationContext());
        intent = getIntent();
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        p534a = findViewById(R.id.p534a);
        p535 = findViewById(R.id.p535);
        p534b_pollo_otro = findViewById(R.id.p534b_pollo_otro);
        p534b_pavo_otro = findViewById(R.id.p534b_pavo_otro);
        p534b_gallina_otro = findViewById(R.id.p534b_gallina_otro);

        p534b_vacuno_otro = findViewById(R.id.p534b_vacuno_otro);
        p534b_porcino_otro = findViewById(R.id.p534b_porcino_otro);

        guardar5j = findViewById(R.id.guardar5j);

        salirLoteCapitulo5j = findViewById(R.id.salirLoteCapitulo5j);
        p534bPollos = new ArrayList<>();
        p534bPavos = new ArrayList<>();
        p534bGallinas = new ArrayList<>();

        p535aVacuno = new ArrayList<>();
        p535aOvino = new ArrayList<>();
        p535bAve = new ArrayList<>();
        p535bPorcino = new ArrayList<>();
        p535bVacuno = new ArrayList<>();


        p534b_pollo_1 = findViewById(R.id.p534b_pollo_1);
        p534b_pollo_2 = findViewById(R.id.p534b_pollo_2);
        p534b_pollo_3 = findViewById(R.id.p534b_pollo_3);
        p534b_pollo_4 = findViewById(R.id.p534b_pollo_4);
        p534b_pollo_5 = findViewById(R.id.p534b_pollo_5);
        p534b_pollo_6 = findViewById(R.id.p534b_pollo_6);

        p534b_pavos_7 = findViewById(R.id.p534b_pavos_7);
        p534b_pavos_8 = findViewById(R.id.p534b_pavos_8);
        p534b_pavos_9 = findViewById(R.id.p534b_pavos_9);
        p534b_pavos_10 = findViewById(R.id.p534b_pavos_10);
        p534b_pavos_11 = findViewById(R.id.p534b_pavos_11);
        p534b_pavos_12 = findViewById(R.id.p534b_pavos_12);

        p534b_gallinas_13 = findViewById(R.id.p534b_gallinas_13);
        p534b_gallinas_14 = findViewById(R.id.p534b_gallinas_14);
        p534b_gallinas_15 = findViewById(R.id.p534b_gallinas_15);
        p534b_gallinas_16 = findViewById(R.id.p534b_gallinas_16);
        p534b_gallinas_17 = findViewById(R.id.p534b_gallinas_17);
        p534b_gallinas_18 = findViewById(R.id.p534b_gallinas_18);
        p534b_gallinas_19 = findViewById(R.id.p534b_gallinas_19);

        p535a_vacuno_1 = findViewById(R.id.p535a_vacuno_1);
        p535a_vacuno_2 = findViewById(R.id.p535a_vacuno_2);
        p535a_ovino = findViewById(R.id.p535a_ovino);
        p535b_ave = findViewById(R.id.p535b_ave);
        p535b_porcino = findViewById(R.id.p535b_porcino);
        p535b_vacuno_1 = findViewById(R.id.p535b_vacuno_1);
        p535b_vacuno_2 = findViewById(R.id.p535b_vacuno_2);


        agregarP534();
        agregarP535();

        salirLoteCapitulo5j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        guardar5j.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(pe.gob.minagri.ena.activity.ModuloJCapitulo5Activity.this)
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
        validar5j.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                if (!validarFormulario()) {
                    guardarFormulario();
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_error), Toast.LENGTH_SHORT).show();
                }
            }
        });
        enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
        if (enaForm != null) {
            String json = enaForm.getJson();
            ObjectMapper obj = new ObjectMapper();
            try {
                envio = obj.readValue(json, Envio.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            if (envio.getCapitulo5() != null) {
                try {
                    Capitulo5 capitulo5 = envio.getCapitulo5();
                    String p536aValue = envio.getCapitulo5().getP536a();

                    p534a.setSelection(Util.getIndex(p534a, "" + capitulo5.getP534a()));

                    String p534bPolloValue = envio.getCapitulo5().getP534bPollo();
                    p534bPollos = new ArrayList<>(Arrays.asList(p534bPolloValue.split("\\s*,\\s*")));
                    List<String> p534bPolloValues = Arrays.asList(p534bPolloValue.split("\\s*,\\s*"));
                    if (p534bPolloValues.contains("1")) {
                        p534b_pollo_1.setChecked(Boolean.TRUE);
                    }
                    if (p534bPolloValues.contains("2")) {
                        p534b_pollo_2.setChecked(Boolean.TRUE);
                    }
                    if (p534bPolloValues.contains("3")) {
                        p534b_pollo_3.setChecked(Boolean.TRUE);
                    }
                    if (p534bPolloValues.contains("4")) {
                        p534b_pollo_4.setChecked(Boolean.TRUE);
                    }
                    if (p534bPolloValues.contains("5")) {
                        p534b_pollo_5.setChecked(Boolean.TRUE);
                    }
                    if (p534bPolloValues.contains("6")) {
                        p534b_pollo_6.setChecked(Boolean.TRUE);
                    }

                    p534b_pollo_otro.setText(capitulo5.getP534bPolloOtro());

                    String p534bPavosValue = envio.getCapitulo5().getP534bPavo();
                    p534bPavos = new ArrayList<>(Arrays.asList(p534bPavosValue.split("\\s*,\\s*")));
                    List<String> p534bPavosValues = Arrays.asList(p534bPavosValue.split("\\s*,\\s*"));
                    if (p534bPavosValues.contains("7")) {
                        p534b_pavos_7.setChecked(Boolean.TRUE);
                    }
                    if (p534bPavosValues.contains("8")) {
                        p534b_pavos_8.setChecked(Boolean.TRUE);
                    }
                    if (p534bPavosValues.contains("9")) {
                        p534b_pavos_9.setChecked(Boolean.TRUE);
                    }
                    if (p534bPavosValues.contains("10")) {
                        p534b_pavos_10.setChecked(Boolean.TRUE);
                    }
                    if (p534bPavosValues.contains("11")) {
                        p534b_pavos_11.setChecked(Boolean.TRUE);
                    }
                    if (p534bPavosValues.contains("12")) {
                        p534b_pavos_12.setChecked(Boolean.TRUE);
                    }
                    p534b_pavo_otro.setText(capitulo5.getP534bPavoOtro());


                    String p534bGallinasValue = envio.getCapitulo5().getP534bGallina();
                    p534bGallinas = new ArrayList<>(Arrays.asList(p534bGallinasValue.split("\\s*,\\s*")));
                    List<String> p534bGallinasValues = Arrays.asList(p534bGallinasValue.split("\\s*,\\s*"));
                    if (p534bGallinasValues.contains("13")) {
                        p534b_gallinas_13.setChecked(Boolean.TRUE);
                    }
                    if (p534bGallinasValues.contains("14")) {
                        p534b_gallinas_14.setChecked(Boolean.TRUE);
                    }
                    if (p534bGallinasValues.contains("15")) {
                        p534b_gallinas_15.setChecked(Boolean.TRUE);
                    }
                    if (p534bGallinasValues.contains("16")) {
                        p534b_gallinas_16.setChecked(Boolean.TRUE);
                    }
                    if (p534bGallinasValues.contains("17")) {
                        p534b_gallinas_17.setChecked(Boolean.TRUE);
                    }
                    if (p534bGallinasValues.contains("18")) {
                        p534b_gallinas_18.setChecked(Boolean.TRUE);
                    }
                    if (p534bGallinasValues.contains("19")) {
                        p534b_gallinas_19.setChecked(Boolean.TRUE);
                    }
                    p534b_gallina_otro.setText(capitulo5.getP534bGallinaOtro());
                    p534b_vacuno_otro.setText(capitulo5.getP534bVacunoOtro());
                    p534b_porcino_otro.setText(capitulo5.getP534bPorcinoOtro());

                    String p535aVacunoValue = envio.getCapitulo5().getP535aVacuno();
                    p535aVacuno = new ArrayList<>(Arrays.asList(p535aVacunoValue.split("\\s*,\\s*")));
                    List<String> p535aVacunoValues = Arrays.asList(p535aVacunoValue.split("\\s*,\\s*"));
                    if (p535aVacunoValues.contains("1")) {
                        p535a_vacuno_1.setChecked(Boolean.TRUE);
                    }
                    if (p535aVacunoValues.contains("2")) {
                        p535a_vacuno_2.setChecked(Boolean.TRUE);
                    }

                    String p535aOvinoValue = envio.getCapitulo5().getP535aOvino();
                    p535aOvino = new ArrayList<>(Arrays.asList(p535aOvinoValue.split("\\s*,\\s*")));
                    List<String> p535aOvinoValues = Arrays.asList(p535aOvinoValue.split("\\s*,\\s*"));
                    if (p535aOvinoValues.contains("1")) {
                        p535a_ovino.setChecked(Boolean.TRUE);
                    }

                    String p535bAveValue = envio.getCapitulo5().getP535bAve();
                    p535bAve = new ArrayList<>(Arrays.asList(p535bAveValue.split("\\s*,\\s*")));
                    List<String> p535bAveValues = Arrays.asList(p535bAveValue.split("\\s*,\\s*"));
                    if (p535bAveValues.contains("1")) {
                        p535b_ave.setChecked(Boolean.TRUE);
                    }

                    String p535bPorcinoValue = envio.getCapitulo5().getP535bPorcino();
                    p535bPorcino = new ArrayList<>(Arrays.asList(p535bPorcinoValue.split("\\s*,\\s*")));
                    List<String> p535bPorcinoValues = Arrays.asList(p535bPorcinoValue.split("\\s*,\\s*"));
                    if (p535bPorcinoValues.contains("1")) {
                        p535b_porcino.setChecked(Boolean.TRUE);
                    }

                    String p535bVacunosValue = envio.getCapitulo5().getP535bVacuno();
                    p535bVacuno = new ArrayList<>(Arrays.asList(p535bVacunosValue.split("\\s*,\\s*")));
                    List<String> p535bVacunosValues = Arrays.asList(p535bVacunosValue.split("\\s*,\\s*"));
                    if (p535bVacunosValues.contains("1")) {
                        p535b_vacuno_1.setChecked(Boolean.TRUE);
                    }
                    if (p535bVacunosValues.contains("2")) {
                        p535b_vacuno_2.setChecked(Boolean.TRUE);
                    }


                    p535.setSelection(Util.getIndex(p535, "" + capitulo5.getP535()));

                } catch (Exception e) {
                    //e.printStackTrace();
                }

            }

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        Combo p534_rptaValue = (Combo) p534a.getSelectedItem();
        Combo p535_rptaValue = (Combo) p535.getSelectedItem();

        enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
        ObjectMapper obj = new ObjectMapper();
        envio = new Envio();
        String jsonStr = null;
        try {
            envio = obj.readValue(enaForm.getJson(), Envio.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Capitulo5 capitulo5;
        if (envio.getCapitulo4() != null) {
            capitulo5 = envio.getCapitulo5();
        } else {
            capitulo5 = new Capitulo5();
        }

        if (p534_rptaValue.getId() != null) {
            capitulo5.setP534a(new Integer(p534_rptaValue.getId()));
        }
        if (p535_rptaValue.getId() != null) {
            capitulo5.setP535(new Integer(p535_rptaValue.getId()));
        }
        capitulo5.setP534bPollo(String.join(",", p534bPollos));
        if (p534b_pollo_otro.getText() != null && !p534b_pollo_otro.getText().toString().isEmpty()) {
            capitulo5.setP534bPolloOtro(p534b_pollo_otro.getText().toString());
        }
        capitulo5.setP534bPavo(String.join(",", p534bPavos));
        if (p534b_pavo_otro.getText() != null && !p534b_pavo_otro.getText().toString().isEmpty()) {
            capitulo5.setP534bPavoOtro(p534b_pavo_otro.getText().toString());
        }

        capitulo5.setP534bGallina(String.join(",", p534bGallinas));
        if (p534b_gallina_otro.getText() != null && !p534b_gallina_otro.getText().toString().isEmpty()) {
            capitulo5.setP534bGallinaOtro(p534b_gallina_otro.getText().toString());
        }

        if (p534b_vacuno_otro.getText() != null && !p534b_vacuno_otro.getText().toString().isEmpty()) {
            capitulo5.setP534bVacunoOtro(p534b_vacuno_otro.getText().toString());
        }

        if (p534b_porcino_otro.getText() != null && !p534b_porcino_otro.getText().toString().isEmpty()) {
            capitulo5.setP534bPorcinoOtro(p534b_porcino_otro.getText().toString());
        }

        capitulo5.setP535aOvino(String.join(",", p535aOvino));
        capitulo5.setP535aVacuno(String.join(",", p535aVacuno));

        capitulo5.setP535bAve(String.join(",", p535bAve));
        capitulo5.setP535bPorcino(String.join(",", p535bPorcino));
        capitulo5.setP535bVacuno(String.join(",", p535bVacuno));

        envio.setCapitulo5(capitulo5);

        try {
            jsonStr = obj.writeValueAsString(envio);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("jsonStr = " + jsonStr);

        enaForm.setJson(jsonStr);
        enaForm.setSegmentoEmpresa(segmentoEmpresa);
        enaForm.setNroParcela(nroParcela);
        enaForm.setDni(dni);
        sqlHelper.saveInformation(enaForm);
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();

    }

    private boolean validarFormulario() {
        return false;
    }

    public void agregarP534() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p534a.setAdapter(dataAdapter);
    }

    public void agregarP535() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p535.setAdapter(dataAdapter);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked

        int index = 0;
        switch (view.getId()) {
            case R.id.p534b_pollo_1:
                if (checked) {
                    p534bPollos.add("1");
                } else {
                    if (p534bPollos.contains("1")) {
                        p534bPollos.remove("1");
                    }
                }
                break;
            case R.id.p534b_pollo_2:
                if (checked) {
                    p534bPollos.add("2");
                } else {
                    if (p534bPollos.contains("2")) {
                        p534bPollos.remove("2");
                    }
                }
                break;
            case R.id.p534b_pollo_3:
                if (checked) {
                    p534bPollos.add("3");
                } else {
                    if (p534bPollos.contains("3")) {
                        p534bPollos.remove("3");
                    }
                }
                break;
            case R.id.p534b_pollo_4:
                if (checked) {
                    p534bPollos.add("4");
                } else {
                    if (p534bPollos.contains("4")) {
                        p534bPollos.remove("4");
                    }
                }
                break;
            case R.id.p534b_pollo_5:
                if (checked) {
                    p534bPollos.add("5");
                } else {
                    if (p534bPollos.contains("5")) {
                        p534bPollos.remove("5");
                    }
                }
                break;
            case R.id.p534b_pollo_6:
                if (checked) {
                    p534bPollos.add("6");
                } else {
                    if (p534bPollos.contains("6")) {
                        p534bPollos.remove("6");
                    }
                }
                break;
            case R.id.p534b_pavos_7:
                if (checked) {
                    p534bPavos.add("7");
                } else {
                    if (p534bPavos.contains("7")) {
                        p534bPavos.remove("7");
                    }
                }
                break;
            case R.id.p534b_pavos_8:
                if (checked) {
                    p534bPavos.add("8");
                } else {
                    if (p534bPavos.contains("8")) {
                        p534bPavos.remove("8");
                    }
                }
                break;
            case R.id.p534b_pavos_9:
                if (checked) {
                    p534bPavos.add("9");
                } else {
                    if (p534bPavos.contains("9")) {
                        p534bPavos.remove("9");
                    }
                }
                break;
            case R.id.p534b_pavos_10:
                if (checked) {
                    p534bPavos.add("10");
                } else {
                    if (p534bPavos.contains("10")) {
                        p534bPavos.remove("10");
                    }
                }
                break;
            case R.id.p534b_pavos_11:
                if (checked) {
                    p534bPavos.add("11");
                } else {
                    if (p534bPavos.contains("11")) {
                        p534bPavos.remove("11");
                    }
                }
                break;
            case R.id.p534b_pavos_12:
                if (checked) {
                    p534bPavos.add("12");
                } else {
                    if (p534bPavos.contains("12")) {
                        p534bPavos.remove("12");
                    }
                }
                break;

            case R.id.p534b_gallinas_13:
                if (checked) {
                    p534bGallinas.add("13");
                } else {
                    if (p534bGallinas.contains("13")) {
                        p534bGallinas.remove("13");
                    }
                }
                break;
            case R.id.p534b_gallinas_14:
                if (checked) {
                    p534bGallinas.add("14");
                } else {
                    if (p534bGallinas.contains("14")) {
                        p534bGallinas.remove("14");
                    }
                }
                break;
            case R.id.p534b_gallinas_15:
                if (checked) {
                    p534bGallinas.add("15");
                } else {
                    if (p534bGallinas.contains("15")) {
                        p534bGallinas.remove("15");
                    }
                }
                break;
            case R.id.p534b_gallinas_16:
                if (checked) {
                    p534bGallinas.add("16");
                } else {
                    if (p534bGallinas.contains("16")) {
                        p534bGallinas.remove("16");
                    }
                }
                break;
            case R.id.p534b_gallinas_17:
                if (checked) {
                    p534bGallinas.add("17");
                } else {
                    if (p534bGallinas.contains("17")) {
                        p534bGallinas.remove("17");
                    }
                }
                break;
            case R.id.p534b_gallinas_18:
                if (checked) {
                    p534bGallinas.add("18");
                } else {
                    if (p534bGallinas.contains("18")) {
                        p534bGallinas.remove("18");
                    }
                }
                break;
            case R.id.p534b_gallinas_19:
                if (checked) {
                    p534bGallinas.add("19");
                } else {
                    if (p534bGallinas.contains("19")) {
                        p534bGallinas.remove("19");
                    }
                }
                break;
        }
    }

}
