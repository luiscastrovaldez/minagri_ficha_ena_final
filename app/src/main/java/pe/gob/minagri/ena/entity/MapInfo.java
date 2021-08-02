package pe.gob.minagri.ena.entity;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class MapInfo {

    private String codigo;
    private List<List<LatLng>> coordenadas;
    private String descripcion;
    private String colorLinea;
    private String colorFondo;

    public MapInfo(){

    }

    public MapInfo(String codigo, List<List<LatLng>> coordenadas, String descripcion, String colorLinea, String colorFondo) {
        this.codigo = codigo;
        this.coordenadas = coordenadas;
        this.descripcion = descripcion;
        this.colorLinea = colorLinea;
        this.colorFondo = colorFondo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<List<LatLng>> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<List<LatLng>> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }

    public String getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(String colorFondo) {
        this.colorFondo = colorFondo;
    }
}
