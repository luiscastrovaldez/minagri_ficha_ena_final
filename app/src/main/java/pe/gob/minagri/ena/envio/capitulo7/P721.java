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
        "p721_nom",
        "p721_tipo"
})
public class P721 {

    @JsonProperty("p721_nom")
    private String p721Nom;
    @JsonProperty("p721_tipo")
    private Integer p721Tipo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p721_nom")
    public String getP721Nom() {
        return p721Nom;
    }

    @JsonProperty("p721_nom")
    public void setP721Nom(String p721Nom) {
        this.p721Nom = p721Nom;
    }

    @JsonProperty("p721_tipo")
    public Integer getP721Tipo() {
        return p721Tipo;
    }

    @JsonProperty("p721_tipo")
    public void setP721Tipo(Integer p721Tipo) {
        this.p721Tipo = p721Tipo;
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
