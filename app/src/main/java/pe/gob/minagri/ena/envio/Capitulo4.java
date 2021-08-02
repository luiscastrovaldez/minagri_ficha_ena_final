
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

import pe.gob.minagri.ena.envio.capitulo4.P401;
import pe.gob.minagri.ena.envio.capitulo4.P428;
import pe.gob.minagri.ena.envio.capitulo4.P432;
import pe.gob.minagri.ena.envio.capitulo4.P440;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "p401",
        "p428",
        "p432",
        "p437",
        "p437_otro",
        "p438",
        "p438_otro",
        "p439",
        "p440",
        "p442",
        "p443",
        "p443_otro",
        "p444",
        "p444_otro",
        "p445",
        "p446",
        "p446_observaciones"
})

public class Capitulo4 {

    @JsonProperty("p401")
    private List<P401> p401 = null;
    @JsonProperty("p428")
    private List<P428> p428 = null;
    @JsonProperty("p432")
    private List<P432> p432 = null;
    @JsonProperty("p437")
    private String p437;
    @JsonProperty("p437_otro")
    private String p437Otro;
    @JsonProperty("p438")
    private String p438;
    @JsonProperty("p438_otro")
    private String p438Otro;
    @JsonProperty("p439")
    private Integer p439;
    @JsonProperty("p440")
    private List<P440> p440 = null;
    @JsonProperty("p442")
    private Integer p442;
    @JsonProperty("p443")
    private String p443;
    @JsonProperty("p443_otro")
    private String p443Otro;
    @JsonProperty("p444")
    private String p444;
    @JsonProperty("p444_otro")
    private String p444Otro;
    @JsonProperty("p445")
    private Integer p445;
    @JsonProperty("p446")
    private Integer p446;
    @JsonProperty("p446_observaciones")
    private String p446Observaciones;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p401")
    public List<P401> getP401() {
        return p401;
    }

    @JsonProperty("p401")
    public void setP401(List<P401> p401) {
        this.p401 = p401;
    }

    @JsonProperty("p428")
    public List<P428> getP428() {
        return p428;
    }

    @JsonProperty("p428")
    public void setP428(List<P428> p428) {
        this.p428 = p428;
    }

    @JsonProperty("p432")
    public List<P432> getP432() {
        return p432;
    }

    @JsonProperty("p432")
    public void setP432(List<P432> p432) {
        this.p432 = p432;
    }

    @JsonProperty("p437")
    public String getP437() {
        return p437;
    }

    @JsonProperty("p437")
    public void setP437(String p437) {
        this.p437 = p437;
    }

    @JsonProperty("p437_otro")
    public String getP437Otro() {
        return p437Otro;
    }

    @JsonProperty("p437_otro")
    public void setP437Otro(String p437Otro) {
        this.p437Otro = p437Otro;
    }

    @JsonProperty("p438")
    public String getP438() {
        return p438;
    }

    @JsonProperty("p438")
    public void setP438(String p438) {
        this.p438 = p438;
    }

    @JsonProperty("p438_otro")
    public String getP438Otro() {
        return p438Otro;
    }

    @JsonProperty("p438_otro")
    public void setP438Otro(String p438Otro) {
        this.p438Otro = p438Otro;
    }

    @JsonProperty("p439")
    public Integer getP439() {
        return p439;
    }

    @JsonProperty("p439")
    public void setP439(Integer p439) {
        this.p439 = p439;
    }

    @JsonProperty("p440")
    public List<P440> getP440() {
        return p440;
    }

    @JsonProperty("p440")
    public void setP440(List<P440> p440) {
        this.p440 = p440;
    }

    @JsonProperty("p442")
    public Integer getP442() {
        return p442;
    }

    @JsonProperty("p442")
    public void setP442(Integer p442) {
        this.p442 = p442;
    }

    @JsonProperty("p443")
    public String getP443() {
        return p443;
    }

    @JsonProperty("p443")
    public void setP443(String p443) {
        this.p443 = p443;
    }

    @JsonProperty("p443_otro")
    public String getP443Otro() {
        return p443Otro;
    }

    @JsonProperty("p443_otro")
    public void setP443Otro(String p443Otro) {
        this.p443Otro = p443Otro;
    }

    @JsonProperty("p444")
    public String getP444() {
        return p444;
    }

    @JsonProperty("p444")
    public void setP444(String p444) {
        this.p444 = p444;
    }

    @JsonProperty("p444_otro")
    public String getP444Otro() {
        return p444Otro;
    }

    @JsonProperty("p444_otro")
    public void setP444Otro(String p444Otro) {
        this.p444Otro = p444Otro;
    }

    @JsonProperty("p445")
    public Integer getP445() {
        return p445;
    }

    @JsonProperty("p445")
    public void setP445(Integer p445) {
        this.p445 = p445;
    }

    @JsonProperty("p446")
    public Integer getP446() {
        return p446;
    }

    @JsonProperty("p446")
    public void setP446(Integer p446) {
        this.p446 = p446;
    }

    @JsonProperty("p446_observaciones")
    public String getP446Observaciones() {
        return p446Observaciones;
    }

    @JsonProperty("p446_observaciones")
    public void setP446Observaciones(String p446Observaciones) {
        this.p446Observaciones = p446Observaciones;
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
