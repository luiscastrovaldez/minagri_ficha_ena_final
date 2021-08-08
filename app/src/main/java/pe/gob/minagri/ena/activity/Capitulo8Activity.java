package pe.gob.minagri.ena.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;
public class Capitulo8Activity extends AppCompatActivity {

    private FloatingActionButton btnGuardar8, btnSalir;
    private String segmentoEmpresa, nroParcela, dni;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private String formulario;

    private List<String> P801, P802, P803;
    private CheckBox P801_1, P801_2, P801_3, P801_4, P801_5, P801_6, P801_7, P801_8;
    private CheckBox P802_1, P802_2, P802_3, P802_4, P802_5, P802_6, P802_7;
    private CheckBox P803_1, P803_2, P803_3, P803_4, P803_5, P803_6, P803_7, P803_8, P803_9, P803_10;
    private EditText P802_otro, P803_otro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo8);
        inicializarCapitulo();
        obternerFormulario();

        btnGuardar8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                AlertDialog alertDialog = new AlertDialog.Builder(Capitulo8Activity.this)
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
        P801 = new ArrayList<>();
        P802 = new ArrayList<>();
        P803 = new ArrayList<>();

        P801_1 = (CheckBox) findViewById(R.id.p801_1);
        P801_2 = (CheckBox) findViewById(R.id.p801_2);
        P801_3 = (CheckBox) findViewById(R.id.p801_3);
        P801_4 = (CheckBox) findViewById(R.id.p801_4);
        P801_5 = (CheckBox) findViewById(R.id.p801_5);
        P801_6 = (CheckBox) findViewById(R.id.p801_6);
        P801_7 = (CheckBox) findViewById(R.id.p801_7);
        P801_8 = (CheckBox) findViewById(R.id.p801_8);

        P802_1 = (CheckBox) findViewById(R.id.p802_1);
        P802_2 = (CheckBox) findViewById(R.id.p802_2);
        P802_3 = (CheckBox) findViewById(R.id.p802_3);
        P802_4 = (CheckBox) findViewById(R.id.p802_4);
        P802_5 = (CheckBox) findViewById(R.id.p802_5);
        P802_6 = (CheckBox) findViewById(R.id.p802_6);
        P802_7 = (CheckBox) findViewById(R.id.p802_7);
        P802_otro = (EditText) findViewById(R.id.p802_otro);

        P803_1 = (CheckBox) findViewById(R.id.p803_1);
        P803_2 = (CheckBox) findViewById(R.id.p803_2);
        P803_3 = (CheckBox) findViewById(R.id.p803_3);
        P803_4 = (CheckBox) findViewById(R.id.p803_4);
        P803_5 = (CheckBox) findViewById(R.id.p803_5);
        P803_6 = (CheckBox) findViewById(R.id.p803_6);
        P803_7 = (CheckBox) findViewById(R.id.p803_7);
        P803_8 = (CheckBox) findViewById(R.id.p803_8);
        P803_9 = (CheckBox) findViewById(R.id.p803_9);
        P803_10 = (CheckBox) findViewById(R.id.p803_10);
        P803_otro = (EditText) findViewById(R.id.p803_otro);

        P802_otro.setVisibility(View.GONE);
        P803_otro.setVisibility(View.GONE);

        btnGuardar8 = (FloatingActionButton) findViewById(R.id.btnGuardar8);
        btnSalir = (FloatingActionButton) findViewById(R.id.btnSalirCap8);

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
                this.formulario = enaForm.getCapitulo8();
                LinearLayout layout = findViewById(R.id.capitulo8);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    Util.setearInformacion(getResources(), view, this.formulario);
                }

                String p801Value = Util.getJsonValue(this.formulario, "p801");
                String p802Value = Util.getJsonValue(this.formulario, "p802");
                String p803Value = Util.getJsonValue(this.formulario, "p803");
                List<String> pCheckValues;

                if (!p801Value.contains("_value")) {
                    P801 = new LinkedList<>(Arrays.asList(p801Value.split("\\s*,\\s*")));
                    pCheckValues = Arrays.asList(p801Value.split("\\s*,\\s*"));

                    if (pCheckValues.contains("1")) {
                        P801_1.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("2")) {
                        P801_2.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("3")) {
                        P801_3.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("4")) {
                        P801_4.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("5")) {
                        P801_5.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("6")) {
                        P801_6.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("7")) {
                        P801_7.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("8")) {
                        P801_8.setChecked(Boolean.TRUE);
                    }
                }

                if (!p802Value.contains("_value")) {
                    P802 = new LinkedList<>(Arrays.asList(p802Value.split("\\s*,\\s*")));
                    pCheckValues = Arrays.asList(p802Value.split("\\s*,\\s*"));

                    P802_otro.setVisibility(View.GONE);
                    if (pCheckValues.contains("1")) {
                        P802_1.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("2")) {
                        P802_2.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("3")) {
                        P802_3.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("4")) {
                        P802_4.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("5")) {
                        P802_5.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("6")) {
                        P802_6.setChecked(Boolean.TRUE);
                        P802_otro.setVisibility(View.VISIBLE);
                    }
                    if (pCheckValues.contains("7")) {
                        P802_7.setChecked(Boolean.TRUE);
                    }
                }

                if (!p803Value.contains("_value")) {
                    P803 = new LinkedList<>(Arrays.asList(p803Value.split("\\s*,\\s*")));
                    pCheckValues = Arrays.asList(p803Value.split("\\s*,\\s*"));
                    P803_otro.setVisibility(View.GONE);
                    if (pCheckValues.contains("1")) {
                        P803_1.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("2")) {
                        P803_2.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("3")) {
                        P803_3.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("4")) {
                        P803_4.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("5")) {
                        P803_5.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("6")) {
                        P803_6.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("7")) {
                        P803_7.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("8")) {
                        P803_8.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("9")) {
                        P803_9.setChecked(Boolean.TRUE);
                    }
                    if (pCheckValues.contains("10")) {
                        P803_10.setChecked(Boolean.TRUE);
                        P803_otro.setVisibility(View.VISIBLE);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        formulario = Util.loadData(getAssets(), Constants.CAPITULO8_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.capitulo8);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
        }
        enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
        if (enaForm == null) {
            enaForm = new EnaForm();
        }
        this.formulario = this.formulario.replace("p801_value", String.join(",", P801));
        this.formulario = this.formulario.replace("p802_value", String.join(",", P802));
        this.formulario = this.formulario.replace("p803_value", String.join(",", P803));

        enaForm.setCapitulo8(this.formulario);
        enaForm.setSegmentoEmpresa(segmentoEmpresa);
        enaForm.setNroParcela(nroParcela);
        enaForm.setDni(dni);
        sqlHelper.saveInformation(enaForm);
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
    }


    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        int index = 0;
        switch (view.getId()) {
            case R.id.p801_1:
                if (checked) {
                    P801.add("1");
                } else {
                    if (P801.contains("1")) {
                        P801.remove("1");
                    }
                }
                break;
            case R.id.p801_2:
                if (checked) {
                    P801.add("2");
                } else {
                    if (P801.contains("2")) {
                        P801.remove("2");
                    }
                }
                break;
            case R.id.p801_3:
                if (checked) {
                    P801.add("3");
                } else {
                    if (P801.contains("3")) {
                        P801.remove("3");
                    }
                }
                break;
            case R.id.p801_4:
                if (checked) {
                    P801.add("4");
                } else {
                    if (P801.contains("4")) {
                        P801.remove("4");
                    }
                }
                break;
            case R.id.p801_5:
                if (checked) {
                    P801.add("5");
                } else {
                    if (P801.contains("5")) {
                        P801.remove("5");
                    }
                }
                break;
            case R.id.p801_6:
                if (checked) {
                    P801.add("6");
                } else {
                    if (P801.contains("6")) {
                        P801.remove("6");
                    }
                }
                break;

            case R.id.p801_7:
                if (checked) {
                    P801.add("7");
                } else {
                    if (P801.contains("7")) {
                        P801.remove("7");
                    }
                }
                break;

            case R.id.p801_8:
                if (checked) {
                    P801.clear();
                    P801.add("8");
                    limpiarCheckBox(P801_1);
                    limpiarCheckBox(P801_2);
                    limpiarCheckBox(P801_3);
                    limpiarCheckBox(P801_4);
                    limpiarCheckBox(P801_5);
                    limpiarCheckBox(P801_6);
                    limpiarCheckBox(P801_7);
                } else {
                    if (P801.contains("8")) {
                        P801.remove("8");
                    }
                }
                break;

            case R.id.p802_1:
                if (checked) {
                    P802.add("1");
                } else {
                    if (P802.contains("1")) {
                        P802.remove("1");
                    }
                }
                break;
            case R.id.p802_2:
                if (checked) {
                    P802.add("2");
                } else {
                    if (P802.contains("2")) {
                        P802.remove("2");
                    }
                }
                break;
            case R.id.p802_3:
                if (checked) {
                    P802.add("3");
                } else {
                    if (P802.contains("3")) {
                        P802.remove("3");
                    }
                }
                break;
            case R.id.p802_4:
                if (checked) {
                    P802.add("4");
                } else {
                    if (P802.contains("4")) {
                        P802.remove("4");
                    }
                }
                break;
            case R.id.p802_5:
                if (checked) {
                    P802.add("5");
                } else {
                    if (P802.contains("5")) {
                        P802.remove("5");
                    }
                }
                break;
            case R.id.p802_6:
                if (checked) {
                    P802.add("6");
                    P802_otro.setVisibility(View.VISIBLE);
                } else {
                    if (P802.contains("6")) {
                        P802.remove("6");
                        P802_otro.setText("");
                        P802_otro.setVisibility(View.GONE);
                    }
                }
                break;

            case R.id.p802_7:
                if (checked) {
                    P802.clear();
                    P802.add("7");
                    limpiarCheckBox(P802_1);
                    limpiarCheckBox(P802_2);
                    limpiarCheckBox(P803_3);
                    limpiarCheckBox(P803_4);
                    limpiarCheckBox(P803_5);
                    limpiarCheckBox(P803_6);
                    P802_otro.setText("");
                    P802_otro.setVisibility(View.GONE);

                } else {
                    if (P802.contains("7")) {
                        P802.remove("7");
                    }
                }
                break;

            case R.id.p803_1:
                if (checked) {
                    P803.add("1");
                } else {
                    if (P803.contains("1")) {
                        P803.remove("1");
                    }
                }
                break;
            case R.id.p803_2:
                if (checked) {
                    P803.add("2");
                } else {
                    if (P803.contains("2")) {
                        P803.remove("2");
                    }
                }
                break;
            case R.id.p803_3:
                if (checked) {
                    P803.add("3");
                } else {
                    if (P803.contains("3")) {
                        P803.remove("3");
                    }
                }
                break;
            case R.id.p803_4:
                if (checked) {
                    P803.add("4");
                } else {
                    if (P803.contains("4")) {
                        P803.remove("4");
                    }
                }
                break;
            case R.id.p803_5:
                if (checked) {
                    P803.add("5");
                } else {
                    if (P803.contains("5")) {
                        P803.remove("5");
                    }
                }
                break;
            case R.id.p803_6:
                if (checked) {
                    P803.add("6");
                } else {
                    if (P803.contains("6")) {
                        P803.remove("6");
                    }
                }
                break;
            case R.id.p803_7:
                if (checked) {
                    P803.add("7");
                } else {
                    if (P803.contains("7")) {
                        P803.remove("7");
                    }
                }
                break;
            case R.id.p803_8:
                if (checked) {
                    P803.add("8");
                } else {
                    if (P803.contains("8")) {
                        P803.remove("8");
                    }
                }
                break;
            case R.id.p803_9:
                if (checked) {
                    P803.add("9");
                } else {
                    if (P803.contains("9")) {
                        P803.remove("9");
                    }
                }
                break;
            case R.id.p803_10:
                if (checked) {
                    P803.add("10");
                    P803_otro.setVisibility(View.VISIBLE);
                } else {
                    if (P803.contains("10")) {
                        P803.remove("10");
                        P803_otro.setText("");
                        P803_otro.setVisibility(View.GONE);
                    }
                }
                break;

        }
    }
    private void limpiarCheckBox(CheckBox opcion){
        opcion.setChecked(Boolean.FALSE);
    }
}