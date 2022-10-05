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

    private Spinner p301a, p301b_unidad, p301c_unidad;
    private Intent intent;
    private String segmentoEmpresa, nroParcela, dni;
    private SqlHelper sqlHelper;
    private String index;
    private String formulario;
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

        p301a = (Spinner) findViewById(R.id.p301a);
        p301b_unidad = (Spinner) findViewById(R.id.p301b_unidad);
        p301c_unidad = (Spinner) findViewById(R.id.p301c_unidad);

        guardar = (FloatingActionButton) findViewById(R.id.guardarLote3);
        salir = (FloatingActionButton) findViewById(R.id.salirLote3);


        agregarUnidadMedidaB();
        agregarUnidadMedidaC();
        agregarP301aPastosNaturales();


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
            lote = sqlHelper.getLote3(indice, dni, nroParcela, segmentoEmpresa);
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
                this.formulario = enaForm.get3();
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
        LinearLayout layout = findViewById(R.id.loteCapitulo3);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
        }
        int indice = new Integer(index) + 1;
        Lote3 lote = sqlHelper.getLote3(indice, dni, nroParcela, segmentoEmpresa);
        if (lote == null) {
            lote = new Lote3();
            lote.setIndex(String.valueOf(indice));
        }
        this.formulario = this.formulario.replace("index", String.valueOf(indice));
        lote.setDni(dni);
        lote.setJson(this.formulario);
        lote.setParcela(nroParcela);
        lote.setSegmento(segmentoEmpresa);
        sqlHelper.saveLote3(lote);

        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();

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
        list.add(new Combo("1171", "TRANSITORIOS"));
        list.add(new Combo("1171", "PERMANENTES"));
        list.add(new Combo("1171", "FORESTALES"));
        list.add(new Combo("1171", "PASTOS SEMBRADOS"));
        list.add(new Combo("1171", "PASTOS NATURALES"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p301a.setAdapter(dataAdapter);
    }


}