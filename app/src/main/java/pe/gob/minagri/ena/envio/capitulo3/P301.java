
package pe.gob.minagri.ena.envio.capitulo3;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "p301_lote",
        "p301_opcion",
        "p301a",
        "p301b_total",
        "p301b_unidad",
        "p301b_equivalencia",
        "p301c_total",
        "p301c_unidad",
        "p301c_equivalencia"
})

public class P301 {

    @JsonProperty("p301_lote")
    private Integer p301Lote;
    @JsonProperty("p301_opcion")
    private Integer p301Opcion;
    @JsonProperty("p301a")
    private String p301a;
    @JsonProperty("p301b_total")
    private Double p301bTotal;
    @JsonProperty("p301b_unidad")
    private Integer p301bUnidad;
    @JsonProperty("p301b_equivalencia")
    private Double p301bEquivalencia;
    @JsonProperty("p301c_total")
    private Double p301cTotal;
    @JsonProperty("p301c_unidad")
    private Integer p301cUnidad;
    @JsonProperty("p301c_equivalencia")
    private Double p301cEquivalencia;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p301_lote")
    public Integer getP301Lote() {
        return p301Lote;
    }

    @JsonProperty("p301_lote")
    public void setP301Lote(Integer p301Lote) {
        this.p301Lote = p301Lote;
    }

    @JsonProperty("p301_opcion")
    public Integer getP301Opcion() {
        return p301Opcion;
    }

    @JsonProperty("p301_opcion")
    public void setP301Opcion(Integer p301Opcion) {
        this.p301Opcion = p301Opcion;
    }

    @JsonProperty("p301a")
    public String getP301a() {
        return p301a;
    }

    @JsonProperty("p301a")
    public void setP301a(String p301a) {
        this.p301a = p301a;
    }

    @JsonProperty("p301b_total")
    public Double getP301bTotal() {
        return p301bTotal;
    }

    @JsonProperty("p301b_total")
    public void setP301bTotal(Double p301bTotal) {
        this.p301bTotal = p301bTotal;
    }

    @JsonProperty("p301b_unidad")
    public Integer getP301bUnidad() {
        return p301bUnidad;
    }

    @JsonProperty("p301b_unidad")
    public void setP301bUnidad(Integer p301bUnidad) {
        this.p301bUnidad = p301bUnidad;
    }

    @JsonProperty("p301b_equivalencia")
    public Double getP301bEquivalencia() {
        return p301bEquivalencia;
    }

    @JsonProperty("p301b_equivalencia")
    public void setP301bEquivalencia(Double p301bEquivalencia) {
        this.p301bEquivalencia = p301bEquivalencia;
    }

    @JsonProperty("p301c_total")
    public Double getP301cTotal() {
        return p301cTotal;
    }

    @JsonProperty("p301c_total")
    public void setP301cTotal(Double p301cTotal) {
        this.p301cTotal = p301cTotal;
    }

    @JsonProperty("p301c_unidad")
    public Integer getP301cUnidad() {
        return p301cUnidad;
    }

    @JsonProperty("p301c_unidad")
    public void setP301cUnidad(Integer p301cUnidad) {
        this.p301cUnidad = p301cUnidad;
    }

    @JsonProperty("p301c_equivalencia")
    public Double getP301cEquivalencia() {
        return p301cEquivalencia;
    }

    @JsonProperty("p301c_equivalencia")
    public void setP301cEquivalencia(Double p301cEquivalencia) {
        this.p301cEquivalencia = p301cEquivalencia;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
