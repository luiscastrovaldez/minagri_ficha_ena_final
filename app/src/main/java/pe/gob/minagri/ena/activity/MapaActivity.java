package pe.gob.minagri.ena.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.admin.SystemUpdatePolicy;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.entity.Ubigeo;
import pe.gob.minagri.ena.kml.DibujandoPoligono;
import pe.gob.minagri.ena.kml.GenerandoKml;
import pe.gob.minagri.ena.kml.UbicacionActual;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;
import pe.gob.minagri.ena.util.Util;

public class MapaActivity extends AppCompatActivity implements
        OnMapReadyCallback, GoogleMap.OnPolylineClickListener,
        GoogleMap.OnPolygonClickListener {//GoogleMap.OnMapClickListener

    //private EditText dni;
    private GenerandoKml generandoKml;
    private GoogleMap mapa;
    private List<LatLng> puntos;
    private UbicacionActual ubicacionActual;
    private DibujandoPoligono dibujandoPoligono;
    private SqlHelper sqlHelper;
    private List<Ubigeo> ubigeos;
    private ProgressDialog progressDoalog;
    //private CheckBox habilitarSegmento, habilitarParcelas;
    private WebView webview;

    private List<String> paths;
    private Intent listadoCapitulosActivityIntent;

    private FloatingActionButton actualPosicion, tipoMapa, sincronizar, descargar;
    private AlertDialog alertDialog;

    private SupportMapFragment mapFragment;
    private String dni;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        this.sqlHelper = new SqlHelper(getApplicationContext());
        this.actualPosicion = (FloatingActionButton) findViewById(R.id.actualPosicion);
        this.sincronizar = (FloatingActionButton) findViewById(R.id.sincronizar);
        descargar = (FloatingActionButton) findViewById(R.id.descargar);
        //this.habilitarSegmento = (CheckBox) findViewById(R.id.habilitarSegmento);
        //this.habilitarParcelas = (CheckBox) findViewById(R.id.habilitarParcelas);
        this.tipoMapa = (FloatingActionButton) findViewById(R.id.tipoMapa);
        Intent intent = getIntent();
        dni = intent.getStringExtra(Constants.DNI);
        //dni = (EditText) findViewById(R.id.dni);
        this.puntos = new ArrayList<>();
        this.paths = new ArrayList<>();

        this.mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        descargar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Descargar descargar = new Descargar(dni);
                descargar.execute();

                paths.add(Constants.PATH_MINAGRI_KML + File.separator + dni + File.separator + dni + ".kml");
                generandoKml = new GenerandoKml(paths, mapa, MapaActivity.this);
                generandoKml.execute();
            }
        });


        actualPosicion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MapaActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MapaActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            Constants.GPS_STORAGE_REQUEST_CODE);
                } else {
                    // Permission has already been granted
                    ubicacionActual = new UbicacionActual(MapaActivity.this, mapa);
                    ubicacionActual.execute();
                }
            }
        });


        tipoMapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mapa.getMapType() == 1) {
                    mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                } else {
                    mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });


        sincronizar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                long count = sqlHelper.countUbigeo();
                if (count == 0) {
                    ubigeos = Util.readCsvFile(Constants.PATH_MINAGRI_CARGA_CENTROS_POBLADOS);
                    sqlHelper.saveUbigeo(ubigeos);
                    Toast.makeText(getApplicationContext(), "Termino la sincronizacion", Toast.LENGTH_LONG).show();
                } else {
                    alertDialog = new AlertDialog.Builder(MapaActivity.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle(getResources().getString(R.string.titulo_informacion))
                            .setMessage(getResources().getString(R.string.mensaje_informacion_sincronizar))
                            .setPositiveButton(getResources().getString(R.string.si), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    sqlHelper.deleteAllUbigeo();
                                    ubigeos = Util.readCsvFile(Constants.PATH_MINAGRI_CARGA_CENTROS_POBLADOS);
                                    sqlHelper.saveUbigeo(ubigeos);
                                    Toast.makeText(getApplicationContext(), "Termino la sincronizacion", Toast.LENGTH_LONG).show();
                                }
                            }).setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .show();
                }
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(false);
        //mapa.setOnMapClickListener(this);
        mapa.setOnPolygonClickListener(this);


        paths.add(Constants.PATH_MINAGRI_KML + File.separator + dni + File.separator + dni + ".kml");
        generandoKml = new GenerandoKml(paths, mapa, MapaActivity.this);
        generandoKml.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /*
    @Override
    public void onMapClick(LatLng puntoPulsado) {


        mapa.addMarker(new MarkerOptions()
                .position(puntoPulsado)
                .title("Nuevo Punto")
                .snippet("Latitud/Longitud " + puntoPulsado.latitude + "/" + puntoPulsado.longitude)
                .icon(BitmapDescriptorFactory
                        .fromResource(android.R.drawable.ic_menu_myplaces))
                .anchor(0.5f, 0.5f));

        puntos.add(puntoPulsado);
        graficarLinea(puntos);



    }
    */

    void graficarLinea(List<LatLng> puntos) {
        if (puntos.size() > 1) {
            LatLng[] array = new LatLng[puntos.size()];
            puntos.toArray(array);
            Polyline line = mapa.addPolyline(new PolylineOptions()
                    .add(array)
                    .width(5)
                    .color(Color.YELLOW));
        }
    }


    @Override
    public void onPolygonClick(com.google.android.gms.maps.model.Polygon polygon) {
        final Dialog dialog = new Dialog(MapaActivity.this);
        dialog.setContentView(R.layout.custom);

        webview = (WebView) dialog.findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        String tag = (String) polygon.getTag();
        String html = tag.split(Constants.SPLIT)[1];
        final String codigoParcela = tag.split(Constants.SPLIT)[0];
        dialog.setTitle(codigoParcela);
        //System.out.println("pagina = " + html);

        webview.loadDataWithBaseURL("", html, "text/html", "UTF-8", "");
        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listadoCapitulosActivityIntent = new Intent(getApplicationContext(), ListadoCapitulosActivity.class);
                String nroParcela = codigoParcela.substring(codigoParcela.length() - 2, codigoParcela.length());
                nroParcela = (new Integer(nroParcela)).toString();
                listadoCapitulosActivityIntent.putExtra(Constants.SEGMENTO_EMPRESA, codigoParcela.substring(0, codigoParcela.length() - 2));
                listadoCapitulosActivityIntent.putExtra(Constants.NRO_PARCELA, nroParcela);
                listadoCapitulosActivityIntent.putExtra(Constants.DNI, dni);
                startActivity(listadoCapitulosActivityIntent);
            }
        });

        dialog.show();
    }


    @Override
    public void onPolylineClick(Polyline polyline) {
        Toast.makeText(getApplicationContext(), "hola1", Toast.LENGTH_LONG).show();
    }

    /*

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        int index = 0;


        switch (view.getId()) {
            case R.id.habilitarSegmento:
                if (checked) {
                    paths.add(Constants.PATH_MINAGRI_KML + File.separator + dni + "_1.kml");
                } else {
                    paths.remove(Constants.PATH_MINAGRI_KML + File.separator + dni + "_1.kml");
                }
                break;
            case R.id.habilitarParcelas:
                if (checked) {
                    paths.add(Constants.PATH_MINAGRI_KML + File.separator + dni + ".kml");
                } else {
                    paths.remove(Constants.PATH_MINAGRI_KML + File.separator + dni + ".kml");
                }
                break;
        }
        generandoKml = new GenerandoKml(paths, mapa, MapaActivity.this);
        generandoKml.execute();
    }

    */


    private class Descargar extends AsyncTask<String, Void, Void> {

        ProgressDialog dialog;
        private String dni;

        private final static String URL = "https://dev04.midagri.gob.pe/ena_administracion/api/asignacion/obtenerfile";

        public Descargar(String dni) {

            this.dni = dni;
        }

        protected void onPreExecute() {

            dialog = new ProgressDialog(MapaActivity.this);
            dialog.setMessage("Descargando KML...");
            dialog.setCancelable(false);
            dialog.show();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        protected Void doInBackground(final String... args) {

            try {
                Thread.sleep(1000);
                try {
                    PostMethod httpPost = null;
                    PutMethod httpPut = null;
                    HttpClient client = new HttpClient();
                    String response = "";
                    int statusCode = 0;


                    StringRequestEntity requestEntity = new StringRequestEntity(
                            "{\n" +
                                    "  \"dni\": \"" + dni + "\"\n" +
                                    "}",
                            "application/json",
                            "UTF-8");

                    httpPost = new PostMethod(URL);
                    httpPost.setRequestEntity(requestEntity);
                    statusCode = client.executeMethod(httpPost);

                    System.out.println("statusCode =" + statusCode);
                    if (statusCode == 500) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(MapaActivity.this,
                                        "Error en el servidor",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {

                        File theDir = new File(Constants.PATH_MINAGRI_KML + File.separator + dni);
                        if (!theDir.exists()) {
                            theDir.mkdirs();
                        }

                        response = httpPost.getResponseBodyAsString();

                        JSONObject jsonObj = new JSONObject(response);
                        String respuesta = jsonObj.getString("respuesta");
                        System.out.println("respuesta = " + respuesta);
                        final String mensaje = jsonObj.getString("mensaje");
                        System.out.println("mensaje = " + mensaje);
                        JSONObject datos = jsonObj.getJSONObject("datos");
                        JSONArray segmento = datos.getJSONArray("SEGMENTO");
                        JSONObject archivo = segmento.getJSONObject(0);
                        String archivo64 = archivo.getString("FILE");

                        Base64.Decoder decoder = Base64.getMimeDecoder();
                        byte[] kml = decoder.decode(archivo64);
                        File file = new File(theDir + File.separator + dni + ".kml");

                        if (file.createNewFile()) {
                            System.out.println("File is created!");
                        } else {
                            System.out.println("File already exists.");
                        }
                        String contenido = new String(kml);
                        contenido = contenido.replace("xsi:schemaLocation=\"http://www.opengis.net/kml/2.2 http://schemas.opengis.net/kml/2.2.0/ogckml22.xsd http://www.google.com/kml/ext/2.2 http://code.google.com/apis/kml/schema/kml22gx.xsd\"", "");
                        contenido = contenido.replace("<Placemark id=\"ID_00000\">", "<placemarks>\n<Placemark id=\"ID_00000\">");
                        contenido = contenido.replace("</Folder>", "</placemarks>\n</Folder>");
                        System.out.println("contenido = " + contenido);

                        try (FileWriter writer = new FileWriter(file)) {
                            writer.write(contenido);
                            writer.flush();
                            writer.close();
                        }


                        if (statusCode == HttpStatus.SC_OK && respuesta.equals("OK")) {
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    Toast.makeText(getApplicationContext(),
                                            respuesta,
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
                            Toast.makeText(getApplicationContext(), "Error descargando KML ", Toast.LENGTH_LONG).show();
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

}