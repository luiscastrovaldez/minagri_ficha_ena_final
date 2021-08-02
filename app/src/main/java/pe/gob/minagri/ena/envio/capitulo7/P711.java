package pe.gob.minagri.ena.envio.capitulo7;

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
        "p711_nom",
        "p712",
        "p713"
})
public class P711 {

    @JsonProperty("p711_nom")
    private String p711Nom;
    @JsonProperty("p712")
    private Integer p712;
    @JsonProperty("p713")
    private String p713;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p711_nom")
    public String getP711Nom() {
        return p711Nom;
    }

    @JsonProperty("p711_nom")
    public void setP711Nom(String p711Nom) {
        this.p711Nom = p711Nom;
    }

    @JsonProperty("p712")
    public Integer getP712() {
        return p712;
    }

    @JsonProperty("p712")
    public void setP712(Integer p712) {
        this.p712 = p712;
    }

    @JsonProperty("p713")
    public String getP713() {
        return p713;
    }

    @JsonProperty("p713")
    public void setP713(String p713) {
        this.p713 = p713;
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