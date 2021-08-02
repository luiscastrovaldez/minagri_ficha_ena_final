
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
        "p101",
        "p101_observaciones"
})

public class Capitulo1 {

    @JsonProperty("p101")
    private String p101;
    @JsonProperty("p101_observaciones")
    private String p101Observaciones;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p101")
    public String getP101() {
        return p101;
    }

    @JsonProperty("p101")
    public void setP101(String p101) {
        this.p101 = p101;
    }

    @JsonProperty("p101_observaciones")
    public String getP101Observaciones() {
        return p101Observaciones;
    }

    @JsonProperty("p101_observaciones")
    public void setP101Observaciones(String p101Observaciones) {
        this.p101Observaciones = p101Observaciones;
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
