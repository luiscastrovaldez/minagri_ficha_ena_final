
package pe.gob.minagri.ena.envio;

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
        "p801",
        "p802",
        "p802_otro",
        "p803",
        "p803_otro",
        "p803_observacion"
})

public class Capitulo8 {

    @JsonProperty("p801")
    private String p801;
    @JsonProperty("p802")
    private String p802;
    @JsonProperty("p802_otro")
    private String p802Otro;
    @JsonProperty("p803")
    private String p803;
    @JsonProperty("p803_otro")
    private String p803Otro;
    @JsonProperty("p803_observacion")
    private String p803Observacion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p801")
    public String getP801() {
        return p801;
    }

    @JsonProperty("p801")
    public void setP801(String p801) {
        this.p801 = p801;
    }

    @JsonProperty("p802")
    public String getP802() {
        return p802;
    }

    @JsonProperty("p802")
    public void setP802(String p802) {
        this.p802 = p802;
    }

    @JsonProperty("p802_otro")
    public String getP802Otro() {
        return p802Otro;
    }

    @JsonProperty("p802_otro")
    public void setP802Otro(String p802Otro) {
        this.p802Otro = p802Otro;
    }

    @JsonProperty("p803")
    public String getP803() {
        return p803;
    }

    @JsonProperty("p803")
    public void setP803(String p803) {
        this.p803 = p803;
    }

    @JsonProperty("p803_otro")
    public String getP803Otro() {
        return p803Otro;
    }

    @JsonProperty("p803_otro")
    public void setP803Otro(String p803Otro) {
        this.p803Otro = p803Otro;
    }

    @JsonProperty("p803_observacion")
    public String getP803Observacion() {
        return p803Observacion;
    }

    @JsonProperty("p803_observacion")
    public void setP803Observacion(String p803Observacion) {
        this.p803Observacion = p803Observacion;
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
