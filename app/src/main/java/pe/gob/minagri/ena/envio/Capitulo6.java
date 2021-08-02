
package pe.gob.minagri.ena.envio;

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
        "p601",
        "p601_otro",
        "p602",
        "p602_otro",
        "p603",
        "p604",
        "p605",
        "p605_otro",
        "p606",
        "p606_otro",
        "p607",
        "p608",
        "p609",
        "p610",
        "p610_otro"
})

public class Capitulo6 {

    @JsonProperty("p601")
    private String p601;
    @JsonProperty("p601_otro")
    private String p601Otro;
    @JsonProperty("p602")
    private String p602;
    @JsonProperty("p602_otro")
    private String p602Otro;
    @JsonProperty("p603")
    private Integer p603;
    @JsonProperty("p604")
    private Integer p604;
    @JsonProperty("p605")
    private String p605;
    @JsonProperty("p605_otro")
    private String p605Otro;
    @JsonProperty("p606")
    private String p606;
    @JsonProperty("p606_otro")
    private String p606Otro;
    @JsonProperty("p607")
    private Integer p607;
    @JsonProperty("p608")
    private Integer p608;
    @JsonProperty("p609")
    private Integer p609;
    @JsonProperty("p610")
    private String p610;
    @JsonProperty("p610_otro")
    private String p610Otro;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p601")
    public String getP601() {
        return p601;
    }

    @JsonProperty("p601")
    public void setP601(String p601) {
        this.p601 = p601;
    }

    @JsonProperty("p601_otro")
    public String getP601Otro() {
        return p601Otro;
    }

    @JsonProperty("p601_otro")
    public void setP601Otro(String p601Otro) {
        this.p601Otro = p601Otro;
    }

    @JsonProperty("p602")
    public String getP602() {
        return p602;
    }

    @JsonProperty("p602")
    public void setP602(String p602) {
        this.p602 = p602;
    }

    @JsonProperty("p602_otro")
    public String getP602Otro() {
        return p602Otro;
    }

    @JsonProperty("p602_otro")
    public void setP602Otro(String p602Otro) {
        this.p602Otro = p602Otro;
    }

    @JsonProperty("p603")
    public Integer getP603() {
        return p603;
    }

    @JsonProperty("p603")
    public void setP603(Integer p603) {
        this.p603 = p603;
    }

    @JsonProperty("p604")
    public Integer getP604() {
        return p604;
    }

    @JsonProperty("p604")
    public void setP604(Integer p604) {
        this.p604 = p604;
    }

    @JsonProperty("p605")
    public String getP605() {
        return p605;
    }

    @JsonProperty("p605")
    public void setP605(String p605) {
        this.p605 = p605;
    }

    @JsonProperty("p605_otro")
    public String getP605Otro() {
        return p605Otro;
    }

    @JsonProperty("p605_otro")
    public void setP605Otro(String p605Otro) {
        this.p605Otro = p605Otro;
    }

    @JsonProperty("p606")
    public String getP606() {
        return p606;
    }

    @JsonProperty("p606")
    public void setP606(String p606) {
        this.p606 = p606;
    }

    @JsonProperty("p606_otro")
    public String getP606Otro() {
        return p606Otro;
    }

    @JsonProperty("p606_otro")
    public void setP606Otro(String p606Otro) {
        this.p606Otro = p606Otro;
    }

    @JsonProperty("p607")
    public Integer getP607() {
        return p607;
    }

    @JsonProperty("p607")
    public void setP607(Integer p607) {
        this.p607 = p607;
    }

    @JsonProperty("p608")
    public Integer getP608() {
        return p608;
    }

    @JsonProperty("p608")
    public void setP608(Integer p608) {
        this.p608 = p608;
    }

    @JsonProperty("p609")
    public Integer getP609() {
        return p609;
    }

    @JsonProperty("p609")
    public void setP609(Integer p609) {
        this.p609 = p609;
    }

    @JsonProperty("p610")
    public String getP610() {
        return p610;
    }

    @JsonProperty("p610")
    public void setP610(String p610) {
        this.p610 = p610;
    }

    @JsonProperty("p610_otro")
    public String getP610Otro() {
        return p610Otro;
    }

    @JsonProperty("p610_otro")
    public void setP610Otro(String p610Otro) {
        this.p610Otro = p610Otro;
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
