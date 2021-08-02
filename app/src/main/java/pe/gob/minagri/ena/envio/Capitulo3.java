
package pe.gob.minagri.ena.envio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import pe.gob.minagri.ena.envio.capitulo3.P301;
import pe.gob.minagri.ena.envio.capitulo3.P304;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "p301",
        "p301d_total_parcela",
        "p301d_unidad_parcela",
        "p301d_equivalencia_parcela",
        "p301d_total_segmento",
        "p301d_unidad_segmento",
        "p301d_equivalencia_segmento",
        "p301_observacion",
        "p302",
        "p303",
        "p304",
        "p305_regimen_tenencia",
        "p305_otro"
})

public class Capitulo3 {

    @JsonProperty("p301")
    private List<pe.gob.minagri.ena.envio.capitulo3.P301> p301 = null;
    @JsonProperty("p301d_total_parcela")
    private Double p301dTotalParcela;
    @JsonProperty("p301d_unidad_parcela")
    private Integer p301dUnidadParcela;
    @JsonProperty("p301d_equivalencia_parcela")
    private Double p301dEquivalenciaParcela;
    @JsonProperty("p301d_total_segmento")
    private Double p301dTotalSegmento;
    @JsonProperty("p301d_unidad_segmento")
    private Integer p301dUnidadSegmento;
    @JsonProperty("p301d_equivalencia_segmento")
    private Double p301dEquivalenciaSegmento;
    @JsonProperty("p301_observacion")
    private String p301Observacion;
    @JsonProperty("p302")
    private String p302;
    @JsonProperty("p303")
    private int p303;
    @JsonProperty("p304")
    private List<P304> p304 = null;
    @JsonProperty("p305_regimen_tenencia")
    private String p305RegimenTenencia;
    @JsonProperty("p305_otro")
    private String p305Otro;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p301")
    public List<pe.gob.minagri.ena.envio.capitulo3.P301> getP301() {
        return p301;
    }

    @JsonProperty("p301")
    public void setP301(List<P301> p301) {
        this.p301 = p301;
    }

    @JsonProperty("p301d_total_parcela")
    public Double getP301dTotalParcela() {
        return p301dTotalParcela;
    }

    @JsonProperty("p301d_total_parcela")
    public void setP301dTotalParcela(Double p301dTotalParcela) {
        this.p301dTotalParcela = p301dTotalParcela;
    }

    @JsonProperty("p301d_unidad_parcela")
    public Integer getP301dUnidadParcela() {
        return p301dUnidadParcela;
    }

    @JsonProperty("p301d_unidad_parcela")
    public void setP301dUnidadParcela(Integer p301dUnidadParcela) {
        this.p301dUnidadParcela = p301dUnidadParcela;
    }

    @JsonProperty("p301d_equivalencia_parcela")
    public Double getP301dEquivalenciaParcela() {
        return p301dEquivalenciaParcela;
    }

    @JsonProperty("p301d_equivalencia_parcela")
    public void setP301dEquivalenciaParcela(Double p301dEquivalenciaParcela) {
        this.p301dEquivalenciaParcela = p301dEquivalenciaParcela;
    }

    @JsonProperty("p301d_total_segmento")
    public Double getP301dTotalSegmento() {
        return p301dTotalSegmento;
    }

    @JsonProperty("p301d_total_segmento")
    public void setP301dTotalSegmento(Double p301dTotalSegmento) {
        this.p301dTotalSegmento = p301dTotalSegmento;
    }

    @JsonProperty("p301d_unidad_segmento")
    public Integer getP301dUnidadSegmento() {
        return p301dUnidadSegmento;
    }

    @JsonProperty("p301d_unidad_segmento")
    public void setP301dUnidadSegmento(Integer p301dUnidadSegmento) {
        this.p301dUnidadSegmento = p301dUnidadSegmento;
    }

    @JsonProperty("p301d_equivalencia_segmento")
    public Double getP301dEquivalenciaSegmento() {
        return p301dEquivalenciaSegmento;
    }

    @JsonProperty("p301d_equivalencia_segmento")
    public void setP301dEquivalenciaSegmento(Double p301dEquivalenciaSegmento) {
        this.p301dEquivalenciaSegmento = p301dEquivalenciaSegmento;
    }

    @JsonProperty("p301_observacion")
    public String getP301Observacion() {
        return p301Observacion;
    }

    @JsonProperty("p301_observacion")
    public void setP301Observacion(String p301Observacion) {
        this.p301Observacion = p301Observacion;
    }

    @JsonProperty("p302")
    public String getP302() {
        return p302;
    }

    @JsonProperty("p302")
    public void setP302(String p302) {
        this.p302 = p302;
    }

    @JsonProperty("p303")
    public int getP303() {
        return p303;
    }

    @JsonProperty("p303")
    public void setP303(int p303) {
        this.p303 = p303;
    }

    @JsonProperty("p304")
    public List<P304> getP304() {
        return p304;
    }

    @JsonProperty("p304")
    public void setP304(List<P304> p304) {
        this.p304 = p304;
    }

    @JsonProperty("p305_regimen_tenencia")
    public String getP305RegimenTenencia() {
        return p305RegimenTenencia;
    }

    @JsonProperty("p305_regimen_tenencia")
    public void setP305RegimenTenencia(String p305RegimenTenencia) {
        this.p305RegimenTenencia = p305RegimenTenencia;
    }

    @JsonProperty("p305_otro")
    public String getP305Otro() {
        return p305Otro;
    }

    @JsonProperty("p305_otro")
    public void setP305Otro(String p305Otro) {
        this.p305Otro = p305Otro;
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
