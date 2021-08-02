
package pe.gob.minagri.ena.envio.capitulo4;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "p440_num",
        "p440_rpta",
        "p440_anno"
})

public class P440 {

    @JsonProperty("p440_num")
    private Integer p440Num;
    @JsonProperty("p440_rpta")
    private Integer p440Rpta;
    @JsonProperty("p440_anno")
    private Integer p440Anno;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p440_num")
    public Integer getP440Num() {
        return p440Num;
    }

    @JsonProperty("p440_num")
    public void setP440Num(Integer p440Num) {
        this.p440Num = p440Num;
    }

    @JsonProperty("p440_rpta")
    public Integer getP440Rpta() {
        return p440Rpta;
    }

    @JsonProperty("p440_rpta")
    public void setP440Rpta(Integer p440Rpta) {
        this.p440Rpta = p440Rpta;
    }

    @JsonProperty("p440_anno")
    public Integer getP440Anno() {
        return p440Anno;
    }

    @JsonProperty("p440_anno")
    public void setP440Anno(Integer p440Anno) {
        this.p440Anno = p440Anno;
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
