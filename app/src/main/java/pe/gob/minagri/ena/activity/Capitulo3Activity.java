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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

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

public class Capitulo3Activity extends AppCompatActivity {

    private ListView lotesView;
    private Intent intent;
    private String segmentoEmpresa, nroParcela, dni;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private FloatingActionButton guardar, lote, salir;
    private String formulario;
    private Spinner p301d_unidad_segmento, p301d_unidad_parcela, p302, p304_um_parcela_2, p304_um_parcela_3, p304_um_parcela_4;

    private CheckBox p305_1, p305_2, p305_3, p305_4, p305_5;
    private List<String> p305List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo3);
        this.sqlHelper = new SqlHelper(getApplicationContext());
        intent = getIntent();
        guardar = (FloatingActionButton) findViewById(R.id.guardar3);

        salir = (FloatingActionButton) findViewById(R.id.salirCapitulo3);
        lote = (FloatingActionButton) findViewById(R.id.lote);
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        lotesView = findViewById(R.id.lotesView3);
        p301d_unidad_parcela = findViewById(R.id.p301d_unidad_parcela);
        p301d_unidad_segmento = findViewById(R.id.p301d_unidad_segmento);
        p304_um_parcela_2 = findViewById(R.id.p304_um_parcela_2);
        p304_um_parcela_3 = findViewById(R.id.p304_um_parcela_3);
        p304_um_parcela_4 = findViewById(R.id.p304_um_parcela_4);
        p302 = findViewById(R.id.p302);

        formulario = Util.loadData(getAssets(), Constants.CAPITULO3_FORMULARIO_JSON);
        agregarUnidadMedidaParcela();
        agregarUnidadMedidaSegmento();
        agregarP302();
        agregarP304_um_parcela_2();
        agregarP304_um_parcela_3();
        agregarP304_um_parcela_4();

        p305_1 = (CheckBox) findViewById(R.id.p305_1);
        p305_2 = (CheckBox) findViewById(R.id.p305_2);
        p305_3 = (CheckBox) findViewById(R.id.p305_3);
        p305_4 = (CheckBox) findViewById(R.id.p305_4);
        p305_5 = (CheckBox) findViewById(R.id.p305_5);

        List<String> lotes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lotes.add(i, "Lote " + (i + 1));
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, lotes);
        lotesView.setAdapter(adapter);

        lotesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) lotesView.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), LoteActivity3.class);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra("index", "" + itemPosition);


                startActivity(intent);
            }

        });


        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(Capitulo3Activity.this)
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
                this.formulario = enaForm.getCapitulo3();
                LinearLayout layout = findViewById(R.id.capitulo3);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    Util.setearInformacion(getResources(), view, this.formulario);
                    Util.setearInformacionArray(getResources(), view, this.formulario, "p304");
                }
            }
            String p305_regimen_tenencia = Util.getJsonValue(this.formulario, "p305_regimen_tenencia");
            p305List = new LinkedList<>(Arrays.asList(p305_regimen_tenencia.split("\\s*,\\s*")));

            if (p305List.contains("1")) {
                p305_1.setChecked(Boolean.TRUE);
            }
            if (p305List.contains("2")) {
                p305_2.setChecked(Boolean.TRUE);
            }
            if (p305List.contains("3")) {
                p305_3.setChecked(Boolean.TRUE);
            }
            if (p305List.contains("4")) {
                p305_4.setChecked(Boolean.TRUE);
            }
            if (p305List.contains("5")) {
                p305_5.setChecked(Boolean.TRUE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        formulario = Util.loadData(getAssets(), Constants.CAPITULO3_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.capitulo3);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm == null) {
                enaForm = new EnaForm();
            }
            this.formulario = this.formulario.replace("p305_regimen_tenencia_value", String.join(",", p305List));
            enaForm.setCapitulo3(this.formulario);
            enaForm.setSegmentoEmpresa(segmentoEmpresa);
            enaForm.setNroParcela(nroParcela);
            enaForm.setDni(dni);
            sqlHelper.saveInformation(enaForm);
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
        }
    }

    public void agregarUnidadMedidaSegmento() {

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
        p301d_unidad_segmento.setAdapter(dataAdapter);
    }

    public void agregarUnidadMedidaParcela() {

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
        p301d_unidad_parcela.setAdapter(dataAdapter);
    }

    public void agregarP302() {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p302.setAdapter(dataAdapter);

    }

    public void agregarP304_um_parcela_2() {

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
        p304_um_parcela_2.setAdapter(dataAdapter);
    }

    public void agregarP304_um_parcela_3() {

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
        p304_um_parcela_3.setAdapter(dataAdapter);
    }

    public void agregarP304_um_parcela_4() {

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
        p304_um_parcela_4.setAdapter(dataAdapter);
    }


    public void onCheckboxClicked3(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.p305_1:
                if (checked) {
                    p305List.add("1");
                } else {
                    if (p305List.contains("1")) {
                        p305List.remove("1");
                    }
                }
                break;
            case R.id.p305_2:
                if (checked) {
                    p305List.add("2");
                } else {
                    if (p305List.contains("2")) {
                        p305List.remove("2");
                    }
                }
                break;
            case R.id.p305_3:
                if (checked) {
                    p305List.add("3");
                } else {
                    if (p305List.contains("3")) {
                        p305List.remove("3");
                    }
                }
                break;
            case R.id.p305_4:
                if (checked) {
                    p305List.add("4");
                } else {
                    if (p305List.contains("4")) {
                        p305List.remove("4");
                    }
                }
                break;
            case R.id.p305_5:
                if (checked) {
                    p305List.add("5");
                } else {
                    if (p305List.contains("5")) {
                        p305List.remove("5");
                    }
                }
                break;
        }
    }
}