
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
        "p502_num",
        "p503",
        "p504a",
        "p504b",
        "p504c",
        "p504d_cant",
        "p504d_prec",
        "p504e_cant",
        "p504e_peso",
        "p504e_prec",
        "p504f",
        "p504g",
        "p504h",
        "p504i",
        "p504j",
        "p505",
        "p505_otro",
        "p506",
        "p507",
        "p507_otro",
        "p508"
})

public class P502 {

    @JsonProperty("p502_num")
    private Integer p502Num;
    @JsonProperty("p503")
    private Integer p503;
    @JsonProperty("p504a")
    private Integer p504a;
    @JsonProperty("p504b")
    private Integer p504b;
    @JsonProperty("p504c")
    private Integer p504c;
    @JsonProperty("p504d_cant")
    private Integer p504dCant;
    @JsonProperty("p504d_prec")
    private Double p504dPrec;
    @JsonProperty("p504e_cant")
    private Integer p504eCant;
    @JsonProperty("p504e_peso")
    private Double p504ePeso;
    @JsonProperty("p504e_prec")
    private Double p504ePrec;
    @JsonProperty("p504f")
    private Integer p504f;
    @JsonProperty("p504g")
    private Integer p504g;
    @JsonProperty("p504h")
    private Integer p504h;
    @JsonProperty("p504i")
    private Integer p504i;
    @JsonProperty("p504j")
    private Integer p504j;
    @JsonProperty("p505")
    private String p505;
    @JsonProperty("p505_otro")
    private String p505Otro;
    @JsonProperty("p506")
    private Integer p506;
    @JsonProperty("p507")
    private String p507;
    @JsonProperty("p507_otro")
    private String p507Otro;
    @JsonProperty("p508")
    private Integer p508;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p502_num")
    public Integer getP502Num() {
        return p502Num;
    }

    @JsonProperty("p502_num")
    public void setP502Num(Integer p502Num) {
        this.p502Num = p502Num;
    }

    @JsonProperty("p503")
    public Integer getP503() {
        return p503;
    }

    @JsonProperty("p503")
    public void setP503(Integer p503) {
        this.p503 = p503;
    }

    @JsonProperty("p504a")
    public Integer getP504a() {
        return p504a;
    }

    @JsonProperty("p504a")
    public void setP504a(Integer p504a) {
        this.p504a = p504a;
    }

    @JsonProperty("p504b")
    public Integer getP504b() {
        return p504b;
    }

    @JsonProperty("p504b")
    public void setP504b(Integer p504b) {
        this.p504b = p504b;
    }

    @JsonProperty("p504c")
    public Integer getP504c() {
        return p504c;
    }

    @JsonProperty("p504c")
    public void setP504c(Integer p504c) {
        this.p504c = p504c;
    }

    @JsonProperty("p504d_cant")
    public Integer getP504dCant() {
        return p504dCant;
    }

    @JsonProperty("p504d_cant")
    public void setP504dCant(Integer p504dCant) {
        this.p504dCant = p504dCant;
    }

    @JsonProperty("p504d_prec")
    public Double getP504dPrec() {
        return p504dPrec;
    }

    @JsonProperty("p504d_prec")
    public void setP504dPrec(Double p504dPrec) {
        this.p504dPrec = p504dPrec;
    }

    @JsonProperty("p504e_cant")
    public Integer getP504eCant() {
        return p504eCant;
    }

    @JsonProperty("p504e_cant")
    public void setP504eCant(Integer p504eCant) {
        this.p504eCant = p504eCant;
    }

    @JsonProperty("p504e_peso")
    public Double getP504ePeso() {
        return p504ePeso;
    }

    @JsonProperty("p504e_peso")
    public void setP504ePeso(Double p504ePeso) {
        this.p504ePeso = p504ePeso;
    }

    @JsonProperty("p504e_prec")
    public Double getP504ePrec() {
        return p504ePrec;
    }

    @JsonProperty("p504e_prec")
    public void setP504ePrec(Double p504ePrec) {
        this.p504ePrec = p504ePrec;
    }

    @JsonProperty("p504f")
    public Integer getP504f() {
        return p504f;
    }

    @JsonProperty("p504f")
    public void setP504f(Integer p504f) {
        this.p504f = p504f;
    }

    @JsonProperty("p504g")
    public Integer getP504g() {
        return p504g;
    }

    @JsonProperty("p504g")
    public void setP504g(Integer p504g) {
        this.p504g = p504g;
    }

    @JsonProperty("p504h")
    public Integer getP504h() {
        return p504h;
    }

    @JsonProperty("p504h")
    public void setP504h(Integer p504h) {
        this.p504h = p504h;
    }

    @JsonProperty("p504i")
    public Integer getP504i() {
        return p504i;
    }

    @JsonProperty("p504i")
    public void setP504i(Integer p504i) {
        this.p504i = p504i;
    }

    @JsonProperty("p504j")
    public Integer getP504j() {
        return p504j;
    }

    @JsonProperty("p504j")
    public void setP504j(Integer p504j) {
        this.p504j = p504j;
    }

    @JsonProperty("p505")
    public String getP505() {
        return p505;
    }

    @JsonProperty("p505")
    public void setP505(String p505) {
        this.p505 = p505;
    }

    @JsonProperty("p505_otro")
    public String getP505Otro() {
        return p505Otro;
    }

    @JsonProperty("p505_otro")
    public void setP505Otro(String p505Otro) {
        this.p505Otro = p505Otro;
    }

    @JsonProperty("p506")
    public Integer getP506() {
        return p506;
    }

    @JsonProperty("p506")
    public void setP506(Integer p506) {
        this.p506 = p506;
    }

    @JsonProperty("p507")
    public String getP507() {
        return p507;
    }

    @JsonProperty("p507")
    public void setP507(String p507) {
        this.p507 = p507;
    }

    @JsonProperty("p507_otro")
    public String getP507Otro() {
        return p507Otro;
    }

    @JsonProperty("p507_otro")
    public void setP507Otro(String p507Otro) {
        this.p507Otro = p507Otro;
    }

    @JsonProperty("p508")
    public Integer getP508() {
        return p508;
    }

    @JsonProperty("p508")
    public void setP508(Integer p508) {
        this.p508 = p508;
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
