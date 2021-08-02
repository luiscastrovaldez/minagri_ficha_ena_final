package pe.gob.minagri.ena.envio.capitulo7;

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
        "p708_num",
        "p708_otro",
        "p708a",
        "p708b",
        "p709",
        "p709_otro"
})

public class P708 {

    @JsonProperty("p708_num")
    private Integer p708Num;
    @JsonProperty("p708_otro")
    private String p708Otro;
    @JsonProperty("p708a")
    private Integer p708a;
    @JsonProperty("p708b")
    private Integer p708b;
    @JsonProperty("p709")
    private String p709;
    @JsonProperty("p709_otro")
    private String p709Otro;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p708_num")
    public Integer getP708Num() {
        return p708Num;
    }

    @JsonProperty("p708_num")
    public void setP708Num(Integer p708Num) {
        this.p708Num = p708Num;
    }

    @JsonProperty("p708_otro")
    public String getP708Otro() {
        return p708Otro;
    }

    @JsonProperty("p708_otro")
    public void setP708Otro(String p708Otro) {
        this.p708Otro = p708Otro;
    }

    @JsonProperty("p708a")
    public Integer getP708a() {
        return p708a;
    }

    @JsonProperty("p708a")
    public void setP708a(Integer p708a) {
        this.p708a = p708a;
    }

    @JsonProperty("p708b")
    public Integer getP708b() {
        return p708b;
    }

    @JsonProperty("p708b")
    public void setP708b(Integer p708b) {
        this.p708b = p708b;
    }

    @JsonProperty("p709")
    public String getP709() {
        return p709;
    }

    @JsonProperty("p709")
    public void setP709(String p709) {
        this.p709 = p709;
    }

    @JsonProperty("p709_otro")
    public String getP709Otro() {
        return p709Otro;
    }

    @JsonProperty("p709_otro")
    public void setP709Otro(String p709Otro) {
        this.p709Otro = p709Otro;
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
