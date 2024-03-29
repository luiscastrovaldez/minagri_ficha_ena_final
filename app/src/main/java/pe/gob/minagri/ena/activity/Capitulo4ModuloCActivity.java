package pe.gob.minagri.ena.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
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

import pe.gob.minagri.ena.entity.OrdenC;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class Capitulo4ModuloCActivity extends AppCompatActivity {

    private Spinner p432_rpta, p433b, p434, p435a2;

    private String segmentoEmpresa, nroParcela, dni;
    private Intent intent;
    private FloatingActionButton guardar, salir;
    private String formulario;
    private String index;
    private SqlHelper sqlHelper;
    private OrdenC ordenC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo4_modulo_c);
        p432_rpta = findViewById(R.id.p432_rpta);
        p433b = findViewById(R.id.p433b);
        p434 = findViewById(R.id.p434);
        p435a2 = findViewById(R.id.p435a2);

        intent = getIntent();
        this.sqlHelper = new SqlHelper(getApplicationContext());
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        index = intent.getStringExtra(Constants.INDEX);
        guardar = (FloatingActionButton) findViewById(R.id.guardarLoteCapitulo4ModuloC);
        salir = (FloatingActionButton) findViewById(R.id.salirLoteCapitulo4ModuloC);

        agregarP432();
        agregarP432b();
        agregarP434();
        agregarP435a2();

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(Capitulo4ModuloCActivity.this)
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
            ordenC = sqlHelper.getOrdenC(indice, dni, nroParcela, segmentoEmpresa);
            if (ordenC != null) {
                this.formulario = ordenC.getJson();
                LinearLayout layout = findViewById(R.id.loteCapitulo4ModuloC);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    Util.setearInformacion(getResources(), view, this.formulario);
                    //Util.setearInformacionArray(getResources(), view, this.formulario, "p304");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void guardarFormulario() {

        formulario = Util.loadData(getAssets(), Constants.ORDENC_FORMULARIO_JSON);
        LinearLayout layout = findViewById(R.id.loteCapitulo4ModuloC);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
        }
        int indice = new Integer(index) + 1;
        ordenC = sqlHelper.getOrdenC(indice, dni, nroParcela, segmentoEmpresa);
        if (ordenC == null) {
            ordenC = new OrdenC();
            ordenC.setIndex(String.valueOf(indice));
        }
        this.formulario = this.formulario.replace("index", String.valueOf(indice));
        ordenC.setDni(dni);
        ordenC.setJson(this.formulario);
        ordenC.setParcela(nroParcela);
        ordenC.setSegmento(segmentoEmpresa);
        sqlHelper.saveOrdenC(ordenC);

        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();

    }

    public void agregarP432() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Cultivo 1"));
        list.add(new Combo("2", "Cultivo 2"));
        list.add(new Combo("3", "Cultivo 3"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p432_rpta.setAdapter(dataAdapter);
    }

    public void agregarP432b() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "KILOS"));
        list.add(new Combo("2", "SACOS"));
        list.add(new Combo("3", "SAQUILLO"));
        list.add(new Combo("4", "CIENTOS"));
        list.add(new Combo("5", "QUINTALE"));
        list.add(new Combo("6", "UNIDADES"));
        list.add(new Combo("7", "BALDES"));
        list.add(new Combo("8", "CANASTAS"));
        list.add(new Combo("9", "RACIMOS"));
        list.add(new Combo("10", "ARROBAS"));
        list.add(new Combo("11", "CARGAS"));
        list.add(new Combo("12", "LATAS"));
        list.add(new Combo("13", "JABAS"));
        list.add(new Combo("14", "TERCIOS"));
        list.add(new Combo("15", "TONELADA"));
        list.add(new Combo("16", "LIBRA"));
        list.add(new Combo("17", "ATADOS"));
        list.add(new Combo("18", "MANOJOS"));
        list.add(new Combo("19", "PORCION"));
        list.add(new Combo("20", "FANEGAS"));
        list.add(new Combo("21", "BANDEJAS"));
        list.add(new Combo("22", "BOLSAS"));
        list.add(new Combo("23", "CAJAS"));
        list.add(new Combo("24", "CABEZAS"));
        list.add(new Combo("25", "TINAS"));
        list.add(new Combo("26", "QUINTALES"));
        list.add(new Combo("27", "VARAS"));
        list.add(new Combo("28", "CAJONES"));
        list.add(new Combo("29", "PAQUETES"));
        list.add(new Combo("30", "CORTES"));
        list.add(new Combo("31", "FARDOS"));
        list.add(new Combo("32", "LOTE"));
        list.add(new Combo("33", "MANTADAS"));
        list.add(new Combo("34", "MANTAS"));
        list.add(new Combo("35", "DOCENAS"));
        list.add(new Combo("36", "MALLAS"));
        list.add(new Combo("37", "MATAS"));
        list.add(new Combo("38", "BOLA"));
        list.add(new Combo("39", "RAMO"));
        list.add(new Combo("40", "CAMIONES"));
        list.add(new Combo("41", "CARRETA"));
        list.add(new Combo("42", "TALLOS"));
        list.add(new Combo("43", "TABLAS"));
        list.add(new Combo("44", "PACAS"));
        list.add(new Combo("45", "MAZOS"));
        list.add(new Combo("46", "AMARRE"));
        list.add(new Combo("47", "ARCOS"));
        list.add(new Combo("48", "MANOS"));
        list.add(new Combo("49", "TAPAS"));
        list.add(new Combo("50", "MONTON"));
        list.add(new Combo("51", "RACIONES"));
        list.add(new Combo("52", "BRAZADAS"));
        list.add(new Combo("53", "HECTAREA"));
        list.add(new Combo("51", "CESTA"));
        list.add(new Combo("55", "MILLARES"));
        list.add(new Combo("56", "BATEAS"));
        list.add(new Combo("57", "CUARTILL"));
        list.add(new Combo("58", "PANEROS"));
        list.add(new Combo("59", "MACETAS"));
        list.add(new Combo("60", "ROLLOS"));
        list.add(new Combo("61", "BUGGY"));
        list.add(new Combo("62", "CENADA"));
        list.add(new Combo("63", "CALCHA"));
        list.add(new Combo("64", "CHALLCAS"));
        list.add(new Combo("65", "CHOCCOS"));
        list.add(new Combo("66", "CHULLAS"));
        list.add(new Combo("67", "PILONAS"));
        list.add(new Combo("68", "PIRHUA"));
        list.add(new Combo("69", "GAJOS"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p433b.setAdapter(dataAdapter);
    }

    public void agregarP434() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p434.setAdapter(dataAdapter);
    }

    public void agregarP435a2() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "KILOS"));
        list.add(new Combo("2", "SACOS"));
        list.add(new Combo("3", "SAQUILLO"));
        list.add(new Combo("4", "CIENTOS"));
        list.add(new Combo("5", "QUINTALE"));
        list.add(new Combo("6", "UNIDADES"));
        list.add(new Combo("7", "BALDES"));
        list.add(new Combo("8", "CANASTAS"));
        list.add(new Combo("9", "RACIMOS"));
        list.add(new Combo("10", "ARROBAS"));
        list.add(new Combo("11", "CARGAS"));
        list.add(new Combo("12", "LATAS"));
        list.add(new Combo("13", "JABAS"));
        list.add(new Combo("14", "TERCIOS"));
        list.add(new Combo("15", "TONELADA"));
        list.add(new Combo("16", "LIBRA"));
        list.add(new Combo("17", "ATADOS"));
        list.add(new Combo("18", "MANOJOS"));
        list.add(new Combo("19", "PORCION"));
        list.add(new Combo("20", "FANEGAS"));
        list.add(new Combo("21", "BANDEJAS"));
        list.add(new Combo("22", "BOLSAS"));
        list.add(new Combo("23", "CAJAS"));
        list.add(new Combo("24", "CABEZAS"));
        list.add(new Combo("25", "TINAS"));
        list.add(new Combo("26", "QUINTALES"));
        list.add(new Combo("27", "VARAS"));
        list.add(new Combo("28", "CAJONES"));
        list.add(new Combo("29", "PAQUETES"));
        list.add(new Combo("30", "CORTES"));
        list.add(new Combo("31", "FARDOS"));
        list.add(new Combo("32", "LOTE"));
        list.add(new Combo("33", "MANTADAS"));
        list.add(new Combo("34", "MANTAS"));
        list.add(new Combo("35", "DOCENAS"));
        list.add(new Combo("36", "MALLAS"));
        list.add(new Combo("37", "MATAS"));
        list.add(new Combo("38", "BOLA"));
        list.add(new Combo("39", "RAMO"));
        list.add(new Combo("40", "CAMIONES"));
        list.add(new Combo("41", "CARRETA"));
        list.add(new Combo("42", "TALLOS"));
        list.add(new Combo("43", "TABLAS"));
        list.add(new Combo("44", "PACAS"));
        list.add(new Combo("45", "MAZOS"));
        list.add(new Combo("46", "AMARRE"));
        list.add(new Combo("47", "ARCOS"));
        list.add(new Combo("48", "MANOS"));
        list.add(new Combo("49", "TAPAS"));
        list.add(new Combo("50", "MONTON"));
        list.add(new Combo("51", "RACIONES"));
        list.add(new Combo("52", "BRAZADAS"));
        list.add(new Combo("53", "HECTAREA"));
        list.add(new Combo("51", "CESTA"));
        list.add(new Combo("55", "MILLARES"));
        list.add(new Combo("56", "BATEAS"));
        list.add(new Combo("57", "CUARTILL"));
        list.add(new Combo("58", "PANEROS"));
        list.add(new Combo("59", "MACETAS"));
        list.add(new Combo("60", "ROLLOS"));
        list.add(new Combo("61", "BUGGY"));
        list.add(new Combo("62", "CENADA"));
        list.add(new Combo("63", "CALCHA"));
        list.add(new Combo("64", "CHALLCAS"));
        list.add(new Combo("65", "CHOCCOS"));
        list.add(new Combo("66", "CHULLAS"));
        list.add(new Combo("67", "PILONAS"));
        list.add(new Combo("68", "PIRHUA"));
        list.add(new Combo("69", "GAJOS"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p435a2.setAdapter(dataAdapter);
    }

    /*
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
    */
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked

        int index = 0;
        switch (view.getId()) {

        }
    }
}