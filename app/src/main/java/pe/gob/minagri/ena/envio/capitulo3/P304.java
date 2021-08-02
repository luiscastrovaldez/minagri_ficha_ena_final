
package pe.gob.minagri.ena.envio.capitulo3;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "p304_orden_parcela",
        "p304_superficie",
        "p304_um_parcela",
        "p304_equivalencia"
})

public class P304 {

    @JsonProperty("p304_orden_parcela")
    private Integer p304OrdenParcela;
    @JsonProperty("p304_superficie")
    private Double p304Superficie;
    @JsonProperty("p304_um_parcela")
    private Integer p304UmParcela;
    @JsonProperty("p304_equivalencia")
    private Double p304Equivalencia;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p304_orden_parcela")
    public Integer getP304OrdenParcela() {
        return p304OrdenParcela;
    }

    @JsonProperty("p304_orden_parcela")
    public void setP304OrdenParcela(Integer p304OrdenParcela) {
        this.p304OrdenParcela = p304OrdenParcela;
    }

    @JsonProperty("p304_superficie")
    public Double getP304Superficie() {
        return p304Superficie;
    }

    @JsonProperty("p304_superficie")
    public void setP304Superficie(Double p304Superficie) {
        this.p304Superficie = p304Superficie;
    }

    @JsonProperty("p304_um_parcela")
    public Integer getP304UmParcela() {
        return p304UmParcela;
    }

    @JsonProperty("p304_um_parcela")
    public void setP304UmParcela(Integer p304UmParcela) {
        this.p304UmParcela = p304UmParcela;
    }

    @JsonProperty("p304_equivalencia")
    public Double getP304Equivalencia() {
        return p304Equivalencia;
    }

    @JsonProperty("p304_equivalencia")
    public void setP304Equivalencia(Double p304Equivalencia) {
        this.p304Equivalencia = p304Equivalencia;
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