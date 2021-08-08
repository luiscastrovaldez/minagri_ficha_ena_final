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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.ListCustomAdapter;
import pe.gob.minagri.ena.util.ListCustomAdapter.customButtonListener;
import pe.gob.minagri.ena.util.Util;

public class Capitulo9Activity extends AppCompatActivity implements customButtonListener {

    private FloatingActionButton btnGuardar9, btnEquipo, btnSalir;
    private String segmentoEmpresa, nroParcela, dni;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private String formulario;

    private ListView listViewMaq;
    private String size;
    private List<String> lstMaq;
    private ListCustomAdapter adapter;
    private Spinner P901;
    private LinearLayout BloqueLst902;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo9);
        inicializarCapitulo();
        obternerFormulario();

        btnEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EquipoActivity.class);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra(Constants.INDEX, "-1");
                intent.putExtra(Constants.SIZE, "" + size);
                startActivity(intent);
            }
        });
        btnGuardar9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(Capitulo9Activity.this)
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

        P901.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Combo combo = (Combo) adapterView.getItemAtPosition(i);
                if (combo.getId().equals("1")) {
                    BloqueLst902.setVisibility(View.VISIBLE);
                    btnEquipo.setVisibility(View.VISIBLE);
                } else {
                    BloqueLst902.setVisibility(View.GONE);
                    btnEquipo.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(Capitulo6Activity.this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });

        listViewMaq.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int itemPosition = position;

                Intent intent = new Intent(getApplicationContext(), EquipoActivity.class);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra(Constants.INDEX, "" + itemPosition);
                intent.putExtra(Constants.SIZE, "" + size);

                startActivity(intent);
            }
        });

        listViewMaq.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                final int posicion = i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Capitulo9Activity.this);
                dialogo1.setTitle(getResources().getString(R.string.titulo_eliminar));
                dialogo1.setMessage(getResources().getString(R.string.titulo_eliminar_dato));
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton(getResources().getString(R.string.si), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        try{
                            lstMaq.remove(posicion);
                            adapter.notifyDataSetChanged();
                            if (enaForm != null) {
                                formulario = enaForm.getCapitulo9();
                                if(formulario != null){
                                    JSONObject object = new JSONObject(formulario);
                                    JSONArray json_array = object.getJSONArray("p902");
                                    Object o = json_array.remove(posicion);
                                    formulario = object.toString();
                                    grabarCapitulo();
                                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
                dialogo1.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        cargarDatosLista();
    }

    @Override
    public void onButtonClickListner(int position, String value) {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Capitulo9Activity.this);
        dialogo1.setTitle(getResources().getString(R.string.titulo_eliminar));
        dialogo1.setMessage(getResources().getString(R.string.titulo_eliminar_dato));
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton(getResources().getString(R.string.si), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                try{
                    lstMaq.remove(position);
                    adapter.notifyDataSetChanged();
                    if (enaForm != null) {
                        formulario = enaForm.getCapitulo9();
                        if(formulario != null){
                            JSONObject object = new JSONObject(formulario);
                            JSONArray json_array = object.getJSONArray("p902");
                            Object o = json_array.remove(position);
                            formulario = object.toString();
                            grabarCapitulo();
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        dialogo1.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });
        dialogo1.show();
    }

    private void inicializarCapitulo(){
        btnGuardar9 = (FloatingActionButton) findViewById(R.id.btnGuardar09) ;
        btnEquipo = (FloatingActionButton) findViewById(R.id.btnEquipo) ;
        btnSalir = (FloatingActionButton) findViewById(R.id.btnSalirCap9);
        listViewMaq = (ListView) findViewById(R.id.listViewMaq);
        P901 = (Spinner) findViewById(R.id.p901);
        BloqueLst902 = (LinearLayout) findViewById(R.id.BloqueLst902);

        agregarP901();
        BloqueLst902.setVisibility(View.GONE);
        btnEquipo.setVisibility(View.GONE);

        size = "0";
        lstMaq = new ArrayList<>();

        Intent intent = getIntent();
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        this.sqlHelper = new SqlHelper(getApplicationContext());
    }
    private void obternerFormulario(){
        try {
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm != null) {
                this.formulario = enaForm.getCapitulo9();
                LinearLayout layout = findViewById(R.id.capitulo9);
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View view = layout.getChildAt(i);
                    Util.setearInformacion(getResources(), view, this.formulario);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {
        int dato = new Integer(((Combo) P901.getSelectedItem()).getId());
        if (dato == 2) {
            formulario = Util.loadData(getAssets(), Constants.CAPITULO9_FORMULARIO_JSON);
            LinearLayout layout = findViewById(R.id.capitulo9);
            for (int i = 0; i < layout.getChildCount(); i++) {
                View view = layout.getChildAt(i);
                this.formulario = Util.generarJson(getResources(), view, this.formulario);
            }
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm == null) {
                enaForm = new EnaForm();
            }
            grabarCapitulo();
        }
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
    }

    private void cargarDatosLista(){
        try {
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm != null) {
                this.formulario = enaForm.getCapitulo9();
                if(this.formulario != null){
                    if (lstMaq.size() > 0) {
                        lstMaq.clear();
                    }
                    JSONObject object = new JSONObject(this.formulario);
                    JSONArray json_array = object.getJSONArray("p902");
                    int tamano = json_array.length();
                    if(tamano != 0){
                        for (int i = 0; i < tamano; i++) {
                            JSONObject dato= json_array.getJSONObject(i);
                            if(dato.getString("p902a").equals("0")){
                                lstMaq.add("Equipo - " + dato.getString("p902b"));
                            } else {
                                lstMaq.add("Maquinaria - " + dato.getString("p902a"));
                            }
                        }
                        size = tamano + "";
                        adapter = new ListCustomAdapter(Capitulo9Activity.this, lstMaq);
                        adapter.setCustomButtonListner(Capitulo9Activity.this);
                        listViewMaq.setAdapter(adapter);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void  grabarCapitulo(){
        enaForm.setCapitulo9(this.formulario);
        enaForm.setSegmentoEmpresa(segmentoEmpresa);
        enaForm.setNroParcela(nroParcela);
        enaForm.setDni(dni);
        sqlHelper.saveInformation(enaForm);
    }

    public void agregarP901() {
        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        P901.setAdapter(dataAdapter);
    }
}