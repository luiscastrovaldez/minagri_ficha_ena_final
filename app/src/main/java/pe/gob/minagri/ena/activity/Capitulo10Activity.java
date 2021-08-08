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
import android.widget.ListView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.ListCustomAdapter;
import pe.gob.minagri.ena.util.ListCustomAdapter.customButtonListener;

public class Capitulo10Activity extends AppCompatActivity implements customButtonListener {

    private FloatingActionButton btnGuardar10, btnInfra, btnSalir;
    private String segmentoEmpresa, nroParcela, dni;
    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private String formulario;

    private ListView listViewInfra;
    private String size;
    private List<String> lstInfrac;
    private ListCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo10);
        inicializarCapitulo();

        btnGuardar10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(Capitulo10Activity.this)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setTitle(getResources().getString(R.string.titulo_guardar))
                        .setMessage(getResources().getString(R.string.titulo_guardar_pregunta))
                        .setPositiveButton(getResources().getString(R.string.si), new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
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
        btnInfra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InfraestructuraActivity.class);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra(Constants.INDEX, "-1");
                intent.putExtra(Constants.SIZE, "" + size);
                startActivity(intent);
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        listViewInfra.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int itemPosition = position;
                Intent intent = new Intent(getApplicationContext(), InfraestructuraActivity.class);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra(Constants.INDEX, "" + itemPosition);
                intent.putExtra(Constants.SIZE, "" + size);
                startActivity(intent);
            }
        });
        listViewInfra.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                final int posicion = i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Capitulo10Activity.this);
                dialogo1.setTitle(getResources().getString(R.string.titulo_eliminar));
                dialogo1.setMessage(getResources().getString(R.string.titulo_eliminar_dato));
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton(getResources().getString(R.string.si), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        try{
                            lstInfrac.remove(posicion);
                            adapter.notifyDataSetChanged();
                            if (enaForm != null) {
                                formulario = enaForm.getCapitulo10();
                                if(formulario != null){
                                    JSONArray json_array = new JSONArray(formulario);
                                    Object o = json_array.remove(posicion);
                                    formulario = json_array.toString();
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
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Capitulo10Activity.this);
        dialogo1.setTitle(getResources().getString(R.string.titulo_eliminar));
        dialogo1.setMessage(getResources().getString(R.string.titulo_eliminar_dato));
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton(getResources().getString(R.string.si), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                try{
                    lstInfrac.remove(position);
                    adapter.notifyDataSetChanged();
                    if (enaForm != null) {
                        formulario = enaForm.getCapitulo10();
                        if(formulario != null){
                            JSONArray json_array = new JSONArray(formulario);
                            Object o = json_array.remove(position);
                            formulario = json_array.toString();
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
        btnGuardar10 = (FloatingActionButton) findViewById(R.id.btnGuardar10) ;
        btnSalir = (FloatingActionButton) findViewById(R.id.btnSalirCap10);
        btnInfra = (FloatingActionButton) findViewById(R.id.btnInfra) ;
        listViewInfra = (ListView) findViewById(R.id.listViewInfra);
        size = "0";
        lstInfrac = new ArrayList<>();
        //Obtener Datos Generales
        Intent intent = getIntent();
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        this.sqlHelper = new SqlHelper(getApplicationContext());
    }

    private void cargarDatosLista(){
        try {
            enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
            if (enaForm != null) {
                this.formulario = enaForm.getCapitulo10();
                if(this.formulario != null){
                    if (lstInfrac.size() > 0) {
                        lstInfrac.clear();
                    }

                    JSONArray json_array = new JSONArray(this.formulario);
                    int tamano = json_array.length();
                    if(tamano != 0){
                        for (int i = 0; i < tamano; i++) {
                            JSONObject dato= json_array.getJSONObject(i);
                            lstInfrac.add("Infraestructura - " + dato.getString("p1001"));
                        }
                        size = tamano + "";
                        adapter = new ListCustomAdapter(Capitulo10Activity.this, lstInfrac);
                        adapter.setCustomButtonListner(Capitulo10Activity.this);
                        listViewInfra.setAdapter(adapter);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void  grabarCapitulo(){
        enaForm.setCapitulo10(this.formulario);
        enaForm.setSegmentoEmpresa(segmentoEmpresa);
        enaForm.setNroParcela(nroParcela);
        enaForm.setDni(dni);
        sqlHelper.saveInformation(enaForm);
    }
}