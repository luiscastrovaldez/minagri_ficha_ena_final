
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
        "p428_num",
        "p428_rpta",
        "p429",
        "p430",
        "p431_01",
        "p431_02",
        "p431_03",
        "p431_04",
        "p431_05",
        "p431_06",
        "p431_07",
        "p431_08",
        "p431_09",
        "p431_10",
        "p431_11",
        "p431_12"
})

public class P428 {

    @JsonProperty("p428_num")
    private Integer p428Num;
    @JsonProperty("p428_rpta")
    private String p428Rpta;
    @JsonProperty("p429")
    private Integer p429;
    @JsonProperty("p430")
    private Integer p430;
    @JsonProperty("p431_01")
    private String p43101;
    @JsonProperty("p431_02")
    private String p43102;
    @JsonProperty("p431_03")
    private String p43103;
    @JsonProperty("p431_04")
    private String p43104;
    @JsonProperty("p431_05")
    private String p43105;
    @JsonProperty("p431_06")
    private String p43106;
    @JsonProperty("p431_07")
    private String p43107;
    @JsonProperty("p431_08")
    private String p43108;
    @JsonProperty("p431_09")
    private String p43109;
    @JsonProperty("p431_10")
    private String p43110;
    @JsonProperty("p431_11")
    private String p43111;
    @JsonProperty("p431_12")
    private String p43112;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p428_num")
    public Integer getP428Num() {
        return p428Num;
    }

    @JsonProperty("p428_num")
    public void setP428Num(Integer p428Num) {
        this.p428Num = p428Num;
    }

    @JsonProperty("p428_rpta")
    public String getP428Rpta() {
        return p428Rpta;
    }

    @JsonProperty("p428_rpta")
    public void setP428Rpta(String p428Rpta) {
        this.p428Rpta = p428Rpta;
    }

    @JsonProperty("p429")
    public Integer getP429() {
        return p429;
    }

    @JsonProperty("p429")
    public void setP429(Integer p429) {
        this.p429 = p429;
    }

    @JsonProperty("p430")
    public Integer getP430() {
        return p430;
    }

    @JsonProperty("p430")
    public void setP430(Integer p430) {
        this.p430 = p430;
    }

    @JsonProperty("p431_01")
    public String getP43101() {
        return p43101;
    }

    @JsonProperty("p431_01")
    public void setP43101(String p43101) {
        this.p43101 = p43101;
    }

    @JsonProperty("p431_02")
    public String getP43102() {
        return p43102;
    }

    @JsonProperty("p431_02")
    public void setP43102(String p43102) {
        this.p43102 = p43102;
    }

    @JsonProperty("p431_03")
    public String getP43103() {
        return p43103;
    }

    @JsonProperty("p431_03")
    public void setP43103(String p43103) {
        this.p43103 = p43103;
    }

    @JsonProperty("p431_04")
    public String getP43104() {
        return p43104;
    }

    @JsonProperty("p431_04")
    public void setP43104(String p43104) {
        this.p43104 = p43104;
    }

    @JsonProperty("p431_05")
    public String getP43105() {
        return p43105;
    }

    @JsonProperty("p431_05")
    public void setP43105(String p43105) {
        this.p43105 = p43105;
    }

    @JsonProperty("p431_06")
    public String getP43106() {
        return p43106;
    }

    @JsonProperty("p431_06")
    public void setP43106(String p43106) {
        this.p43106 = p43106;
    }

    @JsonProperty("p431_07")
    public String getP43107() {
        return p43107;
    }

    @JsonProperty("p431_07")
    public void setP43107(String p43107) {
        this.p43107 = p43107;
    }

    @JsonProperty("p431_08")
    public String getP43108() {
        return p43108;
    }

    @JsonProperty("p431_08")
    public void setP43108(String p43108) {
        this.p43108 = p43108;
    }

    @JsonProperty("p431_09")
    public String getP43109() {
        return p43109;
    }

    @JsonProperty("p431_09")
    public void setP43109(String p43109) {
        this.p43109 = p43109;
    }

    @JsonProperty("p431_10")
    public String getP43110() {
        return p43110;
    }

    @JsonProperty("p431_10")
    public void setP43110(String p43110) {
        this.p43110 = p43110;
    }

    @JsonProperty("p431_11")
    public String getP43111() {
        return p43111;
    }

    @JsonProperty("p431_11")
    public void setP43111(String p43111) {
        this.p43111 = p43111;
    }

    @JsonProperty("p431_12")
    public String getP43112() {
        return p43112;
    }

    @JsonProperty("p431_12")
    public void setP43112(String p43112) {
        this.p43112 = p43112;
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
