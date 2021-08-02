
package pe.gob.minagri.ena.envio.capitulo4;

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
        "p423a",
        "p423b",
        "p423c",
        "p423d  "
})

public class P423 {

    @JsonProperty("p423a")
    private String p423a;
    @JsonProperty("p423b")
    private Double p423b;
    @JsonProperty("p423c")
    private Integer p423c;
    @JsonProperty("p423d  ")
    private Integer p423d;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p423a")
    public String getP423a() {
        return p423a;
    }

    @JsonProperty("p423a")
    public void setP423a(String p423a) {
        this.p423a = p423a;
    }

    @JsonProperty("p423b")
    public Double getP423b() {
        return p423b;
    }

    @JsonProperty("p423b")
    public void setP423b(Double p423b) {
        this.p423b = p423b;
    }

    @JsonProperty("p423c")
    public Integer getP423c() {
        return p423c;
    }

    @JsonProperty("p423c")
    public void setP423c(Integer p423c) {
        this.p423c = p423c;
    }

    @JsonProperty("p423d  ")
    public Integer getP423d() {
        return p423d;
    }

    @JsonProperty("p423d  ")
    public void setP423d(Integer p423d) {
        this.p423d = p423d;
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
