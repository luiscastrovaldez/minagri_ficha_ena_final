
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

import pe.gob.minagri.ena.envio.capitulo11.P1101;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "p1101",
        "p1109",
        "p1109_otro",
        "p1110",
        "p1111",
        "p1112_perm",
        "p1112_perm_h",
        "p1112_perm_m",
        "p1112_even",
        "p1112_even_h",
        "p1112_even_m",
        "p1113",
        "p1114",
        "p1114_otro",
        "p1115",
        "p1116",
        "p1116a",
        "p1116a_otro",
        "p1117",
        "p1117_otro",
        "p1117_observacion"
})

public class Capitulo11 {

    @JsonProperty("p1101")
    private List<pe.gob.minagri.ena.envio.capitulo11.P1101> p1101 = null;
    @JsonProperty("p1109")
    private Integer p1109;
    @JsonProperty("p1109_otro")
    private String p1109Otro;
    @JsonProperty("p1110")
    private Integer p1110;
    @JsonProperty("p1111")
    private Integer p1111;
    @JsonProperty("p1112_perm")
    private Integer p1112Perm;
    @JsonProperty("p1112_perm_h")
    private Integer p1112PermH;
    @JsonProperty("p1112_perm_m")
    private Integer p1112PermM;
    @JsonProperty("p1112_even")
    private Integer p1112Even;
    @JsonProperty("p1112_even_h")
    private Integer p1112EvenH;
    @JsonProperty("p1112_even_m")
    private Integer p1112EvenM;
    @JsonProperty("p1113")
    private Integer p1113;
    @JsonProperty("p1114")
    private String p1114;
    @JsonProperty("p1114_otro")
    private String p1114Otro;
    @JsonProperty("p1115")
    private Integer p1115;
    @JsonProperty("p1116")
    private Integer p1116;
    @JsonProperty("p1116a")
    private String p1116a;
    @JsonProperty("p1116a_otro")
    private String p1116aOtro;
    @JsonProperty("p1117")
    private String p1117;
    @JsonProperty("p1117_otro")
    private String p1117Otro;
    @JsonProperty("p1117_observacion")
    private String p1117Observacion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p1101")
    public List<pe.gob.minagri.ena.envio.capitulo11.P1101> getP1101() {
        return p1101;
    }

    @JsonProperty("p1101")
    public void setP1101(List<P1101> p1101) {
        this.p1101 = p1101;
    }

    @JsonProperty("p1109")
    public Integer getP1109() {
        return p1109;
    }

    @JsonProperty("p1109")
    public void setP1109(Integer p1109) {
        this.p1109 = p1109;
    }

    @JsonProperty("p1109_otro")
    public String getP1109Otro() {
        return p1109Otro;
    }

    @JsonProperty("p1109_otro")
    public void setP1109Otro(String p1109Otro) {
        this.p1109Otro = p1109Otro;
    }

    @JsonProperty("p1110")
    public Integer getP1110() {
        return p1110;
    }

    @JsonProperty("p1110")
    public void setP1110(Integer p1110) {
        this.p1110 = p1110;
    }

    @JsonProperty("p1111")
    public Integer getP1111() {
        return p1111;
    }

    @JsonProperty("p1111")
    public void setP1111(Integer p1111) {
        this.p1111 = p1111;
    }

    @JsonProperty("p1112_perm")
    public Integer getP1112Perm() {
        return p1112Perm;
    }

    @JsonProperty("p1112_perm")
    public void setP1112Perm(Integer p1112Perm) {
        this.p1112Perm = p1112Perm;
    }

    @JsonProperty("p1112_perm_h")
    public Integer getP1112PermH() {
        return p1112PermH;
    }

    @JsonProperty("p1112_perm_h")
    public void setP1112PermH(Integer p1112PermH) {
        this.p1112PermH = p1112PermH;
    }

    @JsonProperty("p1112_perm_m")
    public Integer getP1112PermM() {
        return p1112PermM;
    }

    @JsonProperty("p1112_perm_m")
    public void setP1112PermM(Integer p1112PermM) {
        this.p1112PermM = p1112PermM;
    }

    @JsonProperty("p1112_even")
    public Integer getP1112Even() {
        return p1112Even;
    }

    @JsonProperty("p1112_even")
    public void setP1112Even(Integer p1112Even) {
        this.p1112Even = p1112Even;
    }

    @JsonProperty("p1112_even_h")
    public Integer getP1112EvenH() {
        return p1112EvenH;
    }

    @JsonProperty("p1112_even_h")
    public void setP1112EvenH(Integer p1112EvenH) {
        this.p1112EvenH = p1112EvenH;
    }

    @JsonProperty("p1112_even_m")
    public Integer getP1112EvenM() {
        return p1112EvenM;
    }

    @JsonProperty("p1112_even_m")
    public void setP1112EvenM(Integer p1112EvenM) {
        this.p1112EvenM = p1112EvenM;
    }

    @JsonProperty("p1113")
    public Integer getP1113() {
        return p1113;
    }

    @JsonProperty("p1113")
    public void setP1113(Integer p1113) {
        this.p1113 = p1113;
    }

    @JsonProperty("p1114")
    public String getP1114() {
        return p1114;
    }

    @JsonProperty("p1114")
    public void setP1114(String p1114) {
        this.p1114 = p1114;
    }

    @JsonProperty("p1114_otro")
    public String getP1114Otro() {
        return p1114Otro;
    }

    @JsonProperty("p1114_otro")
    public void setP1114Otro(String p1114Otro) {
        this.p1114Otro = p1114Otro;
    }

    @JsonProperty("p1115")
    public Integer getP1115() {
        return p1115;
    }

    @JsonProperty("p1115")
    public void setP1115(Integer p1115) {
        this.p1115 = p1115;
    }

    @JsonProperty("p1116")
    public Integer getP1116() {
        return p1116;
    }

    @JsonProperty("p1116")
    public void setP1116(Integer p1116) {
        this.p1116 = p1116;
    }

    @JsonProperty("p1116a")
    public String getP1116a() {
        return p1116a;
    }

    @JsonProperty("p1116a")
    public void setP1116a(String p1116a) {
        this.p1116a = p1116a;
    }

    @JsonProperty("p1116a_otro")
    public String getP1116aOtro() {
        return p1116aOtro;
    }

    @JsonProperty("p1116a_otro")
    public void setP1116aOtro(String p1116aOtro) {
        this.p1116aOtro = p1116aOtro;
    }

    @JsonProperty("p1117")
    public String getP1117() {
        return p1117;
    }

    @JsonProperty("p1117")
    public void setP1117(String p1117) {
        this.p1117 = p1117;
    }

    @JsonProperty("p1117_otro")
    public String getP1117Otro() {
        return p1117Otro;
    }

    @JsonProperty("p1117_otro")
    public void setP1117Otro(String p1117Otro) {
        this.p1117Otro = p1117Otro;
    }

    @JsonProperty("p1117_observacion")
    public String getP1117Observacion() {
        return p1117Observacion;
    }

    @JsonProperty("p1117_observacion")
    public void setP1117Observacion(String p1117Observacion) {
        this.p1117Observacion = p1117Observacion;
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
