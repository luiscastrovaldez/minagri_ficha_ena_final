
package pe.gob.minagri.ena.envio.capitulo5;

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
        "p501_num",
        "p501_cant_h",
        "p501_cant_m",
        "p501_otro"
})

public class P501 {

    @JsonProperty("p501_num")
    private Integer p501Num;
    @JsonProperty("p501_cant_h")
    private Integer p501CantH;
    @JsonProperty("p501_cant_m")
    private Integer p501CantM;
    @JsonProperty("p501_otro")
    private String p501Otro;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p501_num")
    public Integer getP501Num() {
        return p501Num;
    }

    @JsonProperty("p501_num")
    public void setP501Num(Integer p501Num) {
        this.p501Num = p501Num;
    }

    @JsonProperty("p501_cant_h")
    public Integer getP501CantH() {
        return p501CantH;
    }

    @JsonProperty("p501_cant_h")
    public void setP501CantH(Integer p501CantH) {
        this.p501CantH = p501CantH;
    }

    @JsonProperty("p501_cant_m")
    public Integer getP501CantM() {
        return p501CantM;
    }

    @JsonProperty("p501_cant_m")
    public void setP501CantM(Integer p501CantM) {
        this.p501CantM = p501CantM;
    }

    @JsonProperty("p501_otro")
    public String getP501Otro() {
        return p501Otro;
    }

    @JsonProperty("p501_otro")
    public void setP501Otro(String p501Otro) {
        this.p501Otro = p501Otro;
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
