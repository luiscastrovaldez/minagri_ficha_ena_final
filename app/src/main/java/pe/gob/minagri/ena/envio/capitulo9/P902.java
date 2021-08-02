package pe.gob.minagri.ena.envio.capitulo9;

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
        "p902a",
        "p902b",
        "p902_otro",
        "p903",
        "p904",
        "p904_otro",
        "p905a",
        "p905b",
        "p906",
        "p907"
})

public class P902 {

    @JsonProperty("p902a")
    private Integer p902a;
    @JsonProperty("p902b")
    private Integer p902b;
    @JsonProperty("p902_otro")
    private String p902Otro;
    @JsonProperty("p903")
    private Integer p903;
    @JsonProperty("p904")
    private Integer p904;
    @JsonProperty("p904_otro")
    private String p904Otro;
    @JsonProperty("p905a")
    private Integer p905a;
    @JsonProperty("p905b")
    private Integer p905b;
    @JsonProperty("p906")
    private Integer p906;
    @JsonProperty("p907")
    private Integer p907;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p902a")
    public Integer getP902a() {
        return p902a;
    }

    @JsonProperty("p902a")
    public void setP902a(Integer p902a) {
        this.p902a = p902a;
    }

    @JsonProperty("p902b")
    public Integer getP902b() {
        return p902b;
    }

    @JsonProperty("p902b")
    public void setP902b(Integer p902b) {
        this.p902b = p902b;
    }

    @JsonProperty("p902_otro")
    public String getP902Otro() {
        return p902Otro;
    }

    @JsonProperty("p902_otro")
    public void setP902Otro(String p902Otro) {
        this.p902Otro = p902Otro;
    }

    @JsonProperty("p903")
    public Integer getP903() {
        return p903;
    }

    @JsonProperty("p903")
    public void setP903(Integer p903) {
        this.p903 = p903;
    }

    @JsonProperty("p904")
    public Integer getP904() {
        return p904;
    }

    @JsonProperty("p904")
    public void setP904(Integer p904) {
        this.p904 = p904;
    }

    @JsonProperty("p904_otro")
    public String getP904Otro() {
        return p904Otro;
    }

    @JsonProperty("p904_otro")
    public void setP904Otro(String p904Otro) {
        this.p904Otro = p904Otro;
    }

    @JsonProperty("p905a")
    public Integer getP905a() {
        return p905a;
    }

    @JsonProperty("p905a")
    public void setP905a(Integer p905a) {
        this.p905a = p905a;
    }

    @JsonProperty("p905b")
    public Integer getP905b() {
        return p905b;
    }

    @JsonProperty("p905b")
    public void setP905b(Integer p905b) {
        this.p905b = p905b;
    }

    @JsonProperty("p906")
    public Integer getP906() {
        return p906;
    }

    @JsonProperty("p906")
    public void setP906(Integer p906) {
        this.p906 = p906;
    }

    @JsonProperty("p907")
    public Integer getP907() {
        return p907;
    }

    @JsonProperty("p907")
    public void setP907(Integer p907) {
        this.p907 = p907;
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
