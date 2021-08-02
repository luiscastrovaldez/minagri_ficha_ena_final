
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
        "p509_num",
        "p510",
        "p511",
        "p512",
        "p513a",
        "p513b",
        "p513c",
        "p513d",
        "p513e",
        "p513f",
        "p514a",
        "p514b",
        "p515a1",
        "p515a2",
        "p515a3",
        "p515a4",
        "p515a5",
        "p515b1",
        "p515b2",
        "p515b3"
})

public class P509 {

    @JsonProperty("p509_num")
    private Integer p509Num;
    @JsonProperty("p510")
    private Integer p510;
    @JsonProperty("p511")
    private Integer p511;
    @JsonProperty("p512")
    private Integer p512;
    @JsonProperty("p513a")
    private Integer p513a;
    @JsonProperty("p513b")
    private Integer p513b;
    @JsonProperty("p513c")
    private Integer p513c;
    @JsonProperty("p513d")
    private Integer p513d;
    @JsonProperty("p513e")
    private Integer p513e;
    @JsonProperty("p513f")
    private Integer p513f;
    @JsonProperty("p514a")
    private Integer p514a;
    @JsonProperty("p514b")
    private Integer p514b;
    @JsonProperty("p515a1")
    private Integer p515a1;
    @JsonProperty("p515a2")
    private Integer p515a2;
    @JsonProperty("p515a3")
    private Double p515a3;
    @JsonProperty("p515a4")
    private Double p515a4;
    @JsonProperty("p515a5")
    private Double p515a5;
    @JsonProperty("p515b1")
    private Integer p515b1;
    @JsonProperty("p515b2")
    private Integer p515b2;
    @JsonProperty("p515b3")
    private Integer p515b3;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p509_num")
    public Integer getP509Num() {
        return p509Num;
    }

    @JsonProperty("p509_num")
    public void setP509Num(Integer p509Num) {
        this.p509Num = p509Num;
    }

    @JsonProperty("p510")
    public Integer getP510() {
        return p510;
    }

    @JsonProperty("p510")
    public void setP510(Integer p510) {
        this.p510 = p510;
    }

    @JsonProperty("p511")
    public Integer getP511() {
        return p511;
    }

    @JsonProperty("p511")
    public void setP511(Integer p511) {
        this.p511 = p511;
    }

    @JsonProperty("p512")
    public Integer getP512() {
        return p512;
    }

    @JsonProperty("p512")
    public void setP512(Integer p512) {
        this.p512 = p512;
    }

    @JsonProperty("p513a")
    public Integer getP513a() {
        return p513a;
    }

    @JsonProperty("p513a")
    public void setP513a(Integer p513a) {
        this.p513a = p513a;
    }

    @JsonProperty("p513b")
    public Integer getP513b() {
        return p513b;
    }

    @JsonProperty("p513b")
    public void setP513b(Integer p513b) {
        this.p513b = p513b;
    }

    @JsonProperty("p513c")
    public Integer getP513c() {
        return p513c;
    }

    @JsonProperty("p513c")
    public void setP513c(Integer p513c) {
        this.p513c = p513c;
    }

    @JsonProperty("p513d")
    public Integer getP513d() {
        return p513d;
    }

    @JsonProperty("p513d")
    public void setP513d(Integer p513d) {
        this.p513d = p513d;
    }

    @JsonProperty("p513e")
    public Integer getP513e() {
        return p513e;
    }

    @JsonProperty("p513e")
    public void setP513e(Integer p513e) {
        this.p513e = p513e;
    }

    @JsonProperty("p513f")
    public Integer getP513f() {
        return p513f;
    }

    @JsonProperty("p513f")
    public void setP513f(Integer p513f) {
        this.p513f = p513f;
    }

    @JsonProperty("p514a")
    public Integer getP514a() {
        return p514a;
    }

    @JsonProperty("p514a")
    public void setP514a(Integer p514a) {
        this.p514a = p514a;
    }

    @JsonProperty("p514b")
    public Integer getP514b() {
        return p514b;
    }

    @JsonProperty("p514b")
    public void setP514b(Integer p514b) {
        this.p514b = p514b;
    }

    @JsonProperty("p515a1")
    public Integer getP515a1() {
        return p515a1;
    }

    @JsonProperty("p515a1")
    public void setP515a1(Integer p515a1) {
        this.p515a1 = p515a1;
    }

    @JsonProperty("p515a2")
    public Integer getP515a2() {
        return p515a2;
    }

    @JsonProperty("p515a2")
    public void setP515a2(Integer p515a2) {
        this.p515a2 = p515a2;
    }

    @JsonProperty("p515a3")
    public Double getP515a3() {
        return p515a3;
    }

    @JsonProperty("p515a3")
    public void setP515a3(Double p515a3) {
        this.p515a3 = p515a3;
    }

    @JsonProperty("p515a4")
    public Double getP515a4() {
        return p515a4;
    }

    @JsonProperty("p515a4")
    public void setP515a4(Double p515a4) {
        this.p515a4 = p515a4;
    }

    @JsonProperty("p515a5")
    public Double getP515a5() {
        return p515a5;
    }

    @JsonProperty("p515a5")
    public void setP515a5(Double p515a5) {
        this.p515a5 = p515a5;
    }

    @JsonProperty("p515b1")
    public Integer getP515b1() {
        return p515b1;
    }

    @JsonProperty("p515b1")
    public void setP515b1(Integer p515b1) {
        this.p515b1 = p515b1;
    }

    @JsonProperty("p515b2")
    public Integer getP515b2() {
        return p515b2;
    }

    @JsonProperty("p515b2")
    public void setP515b2(Integer p515b2) {
        this.p515b2 = p515b2;
    }

    @JsonProperty("p515b3")
    public Integer getP515b3() {
        return p515b3;
    }

    @JsonProperty("p515b3")
    public void setP515b3(Integer p515b3) {
        this.p515b3 = p515b3;
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
