
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

import pe.gob.minagri.ena.envio.capitulo9.P902;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "p901",
        "p902"
})

public class Capitulo9 {

    @JsonProperty("p901")
    private Integer p901;
    @JsonProperty("p902")
    private List<pe.gob.minagri.ena.envio.capitulo9.P902> p902 = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p901")
    public Integer getP901() {
        return p901;
    }

    @JsonProperty("p901")
    public void setP901(Integer p901) {
        this.p901 = p901;
    }

    @JsonProperty("p902")
    public List<pe.gob.minagri.ena.envio.capitulo9.P902> getP902() {
        return p902;
    }

    @JsonProperty("p902")
    public void setP902(List<P902> p902) {
        this.p902 = p902;
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
