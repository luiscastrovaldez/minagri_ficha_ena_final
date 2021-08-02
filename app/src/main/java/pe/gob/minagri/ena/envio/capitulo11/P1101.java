package pe.gob.minagri.ena.envio.capitulo11;

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
        "p1101_num",
        "p1101_nombre",
        "p1102",
        "p1103",
        "p1104",
        "p1105",
        "p1106",
        "p1107",
        "p1107a",
        "p1107a_otro",
        "p1108"
})

public class P1101 {

    @JsonProperty("p1101_num")
    private Integer p1101Num;
    @JsonProperty("p1101_nombre")
    private String p1101Nombre;
    @JsonProperty("p1102")
    private Integer p1102;
    @JsonProperty("p1103")
    private Integer p1103;
    @JsonProperty("p1104")
    private Integer p1104;
    @JsonProperty("p1105")
    private Integer p1105;
    @JsonProperty("p1106")
    private Integer p1106;
    @JsonProperty("p1107")
    private Integer p1107;
    @JsonProperty("p1107a")
    private String p1107a;
    @JsonProperty("p1107a_otro")
    private String p1107aOtro;
    @JsonProperty("p1108")
    private Integer p1108;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p1101_num")
    public Integer getP1101Num() {
        return p1101Num;
    }

    @JsonProperty("p1101_num")
    public void setP1101Num(Integer p1101Num) {
        this.p1101Num = p1101Num;
    }

    @JsonProperty("p1101_nombre")
    public String getP1101Nombre() {
        return p1101Nombre;
    }

    @JsonProperty("p1101_nombre")
    public void setP1101Nombre(String p1101Nombre) {
        this.p1101Nombre = p1101Nombre;
    }

    @JsonProperty("p1102")
    public Integer getP1102() {
        return p1102;
    }

    @JsonProperty("p1102")
    public void setP1102(Integer p1102) {
        this.p1102 = p1102;
    }

    @JsonProperty("p1103")
    public Integer getP1103() {
        return p1103;
    }

    @JsonProperty("p1103")
    public void setP1103(Integer p1103) {
        this.p1103 = p1103;
    }

    @JsonProperty("p1104")
    public Integer getP1104() {
        return p1104;
    }

    @JsonProperty("p1104")
    public void setP1104(Integer p1104) {
        this.p1104 = p1104;
    }

    @JsonProperty("p1105")
    public Integer getP1105() {
        return p1105;
    }

    @JsonProperty("p1105")
    public void setP1105(Integer p1105) {
        this.p1105 = p1105;
    }

    @JsonProperty("p1106")
    public Integer getP1106() {
        return p1106;
    }

    @JsonProperty("p1106")
    public void setP1106(Integer p1106) {
        this.p1106 = p1106;
    }

    @JsonProperty("p1107")
    public Integer getP1107() {
        return p1107;
    }

    @JsonProperty("p1107")
    public void setP1107(Integer p1107) {
        this.p1107 = p1107;
    }

    @JsonProperty("p1107a")
    public String getP1107a() {
        return p1107a;
    }

    @JsonProperty("p1107a")
    public void setP1107a(String p1107a) {
        this.p1107a = p1107a;
    }

    @JsonProperty("p1107a_otro")
    public String getP1107aOtro() {
        return p1107aOtro;
    }

    @JsonProperty("p1107a_otro")
    public void setP1107aOtro(String p1107aOtro) {
        this.p1107aOtro = p1107aOtro;
    }

    @JsonProperty("p1108")
    public Integer getP1108() {
        return p1108;
    }

    @JsonProperty("p1108")
    public void setP1108(Integer p1108) {
        this.p1108 = p1108;
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
