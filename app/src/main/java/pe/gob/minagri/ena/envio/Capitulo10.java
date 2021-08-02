
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
        "p1001",
        "p1002",
        "p1003"
})

public class Capitulo10 {

    @JsonProperty("p1001")
    private Integer p1001;
    @JsonProperty("p1002")
    private Double p1002;
    @JsonProperty("p1003")
    private Integer p1003;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p1001")
    public Integer getP1001() {
        return p1001;
    }

    @JsonProperty("p1001")
    public void setP1001(Integer p1001) {
        this.p1001 = p1001;
    }

    @JsonProperty("p1002")
    public Double getP1002() {
        return p1002;
    }

    @JsonProperty("p1002")
    public void setP1002(Double p1002) {
        this.p1002 = p1002;
    }

    @JsonProperty("p1003")
    public Integer getP1003() {
        return p1003;
    }

    @JsonProperty("p1003")
    public void setP1003(Integer p1003) {
        this.p1003 = p1003;
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
