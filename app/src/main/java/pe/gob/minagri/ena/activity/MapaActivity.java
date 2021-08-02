package pe.gob.minagri.ena.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.R;
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

    private EditText dni;
    private GenerandoKml generandoKml;
    private GoogleMap mapa;
    private List<LatLng> puntos;
    private UbicacionActual ubicacionActual;
    private DibujandoPoligono dibujandoPoligono;
    private SqlHelper sqlHelper;
    private List<Ubigeo> ubigeos;
    private ProgressDialog progressDoalog;
    private CheckBox habilitarSegmento, habilitarParcelas;
    private WebView webview;

    private List<String> paths;
    private Intent listadoCapitulosActivityIntent;

    private FloatingActionButton actualPosicion, tipoMapa, sincronizar;
    private AlertDialog alertDialog;

    private SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        this.sqlHelper = new SqlHelper(getApplicationContext());
        this.actualPosicion = (FloatingActionButton) findViewById(R.id.actualPosicion);
        this.sincronizar = (FloatingActionButton) findViewById(R.id.sincronizar);
        this.habilitarSegmento = (CheckBox) findViewById(R.id.habilitarSegmento);
        this.habilitarParcelas = (CheckBox) findViewById(R.id.habilitarParcelas);
        this.tipoMapa = (FloatingActionButton) findViewById(R.id.tipoMapa);

        dni = (EditText) findViewById(R.id.dni);
        this.puntos = new ArrayList<>();
        this.paths = new ArrayList<>();

        this.mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


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
                listadoCapitulosActivityIntent.putExtra(Constants.DNI, dni.getText().toString());
                startActivity(listadoCapitulosActivityIntent);
            }
        });

        dialog.show();
    }


    @Override
    public void onPolylineClick(Polyline polyline) {
        Toast.makeText(getApplicationContext(), "hola1", Toast.LENGTH_LONG).show();
    }


    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        int index = 0;
        if (dni.getText().toString().isEmpty()) {
            dni.setError(getResources().getString(R.string.dni_validacion));
            habilitarSegmento.setChecked(Boolean.FALSE);
            habilitarParcelas.setChecked(Boolean.FALSE);
            return;
        } else {
            dni.setError(null);
        }

        switch (view.getId()) {
            case R.id.habilitarSegmento:
                if (checked) {
                    paths.add(Constants.PATH_MINAGRI_KML + File.separator + dni.getText() + "_1.kml");
                } else {
                    paths.remove(Constants.PATH_MINAGRI_KML + File.separator + dni.getText() + "_1.kml");
                }
                break;
            case R.id.habilitarParcelas:
                if (checked) {
                    paths.add(Constants.PATH_MINAGRI_KML + File.separator + dni.getText() + ".kml");
                } else {
                    paths.remove(Constants.PATH_MINAGRI_KML + File.separator + dni.getText() + ".kml");
                }
                break;
        }
        generandoKml = new GenerandoKml(paths, mapa, MapaActivity.this);
        generandoKml.execute();
    }
}