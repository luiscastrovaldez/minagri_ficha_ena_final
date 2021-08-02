
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

import pe.gob.minagri.ena.envio.capitulo7.P708;
import pe.gob.minagri.ena.envio.capitulo7.P711;
import pe.gob.minagri.ena.envio.capitulo7.P717;
import pe.gob.minagri.ena.envio.capitulo7.P718;
import pe.gob.minagri.ena.envio.capitulo7.P732;
import pe.gob.minagri.ena.envio.capitulo7.P733;
import pe.gob.minagri.ena.envio.capitulo7.P734;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "p701",
        "p702",
        "p707",
        "p708",
        "p710",
        "p710_cant",
        "p711",
        "p714",
        "p714_otro",
        "p715",
        "p716",
        "p716_otro",
        "p717",
        "p718",
        "p719",
        "p719_otro",
        "p720",
        "p720_cant",
        "p721",
        "p722",
        "p723",
        "p723_otro",
        "p724",
        "p725",
        "p726",
        "p726_otro",
        "p727",
        "p727_otro",
        "p728",
        "p729",
        "p729_otro",
        "p730",
        "p731",
        "p731_otro",
        "p732",
        "p733",
        "p734",
        "p735",
        "p735_otro",
        "p736",
        "p737",
        "p737_otro",
        "p738",
        "p738_otro",
        "p738_observacion"
})

public class Capitulo7 {

    @JsonProperty("p701")
    private Integer p701;
    @JsonProperty("p702")
    private List<pe.gob.minagri.ena.envio.capitulo7.P702> p702 = null;
    @JsonProperty("p707")
    private Integer p707;
    @JsonProperty("p708")
    private List<pe.gob.minagri.ena.envio.capitulo7.P708> p708 = null;
    @JsonProperty("p710")
    private Integer p710;
    @JsonProperty("p710_cant")
    private Integer p710Cant;
    @JsonProperty("p711")
    private List<P711> p711 = null;
    @JsonProperty("p714")
    private String p714;
    @JsonProperty("p714_otro")
    private String p714Otro;
    @JsonProperty("p715")
    private String p715;
    @JsonProperty("p716")
    private String p716;
    @JsonProperty("p716_otro")
    private String p716Otro;
    @JsonProperty("p717")
    private String p717 = null;
    @JsonProperty("p717_otro")
    private String p717Otro;
    @JsonProperty("p718")
    private List<P718> p718 = null;
    @JsonProperty("p719")
    private String p719;
    @JsonProperty("p719_otro")
    private String p719Otro;
    @JsonProperty("p720")
    private Integer p720;
    @JsonProperty("p720_cant")
    private Integer p720Cant;
    @JsonProperty("p721")
    private Object p721;
    @JsonProperty("p722")
    private Integer p722;
    @JsonProperty("p723")
    private String p723;
    @JsonProperty("p723_otro")
    private String p723Otro;
    @JsonProperty("p724")
    private Integer p724;
    @JsonProperty("p725")
    private Integer p725;
    @JsonProperty("p726")
    private String p726;
    @JsonProperty("p726_otro")
    private String p726Otro;
    @JsonProperty("p727")
    private String p727;
    @JsonProperty("p727_otro")
    private String p727Otro;
    @JsonProperty("p728")
    private Integer p728;
    @JsonProperty("p729")
    private String p729;
    @JsonProperty("p729_otro")
    private String p729Otro;
    @JsonProperty("p730")
    private Integer p730;
    @JsonProperty("p731")
    private String p731;
    @JsonProperty("p731_otro")
    private String p731Otro;
    @JsonProperty("p732")
    private List<P732> p732 = null;
    @JsonProperty("p733")
    private List<P733> p733 = null;
    @JsonProperty("p734")
    private List<P734> p734 = null;
    @JsonProperty("p735")
    private String p735;
    @JsonProperty("p735_otro")
    private String p735Otro;
    @JsonProperty("p736")
    private Integer p736;
    @JsonProperty("p737")
    private String p737;
    @JsonProperty("p737_otro")
    private String p737Otro;
    @JsonProperty("p738")
    private String p738;
    @JsonProperty("p738_otro")
    private String p738Otro;
    @JsonProperty("p738_observacion")
    private String p738Observacion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p701")
    public Integer getP701() {
        return p701;
    }

    @JsonProperty("p701")
    public void setP701(Integer p701) {
        this.p701 = p701;
    }

    @JsonProperty("p702")
    public List<pe.gob.minagri.ena.envio.capitulo7.P702> getP702() {
        return p702;
    }

    @JsonProperty("p702")
    public void setP702(List<pe.gob.minagri.ena.envio.capitulo7.P702> p702) {
        this.p702 = p702;
    }

    @JsonProperty("p707")
    public Integer getP707() {
        return p707;
    }

    @JsonProperty("p707")
    public void setP707(Integer p707) {
        this.p707 = p707;
    }

    @JsonProperty("p708")
    public List<pe.gob.minagri.ena.envio.capitulo7.P708> getP708() {
        return p708;
    }

    @JsonProperty("p708")
    public void setP708(List<P708> p708) {
        this.p708 = p708;
    }

    @JsonProperty("p710")
    public Integer getP710() {
        return p710;
    }

    @JsonProperty("p710")
    public void setP710(Integer p710) {
        this.p710 = p710;
    }

    @JsonProperty("p710_cant")
    public Integer getP710Cant() {
        return p710Cant;
    }

    @JsonProperty("p710_cant")
    public void setP710Cant(Integer p710Cant) {
        this.p710Cant = p710Cant;
    }

    @JsonProperty("p711")
    public List<P711> getP711() {
        return p711;
    }

    @JsonProperty("p711")
    public void setP711(List<P711> p711) {
        this.p711 = p711;
    }

    @JsonProperty("p714")
    public String getP714() {
        return p714;
    }

    @JsonProperty("p714")
    public void setP714(String p714) {
        this.p714 = p714;
    }

    @JsonProperty("p714_otro")
    public String getP714Otro() {
        return p714Otro;
    }

    @JsonProperty("p714_otro")
    public void setP714Otro(String p714Otro) {
        this.p714Otro = p714Otro;
    }

    @JsonProperty("p715")
    public String getP715() {
        return p715;
    }

    @JsonProperty("p715")
    public void setP715(String p715) {
        this.p715 = p715;
    }

    @JsonProperty("p716")
    public String getP716() {
        return p716;
    }

    @JsonProperty("p716")
    public void setP716(String p716) {
        this.p716 = p716;
    }

    @JsonProperty("p716_otro")
    public String getP716Otro() {
        return p716Otro;
    }

    @JsonProperty("p716_otro")
    public void setP716Otro(String p716Otro) {
        this.p716Otro = p716Otro;
    }

    @JsonProperty("p717")
    public String getP717() {
        return p717;
    }

    @JsonProperty("p717")
    public void setP717(String p717) {
        this.p717 = p717;
    }

    @JsonProperty("p717_otro")
    public void setP717Otro(String p717Otro) {
        this.p717Otro = p717Otro;
    }

    @JsonProperty("p717_otro")
    public String getP717Otro() {
        return p717Otro;
    }


    @JsonProperty("p718")
    public List<P718> getP718() {
        return p718;
    }

    @JsonProperty("p718")
    public void setP718(List<P718> p718) {
        this.p718 = p718;
    }

    @JsonProperty("p719")
    public String getP719() {
        return p719;
    }

    @JsonProperty("p719")
    public void setP719(String p719) {
        this.p719 = p719;
    }

    @JsonProperty("p719_otro")
    public String getP719Otro() {
        return p719Otro;
    }

    @JsonProperty("p719_otro")
    public void setP719Otro(String p719Otro) {
        this.p719Otro = p719Otro;
    }

    @JsonProperty("p720")
    public Integer getP720() {
        return p720;
    }

    @JsonProperty("p720")
    public void setP720(Integer p720) {
        this.p720 = p720;
    }

    @JsonProperty("p720_cant")
    public Integer getP720Cant() {
        return p720Cant;
    }

    @JsonProperty("p720_cant")
    public void setP720Cant(Integer p720Cant) {
        this.p720Cant = p720Cant;
    }

    @JsonProperty("p721")
    public Object getP721() {
        return p721;
    }

    @JsonProperty("p721")
    public void setP721(Object p721) {
        this.p721 = p721;
    }

    @JsonProperty("p722")
    public Integer getP722() {
        return p722;
    }

    @JsonProperty("p722")
    public void setP722(Integer p722) {
        this.p722 = p722;
    }

    @JsonProperty("p723")
    public String getP723() {
        return p723;
    }

    @JsonProperty("p723")
    public void setP723(String p723) {
        this.p723 = p723;
    }

    @JsonProperty("p723_otro")
    public String getP723Otro() {
        return p723Otro;
    }

    @JsonProperty("p723_otro")
    public void setP723Otro(String p723Otro) {
        this.p723Otro = p723Otro;
    }

    @JsonProperty("p724")
    public Integer getP724() {
        return p724;
    }

    @JsonProperty("p724")
    public void setP724(Integer p724) {
        this.p724 = p724;
    }

    @JsonProperty("p725")
    public Integer getP725() {
        return p725;
    }

    @JsonProperty("p725")
    public void setP725(Integer p725) {
        this.p725 = p725;
    }

    @JsonProperty("p726")
    public String getP726() {
        return p726;
    }

    @JsonProperty("p726")
    public void setP726(String p726) {
        this.p726 = p726;
    }

    @JsonProperty("p726_otro")
    public String getP726Otro() {
        return p726Otro;
    }

    @JsonProperty("p726_otro")
    public void setP726Otro(String p726Otro) {
        this.p726Otro = p726Otro;
    }

    @JsonProperty("p727")
    public String getP727() {
        return p727;
    }

    @JsonProperty("p727")
    public void setP727(String p727) {
        this.p727 = p727;
    }

    @JsonProperty("p727_otro")
    public String getP727Otro() {
        return p727Otro;
    }

    @JsonProperty("p727_otro")
    public void setP727Otro(String p727Otro) {
        this.p727Otro = p727Otro;
    }

    @JsonProperty("p728")
    public Integer getP728() {
        return p728;
    }

    @JsonProperty("p728")
    public void setP728(Integer p728) {
        this.p728 = p728;
    }

    @JsonProperty("p729")
    public String getP729() {
        return p729;
    }

    @JsonProperty("p729")
    public void setP729(String p729) {
        this.p729 = p729;
    }

    @JsonProperty("p729_otro")
    public String getP729Otro() {
        return p729Otro;
    }

    @JsonProperty("p729_otro")
    public void setP729Otro(String p729Otro) {
        this.p729Otro = p729Otro;
    }

    @JsonProperty("p730")
    public Integer getP730() {
        return p730;
    }

    @JsonProperty("p730")
    public void setP730(Integer p730) {
        this.p730 = p730;
    }

    @JsonProperty("p731")
    public String getP731() {
        return p731;
    }

    @JsonProperty("p731")
    public void setP731(String p731) {
        this.p731 = p731;
    }

    @JsonProperty("p731_otro")
    public String getP731Otro() {
        return p731Otro;
    }

    @JsonProperty("p731_otro")
    public void setP731Otro(String p731Otro) {
        this.p731Otro = p731Otro;
    }

    @JsonProperty("p732")
    public List<P732> getP732() {
        return p732;
    }

    @JsonProperty("p732")
    public void setP732(List<P732> p732) {
        this.p732 = p732;
    }

    @JsonProperty("p733")
    public List<P733> getP733() {
        return p733;
    }

    @JsonProperty("p733")
    public void setP733(List<P733> p733) {
        this.p733 = p733;
    }

    @JsonProperty("p734")
    public List<P734> getP734() {
        return p734;
    }

    @JsonProperty("p734")
    public void setP734(List<P734> p734) {
        this.p734 = p734;
    }

    @JsonProperty("p735")
    public String getP735() {
        return p735;
    }

    @JsonProperty("p735")
    public void setP735(String p735) {
        this.p735 = p735;
    }

    @JsonProperty("p735_otro")
    public String getP735Otro() {
        return p735Otro;
    }

    @JsonProperty("p735_otro")
    public void setP735Otro(String p735Otro) {
        this.p735Otro = p735Otro;
    }

    @JsonProperty("p736")
    public Integer getP736() {
        return p736;
    }

    @JsonProperty("p736")
    public void setP736(Integer p736) {
        this.p736 = p736;
    }

    @JsonProperty("p737")
    public String getP737() {
        return p737;
    }

    @JsonProperty("p737")
    public void setP737(String p737) {
        this.p737 = p737;
    }

    @JsonProperty("p737_otro")
    public Object getP737Otro() {
        return p737Otro;
    }

    @JsonProperty("p737_otro")
    public void setP737Otro(String p737Otro) {
        this.p737Otro = p737Otro;
    }

    @JsonProperty("p738")
    public String getP738() {
        return p738;
    }

    @JsonProperty("p738")
    public void setP738(String p738) {
        this.p738 = p738;
    }

    @JsonProperty("p738_otro")
    public Object getP738Otro() {
        return p738Otro;
    }

    @JsonProperty("p738_otro")
    public void setP738Otro(String p738Otro) {
        this.p738Otro = p738Otro;
    }

    @JsonProperty("p738_observacion")
    public String getP738Observacion() {
        return p738Observacion;
    }

    @JsonProperty("p738_observacion")
    public void setP738Observacion(String p738Observacion) {
        this.p738Observacion = p738Observacion;
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
