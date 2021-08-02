package pe.gob.minagri.ena.envio.capitulo7;

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
        "p702_num",
        "p702_otro",
        "p702_rpta",
        "p702a",
        "p703",
        "p704",
        "p705",
        "p705_otro",
        "p706"
})
public class P702 {

    @JsonProperty("p702_num")
    private Integer p702Num;
    @JsonProperty("p702_otro")
    private String p702Otro;
    @JsonProperty("p702_rpta")
    private String p702Rpta;
    @JsonProperty("p702a")
    private String p702a;
    @JsonProperty("p703")
    private String p703;
    @JsonProperty("p704")
    private Integer p704;
    @JsonProperty("p705")
    private String p705;
    @JsonProperty("p705_otro")
    private Object p705Otro;
    @JsonProperty("p706")
    private String p706;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p702_num")
    public Integer getP702Num() {
        return p702Num;
    }

    @JsonProperty("p702_num")
    public void setP702Num(Integer p702Num) {
        this.p702Num = p702Num;
    }

    @JsonProperty("p702_otro")
    public String getP702Otro() {
        return p702Otro;
    }

    @JsonProperty("p702_otro")
    public void setP702Otro(String p702Otro) {
        this.p702Otro = p702Otro;
    }

    @JsonProperty("p702_rpta")
    public String getP702Rpta() {
        return p702Rpta;
    }

    @JsonProperty("p702_rpta")
    public void setP702Rpta(String p702Rpta) {
        this.p702Rpta = p702Rpta;
    }

    @JsonProperty("p702a")
    public String getP702a() {
        return p702a;
    }

    @JsonProperty("p702a")
    public void setP702a(String p702a) {
        this.p702a = p702a;
    }

    @JsonProperty("p703")
    public String getP703() {
        return p703;
    }

    @JsonProperty("p703")
    public void setP703(String p703) {
        this.p703 = p703;
    }

    @JsonProperty("p704")
    public Integer getP704() {
        return p704;
    }

    @JsonProperty("p704")
    public void setP704(Integer p704) {
        this.p704 = p704;
    }

    @JsonProperty("p705")
    public String getP705() {
        return p705;
    }

    @JsonProperty("p705")
    public void setP705(String p705) {
        this.p705 = p705;
    }

    @JsonProperty("p705_otro")
    public Object getP705Otro() {
        return p705Otro;
    }

    @JsonProperty("p705_otro")
    public void setP705Otro(Object p705Otro) {
        this.p705Otro = p705Otro;
    }

    @JsonProperty("p706")
    public String getP706() {
        return p706;
    }

    @JsonProperty("p706")
    public void setP706(String p706) {
        this.p706 = p706;
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
