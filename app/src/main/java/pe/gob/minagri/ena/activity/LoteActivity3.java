package pe.gob.minagri.ena.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.entity.Lote3;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class LoteActivity3 extends AppCompatActivity {

    private Spinner p301_opcion, p301a, p301b_unidad, p301c_unidad;
    private Intent intent;
    private String segmentoEmpresa, nroParcela, dni;
    private SqlHelper sqlHelper;
    private String index;
    private String formulario;
    private EnaForm enaForm;
    private FloatingActionButton guardar, salir;
    private Lote3 lote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lote3);
        intent = getIntent();
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        index = intent.getStringExtra(Constants.INDEX);
        this.sqlHelper = new SqlHelper(getApplicationContext());
        p301_opcion = (Spinner) findViewById(R.id.p301_opcion);
        p301a = (Spinner) findViewById(R.id.p301a);
        p301b_unidad = (Spinner) findViewById(R.id.p301b_unidad);
        p301c_unidad = (Spinner) findViewById(R.id.p301c_unidad);

        guardar = (FloatingActionButton) findViewById(R.id.guardarLote3);
        salir = (FloatingActionButton) findViewById(R.id.salirLote3);
        segmentoEmpresa = "10";
        dni = "40932086";
        nroParcela = "01";

        agregarUnidadMedidaB();
        agregarUnidadMedidaC();
        agregarP301aPastosNaturales();
        agregarOpcion();

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(LoteActivity3.this)
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
            int indice = new Integer(index) + 1;
            lote = sqlHelper.getLote(String.valueOf(indice), dni, "01", "10");
            if (lote != null) {
                this.formulario = lote.getJson();
                LinearLayout layout = findViewById(R.id.loteCapitulo3);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    Util.setearInformacion(getResources(), view, this.formulario);
                    //Util.setearInformacionArray(getResources(), view, this.formulario, "p304");
                }
            }
            /*
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela("10", "01");
            if (enaForm != null) {
                this.formulario = enaForm.getCapitulo3();
                LinearLayout layout = findViewById(R.id.capitulo3);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    Util.setearInformacion(getResources(), view, this.formulario);
                    Util.setearInformacionArray(getResources(), view, this.formulario, "p304");
                }
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {

        formulario = Util.loadData(getAssets(), Constants.LOTE3_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.capitulo3);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
        }
        Lote3 lote = sqlHelper.getLote(index, dni, nroParcela, segmentoEmpresa);
        if (lote == null) {
            lote = new Lote3();
        }
        lote.setDni(dni);
        int indice = new Integer(index) + 1;
        this.formulario = this.formulario.replace("index", String.valueOf(indice));
        lote.setIndex(String.valueOf(indice));
        lote.setJson(this.formulario);
        lote.setParcela(nroParcela);
        lote.setSegmento(segmentoEmpresa);
        sqlHelper.saveLote(lote);

        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();

        /*
        formulario = Util.loadData(getAssets(), Constants.CAPITULO3_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.capitulo3);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela("10", "01");
            if (enaForm == null) {
                enaForm = new EnaForm();
            }

            enaForm.setCapitulo3(this.formulario);
            enaForm.setSegmentoEmpresa("10");
            enaForm.setNroParcela("01");
            sqlHelper.deleteEna("10", "01");
            sqlHelper.saveInformation(enaForm);
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
        }
        */

    }

    public void agregarUnidadMedidaB() {

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
        p301b_unidad.setAdapter(dataAdapter);
    }

    public void agregarUnidadMedidaC() {

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
        p301c_unidad.setAdapter(dataAdapter);
    }

    public void agregarP301aPastosNaturales() {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1171", "PASTOS NATURALES"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p301a.setAdapter(dataAdapter);
    }

    public void agregarOpcion() {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "1.Lote en cultivo transitorio a nivel de variedad"));
        list.add(new Combo("2", "2.Lote en cultivo permanente a nivel de variedad"));
        list.add(new Combo("3", "3.Lote en plantaciones forestales"));
        list.add(new Combo("4", "4.Lote en pastos sembrados a nivel de variedad"));
        list.add(new Combo("5", "5.Lote en barbecho"));
        list.add(new Combo("6", "6.Lote en descanso"));
        list.add(new Combo("7", "7.Lote en pastos naturales"));
        list.add(new Combo("8", "8.Lote en matorrales"));
        list.add(new Combo("9", "9.Lote en montes y bosques naturales"));
        list.add(new Combo("10", "10.Lote en infraestructura agrícola"));
        list.add(new Combo("11", "11.Lote en infraestructura pecuaria"));
        list.add(new Combo("12", "12.Lote en infraestructura no agraria"));
        list.add(new Combo("13", "13.Lote en afloramientos rocosos, áreas sin vegetación o erosionadas, eriazas"));
        list.add(new Combo("14", "14.Lote en cuerpos de agua (quebradas, riachuelos, lagunas, qochas o reservorios de agua)"));
        list.add(new Combo("15", "15.Lote en otros usos (vivienda, patio, piscina, cancha deportiva, etc.)"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p301_opcion.setAdapter(dataAdapter);

    }
}