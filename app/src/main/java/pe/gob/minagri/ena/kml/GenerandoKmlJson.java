package pe.gob.minagri.ena.kml;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
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

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.entity.Point;
import pe.gob.minagri.ena.entity.Polygon;
import pe.gob.minagri.ena.newkml.Kml;
import pe.gob.minagri.ena.newkml.Placemark;
import pe.gob.minagri.ena.sql.SqlHelper;

public class GenerandoKmlJson extends AsyncTask<String, Integer, String> {

    private static CameraPosition cameraPosition;
    private GoogleMap mapa;
    private String result;
    private ProgressDialog mProgressDialog;
    private int mProgressStatus = 0;
    private String kmlPath;
    private Activity activity;
    private SqlHelper sqlHelper;
    private String dni;

    private static List<List<LatLng>> puntos1;
    private static List<List<LatLng>> puntos2;
    private static List<List<LatLng>> puntos3;

    public GenerandoKmlJson(String kmlPath, GoogleMap mapa, Activity activity, SqlHelper sqlHelper, String dni) {
        this.kmlPath = kmlPath;
        this.mapa = mapa;
        this.activity = activity;
        this.sqlHelper = sqlHelper;
        this.dni = dni;
    }

    @Override
    public void onPreExecute() {
        mProgressStatus = 0;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setMessage("Importando KML");
        mProgressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        InputStream is = null;
        puntos1 = new ArrayList<List<LatLng>>();
        try {
            if (puntos1.size() == 0){
                puntos1.addAll(nuevasCoodenadas(kmlPath));
            }
            result = "in";
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            result = "out";
        }
        return result;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mProgressDialog.setProgress(mProgressStatus);
    }

    @Override
    public void onPostExecute(String result) {
        List<Polygon> polygons = null;
        List<LatLng> puntosCargar = null;
        LatLng[] arrayTotal;
        if (result.equalsIgnoreCase("in")) {

            for (int i = 0; i < puntos1.size(); i++) {
                mapa.addPolygon(new PolygonOptions().strokeColor(Color.BLACK).addAll(puntos1.get(i))).setStrokeWidth(4);
                cameraProperties(puntos1.get(0).get(0));

            }

            List<Point> points = null;
            polygons = sqlHelper.getPoligonsByDni(dni);

            for (Polygon polygon : polygons) {

                points = sqlHelper.getPointsByPolygonId(polygon.getId());
                puntosCargar = new ArrayList<>();
                for (Point point : points) {
                    LatLng latLng = new LatLng(point.getLatitude(), point.getLongitude());
                    puntosCargar.add(latLng);
                }
                if (puntosCargar != null  && !puntosCargar.isEmpty()) {
                    com.google.android.gms.maps.model.Polygon p = mapa.addPolygon(new PolygonOptions().clickable(true)
                            .fillColor(Color.TRANSPARENT).strokeColor(Color.BLUE).addAll(puntosCargar));
                    p.setStrokeWidth(4);
                    p.setTag(polygon.getId());

                }
            }




        }

        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    private List<List<LatLng>> nuevasCoodenadas(String path) {
        List<List<LatLng>> puntosTotales1 = null;
        InputStream is = null;
        try {
            List<LatLng> points1;

            is = new FileInputStream(path);
            Serializer serializer = new Persister();
            puntosTotales1 = new ArrayList<>();
            Kml kml = serializer.read(Kml.class, is);
            System.out.println(kml.getDocument().getId());
            System.out.println(kml.getDocument().getFolder().getName());
            List<Placemark> placemarks = kml.getDocument().getFolder().getPlacemarks();
            for (Placemark placemark : placemarks) {
                points1 = new ArrayList<LatLng>();
                if (placemark.getMultiGeometry() != null && placemark.getMultiGeometry().getPolygon() != null) {
                    String coordenadas = placemark.getMultiGeometry().getPolygon().getOuterBoundaryIs().getLinearRing()
                            .getCoordinates().trim();

                    if (coordenadas.contains("0.000000")) {
                        coordenadas = coordenadas.replace("0.000000", "");
                    } else if (coordenadas.contains("0 -")) {
                        coordenadas = coordenadas.replace("0 -", "-");
                    }

                    String[] puntos = coordenadas.split(",");
                    for (int j = 0; j < puntos.length; j = j + 2) {
                        try {
                            double latitude = Double.parseDouble(puntos[j + 1]);
                            double longitude = Double.parseDouble(puntos[j]);
                            LatLng latLng = new LatLng(latitude, longitude);
                            points1.add(latLng);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    puntosTotales1.add(points1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return puntosTotales1;
    }

    private void cameraProperties(LatLng latLng) {

        if (latLng != null) {
            cameraPosition = new CameraPosition.Builder().target(latLng).zoom(15).build();
            mapa.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            mapa.getUiSettings().setIndoorLevelPickerEnabled(true);
            mapa.getUiSettings().setZoomControlsEnabled(true);
            mapa.getUiSettings().setRotateGesturesEnabled(true);
            mapa.getUiSettings().setZoomGesturesEnabled(true);
            mapa.getUiSettings().setCompassEnabled(true);
            mapa.getUiSettings().setMapToolbarEnabled(true);
        }

    }
}
