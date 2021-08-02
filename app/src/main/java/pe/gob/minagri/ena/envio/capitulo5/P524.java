
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
        "p524_num",
        "p525a",
        "p525b",
        "p525c",
        "p526",
        "p527a",
        "p527b",
        "p528a",
        "p528b",
        "p528c",
        "p529a",
        "p529b",
        "p529c"
})

public class P524 {

    @JsonProperty("p524_num")
    private Integer p524Num;
    @JsonProperty("p525a")
    private Double p525a;
    @JsonProperty("p525b")
    private Integer p525b;
    @JsonProperty("p525c")
    private Double p525c;
    @JsonProperty("p526")
    private Integer p526;
    @JsonProperty("p527a")
    private Double p527a;
    @JsonProperty("p527b")
    private Integer p527b;
    @JsonProperty("p528a")
    private Double p528a;
    @JsonProperty("p528b")
    private Integer p528b;
    @JsonProperty("p528c")
    private Double p528c;
    @JsonProperty("p529a")
    private Double p529a;
    @JsonProperty("p529b")
    private Integer p529b;
    @JsonProperty("p529c")
    private Double p529c;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p524_num")
    public Integer getP524Num() {
        return p524Num;
    }

    @JsonProperty("p524_num")
    public void setP524Num(Integer p524Num) {
        this.p524Num = p524Num;
    }

    @JsonProperty("p525a")
    public Double getP525a() {
        return p525a;
    }

    @JsonProperty("p525a")
    public void setP525a(Double p525a) {
        this.p525a = p525a;
    }

    @JsonProperty("p525b")
    public Integer getP525b() {
        return p525b;
    }

    @JsonProperty("p525b")
    public void setP525b(Integer p525b) {
        this.p525b = p525b;
    }

    @JsonProperty("p525c")
    public Double getP525c() {
        return p525c;
    }

    @JsonProperty("p525c")
    public void setP525c(Double p525c) {
        this.p525c = p525c;
    }

    @JsonProperty("p526")
    public Integer getP526() {
        return p526;
    }

    @JsonProperty("p526")
    public void setP526(Integer p526) {
        this.p526 = p526;
    }

    @JsonProperty("p527a")
    public Double getP527a() {
        return p527a;
    }

    @JsonProperty("p527a")
    public void setP527a(Double p527a) {
        this.p527a = p527a;
    }

    @JsonProperty("p527b")
    public Integer getP527b() {
        return p527b;
    }

    @JsonProperty("p527b")
    public void setP527b(Integer p527b) {
        this.p527b = p527b;
    }

    @JsonProperty("p528a")
    public Double getP528a() {
        return p528a;
    }

    @JsonProperty("p528a")
    public void setP528a(Double p528a) {
        this.p528a = p528a;
    }

    @JsonProperty("p528b")
    public Integer getP528b() {
        return p528b;
    }

    @JsonProperty("p528b")
    public void setP528b(Integer p528b) {
        this.p528b = p528b;
    }

    @JsonProperty("p528c")
    public Double getP528c() {
        return p528c;
    }

    @JsonProperty("p528c")
    public void setP528c(Double p528c) {
        this.p528c = p528c;
    }

    @JsonProperty("p529a")
    public Double getP529a() {
        return p529a;
    }

    @JsonProperty("p529a")
    public void setP529a(Double p529a) {
        this.p529a = p529a;
    }

    @JsonProperty("p529b")
    public Integer getP529b() {
        return p529b;
    }

    @JsonProperty("p529b")
    public void setP529b(Integer p529b) {
        this.p529b = p529b;
    }

    @JsonProperty("p529c")
    public Double getP529c() {
        return p529c;
    }

    @JsonProperty("p529c")
    public void setP529c(Double p529c) {
        this.p529c = p529c;
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
