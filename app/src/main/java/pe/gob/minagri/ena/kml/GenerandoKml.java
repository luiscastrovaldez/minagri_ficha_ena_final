package pe.gob.minagri.ena.kml;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.entity.MapInfo;
import pe.gob.minagri.ena.newkml.Kml;
import pe.gob.minagri.ena.newkml.LineStyle;
import pe.gob.minagri.ena.newkml.Placemark;
import pe.gob.minagri.ena.newkml.PolyStyle;
import pe.gob.minagri.ena.newkml.Style;


public class GenerandoKml extends AsyncTask<String, Integer, String> {

    private static CameraPosition cameraPosition;
    private GoogleMap mapa;
    private String result;
    private ProgressDialog mProgressDialog;
    private int mProgressStatus = 0;
    private List<String> kmlPaths;
    private Activity activity;

    private static List<MapInfo> mapas;

    private static List<List<LatLng>> puntos1;


    public GenerandoKml(List<String> kmlPaths, GoogleMap mapa, Activity activity) {
        this.kmlPaths = kmlPaths;
        this.mapa = mapa;
        this.activity = activity;
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
        mapas = new ArrayList<MapInfo>();
        try {
            if (mapas.size() == 0) {
                mapas.addAll(nuevasCoodenadas(kmlPaths));
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
        MapInfo mapInfo = null;
        LatLng latLng = null;
        String valorTag = null;
        com.google.android.gms.maps.model.Polygon polygon = null;
        mapa.clear();
        if (result.equalsIgnoreCase("in")) {
            for (int i = 0; i < mapas.size(); i++) {
                mapInfo = mapas.get(i);
                puntos1 = mapInfo.getCoordenadas();
                int punto = puntos1.get(0).size()/3;
                latLng = puntos1.get(0).get(punto);
                for (int j = 0; j < puntos1.size(); j++) {
                    PolygonOptions polygonOptions = new PolygonOptions();
                    String colorFondo = mapInfo.getColorFondo();
                    if(colorFondo != null){
                        polygonOptions.clickable(Boolean.TRUE)
                                .strokeColor(Color.RED)

                               // .fillColor(Color.parseColor("#" + mapInfo.getColorFondo()))
                                .addAll(puntos1.get(j));
                        polygon = mapa.addPolygon(polygonOptions);
                        valorTag = mapInfo.getCodigo() + "#-#" + mapInfo.getDescripcion();
                        System.out.println(" valorTag = " + valorTag);
                        polygon.setTag(valorTag);
                        polygon.setStrokeWidth(4);
                    } else {
                        polygonOptions.clickable(Boolean.TRUE)
                                .strokeColor(Color.GREEN)

                                //.fillColor(Color.parseColor("#" + mapInfo.getColorFondo()))
                                .addAll(puntos1.get(j));
                        polygon = mapa.addPolygon(polygonOptions);
                        valorTag = mapInfo.getCodigo() + "#-#" + mapInfo.getDescripcion();
                        System.out.println(" valorTag = " + valorTag);
                        polygon.setTag(valorTag);
                        polygon.setStrokeWidth(4);
                    }
                }
            }
        }

        cameraProperties(latLng);

        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    private List<MapInfo> nuevasCoodenadas(List<String> paths) {
        List<List<LatLng>> puntosTotales1 = null;
        InputStream is = null;
        List<MapInfo> mapas = null;
        try {
            Serializer serializer = new Persister();
            Kml kml = null;
            MapInfo mapInfo = null;
            Style style = null;
            LineStyle lineStyle = null;
            PolyStyle polyStyle = null;
            mapas = new ArrayList<>();
            List<LatLng> points1;
            List<Placemark> placemarks = null;

            for(String path:paths){
                is = new FileInputStream(path);
                kml = serializer.read(Kml.class, is);
                style = kml.getDocument().getStyle();
                lineStyle = style.getLineStyle();
                polyStyle = style.getPolyStyle();
                placemarks = kml.getDocument().getFolder().getPlacemarks();

                for (Placemark placemark : placemarks) {
                    mapInfo = new MapInfo();
                    points1 = new ArrayList<LatLng>();
                    mapInfo.setCodigo(placemark.getName());
                    mapInfo.setDescripcion(placemark.getDescription());
                    mapInfo.setColorLinea(lineStyle.getColor());
                    if(path.contains("_1.kml")){
                        mapInfo.setColorFondo(null);
                        //mapInfo.setColorFondo("80000000");

                    }else {
                        mapInfo.setColorFondo(polyStyle.getColor());
                    }

                    puntosTotales1 = new ArrayList<List<LatLng>>();
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
                    mapInfo.setCoordenadas(puntosTotales1);
                    mapas.add(mapInfo);
                }

            }





        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapas;
    }

    private void cameraProperties(LatLng latLng) {

        if (latLng != null) {
            cameraPosition = new CameraPosition.Builder().target(latLng).zoom(12).build();
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
