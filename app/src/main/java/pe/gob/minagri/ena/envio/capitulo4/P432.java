
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
        "p432_num",
        "p432_rpta",
        "p433a",
        "p433b",
        "p433c",
        "p434",
        "p435a1",
        "p435a2",
        "p435a3",
        "p435b",
        "p436a",
        "p436b"
})

public class P432 {

    @JsonProperty("p432_num")
    private Integer p432Num;
    @JsonProperty("p432_rpta")
    private String p432Rpta;
    @JsonProperty("p433a")
    private Integer p433a;
    @JsonProperty("p433b")
    private Integer p433b;
    @JsonProperty("p433c")
    private Integer p433c;
    @JsonProperty("p434")
    private String p434;
    @JsonProperty("p435a1")
    private Double p435a1;
    @JsonProperty("p435a2")
    private Integer p435a2;
    @JsonProperty("p435a3")
    private Double p435a3;
    @JsonProperty("p435b")
    private Integer p435b;
    @JsonProperty("p436a")
    private Double p436a;
    @JsonProperty("p436b")
    private Double p436b;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p432_num")
    public Integer getP432Num() {
        return p432Num;
    }

    @JsonProperty("p432_num")
    public void setP432Num(Integer p432Num) {
        this.p432Num = p432Num;
    }

    @JsonProperty("p432_rpta")
    public String getP432Rpta() {
        return p432Rpta;
    }

    @JsonProperty("p432_rpta")
    public void setP432Rpta(String p432Rpta) {
        this.p432Rpta = p432Rpta;
    }

    @JsonProperty("p433a")
    public Integer getP433a() {
        return p433a;
    }

    @JsonProperty("p433a")
    public void setP433a(Integer p433a) {
        this.p433a = p433a;
    }

    @JsonProperty("p433b")
    public Integer getP433b() {
        return p433b;
    }

    @JsonProperty("p433b")
    public void setP433b(Integer p433b) {
        this.p433b = p433b;
    }

    @JsonProperty("p433c")
    public Integer getP433c() {
        return p433c;
    }

    @JsonProperty("p433c")
    public void setP433c(Integer p433c) {
        this.p433c = p433c;
    }

    @JsonProperty("p434")
    public String getP434() {
        return p434;
    }

    @JsonProperty("p434")
    public void setP434(String p434) {
        this.p434 = p434;
    }

    @JsonProperty("p435a1")
    public Double getP435a1() {
        return p435a1;
    }

    @JsonProperty("p435a1")
    public void setP435a1(Double p435a1) {
        this.p435a1 = p435a1;
    }

    @JsonProperty("p435a2")
    public Integer getP435a2() {
        return p435a2;
    }

    @JsonProperty("p435a2")
    public void setP435a2(Integer p435a2) {
        this.p435a2 = p435a2;
    }

    @JsonProperty("p435a3")
    public Double getP435a3() {
        return p435a3;
    }

    @JsonProperty("p435a3")
    public void setP435a3(Double p435a3) {
        this.p435a3 = p435a3;
    }

    @JsonProperty("p435b")
    public Integer getP435b() {
        return p435b;
    }

    @JsonProperty("p435b")
    public void setP435b(Integer p435b) {
        this.p435b = p435b;
    }

    @JsonProperty("p436a")
    public Double getP436a() {
        return p436a;
    }

    @JsonProperty("p436a")
    public void setP436a(Double p436a) {
        this.p436a = p436a;
    }

    @JsonProperty("p436b")
    public Double getP436b() {
        return p436b;
    }

    @JsonProperty("p436b")
    public void setP436b(Double p436b) {
        this.p436b = p436b;
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
