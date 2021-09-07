package pe.gob.minagri.ena.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.clans.fab.FloatingActionButton;

import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.entity.Ubigeo;
import pe.gob.minagri.ena.envio.Envio;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class ListadoCapitulosActivity extends AppCompatActivity {

    ListView listView;
    private String formulario;
    private String formularioUbicacion;

    String mTitle[] = {"CAPÍTULO II.", "CAPÍTULO III.", "CAPÍTULO IV.", "CAPÍTULO V.", "CAPÍTULO VI.", "CAPÍTULO VII.",
            "CAPÍTULO VIII.", "CAPÍTULO IX.", "CAPÍTULO X.",
            "CAPÍTULO XI.", "CAPÍTULO XII."};
    String mDescription[] = {"IDENTIFICACIÓN DEL PRODUCTOR/A  AGRARIO/A  Y CARACTERÍSTICAS DE LA PARCELA AGRARIA",
            "ÁREA TOTAL EN USOS Y COBERTURAS DE LA TIERRA DENTRO DE LA PARCELA, NÚMERO DE PARCELAS EN EL DISTRITO Y RÉGIMEN DE TENENCIA",
            "INVENTARIO AGRÍCOLA  ENTRE ENERO DEL 2020 A JULIO 2021, ÁREA SEMBRADA, ÁREA COSECHADA, PRODUCCIÓN Y RENDIMIENTO",
            "PRODUCCIÓN PECUARIA EN LA UNIDAD AGRARIA",
            "INOCUIDAD (PARA TODO PRODUCTOR/A AGRARIO/A) DESDE ENERO DE 2020 HASTA EL DÍA DE LA ENTREVISTA",
            "SERVICIOS DE EXTENSIÓN AGRARIA REQUERIDOS",
            "AGUA Y ENERGÍA EN LA PARCELA AGRARIA",
            "MAQUINARIA Y EQUIPO DE USO AGRARIO EN LA UNIDAD PRODUCTORA AGRARIA",
            "INFRAESTRUCTURA E INSTALACIONES DE USO"
            , "CARACTERÍSTICAS SOCIODEMOGRÁFICAS DEL PRODUCTOR/A AGRARIO/A Y SU HOGAR"
            , "EVALUACIÓN DE RESULTADOS."};

    private List<String> p101;
    private Envio envio;

    private SqlHelper sqlHelper;
    private String segmentoEmpresa, nroParcela;
    private EnaForm enaForm;


    private Spinner departamentos;
    private Spinner provincias;
    private Spinner distritos;
    private Spinner centroPoblados;

    private Spinner comunidad;

    private String txtCcCn;

    private CheckBox p101_1;
    private CheckBox p101_2;
    private CheckBox p101_3;
    private CheckBox p101_4;
    private CheckBox p101_5;
    private CheckBox p101_6;
    private CheckBox p101_7;
    private CheckBox p101_8;
    private CheckBox p101_9;
    private CheckBox p101_10;
    private CheckBox p101_11;
    private CheckBox p101_12;
    private EditText p101_observaciones;
    private boolean noAgricola;

    private String codDepartamento;
    private String codProvincia;
    private String codDistrito;
    private String dni;
    private String geocodigo;
    private String cod_region_natural;
    private String cod_piso_ecologico;

    private FloatingActionButton camara, posicion, guardar, enviar;
    private Intent mapIntent;
    private ObjectMapper obj;
    private Ubigeo ubigeo;
    private TextView num_total_parcelas_sm;
    private String totalParcelas;
    private ListView listadoFichas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_capitulos);
        obj = new ObjectMapper();
        this.mapIntent = getIntent();
        this.dni = mapIntent.getStringExtra(Constants.DNI);
        this.segmentoEmpresa = mapIntent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        this.nroParcela = mapIntent.getStringExtra(Constants.NRO_PARCELA);
        this.totalParcelas = mapIntent.getStringExtra("totalParcelas");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        this.p101 = new ArrayList<>();
        this.noAgricola = Boolean.FALSE;

        this.posicion = (FloatingActionButton) findViewById(R.id.posicion);
        this.guardar = (FloatingActionButton) findViewById(R.id.guardar);
        this.enviar = (FloatingActionButton) findViewById(R.id.enviar);


        this.departamentos = (Spinner) findViewById(R.id.departamentos);
        this.provincias = (Spinner) findViewById(R.id.provincias);
        this.distritos = (Spinner) findViewById(R.id.distritos);
        this.centroPoblados = (Spinner) findViewById(R.id.centroPoblados);
        this.comunidad = (Spinner) findViewById(R.id.comunidad);
        num_total_parcelas_sm = findViewById(R.id.num_total_parcelas_sm);
        num_total_parcelas_sm.setText(this.totalParcelas);
        this.p101_1 = (CheckBox) findViewById(R.id.p101_1);
        this.p101_2 = (CheckBox) findViewById(R.id.p101_2);
        this.p101_3 = (CheckBox) findViewById(R.id.p101_3);
        this.p101_4 = (CheckBox) findViewById(R.id.p101_4);
        this.p101_5 = (CheckBox) findViewById(R.id.p101_5);
        this.p101_6 = (CheckBox) findViewById(R.id.p101_6);
        this.p101_7 = (CheckBox) findViewById(R.id.p101_7);
        this.p101_8 = (CheckBox) findViewById(R.id.p101_8);
        this.p101_9 = (CheckBox) findViewById(R.id.p101_9);
        this.p101_10 = (CheckBox) findViewById(R.id.p101_10);
        this.p101_11 = (CheckBox) findViewById(R.id.p101_11);
        this.p101_12 = (CheckBox) findViewById(R.id.p101_12);
        this.p101_observaciones = (EditText) findViewById(R.id.p101_observaciones);


        if (this.p101_12.isChecked()) {
            this.p101_observaciones.setVisibility(View.VISIBLE);
        } else {
            this.p101_observaciones.setVisibility(View.GONE);
        }

        this.sqlHelper = new SqlHelper(getApplicationContext());
        agregarDepartamentos();
        cargarListaCapitulos();


        enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(ListadoCapitulosActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setTitle("Enviar informacion Minagri")
                        .setMessage("Desea Enviar la informacion?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
                                EnviarPost post = new EnviarPost(sqlHelper, enaForm);
                                post.execute();
                                //Toast.makeText(getApplicationContext(), "Se Envio la informacion Correctamente", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });
        obternerFormulario();
        guardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(ListadoCapitulosActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setTitle("Guardar informacion Minagri")
                        .setMessage("Desea Guardar la informacion?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
                                //if (enaForm.getCapitulo1() != null) {
                                guardarFormulario();
                                listView.setVisibility(View.VISIBLE);

                               /* } else {
                                    AlertDialog alertDialog = new AlertDialog.Builder(ListadoCapitulosActivity.this)
                                            .setIcon(android.R.drawable.ic_dialog_alert)
                                            .setTitle(getResources().getString(R.string.titulo_informacion))
                                            .setMessage(getResources().getString(R.string.titulo_alerta_sincronizando))
                                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                }
                                            }).show();
                                }*/
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });

    }

    public void cargarListaCapitulos() {
        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, null);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                if (position == 0) {
                    intent = new Intent(getApplicationContext(), Capitulo2Activity.class);
                }
                if (position == 1) {
                    intent = new Intent(getApplicationContext(), Capitulo3Activity.class);
                }
                if (position == 2) {
                    intent = new Intent(getApplicationContext(), Capitulo4Activity.class);
                }
                if (position == 3) {
                    intent = new Intent(getApplicationContext(), Capitulo5Activity.class);
                }
                if (position == 4) {
                    intent = new Intent(getApplicationContext(), Capitulo6Activity.class);

                }
                if (position == 5) {
                    intent = new Intent(getApplicationContext(), Capitulo7Activity.class);
                }

                if (position == 6) {
                    intent = new Intent(getApplicationContext(), Capitulo8Activity.class);
                }
                if (position == 7) {
                    intent = new Intent(getApplicationContext(), Capitulo9Activity.class);
                }
                if (position == 8) {
                    intent = new Intent(getApplicationContext(), Capitulo10Activity.class);
                }
                if (position == 9) {
                    intent = new Intent(getApplicationContext(), Capitulo11Activity.class);
                }
                if (position == 10) {
                    intent = new Intent(getApplicationContext(), Capitulo12Activity.class);
                }
                intent.putExtra(Constants.DEPARTAMENTO, codDepartamento);
                intent.putExtra(Constants.PROVINCIA, codProvincia);
                intent.putExtra(Constants.DISTRITO, codDistrito);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                //intent.putExtra("noAgricola", noAgricola);
                startActivity(intent);
            }


        });

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImages[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImages = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row, parent, false);

            //ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // images.setImageResource(rImages[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }

    public void agregarDepartamentos() {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar Region"));
        List<Ubigeo> departamentosList = sqlHelper.buscarDepartamentos();
        for (Ubigeo ubigeo : departamentosList) {
            list.add(new Combo(ubigeo.getCod_departamento(), ubigeo.getDepartamento()));
        }


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departamentos.setAdapter(dataAdapter);
    }

    public void agregarProvincias(String codDepartamento) {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar Provincia"));
        List<Ubigeo> provinciasList = sqlHelper.buscarProvincias(codDepartamento);
        for (Ubigeo ubigeo : provinciasList) {
            list.add(new Combo(ubigeo.getCod_provincia(), ubigeo.getProvincia()));
        }


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provincias.setAdapter(dataAdapter);
    }

    public void agregarDistritos(String codDepartamento, String codProvincia) {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar Distrito"));
        List<Ubigeo> distritosList = sqlHelper.buscarDistritos(codDepartamento, codProvincia);
        for (Ubigeo ubigeo : distritosList) {
            list.add(new Combo(ubigeo.getCod_distrito(), ubigeo.getDistrito()));
        }


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distritos.setAdapter(dataAdapter);
    }

    public void agregarCentroPoblados(String codDepartamento, String codProvincia, String codDistrito, String cod_segmento_empresa) {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar Centro Poblado"));
        List<Ubigeo> centroPobladosList = sqlHelper.buscarCentroPoblados(codDepartamento, codProvincia, codDistrito, cod_segmento_empresa);
        for (Ubigeo ubigeo : centroPobladosList) {
            list.add(new Combo(ubigeo.getCod_ccpp(), ubigeo.getCcpp()));
        }


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        centroPoblados.setAdapter(dataAdapter);

    }

    public void agregarComunidad(String codDepartamento, String codProvincia, String codDistrito, String cod_segmento_empresa) {

        List<Combo> list = new ArrayList<>();

        list.add(new Combo("0", "Seleccionar Comunidad"));
        List<Ubigeo> comunidadList = sqlHelper.buscarComunidadCampesina(codDepartamento, codProvincia, codDistrito, cod_segmento_empresa);
        if (comunidadList != null & !comunidadList.isEmpty()) {
            for (Ubigeo ubigeo : comunidadList) {
                list.add(new Combo(ubigeo.getCod_cc(), ubigeo.getCc()));
            }
        }


        comunidadList = sqlHelper.buscarComunidadNativa(codDepartamento, codProvincia, codDistrito, cod_segmento_empresa);
        if (comunidadList != null & !comunidadList.isEmpty()) {
            for (Ubigeo ubigeo : comunidadList) {
                list.add(new Combo(ubigeo.getCod_cn(), ubigeo.getCn()));
            }
        }


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comunidad.setAdapter(dataAdapter);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        try {
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked

            int index = 0;
            switch (view.getId()) {
                case R.id.p101_1:
                    if (checked) {
                        p101.add("1");
                    } else {
                        if (p101.contains("1")) {
                            p101.remove("1");
                        }
                    }
                    break;
                case R.id.p101_2:
                    if (checked) {
                        p101.add("2");
                    } else {
                        if (p101.contains("2")) {
                            p101.remove("2");
                        }
                    }
                    break;
                case R.id.p101_3:
                    if (checked) {
                        p101.add("3");
                    } else {
                        if (p101.contains("3")) {
                            p101.remove("3");
                        }
                    }
                    break;
                case R.id.p101_4:
                    if (checked) {
                        p101.add("4");
                    } else {
                        if (p101.contains("4")) {
                            p101.remove("4");
                        }
                    }
                    break;
                case R.id.p101_5:
                    if (checked) {
                        p101.add("5");
                    } else {
                        if (p101.contains("5")) {
                            p101.remove("5");
                        }
                    }
                    break;
                case R.id.p101_6:
                    if (checked) {
                        p101.add("6");
                    } else {
                        if (p101.contains("6")) {
                            p101.remove("6");
                        }
                    }
                    break;
                case R.id.p101_7:
                    if (checked) {
                        p101.add("7");
                    } else {
                        if (p101.contains("7")) {
                            p101.remove("7");
                        }
                    }
                    break;
                case R.id.p101_8:
                    if (checked) {
                        p101.add("8");
                    } else {
                        if (p101.contains("8")) {
                            p101.remove("8");
                        }
                    }
                    break;
                case R.id.p101_9:
                    if (checked) {
                        p101.add("9");
                    } else {
                        if (p101.contains("9")) {
                            p101.remove("9");
                        }
                    }
                    break;
                case R.id.p101_10:
                    if (checked) {
                        p101.add("10");
                    } else {
                        if (p101.contains("10")) {
                            p101.remove("10");
                        }
                    }
                    break;
                case R.id.p101_11:
                    if (checked) {
                        p101.add("11");
                    } else {
                        if (p101.contains("11")) {
                            p101.remove("11");
                        }
                    }
                    break;
                case R.id.p101_12:
                    if (checked) {
                        p101.add("12");
                        noHabilitar();

                    } else {
                        if (p101.contains("12")) {
                            p101.remove("12");
                        }
                        habilitar();

                    }
                    break;
            }

            if (p101.contains("1") || p101.contains("2") || p101.contains("3")) {
                noAgricola = Boolean.FALSE;
            } else {
                noAgricola = Boolean.TRUE;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void noHabilitar() {
        //p101_observaciones.setEnabled(Boolean.TRUE);
        this.p101_observaciones.setVisibility(View.VISIBLE);
        p101_1.setClickable(Boolean.FALSE);
        p101_2.setClickable(Boolean.FALSE);
        p101_3.setClickable(Boolean.FALSE);
        p101_4.setClickable(Boolean.FALSE);
        p101_5.setClickable(Boolean.FALSE);
        p101_6.setClickable(Boolean.FALSE);
        p101_7.setClickable(Boolean.FALSE);
        p101_8.setClickable(Boolean.FALSE);
        p101_9.setClickable(Boolean.FALSE);
        p101_10.setClickable(Boolean.FALSE);
        p101_11.setClickable(Boolean.FALSE);
    }

    private void habilitar() {
        //p101_observaciones.setEnabled(Boolean.FALSE);
        this.p101_observaciones.setVisibility(View.GONE);
        p101_1.setClickable(Boolean.TRUE);
        p101_2.setClickable(Boolean.TRUE);
        p101_3.setClickable(Boolean.TRUE);
        p101_4.setClickable(Boolean.TRUE);
        p101_5.setClickable(Boolean.TRUE);
        p101_6.setClickable(Boolean.TRUE);
        p101_7.setClickable(Boolean.TRUE);
        p101_8.setClickable(Boolean.TRUE);
        p101_9.setClickable(Boolean.TRUE);
        p101_10.setClickable(Boolean.TRUE);
        p101_11.setClickable(Boolean.TRUE);
    }

    private class EnviarPost extends AsyncTask<String, Void, Void> {

        ProgressDialog dialog;
        private SqlHelper sqlHelper;
        private EnaForm enaForm;

        private final static String URL = "https://test01.minagri.gob.pe/ena_api/Encuesta";

        public EnviarPost(SqlHelper sqlHelper, EnaForm enaForm) {
            this.sqlHelper = sqlHelper;
            this.enaForm = enaForm;
        }

        protected void onPreExecute() {

            dialog = new ProgressDialog(ListadoCapitulosActivity.this);
            dialog.setMessage("Enviando Informacion...");
            dialog.setCancelable(false);
            dialog.show();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        protected Void doInBackground(final String... args) {
            String jsontTotal = "";
            try {
                Thread.sleep(1000);
                try {
                    PostMethod httpPost = null;
                    PutMethod httpPut = null;
                    HttpClient client = new HttpClient();
                    String response = "";
                    int statusCode = 0;
                    System.out.println(" enaForm =" + enaForm.toString());
                    System.out.println("enviar json =" + enaForm.getJson());

                    String path = Constants.PATH_MINAGRI + File.separator + enaForm.getSegmentoEmpresa() + enaForm.getNroParcela() + ".json";
                    jsontTotal = Util.loadData(getAssets(), Constants.FORMULARIO_JSON);
                    jsontTotal = jsontTotal.replace("datos_generales_value", enaForm.getUbicaciongGeografica());
                    jsontTotal = jsontTotal.replace("capitulo_1_value", enaForm.getCapitulo1());
                    //jsontTotal = jsontTotal.replace("capitulo_2_value", enaForm.getCapitulo2());

                    System.out.println("jsontTotal = " + jsontTotal);

                    Files.write(Paths.get(path), jsontTotal.getBytes());


                    StringRequestEntity requestEntity = new StringRequestEntity(
                            jsontTotal,
                            "application/json",
                            "UTF-8");
                    ;
                    if (enaForm.getCode() == null) {
                        httpPost = new PostMethod(URL);
                        httpPost.setRequestEntity(requestEntity);
                        statusCode = client.executeMethod(httpPost);
                    } else {
                        String url = URL + "/" + enaForm.getCode();
                        System.out.println("url =" + url);
                        httpPut = new PutMethod(url);
                        httpPut.setRequestEntity(requestEntity);
                        statusCode = client.executeMethod(httpPut);
                    }

                    System.out.println("statusCode =" + statusCode);
                    if (statusCode == 500) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(ListadoCapitulosActivity.this,
                                        "Error en el servidor",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        if (enaForm.getCode() == null) {
                            response = httpPost.getResponseBodyAsString();
                        } else {
                            response = httpPut.getResponseBodyAsString();
                        }

                        JSONObject jsonObj = new JSONObject(response);
                        String respuesta = jsonObj.getString("respuesta");
                        String codigo = jsonObj.getString("codigo");
                        System.out.println("codigo = " + codigo);
                        System.out.println("respuesta = " + respuesta);
                        final String mensaje = jsonObj.getString("mensaje");
                        System.out.println("mensaje = " + mensaje);

                        path = Constants.PATH_MINAGRI + File.separator + enaForm.getSegmentoEmpresa() + enaForm.getNroParcela() + "-error.json";
                        Files.write(Paths.get(path), mensaje.getBytes());

                        if (statusCode == HttpStatus.SC_OK && respuesta.equals("OK")) {
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    enaForm.setCode(codigo);
                                    sqlHelper.updateInformation(enaForm);

                                    Toast.makeText(getApplicationContext(),
                                            mensaje,
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    mensaje,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Error enviando la informacion ", Toast.LENGTH_LONG).show();
                        }
                    });
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }


        protected void onPostExecute(final Void unused) {

            if (dialog.isShowing()) {
                dialog.dismiss();
            }


        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void guardarFormulario() {

        LinearLayout layout = findViewById(R.id.capitulo1);
        formularioUbicacion = Util.loadData(getAssets(), Constants.UBICACION_FORMULARIO_JSON);
        formulario = Util.loadData(getAssets(), Constants.CAPITULO1_FORMULARIO_JSON);

        //ubigeo = sqlHelper.obtenerEmpresaByNroEmpresa(segmentoEmpresa, nroParcela);
        ubigeo = sqlHelper.obtenerEmpresaByNroEmpresa(segmentoEmpresa);
        if (this.formularioUbicacion == null) {
            formularioUbicacion = Util.loadData(getAssets(), Constants.UBICACION_FORMULARIO_JSON);
        }
        if (ubigeo != null) {
            this.formularioUbicacion = this.formularioUbicacion.replace("cod_geocodigo_value", ubigeo.getCod_geocodigo());
            this.formularioUbicacion = this.formularioUbicacion.replace("cod_ubigeo_value", ubigeo.getCod_geocodigo());
            cod_region_natural = ubigeo.getCod_region_natural();
            this.formularioUbicacion = this.formularioUbicacion.replace("cod_region_natural_value", ubigeo.getCod_region_natural());
            cod_piso_ecologico = ubigeo.getCod_piso_ecologico();
            this.formularioUbicacion = this.formularioUbicacion.replace("cod_piso_ecologico_value", ubigeo.getCod_piso_ecologico());
            this.formularioUbicacion = this.formularioUbicacion.replace("cod_subestrato_value", ubigeo.getCod_subestrato());
            this.formularioUbicacion = this.formularioUbicacion.replace("cod_tipo_grilla_value", ubigeo.getCod_tipo_grilla());
            this.formularioUbicacion = this.formularioUbicacion.replace("cod_serpentin_value", ubigeo.getCod_serpentin());
            codDepartamento = ubigeo.getCod_departamento();
            codProvincia = ubigeo.getCod_provincia();
            codDistrito = ubigeo.getCod_distrito();
            this.formularioUbicacion = this.formularioUbicacion.replace("num_parcela_sm_value", nroParcela);
            //this.formularioUbicacion = this.formularioUbicacion.replace("num_total_parcelas_sm_value", ubigeo.getNum_total_parcelas_sm());
            this.formularioUbicacion = this.formularioUbicacion.replace("num_total_parcelas_sm_value", num_total_parcelas_sm.getText());
            this.formularioUbicacion = this.formularioUbicacion.replace("cod_ccpp_value", ubigeo.getCod_ccpp());
            this.formularioUbicacion = this.formularioUbicacion.replace("cod_segmento_empresa_value", ubigeo.getCod_segmento_empresa());
            this.formularioUbicacion = this.formularioUbicacion.replace("cod_cc_cn_value", ubigeo.getCod_cn());


        }

        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            this.formulario = Util.generarJson(getResources(), view, this.formulario);
            this.formularioUbicacion = Util.generarJson(getResources(), view, this.formularioUbicacion);
        }
        enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
        if (enaForm == null) {
            enaForm = new EnaForm();
        }
        this.formulario = this.formulario.replace("p101_value", String.join(",", p101));
        this.formulario = this.formulario.replace("fec_encuesta_value", (new Date().toString()));
        enaForm.setUbicacionGeografica(this.formularioUbicacion);
        enaForm.setCapitulo1(this.formulario);
        enaForm.setSegmentoEmpresa(segmentoEmpresa);
        enaForm.setNroParcela(nroParcela);
        enaForm.setDni(dni);
        sqlHelper.saveInformation(enaForm);
        listView.setVisibility(View.VISIBLE);
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_guardo_informacion_correctamente), Toast.LENGTH_SHORT).show();
    }

    private void obternerFormulario() {
        try {

            long count = sqlHelper.countUbigeo();
            if (count == 0) {
                AlertDialog alertDialog = new AlertDialog.Builder(ListadoCapitulosActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(getResources().getString(R.string.titulo_informacion))
                        .setMessage(getResources().getString(R.string.titulo_alerta_sincronizando))
                        .setPositiveButton(getResources().getString(R.string.si), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }).show();
            } else {
                enaForm = sqlHelper.obtenerEnaFormByNroEmpresaAndParcela(segmentoEmpresa, nroParcela, dni);
                if (enaForm != null) {
                    this.formulario = enaForm.getCapitulo1();
                    LinearLayout layout = findViewById(R.id.capitulo1);
                    for (int i = 0; i < layout.getChildCount(); i++) {
                        View view = layout.getChildAt(i);
                        Util.setearInformacion(getResources(), view, this.formulario);
                    }
                    this.formularioUbicacion = enaForm.getUbicaciongGeografica();
                    layout = findViewById(R.id.capitulo1);

                    //ubigeo = sqlHelper.obtenerEmpresaByNroEmpresa(segmentoEmpresa, nroParcela);
                    ubigeo = sqlHelper.obtenerEmpresaByNroEmpresa(segmentoEmpresa);
                    this.formularioUbicacion = this.formularioUbicacion.replace("cod_geocodigo_value", ubigeo.getCod_geocodigo());
                    this.formularioUbicacion = this.formularioUbicacion.replace("cod_ubigeo_value", ubigeo.getCod_geocodigo());
                    cod_region_natural = ubigeo.getCod_region_natural();
                    this.formularioUbicacion = this.formularioUbicacion.replace("cod_region_natural_value", ubigeo.getCod_region_natural());
                    cod_piso_ecologico = ubigeo.getCod_piso_ecologico();
                    this.formularioUbicacion = this.formularioUbicacion.replace("cod_piso_ecologico_value", ubigeo.getCod_piso_ecologico());
                    this.formularioUbicacion = this.formularioUbicacion.replace("cod_subestrato_value", ubigeo.getCod_subestrato());
                    this.formularioUbicacion = this.formularioUbicacion.replace("cod_tipo_grilla_value", ubigeo.getCod_tipo_grilla());
                    this.formularioUbicacion = this.formularioUbicacion.replace("cod_serpentin_value", ubigeo.getCod_serpentin());
                    codDepartamento = ubigeo.getCod_departamento();
                    codProvincia = ubigeo.getCod_provincia();
                    codDistrito = ubigeo.getDistrito();
                    this.formularioUbicacion = this.formularioUbicacion.replace("num_parcela_sm_value", nroParcela);
                    //this.formularioUbicacion = this.formularioUbicacion.replace("num_total_parcelas_sm_value", ubigeo.getNum_total_parcelas_sm());
                    this.formularioUbicacion = this.formularioUbicacion.replace("num_total_parcelas_sm_value", num_total_parcelas_sm.getText());
                    this.formularioUbicacion = this.formularioUbicacion.replace("cod_ccpp_value", ubigeo.getCod_ccpp());
                    this.formularioUbicacion = this.formularioUbicacion.replace("cod_segmento_empresa_value", ubigeo.getCod_segmento_empresa());
                    this.formularioUbicacion = this.formularioUbicacion.replace("cod_cc_cn_value", ubigeo.getCod_cn());

                    departamentos.setSelection(Util.getIndex(departamentos, ubigeo.getCod_departamento()));
                    agregarProvincias(ubigeo.getCod_departamento());
                    provincias.setSelection(Util.getIndex(provincias, ubigeo.getCod_provincia()));
                    agregarDistritos(ubigeo.getCod_departamento(), ubigeo.getCod_provincia());
                    distritos.setSelection(Util.getIndex(distritos, ubigeo.getCod_distrito()));
                    agregarCentroPoblados(ubigeo.getCod_departamento(), ubigeo.getCod_provincia(), ubigeo.getCod_distrito(), segmentoEmpresa);
                    agregarComunidad(ubigeo.getCod_departamento(), ubigeo.getCod_provincia(), ubigeo.getCod_distrito(), segmentoEmpresa);

                    if (ubigeo.getCod_cn().isEmpty()) {
                        txtCcCn = ubigeo.getCod_cc();
                    } else {
                        txtCcCn = ubigeo.getCod_cn();
                    }
                    comunidad.setSelection(Util.getIndex(comunidad, txtCcCn));
                    centroPoblados.setSelection(Util.getIndex(centroPoblados, ubigeo.getCod_ccpp()));
                    this.codDepartamento = ubigeo.getCod_departamento();
                    this.codProvincia = ubigeo.getCod_provincia();
                    this.codDistrito = ubigeo.getCod_distrito();

                    this.formularioUbicacion = this.formularioUbicacion.replace("cod_geocodigo_value", ubigeo.getCod_geocodigo());

                    layout = findViewById(R.id.capitulo1);
                    for (int i = 0; i < layout.getChildCount(); i++) {
                        View view = layout.getChildAt(i);
                        Util.setearInformacion(getResources(), view, this.formularioUbicacion);
                    }

                    listView.setVisibility(View.VISIBLE);
                } else {
                    listView.setVisibility(View.GONE);
                    ubigeo = sqlHelper.obtenerEmpresaByNroEmpresa(segmentoEmpresa);
                    if (this.formularioUbicacion == null) {
                        formularioUbicacion = Util.loadData(getAssets(), Constants.UBICACION_FORMULARIO_JSON);
                    }
                    if (ubigeo != null) {
                        this.formularioUbicacion = this.formularioUbicacion.replace("cod_geocodigo_value", ubigeo.getCod_geocodigo());
                        this.formularioUbicacion = this.formularioUbicacion.replace("cod_ubigeo_value", ubigeo.getCod_geocodigo());
                        cod_region_natural = ubigeo.getCod_region_natural();
                        this.formularioUbicacion = this.formularioUbicacion.replace("cod_region_natural_value", ubigeo.getCod_region_natural());
                        cod_piso_ecologico = ubigeo.getCod_piso_ecologico();
                        this.formularioUbicacion = this.formularioUbicacion.replace("cod_piso_ecologico_value", ubigeo.getCod_piso_ecologico());
                        this.formularioUbicacion = this.formularioUbicacion.replace("cod_subestrato_value", ubigeo.getCod_subestrato());
                        this.formularioUbicacion = this.formularioUbicacion.replace("cod_tipo_grilla_value", ubigeo.getCod_tipo_grilla());
                        this.formularioUbicacion = this.formularioUbicacion.replace("cod_serpentin_value", ubigeo.getCod_serpentin());
                        codDepartamento = ubigeo.getCod_departamento();
                        codProvincia = ubigeo.getCod_provincia();
                        codDistrito = ubigeo.getDistrito();
                        this.formularioUbicacion = this.formularioUbicacion.replace("num_parcela_sm_value", nroParcela);
                        //this.formularioUbicacion = this.formularioUbicacion.replace("num_total_parcelas_sm_value", ubigeo.getNum_total_parcelas_sm());
                        this.formularioUbicacion = this.formularioUbicacion.replace("num_total_parcelas_sm_value", num_total_parcelas_sm.getText());
                        this.formularioUbicacion = this.formularioUbicacion.replace("cod_ccpp_value", ubigeo.getCod_ccpp());
                        this.formularioUbicacion = this.formularioUbicacion.replace("cod_segmento_empresa_value", ubigeo.getCod_segmento_empresa());
                        this.formularioUbicacion = this.formularioUbicacion.replace("cod_cc_cn_value", ubigeo.getCod_cn());

                        departamentos.setSelection(Util.getIndex(departamentos, ubigeo.getCod_departamento()));
                        agregarProvincias(ubigeo.getCod_departamento());
                        provincias.setSelection(Util.getIndex(provincias, ubigeo.getCod_provincia()));
                        agregarDistritos(ubigeo.getCod_departamento(), ubigeo.getCod_provincia());
                        distritos.setSelection(Util.getIndex(distritos, ubigeo.getCod_distrito()));
                        agregarCentroPoblados(ubigeo.getCod_departamento(), ubigeo.getCod_provincia(), ubigeo.getCod_distrito(), segmentoEmpresa);
                        agregarComunidad(ubigeo.getCod_departamento(), ubigeo.getCod_provincia(), ubigeo.getCod_distrito(), segmentoEmpresa);

                        if (ubigeo.getCod_cn().isEmpty()) {
                            txtCcCn = ubigeo.getCod_cc();
                        } else {
                            txtCcCn = ubigeo.getCod_cn();
                        }
                        comunidad.setSelection(Util.getIndex(comunidad, txtCcCn));
                        centroPoblados.setSelection(Util.getIndex(centroPoblados, ubigeo.getCod_ccpp()));
                        this.codDepartamento = ubigeo.getCod_departamento();
                        this.codProvincia = ubigeo.getCod_provincia();
                        this.codDistrito = ubigeo.getCod_distrito();

                        this.formularioUbicacion = this.formularioUbicacion.replace("cod_geocodigo_value", ubigeo.getCod_geocodigo());

                        LinearLayout layout = findViewById(R.id.capitulo1);
                        for (int i = 0; i < layout.getChildCount(); i++) {
                            View view = layout.getChildAt(i);
                            Util.setearInformacion(getResources(), view, this.formularioUbicacion);
                        }
                    } else {
                        Toast.makeText(this, "No existe Información para mostrar para la parcela " + segmentoEmpresa + " " + nroParcela, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }


                String p101Value = Util.getJsonValue(this.formulario, "p101");
                p101 = new LinkedList<>(Arrays.asList(p101Value.split("\\s*,\\s*")));
                List<String> p101Values = Arrays.asList(p101Value.split("\\s*,\\s*"));


                if (p101Values.contains("1")) {
                    p101_1.setChecked(Boolean.TRUE);
                }
                if (p101Values.contains("2")) {
                    p101_2.setChecked(Boolean.TRUE);
                }

                if (p101Values.contains("3")) {
                    p101_3.setChecked(Boolean.TRUE);
                }

                if (p101Values.contains("4")) {
                    p101_4.setChecked(Boolean.TRUE);
                }

                if (p101Values.contains("5")) {
                    p101_5.setChecked(Boolean.TRUE);
                }

                if (p101Values.contains("6")) {
                    p101_6.setChecked(Boolean.TRUE);
                }

                if (p101Values.contains("7")) {
                    p101_7.setChecked(Boolean.TRUE);
                }

                if (p101Values.contains("8")) {
                    p101_8.setChecked(Boolean.TRUE);
                }

                if (p101Values.contains("9")) {
                    p101_9.setChecked(Boolean.TRUE);
                }

                if (p101Values.contains("10")) {
                    p101_10.setChecked(Boolean.TRUE);
                }

                if (p101Values.contains("11")) {
                    p101_11.setChecked(Boolean.TRUE);
                }

                if (p101Values.contains("12")) {
                    p101_12.setChecked(Boolean.TRUE);
                }

            }
            listView.setVisibility(View.VISIBLE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}