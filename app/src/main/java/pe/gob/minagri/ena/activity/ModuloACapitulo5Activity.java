package pe.gob.minagri.ena.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.github.clans.fab.FloatingActionButton;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Lote4;
import pe.gob.minagri.ena.entity.ModuloACapitulo5;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class ModuloACapitulo5Activity extends AppCompatActivity {

    private String formulario;
    private String segmentoEmpresa, nroParcela, dni;
    private Intent intent;
    private SqlHelper sqlHelper;

    private FloatingActionButton guardar, salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_a_capitulo5);

        intent = getIntent();
        this.sqlHelper = new SqlHelper(getApplicationContext());
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        guardar = (FloatingActionButton) findViewById(R.id.guardar5a);
        salir = (FloatingActionButton) findViewById(R.id.salirLoteCapitulo5a);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(ModuloACapitulo5Activity.this)
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {

        formulario = Util.loadData(getAssets(), Constants.CAPITULO5_MODULOA_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.noduloacapitulo5);

        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
        }

        ModuloACapitulo5 moduloACapitulo5 = sqlHelper.getModuloACapitulo5(dni, nroParcela, segmentoEmpresa);
        if (moduloACapitulo5 == null) {
            moduloACapitulo5 = new ModuloACapitulo5();
            //lote.setIndex(String.valueOf(indice));
        }
        //this.formulario = this.formulario.replace("index", String.valueOf(indice));
        moduloACapitulo5.setDni(dni);
        moduloACapitulo5.setJson(this.formulario);
        moduloACapitulo5.setParcela(nroParcela);
        moduloACapitulo5.setSegmento(segmentoEmpresa);
        sqlHelper.saveModuloACapitulo5(moduloACapitulo5);

        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();

    }

    private void obternerFormulario() {
        try {

            ModuloACapitulo5 moduloACapitulo5 = sqlHelper.getModuloACapitulo5(dni, nroParcela, segmentoEmpresa);
            if (moduloACapitulo5 != null) {
                this.formulario = moduloACapitulo5.getJson();
                LinearLayout layout = findViewById(R.id.noduloacapitulo5);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    Util.setearInformacionArray(getResources(), view, this.formulario);
                    //Util.setearInformacionArray(getResources(), view, this.formulario, "p304");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked

        int index = 0;
        switch (view.getId()) {

        }
    }
}