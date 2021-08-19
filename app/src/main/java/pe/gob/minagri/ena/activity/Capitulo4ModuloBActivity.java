package pe.gob.minagri.ena.activity;

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

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.Lote3;
import pe.gob.minagri.ena.entity.OrdenB;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class Capitulo4ModuloBActivity extends AppCompatActivity {

    private Spinner p428_rpta;

    private String segmentoEmpresa, nroParcela, dni;
    private Intent intent;
    private FloatingActionButton guardar, salir;
    private String formulario;
    private String index;
    private SqlHelper sqlHelper;
    private OrdenB ordenB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo4_modulo_b);
        p428_rpta = findViewById(R.id.p428_rpta);
        intent = getIntent();
        this.sqlHelper = new SqlHelper(getApplicationContext());
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        index = intent.getStringExtra(Constants.INDEX);
        guardar = (FloatingActionButton) findViewById(R.id.guardarLoteCapitulo4ModuloB);
        salir = (FloatingActionButton) findViewById(R.id.salirLoteCapitulo4ModuloB);
        agregarP428();
        //loteCapitulo4ModuloB

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(Capitulo4ModuloBActivity.this)
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
            ordenB = sqlHelper.getOrdenB(indice, dni, nroParcela, segmentoEmpresa);
            if (ordenB != null) {
                this.formulario = ordenB.getJson();
                LinearLayout layout = findViewById(R.id.loteCapitulo4ModuloB);
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


    private void guardarFormulario() {

        formulario = Util.loadData(getAssets(), Constants.ORDENB_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.loteCapitulo4ModuloB);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
        }
        int indice = new Integer(index) + 1;
        ordenB = sqlHelper.getOrdenB(indice, dni, nroParcela, segmentoEmpresa);
        if (ordenB == null) {
            ordenB = new OrdenB();
            ordenB.setIndex(String.valueOf(indice));
        }
        this.formulario = this.formulario.replace("index", String.valueOf(indice));
        ordenB.setDni(dni);
        ordenB.setJson(this.formulario);
        ordenB.setParcela(nroParcela);
        ordenB.setSegmento(segmentoEmpresa);
        sqlHelper.saveOrdenB(ordenB);

        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();

    }

    public void agregarP428() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Cultivo 1"));
        list.add(new Combo("2", "Cultivo 2"));
        list.add(new Combo("3", "Cultivo 3"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p428_rpta.setAdapter(dataAdapter);
    }

}