package pe.gob.minagri.ena.kml;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pe.gob.minagri.ena.entity.Point;
import pe.gob.minagri.ena.entity.Polygon;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.PolygonUtils;

public class DibujandoPoligono extends AsyncTask<String, Void, Void> {

    private ProgressDialog dialog;
    private Activity activity;
    private List<LatLng> puntos;
    private LatLng[] arrayTotal;
    private double areaTotal;
    private SqlHelper sqlHelper;
    private GoogleMap mapa;
    boolean isLote;
    private String dni;


    public DibujandoPoligono(Activity activity, List<LatLng> puntos, SqlHelper sqlHelper, GoogleMap mapa, boolean isLote, String dni) {
        this.activity = activity;
        this.puntos = puntos;
        this.sqlHelper = sqlHelper;
        this.mapa = mapa;
        this.isLote = isLote;
        this.dni = dni;
    }

    protected void onPreExecute() {

        dialog = new ProgressDialog(this.activity);
        dialog.setMessage("Guardando");
        dialog.setCancelable(false);
        dialog.show();
    }

    protected Void doInBackground(final String... args) {
        try {
            Thread.sleep(1000);

            this.activity.runOnUiThread(new Runnable() {
                public void run() {

                    if (puntos != null && puntos.size() > 2) {
                        mapa.clear();
                        puntos.add(puntos.get(0));
                        arrayTotal = new LatLng[puntos.size()];
                        puntos.toArray(arrayTotal);
                        areaTotal = PolygonUtils.computeArea(Arrays.asList(arrayTotal));
                        int color = 0;

                        Polygon polygon = new Polygon();
                        Point point = null;
                        polygon.setDni(dni);
                        polygon.setArea(areaTotal);
                        polygon.setType("PARCELA");
                        color = Color.GREEN;
                        Long id = sqlHelper.savePolygon(polygon);

                        for (LatLng punto : arrayTotal) {
                            point = new Point();
                            point.setLatitude(punto.latitude);
                            point.setLongitude(punto.longitude);
                            point.setIdPolygon(id);
                            sqlHelper.savePoint(point);
                        }


                        com.google.android.gms.maps.model.Polygon polygonMap = mapa.addPolygon(new PolygonOptions()
                                .add(arrayTotal)
                                .strokeColor(Color.BLUE).strokeWidth(1)
                                .fillColor(Color.TRANSPARENT));
                        polygonMap.setClickable(true);
                        polygonMap.setTag(id);


/*
                        Polyline line = mapa.addPolyline(new PolylineOptions()
                                .add(arrayTotal)
                                .width(5)
                                .color(color));
                        */
                        puntos = new ArrayList<>();
                        Toast.makeText(activity.getApplicationContext(), "Se Guardo la Informacion Correctamente", Toast.LENGTH_SHORT).show();

                    } else if (puntos.size() != 0) {
                        Toast.makeText(activity.getApplicationContext(), "Debe tener al menos 3 puntos", Toast.LENGTH_SHORT).show();
                    }

                }

            });

        } catch (Exception e) {
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