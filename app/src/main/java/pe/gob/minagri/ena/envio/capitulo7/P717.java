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
        "num",
        "rpta",
        "otro"
})
public class P717 {

    @JsonProperty("num")
    private Integer num;
    @JsonProperty("rpta")
    private String rpta;
    @JsonProperty("otro")
    private String otro;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("num")
    public Integer getNum() {
        return num;
    }

    @JsonProperty("num")
    public void setNum(Integer num) {
        this.num = num;
    }

    @JsonProperty("rpta")
    public String getRpta() {
        return rpta;
    }

    @JsonProperty("rpta")
    public void setRpta(String rpta) {
        this.rpta = rpta;
    }

    @JsonProperty("otro")
    public String getOtro() {
        return otro;
    }

    @JsonProperty("otro")
    public void setOtro(String otro) {
        this.otro = otro;
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
