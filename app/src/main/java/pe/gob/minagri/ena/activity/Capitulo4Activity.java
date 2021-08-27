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
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.EnaForm;

import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class Capitulo4Activity extends AppCompatActivity {

    private ListView lotesView;
    private List<String> lotes;
    private String segmentoEmpresa, nroParcela, dni;
    private Intent intent;
    private FloatingActionButton guardar4, salir;
    private String formulario;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private ListView capitulo4ModuloC, capitulo4ModuloB;

    private Spinner p439, p440_rpta_1, p440_rpta_2, p440_rpta_3, p440_rpta_4, p440_rpta_5, p440_rpta_6, p440_rpta_7, p440_rpta_8, p440_rpta_9, p440_rpta_10, p440_rpta_11,
            p440_rpta_12, p440_rpta_13, p440_rpta_14, p440_rpta_15, p440_rpta_16, p440_rpta_17, p440_rpta_18, p440_rpta_19, p440_rpta_20, p440_rpta_21, p440_rpta_22, p442, p445, p446;

    private List<String> ordenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo4);
        lotesView = findViewById(R.id.lotesView4);
        lotes = new ArrayList<>();
        ordenes = new ArrayList<>();
        this.sqlHelper = new SqlHelper(getApplicationContext());
        intent = getIntent();
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);

        salir = (FloatingActionButton) findViewById(R.id.salirCapitulo4);
        guardar4 = (FloatingActionButton) findViewById(R.id.guardar4);


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

        for (int i = 0; i < 20; i++) {
            lotes.add(i, "Lote " + (i + 1));
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, lotes);
        lotesView.setAdapter(adapter);

        agregarP421();
        agregarp440_rpta_1();
        agregarP439();
        lotesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) lotesView.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), LoteActivity4.class);
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

        guardar4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(Capitulo4Activity.this)
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

        capitulo4ModuloC = findViewById(R.id.capitulo4ModuloC);
        capitulo4ModuloB = findViewById(R.id.capitulo4ModuloB);

        for (int i = 0; i < 20; i++) {
            ordenes.add(i, "Orden " + (i + 1));
        }

        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, ordenes);
        capitulo4ModuloC.setAdapter(adapter1);
        capitulo4ModuloB.setAdapter(adapter1);

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

        obternerFormulario();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        formulario = Util.loadData(getAssets(), Constants.CAPITULO4_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.capitulo4);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm == null) {
                enaForm = new EnaForm();
            }

            enaForm.setCapitulo4(this.formulario);
            enaForm.setSegmentoEmpresa(segmentoEmpresa);
            enaForm.setNroParcela(nroParcela);
            enaForm.setDni(dni);
            sqlHelper.saveInformation(enaForm);
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
        }
    }

    private void obternerFormulario() {
        try {
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm != null) {
                this.formulario = enaForm.getCapitulo4();
                LinearLayout layout = findViewById(R.id.capitulo4);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    Util.setearInformacion(getResources(), view, this.formulario);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarP421() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked

        int index = 0;
        switch (view.getId()) {

        }
    }
}