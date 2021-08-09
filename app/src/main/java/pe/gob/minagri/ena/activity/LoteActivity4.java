package pe.gob.minagri.ena.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.clans.fab.FloatingActionButton;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.envio.Capitulo4;
import pe.gob.minagri.ena.envio.Envio;
import pe.gob.minagri.ena.envio.capitulo4.P401;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class LoteActivity4 extends AppCompatActivity {

    private String segmentoEmpresa, nroParcela, dni;
    private Intent intent;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private Envio envio;
    private FloatingActionButton guardar4, validar4, salir;

    private Spinner p401_rpta, p402, p404, p405b, p409, p412b, p418, p419b, p419d, p421, p425c;

    private Spinner p439, p440_rpta_1, p440_rpta_2, p440_rpta_3, p440_rpta_4, p440_rpta_5, p440_rpta_6, p440_rpta_7, p440_rpta_8, p440_rpta_9, p440_rpta_10, p440_rpta_11,
            p440_rpta_12, p440_rpta_13, p440_rpta_14, p440_rpta_15, p440_rpta_16, p440_rpta_17, p440_rpta_18, p440_rpta_19, p440_rpta_20, p440_rpta_21, p440_rpta_22, p442, p445, p446;

    private EditText p403_mes, p403_anio, p405a, p405c, p406, p407_otro, p408_otro, p410a_mes, p410a_anio, p410b_mes, p410b_anio, p412a, p412c, p413, p414;

    private List<P401> p401Lista = null;

    private String index;

    private P401 p401Entity;

    private ListView capitulo4ModuloC, capitulo4ModuloB;

    private List<String> ordenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lote4);
        ordenes = new ArrayList<>();
        intent = getIntent();

        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        index = intent.getStringExtra(Constants.INDEX);
        guardar4 = (FloatingActionButton) findViewById(R.id.guardar4);
        validar4 = (FloatingActionButton) findViewById(R.id.validar4);
        salir = (FloatingActionButton) findViewById(R.id.salirLoteCapitulo4);

        p403_mes = (EditText) findViewById(R.id.p403_mes);
        p403_anio = (EditText) findViewById(R.id.p403_anio);

        p405c = (EditText) findViewById(R.id.p405c);

        p405a = (EditText) findViewById(R.id.p405a);
        p406 = (EditText) findViewById(R.id.p406);
        p407_otro = (EditText) findViewById(R.id.p407_otro);

        p408_otro = (EditText) findViewById(R.id.p408_otro);

        p410a_mes = (EditText) findViewById(R.id.p410a_mes);
        p410a_anio = (EditText) findViewById(R.id.p410a_anio);
        p410b_mes = (EditText) findViewById(R.id.p410b_mes);
        p410b_anio = (EditText) findViewById(R.id.p410b_anio);

        p412a = (EditText) findViewById(R.id.p412a);
        p412c = (EditText) findViewById(R.id.p412c);
        p413 = (EditText) findViewById(R.id.p413);
        p414 = (EditText) findViewById(R.id.p414);


        p401_rpta = (Spinner) findViewById(R.id.p401_rpta);
        p402 = (Spinner) findViewById(R.id.p402);
        p404 = (Spinner) findViewById(R.id.p404);
        p405b = (Spinner) findViewById(R.id.p405b);
        p412b = (Spinner) findViewById(R.id.p412b);
        p418 = (Spinner) findViewById(R.id.p418);
        p409 = (Spinner) findViewById(R.id.p409);

        p419b = (Spinner) findViewById(R.id.p419b);
        p419d = (Spinner) findViewById(R.id.p419d);
        p421 = (Spinner) findViewById(R.id.p421);
        p425c = (Spinner) findViewById(R.id.p425c);

        p439 = (Spinner) findViewById(R.id.p439);

        p440_rpta_1 = (Spinner) findViewById(R.id.p440_rpta_1);
        p440_rpta_2 = (Spinner) findViewById(R.id.p440_rpta_2);
        p440_rpta_3 = (Spinner) findViewById(R.id.p440_rpta_3);
        p440_rpta_4 = (Spinner) findViewById(R.id.p440_rpta_4);
        p440_rpta_5 = (Spinner) findViewById(R.id.p440_rpta_5);
        p440_rpta_6 = (Spinner) findViewById(R.id.p440_rpta_6);
        p440_rpta_7 = (Spinner) findViewById(R.id.p440_rpta_7);
        p440_rpta_8 = (Spinner) findViewById(R.id.p440_rpta_8);
        p440_rpta_9 = (Spinner) findViewById(R.id.p440_rpta_9);
        p440_rpta_10 = (Spinner) findViewById(R.id.p440_rpta_10);
        p440_rpta_11 = (Spinner) findViewById(R.id.p440_rpta_11);
        p440_rpta_12 = (Spinner) findViewById(R.id.p440_rpta_12);
        p440_rpta_13 = (Spinner) findViewById(R.id.p440_rpta_13);
        p440_rpta_14 = (Spinner) findViewById(R.id.p440_rpta_14);
        p440_rpta_15 = (Spinner) findViewById(R.id.p440_rpta_15);
        p440_rpta_16 = (Spinner) findViewById(R.id.p440_rpta_16);
        p440_rpta_17 = (Spinner) findViewById(R.id.p440_rpta_17);
        p440_rpta_18 = (Spinner) findViewById(R.id.p440_rpta_18);
        p440_rpta_19 = (Spinner) findViewById(R.id.p440_rpta_19);
        p440_rpta_20 = (Spinner) findViewById(R.id.p440_rpta_20);
        p440_rpta_21 = (Spinner) findViewById(R.id.p440_rpta_21);
        p440_rpta_22 = (Spinner) findViewById(R.id.p440_rpta_22);
        p442 = (Spinner) findViewById(R.id.p442);
        p445 = (Spinner) findViewById(R.id.p445);
        p446 = (Spinner) findViewById(R.id.p446);


        capitulo4ModuloC = findViewById(R.id.capitulo4ModuloC);
        capitulo4ModuloB = findViewById(R.id.capitulo4ModuloB);

        for (int i = 0; i < 20; i++) {
            ordenes.add(i, "Orden " + (i + 1));
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, ordenes);
        capitulo4ModuloC.setAdapter(adapter);
        capitulo4ModuloB.setAdapter(adapter);

        capitulo4ModuloC.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) capitulo4ModuloC.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), Capitulo4ModuloCActivity.class);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra("index", "" + itemPosition);


                startActivity(intent);
            }

        });

        capitulo4ModuloB.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) capitulo4ModuloB.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), Capitulo4ModuloBActivity.class);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra("index", "" + itemPosition);


                startActivity(intent);
            }

        });

        this.sqlHelper = new SqlHelper(getApplicationContext());
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        agregarP401();
        agregarP402();
        agregarP404();
        agregarP405b();
        agregarP409();
        agregarP412b();
        agregarP418();
        agregarP419b();
        agregarP421();
        agregarP45c();
        agregarP439();
        agregarp440_rpta_1();

        enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
        /*
        if (enaForm != null) {
            String json = enaForm.getJson();
            ObjectMapper obj = new ObjectMapper();
            try {
                envio = obj.readValue(json, Envio.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            if (envio.getCapitulo4() != null && !envio.getCapitulo4().getP401().isEmpty()) {
                p401Lista = envio.getCapitulo4().getP401();
                Capitulo4 capitulo4 = envio.getCapitulo4();
                try {
                    p401Entity = p401Lista.get(new Integer(index));
                    p401_rpta.setSelection(Util.getIndex(p401_rpta, "" + p401Entity.getP401Rpta()));
                    p402.setSelection(Util.getIndex(p402, "" + p401Entity.getP402()));
                    p403_mes.setText(p401Entity.getP403Mes());
                    p403_anio.setText(p401Entity.getP403Anio());
                    p404.setSelection(Util.getIndex(p404, "" + p401Entity.getP404()));
                    p405a.setText(p401Entity.getP405a().toString());
                    p405b.setSelection(Util.getIndex(p405b, "" + p401Entity.getP405b()));
                    p405c.setText(p401Entity.getP405c().toString());
                    p406.setText(p401Entity.getP406().toString());
                    p407_otro.setText(p401Entity.getP407Otro());
                    p408_otro.setText(p401Entity.getP408Otro());
                    p409.setSelection(Util.getIndex(p409, "" + p401Entity.getP409()));

                    p410a_anio.setText(p401Entity.getP410aAnio());
                    p410a_mes.setText(p401Entity.getP410aMes());
                    p410b_anio.setText(p401Entity.getP410bAnio());
                    p410b_mes.setText(p401Entity.getP410bMes());

                    p412a.setText(p401Entity.getP412a().toString());
                    p412b.setSelection(Util.getIndex(p412b, "" + p401Entity.getP412b()));
                    p412c.setText(p401Entity.getP412c().toString());
                    p413.setText(p401Entity.getP413().toString());
                    p414.setText(p401Entity.getP414().toString());

                    p445.setSelection(Util.getIndex(p445, "" + capitulo4.getP445()));
                    p446.setSelection(Util.getIndex(p446, "" + capitulo4.getP446()));

                    p418.setSelection(Util.getIndex(p418, "" + p401Entity.getP418()));

                    //p419a.setText(p401Entity.getP412a().toString());
                    //p412b.setSelection(Util.getIndex(p412b, "" + p401Entity.getP412b()));
                    //p412c.setText(p401Entity.getP412c().toString());

                } catch (Exception e) {
                    //e.printStackTrace();
                }


            }
        }*/

        guardar4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(LoteActivity4.this)
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
        validar4.setOnClickListener(new View.OnClickListener() {
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

        p405b.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Get the spinner selected item text
                Combo combo = (Combo) adapterView.getItemAtPosition(i);
                BigDecimal valor = null;
                if (!combo.getId().equals("0")) {
                    if (p405a.getText().toString().isEmpty()) {
                        p405a.setError("Campo Cantidad es obligatorio");
                        return;
                    } else {
                        p405a.setError(null);
                    }
                }

                switch (combo.getId()) {

                    case "5":
                        valor = new BigDecimal(p405a.getText().toString()).multiply(new BigDecimal(24));
                        valor = valor.setScale(2, BigDecimal.ROUND_HALF_UP);
                        p405c.setText(valor.toString());
                        break;
                    case "011":
                        valor = new BigDecimal(p405a.getText().toString()).multiply(new BigDecimal(25));
                        valor = valor.setScale(2, BigDecimal.ROUND_HALF_UP);
                        p405c.setText(valor.toString());
                        break;

                    case "48":

                        valor = new BigDecimal(p405a.getText().toString()).multiply(new BigDecimal(3));
                        valor = valor.setScale(2, BigDecimal.ROUND_HALF_UP);
                        p405c.setText(valor.toString());
                        break;
                    case "51":

                        valor = new BigDecimal(p405a.getText().toString()).multiply(new BigDecimal(1));
                        valor = valor.setScale(2, BigDecimal.ROUND_HALF_UP);
                        p405c.setText(valor.toString());
                        break;
                    case "72":

                        valor = new BigDecimal(p405a.getText().toString()).multiply(new BigDecimal(2));
                        valor = valor.setScale(2, BigDecimal.ROUND_HALF_UP);
                        p405c.setText(valor.toString());
                        break;
                    case "74":
                        valor = new BigDecimal(p405a.getText().toString()).multiply(new BigDecimal(1));
                        valor = valor.setScale(2, BigDecimal.ROUND_HALF_UP);
                        p405c.setText(valor.toString());
                        break;

                    case "95":

                        valor = new BigDecimal(p405a.getText().toString()).multiply(new BigDecimal(75));
                        valor = valor.setScale(2, BigDecimal.ROUND_HALF_UP);
                        p405c.setText(valor.toString());
                        break;

                    case "19":

                        valor = new BigDecimal(p405a.getText().toString()).multiply(new BigDecimal(0.7));
                        valor = valor.setScale(2, BigDecimal.ROUND_HALF_UP);
                        p405c.setText(valor.toString());
                        break;

                    case "110":

                        valor = new BigDecimal(p405a.getText().toString()).multiply(new BigDecimal(25));
                        valor = valor.setScale(2, BigDecimal.ROUND_HALF_UP);
                        p405c.setText(valor.toString());
                        break;
                    case "114":
                        valor = new BigDecimal(p405a.getText().toString()).multiply(new BigDecimal(23));
                        valor = valor.setScale(2, BigDecimal.ROUND_HALF_UP);
                        p405c.setText(valor.toString());

                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(LoteActivity4.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        Combo p401_rptaValue = (Combo) p401_rpta.getSelectedItem();
        Combo p402_value = (Combo) p402.getSelectedItem();
        Combo p404_value = (Combo) p404.getSelectedItem();
        Combo p405b_value = (Combo) p405b.getSelectedItem();

        Combo p445_value = (Combo) p445.getSelectedItem();
        Combo p446_value = (Combo) p446.getSelectedItem();

        Combo p409_value = (Combo) p409.getSelectedItem();

        Combo p412_value = (Combo) p412b.getSelectedItem();

        enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
        ObjectMapper obj = new ObjectMapper();
        envio = new Envio();
        String jsonStr = null;
        try {
            envio = obj.readValue(enaForm.getJson(), Envio.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Capitulo4 capitulo4;
        if (envio.getCapitulo4() != null) {
            capitulo4 = envio.getCapitulo4();
        } else {
            capitulo4 = new Capitulo4();
        }

        if (envio.getCapitulo4() != null && envio.getCapitulo4().getP401() != null && !envio.getCapitulo4().getP401().isEmpty()) {
            p401Lista = envio.getCapitulo4().getP401();
            try {
                p401Entity = p401Lista.get(new Integer(index));
            } catch (Exception e) {
                p401Entity = new P401();
            }
        } else {
            p401Entity = new P401();
            p401Lista = new ArrayList();
        }
        p401Entity.setP401Num(new Integer(index) + 1);
        p401Entity.setP401Rpta(new Integer(p401_rptaValue.getId()));
        if (p402_value.getId() != null) {
            p401Entity.setP402(p402_value.getId());
        }

        if (p403_anio.getText() != null && !p403_anio.getText().toString().isEmpty()) {
            p401Entity.setP403Anio(p403_anio.getText().toString());
        }

        if (p403_mes.getText() != null && !p403_mes.getText().toString().isEmpty()) {
            p401Entity.setP403Mes(p403_mes.getText().toString());
        }
        if (!p404_value.getId().isEmpty()) {
            p401Entity.setP404(new Integer(p404_value.getId()));
        }
        if (p405a.getText() != null && !p405a.getText().toString().isEmpty()) {
            p401Entity.setP405a(new Double(p405a.getText().toString()));
        }
        if (!p405b_value.getId().isEmpty()) {
            p401Entity.setP405b(new Integer(p405b_value.getId()));
        }

        if (p405c.getText() != null && !p405c.getText().toString().isEmpty()) {
            p401Entity.setP405c(new Double(p405c.getText().toString()));
        }

        if (p406.getText() != null && !p406.getText().toString().isEmpty()) {
            p401Entity.setP406(new Double(p406.getText().toString()));
        }

        if (p407_otro.getText() != null && !p407_otro.getText().toString().isEmpty()) {
            p401Entity.setP407Otro(p407_otro.getText().toString());
        }

        if (p408_otro.getText() != null && !p408_otro.getText().toString().isEmpty()) {
            p401Entity.setP408Otro(p408_otro.getText().toString());
        }

        if (p409_value.getId() != null) {
            p401Entity.setP409(new Integer(p409_value.getId()));
        }

        if (p410a_mes.getText() != null && !p410a_mes.getText().toString().isEmpty()) {
            p401Entity.setP410aMes(p410a_mes.getText().toString());
        }

        if (p410a_anio.getText() != null && !p410a_anio.getText().toString().isEmpty()) {
            p401Entity.setP410aAnio(p410a_anio.getText().toString());
        }

        if (p408_otro.getText() != null && !p408_otro.getText().toString().isEmpty()) {
            p401Entity.setP408Otro(p408_otro.getText().toString());
        }

        if (p410b_mes.getText() != null && !p410b_mes.getText().toString().isEmpty()) {
            p401Entity.setP410bMes(p410b_mes.getText().toString());
        }

        if (p410b_anio.getText() != null && !p410b_anio.getText().toString().isEmpty()) {
            p401Entity.setP410bAnio(p410b_anio.getText().toString());
        }

        if (p412a.getText() != null && !p412a.getText().toString().isEmpty()) {
            p401Entity.setP412a(new Double(p412a.getText().toString()));
        }

        if (p412_value.getId() != null) {
            p401Entity.setP412b(new Integer(p412_value.getId()));
        }

        if (p412c.getText() != null && !p412c.getText().toString().isEmpty()) {
            p401Entity.setP412c(new Double(p412c.getText().toString()));
        }

        if (p413.getText() != null && !p413.getText().toString().isEmpty()) {
            p401Entity.setP413(new Double(p413.getText().toString()));
        }

        if (p414.getText() != null && !p414.getText().toString().isEmpty()) {
            p401Entity.setP414(new Double(p414.getText().toString()));
        }


        if (!p401Lista.isEmpty()) {
            try {
                p401Lista.set(new Integer(index), p401Entity);
            } catch (Exception e) {
                p401Lista.add(new Integer(index), p401Entity);
            }
        } else {
            p401Lista.add(new Integer(index), p401Entity);
        }

        if (!p445_value.getId().isEmpty()) {
            capitulo4.setP445(new Integer(p445_value.getId()));
        }

        if (!p446_value.getId().isEmpty()) {
            capitulo4.setP446(new Integer(p446_value.getId()));
        }

        capitulo4.setP401(p401Lista);
        envio.setCapitulo4(capitulo4);

        try {
            jsonStr = obj.writeValueAsString(envio);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("jsonStr = " + jsonStr);

        enaForm.setJson(jsonStr);
        enaForm.setSegmentoEmpresa(segmentoEmpresa);
        sqlHelper.saveInformation(enaForm);
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
    }

    private boolean validarFormulario() {
        Combo p401_rptaValue = (Combo) p401_rpta.getSelectedItem();
        if (p401_rptaValue.getId().equals("0")) {
            ((TextView) p401_rpta.getSelectedView()).setError("Pregunta 401 es obligatoria");
            Toast.makeText(getApplicationContext(), "Pregunta 401 es obligatoria", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            ((TextView) p401_rpta.getSelectedView()).setError(null);
        }

        Combo p402_value = (Combo) p402.getSelectedItem();
        if (p402_value.getId().equals("0")) {
            ((TextView) p402.getSelectedView()).setError("Pregunta 402 es obligatoria");
            Toast.makeText(getApplicationContext(), "Pregunta 402 es obligatoria", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            ((TextView) p402.getSelectedView()).setError(null);
        }

        if (p403_mes.getText().toString().isEmpty()) {
            p403_mes.setError("Pregunta 403 es obligatoria");
            Toast.makeText(getApplicationContext(), "Pregunta 403 es obligatoria", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            p403_mes.setError(null);
        }

        if (p403_anio.getText().toString().isEmpty()) {
            p403_anio.setError("Pregunta 403 es obligatoria");
            Toast.makeText(getApplicationContext(), "Pregunta 403 es obligatoria", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            p403_anio.setError(null);
        }

        Combo p404_value = (Combo) p404.getSelectedItem();
        if (p404_value.getId().equals("0")) {
            ((TextView) p404.getSelectedView()).setError("Pregunta 404 es obligatoria");
            Toast.makeText(getApplicationContext(), "Pregunta 404 es obligatoria", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            ((TextView) p404.getSelectedView()).setError(null);
        }

        if (p405a.getText().toString().isEmpty()) {
            p405a.setError("Pregunta 405a es obligatoria");
            Toast.makeText(getApplicationContext(), "Pregunta 405a es obligatoria", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            p405a.setError(null);
        }

        Combo p405b_value = (Combo) p405b.getSelectedItem();
        if (p405b_value.getId().equals("0")) {
            ((TextView) p405b.getSelectedView()).setError("Pregunta 405b es obligatoria");
            Toast.makeText(getApplicationContext(), "Pregunta 405b es obligatoria", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            ((TextView) p405b.getSelectedView()).setError(null);
        }

        if (p405c.getText().toString().isEmpty()) {
            p405c.setError("Pregunta 405c es obligatoria");
            Toast.makeText(getApplicationContext(), "Pregunta 405a es obligatoria", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            p405c.setError(null);
        }

        Combo p445_value = (Combo) p445.getSelectedItem();
        if (p445_value.getId().equals("0")) {
            ((TextView) p445.getSelectedView()).setError("Pregunta 445 es obligatoria");
            Toast.makeText(getApplicationContext(), "Pregunta 445 es obligatoria", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            ((TextView) p445.getSelectedView()).setError(null);
        }
        Combo p446_value = (Combo) p446.getSelectedItem();
        if (p446_value.getId().equals("0")) {
            ((TextView) p446.getSelectedView()).setError("Pregunta 446 es obligatoria");
            Toast.makeText(getApplicationContext(), "Pregunta 446 es obligatoria", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            ((TextView) p446.getSelectedView()).setError(null);
        }

        return false;
    }

    public void agregarP401() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Presente"));
        list.add(new Combo("2", "Pasado"));
        list.add(new Combo("3", "Future"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p401_rpta.setAdapter(dataAdapter);
    }

    public void agregarP402() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Transitorio"));
        list.add(new Combo("2", "Permanente"));
        list.add(new Combo("3", "Forestales"));
        list.add(new Combo("4", "Pastos sembrados"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p402.setAdapter(dataAdapter);
    }

    public void agregarP404() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Solo"));
        list.add(new Combo("2", "Asociado"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p404.setAdapter(dataAdapter);
    }

    public void agregarP405b() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("5", "Almud"));
        list.add(new Combo("6", "Almud (otro)"));
        list.add(new Combo("11", "Arroba"));
        list.add(new Combo("12", "Arroba (otro)"));
        list.add(new Combo("48", "Fanegada"));
        list.add(new Combo("51", "Hectárea"));
        list.add(new Combo("72", "Melga"));
        list.add(new Combo("73", "Melga (otro)"));
        list.add(new Combo("74", "Metro cuadrado"));
        list.add(new Combo("95", "Tabla"));
        list.add(new Combo("96", "Tabla (otro)"));
        list.add(new Combo("19", "Vara"));
        list.add(new Combo("110", "Yugada"));
        list.add(new Combo("111", "Yugada (otro)"));
        list.add(new Combo("114", "Yuntada"));
        list.add(new Combo("115", "Yuntada (otro)"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p405b.setAdapter(dataAdapter);
    }

    public void agregarP409() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Producción"));
        list.add(new Combo("2", "¿Protección"));
        list.add(new Combo("3", "Rodal Semillero"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p409.setAdapter(dataAdapter);
    }

    public void agregarP412b() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("5", "Almud"));
        list.add(new Combo("6", "Almud (otro)"));
        list.add(new Combo("11", "Arroba"));
        list.add(new Combo("12", "Arroba (otro)"));
        list.add(new Combo("48", "Fanegada"));
        list.add(new Combo("51", "Hectárea"));
        list.add(new Combo("72", "Melga"));
        list.add(new Combo("73", "Melga (otro)"));
        list.add(new Combo("74", "Metro cuadrado"));
        list.add(new Combo("95", "Tabla"));
        list.add(new Combo("96", "Tabla (otro)"));
        list.add(new Combo("19", "Vara"));
        list.add(new Combo("110", "Yugada"));
        list.add(new Combo("111", "Yugada (otro)"));
        list.add(new Combo("114", "Yuntada"));
        list.add(new Combo("115", "Yuntada (otro)"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p412b.setAdapter(dataAdapter);
    }

    public void agregarP419b() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("5", "Almud"));
        list.add(new Combo("6", "Almud (otro)"));
        list.add(new Combo("11", "Arroba"));
        list.add(new Combo("12", "Arroba (otro)"));
        list.add(new Combo("48", "Fanegada"));
        list.add(new Combo("51", "Hectárea"));
        list.add(new Combo("72", "Melga"));
        list.add(new Combo("73", "Melga (otro)"));
        list.add(new Combo("74", "Metro cuadrado"));
        list.add(new Combo("95", "Tabla"));
        list.add(new Combo("96", "Tabla (otro)"));
        list.add(new Combo("19", "Vara"));
        list.add(new Combo("110", "Yugada"));
        list.add(new Combo("111", "Yugada (otro)"));
        list.add(new Combo("114", "Yuntada"));
        list.add(new Combo("115", "Yuntada (otro)"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p419b.setAdapter(dataAdapter);
    }

    public void agregarP418() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Por Corte"));
        list.add(new Combo("2", "Por Pastore"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p418.setAdapter(dataAdapter);
    }

    public void agregarP421() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p421.setAdapter(dataAdapter);
        p442.setAdapter(dataAdapter);
        p445.setAdapter(dataAdapter);
        p446.setAdapter(dataAdapter);

    }

    public void agregarp440_rpta_1() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p440_rpta_1.setAdapter(dataAdapter);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p440_rpta_2.setAdapter(dataAdapter);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p440_rpta_3.setAdapter(dataAdapter);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p440_rpta_4.setAdapter(dataAdapter);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p440_rpta_5.setAdapter(dataAdapter);
        p440_rpta_6.setAdapter(dataAdapter);
        p440_rpta_7.setAdapter(dataAdapter);
        p440_rpta_8.setAdapter(dataAdapter);
        p440_rpta_9.setAdapter(dataAdapter);
        p440_rpta_10.setAdapter(dataAdapter);
        p440_rpta_11.setAdapter(dataAdapter);
        p440_rpta_12.setAdapter(dataAdapter);
        p440_rpta_13.setAdapter(dataAdapter);
        p440_rpta_14.setAdapter(dataAdapter);
        p440_rpta_15.setAdapter(dataAdapter);
        p440_rpta_16.setAdapter(dataAdapter);
        p440_rpta_17.setAdapter(dataAdapter);
        p440_rpta_18.setAdapter(dataAdapter);
        p440_rpta_19.setAdapter(dataAdapter);
        p440_rpta_20.setAdapter(dataAdapter);
        p440_rpta_21.setAdapter(dataAdapter);
        p440_rpta_22.setAdapter(dataAdapter);
    }


    public void agregarP45c() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("5", "Almud"));
        list.add(new Combo("6", "Almud (otro)"));
        list.add(new Combo("11", "Arroba"));
        list.add(new Combo("12", "Arroba (otro)"));
        list.add(new Combo("48", "Fanegada"));
        list.add(new Combo("51", "Hectárea"));
        list.add(new Combo("72", "Melga"));
        list.add(new Combo("73", "Melga (otro)"));
        list.add(new Combo("74", "Metro cuadrado"));
        list.add(new Combo("95", "Tabla"));
        list.add(new Combo("96", "Tabla (otro)"));
        list.add(new Combo("19", "Vara"));
        list.add(new Combo("110", "Yugada"));
        list.add(new Combo("111", "Yugada (otro)"));
        list.add(new Combo("114", "Yuntada"));
        list.add(new Combo("115", "Yuntada (otro)"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p425c.setAdapter(dataAdapter);
    }

    public void agregarP439() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Buena"));
        list.add(new Combo("2", "Regular"));
        list.add(new Combo("3", "Pobre"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p439.setAdapter(dataAdapter);
    }
}
