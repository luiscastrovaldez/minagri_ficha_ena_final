
package pe.gob.minagri.ena.envio.capitulo4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "p401_num",
        "p401_rpta",
        "p402",
        "p403_mes",
        "p403_anio",
        "p404",
        "p405a",
        "p405b",
        "p405c",
        "p406",
        "p407",
        "p407_otro",
        "p408",
        "p408_otro",
        "p409",
        "p410a_mes",
        "p410a_anio",
        "p410b_mes",
        "p410b_anio",
        "p411_01",
        "p411_02",
        "p411_03",
        "p411_04",
        "p411_05",
        "p411_06",
        "p411_07",
        "p411_08",
        "p411_09",
        "p411_10",
        "p411_11",
        "p411_12",
        "p412a",
        "p412b",
        "p412c",
        "p413",
        "p414",
        "p415",
        "p416",
        "p417",
        "p418",
        "p419a",
        "p419b",
        "p419c",
        "p419d",
        "p419e",
        "p420",
        "p421",
        "p422",
        "p423",
        "p424",
        "p424_otro",
        "p425a",
        "p425b",
        "p425c",
        "p425d",
        "p426a",
        "p426a_otro",
        "p426b",
        "p426b_otro",
        "p427",
        "p427_otro"
})

public class P401 {

    @JsonProperty("p401_num")
    private Integer p401Num;
    @JsonProperty("p401_rpta")
    private Integer p401Rpta;
    @JsonProperty("p402")
    private String p402;
    @JsonProperty("p403_mes")
    private String p403Mes;
    @JsonProperty("p403_anio")
    private String p403Anio;
    @JsonProperty("p404")
    private Integer p404;
    @JsonProperty("p405a")
    private Double p405a;
    @JsonProperty("p405b")
    private Integer p405b;
    @JsonProperty("p405c")
    private Double p405c;
    @JsonProperty("p406")
    private Double p406;
    @JsonProperty("p407")
    private String p407;
    @JsonProperty("p407_otro")
    private String p407Otro;
    @JsonProperty("p408")
    private String p408;
    @JsonProperty("p408_otro")
    private String p408Otro;
    @JsonProperty("p409")
    private Integer p409;
    @JsonProperty("p410a_mes")
    private String p410aMes;
    @JsonProperty("p410a_anio")
    private String p410aAnio;
    @JsonProperty("p410b_mes")
    private String p410bMes;
    @JsonProperty("p410b_anio")
    private String p410bAnio;
    @JsonProperty("p411_01")
    private String p41101;
    @JsonProperty("p411_02")
    private String p41102;
    @JsonProperty("p411_03")
    private String p41103;
    @JsonProperty("p411_04")
    private String p41104;
    @JsonProperty("p411_05")
    private String p41105;
    @JsonProperty("p411_06")
    private String p41106;
    @JsonProperty("p411_07")
    private String p41107;
    @JsonProperty("p411_08")
    private String p41108;
    @JsonProperty("p411_09")
    private String p41109;
    @JsonProperty("p411_10")
    private String p41110;
    @JsonProperty("p411_11")
    private String p41111;
    @JsonProperty("p411_12")
    private String p41112;
    @JsonProperty("p412a")
    private Double p412a;
    @JsonProperty("p412b")
    private Integer p412b;
    @JsonProperty("p412c")
    private Double p412c;
    @JsonProperty("p413")
    private Double p413;
    @JsonProperty("p414")
    private Double p414;
    @JsonProperty("p415")
    private String p415;
    @JsonProperty("p416")
    private String p416;
    @JsonProperty("p417")
    private String p417;
    @JsonProperty("p418")
    private Integer p418;
    @JsonProperty("p419a")
    private Double p419a;
    @JsonProperty("p419b")
    private Integer p419b;
    @JsonProperty("p419c")
    private Integer p419c;
    @JsonProperty("p419d")
    private Integer p419d;
    @JsonProperty("p419e")
    private Double p419e;
    @JsonProperty("p420")
    private Double p420;
    @JsonProperty("p421")
    private Integer p421;
    @JsonProperty("p422")
    private Integer p422;
    @JsonProperty("p423")
    private List<P423> p423 = null;
    @JsonProperty("p424")
    private String p424;
    @JsonProperty("p424_otro")
    private String p424Otro;
    @JsonProperty("p425a")
    private Double p425a;
    @JsonProperty("p425b")
    private Integer p425b;
    @JsonProperty("p425c")
    private Integer p425c;
    @JsonProperty("p425d")
    private Double p425d;
    @JsonProperty("p426a")
    private String p426a;
    @JsonProperty("p426a_otro")
    private String p426aOtro;
    @JsonProperty("p426b")
    private String p426b;
    @JsonProperty("p426b_otro")
    private String p426bOtro;
    @JsonProperty("p427")
    private String p427;
    @JsonProperty("p427_otro")
    private String p427Otro;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p401_num")
    public Integer getP401Num() {
        return p401Num;
    }

    @JsonProperty("p401_num")
    public void setP401Num(Integer p401Num) {
        this.p401Num = p401Num;
    }

    @JsonProperty("p401_rpta")
    public Integer getP401Rpta() {
        return p401Rpta;
    }

    @JsonProperty("p401_rpta")
    public void setP401Rpta(Integer p401Rpta) {
        this.p401Rpta = p401Rpta;
    }

    @JsonProperty("p402")
    public String getP402() {
        return p402;
    }

    @JsonProperty("p402")
    public void setP402(String p402) {
        this.p402 = p402;
    }

    @JsonProperty("p403_mes")
    public String getP403Mes() {
        return p403Mes;
    }

    @JsonProperty("p403_mes")
    public void setP403Mes(String p403Mes) {
        this.p403Mes = p403Mes;
    }

    @JsonProperty("p403_anio")
    public String getP403Anio() {
        return p403Anio;
    }

    @JsonProperty("p403_anio")
    public void setP403Anio(String p403Anio) {
        this.p403Anio = p403Anio;
    }

    @JsonProperty("p404")
    public Integer getP404() {
        return p404;
    }

    @JsonProperty("p404")
    public void setP404(Integer p404) {
        this.p404 = p404;
    }

    @JsonProperty("p405a")
    public Double getP405a() {
        return p405a;
    }

    @JsonProperty("p405a")
    public void setP405a(Double p405a) {
        this.p405a = p405a;
    }

    @JsonProperty("p405b")
    public Integer getP405b() {
        return p405b;
    }

    @JsonProperty("p405b")
    public void setP405b(Integer p405b) {
        this.p405b = p405b;
    }

    @JsonProperty("p405c")
    public Double getP405c() {
        return p405c;
    }

    @JsonProperty("p405c")
    public void setP405c(Double p405c) {
        this.p405c = p405c;
    }

    @JsonProperty("p406")
    public Double getP406() {
        return p406;
    }

    @JsonProperty("p406")
    public void setP406(Double p406) {
        this.p406 = p406;
    }

    @JsonProperty("p407")
    public String getP407() {
        return p407;
    }

    @JsonProperty("p407")
    public void setP407(String p407) {
        this.p407 = p407;
    }

    @JsonProperty("p407_otro")
    public String getP407Otro() {
        return p407Otro;
    }

    @JsonProperty("p407_otro")
    public void setP407Otro(String p407Otro) {
        this.p407Otro = p407Otro;
    }

    @JsonProperty("p408")
    public String getP408() {
        return p408;
    }

    @JsonProperty("p408")
    public void setP408(String p408) {
        this.p408 = p408;
    }

    @JsonProperty("p408_otro")
    public String getP408Otro() {
        return p408Otro;
    }

    @JsonProperty("p408_otro")
    public void setP408Otro(String p408Otro) {
        this.p408Otro = p408Otro;
    }

    @JsonProperty("p409")
    public Integer getP409() {
        return p409;
    }

    @JsonProperty("p409")
    public void setP409(Integer p409) {
        this.p409 = p409;
    }

    @JsonProperty("p410a_mes")
    public String getP410aMes() {
        return p410aMes;
    }

    @JsonProperty("p410a_mes")
    public void setP410aMes(String p410aMes) {
        this.p410aMes = p410aMes;
    }

    @JsonProperty("p410a_anio")
    public String getP410aAnio() {
        return p410aAnio;
    }

    @JsonProperty("p410a_anio")
    public void setP410aAnio(String p410aAnio) {
        this.p410aAnio = p410aAnio;
    }

    @JsonProperty("p410b_mes")
    public String getP410bMes() {
        return p410bMes;
    }

    @JsonProperty("p410b_mes")
    public void setP410bMes(String p410bMes) {
        this.p410bMes = p410bMes;
    }

    @JsonProperty("p410b_anio")
    public String getP410bAnio() {
        return p410bAnio;
    }

    @JsonProperty("p410b_anio")
    public void setP410bAnio(String p410bAnio) {
        this.p410bAnio = p410bAnio;
    }

    @JsonProperty("p411_01")
    public String getP41101() {
        return p41101;
    }

    @JsonProperty("p411_01")
    public void setP41101(String p41101) {
        this.p41101 = p41101;
    }

    @JsonProperty("p411_02")
    public String getP41102() {
        return p41102;
    }

    @JsonProperty("p411_02")
    public void setP41102(String p41102) {
        this.p41102 = p41102;
    }

    @JsonProperty("p411_03")
    public String getP41103() {
        return p41103;
    }

    @JsonProperty("p411_03")
    public void setP41103(String p41103) {
        this.p41103 = p41103;
    }

    @JsonProperty("p411_04")
    public String getP41104() {
        return p41104;
    }

    @JsonProperty("p411_04")
    public void setP41104(String p41104) {
        this.p41104 = p41104;
    }

    @JsonProperty("p411_05")
    public String getP41105() {
        return p41105;
    }

    @JsonProperty("p411_05")
    public void setP41105(String p41105) {
        this.p41105 = p41105;
    }

    @JsonProperty("p411_06")
    public String getP41106() {
        return p41106;
    }

    @JsonProperty("p411_06")
    public void setP41106(String p41106) {
        this.p41106 = p41106;
    }

    @JsonProperty("p411_07")
    public String getP41107() {
        return p41107;
    }

    @JsonProperty("p411_07")
    public void setP41107(String p41107) {
        this.p41107 = p41107;
    }

    @JsonProperty("p411_08")
    public String getP41108() {
        return p41108;
    }

    @JsonProperty("p411_08")
    public void setP41108(String p41108) {
        this.p41108 = p41108;
    }

    @JsonProperty("p411_09")
    public String getP41109() {
        return p41109;
    }

    @JsonProperty("p411_09")
    public void setP41109(String p41109) {
        this.p41109 = p41109;
    }

    @JsonProperty("p411_10")
    public String getP41110() {
        return p41110;
    }

    @JsonProperty("p411_10")
    public void setP41110(String p41110) {
        this.p41110 = p41110;
    }

    @JsonProperty("p411_11")
    public String getP41111() {
        return p41111;
    }

    @JsonProperty("p411_11")
    public void setP41111(String p41111) {
        this.p41111 = p41111;
    }

    @JsonProperty("p411_12")
    public String getP41112() {
        return p41112;
    }

    @JsonProperty("p411_12")
    public void setP41112(String p41112) {
        this.p41112 = p41112;
    }

    @JsonProperty("p412a")
    public Double getP412a() {
        return p412a;
    }

    @JsonProperty("p412a")
    public void setP412a(Double p412a) {
        this.p412a = p412a;
    }

    @JsonProperty("p412b")
    public Integer getP412b() {
        return p412b;
    }

    @JsonProperty("p412b")
    public void setP412b(Integer p412b) {
        this.p412b = p412b;
    }

    @JsonProperty("p412c")
    public Double getP412c() {
        return p412c;
    }

    @JsonProperty("p412c")
    public void setP412c(Double p412c) {
        this.p412c = p412c;
    }

    @JsonProperty("p413")
    public Double getP413() {
        return p413;
    }

    @JsonProperty("p413")
    public void setP413(Double p413) {
        this.p413 = p413;
    }

    @JsonProperty("p414")
    public Double getP414() {
        return p414;
    }

    @JsonProperty("p414")
    public void setP414(Double p414) {
        this.p414 = p414;
    }

    @JsonProperty("p415")
    public String getP415() {
        return p415;
    }

    @JsonProperty("p415")
    public void setP415(String p415) {
        this.p415 = p415;
    }

    @JsonProperty("p416")
    public String getP416() {
        return p416;
    }

    @JsonProperty("p416")
    public void setP416(String p416) {
        this.p416 = p416;
    }

    @JsonProperty("p417")
    public String getP417() {
        return p417;
    }

    @JsonProperty("p417")
    public void setP417(String p417) {
        this.p417 = p417;
    }

    @JsonProperty("p418")
    public Integer getP418() {
        return p418;
    }

    @JsonProperty("p418")
    public void setP418(Integer p418) {
        this.p418 = p418;
    }

    @JsonProperty("p419a")
    public Double getP419a() {
        return p419a;
    }

    @JsonProperty("p419a")
    public void setP419a(Double p419a) {
        this.p419a = p419a;
    }

    @JsonProperty("p419b")
    public Integer getP419b() {
        return p419b;
    }

    @JsonProperty("p419b")
    public void setP419b(Integer p419b) {
        this.p419b = p419b;
    }

    @JsonProperty("p419c")
    public Integer getP419c() {
        return p419c;
    }

    @JsonProperty("p419c")
    public void setP419c(Integer p419c) {
        this.p419c = p419c;
    }

    @JsonProperty("p419d")
    public Integer getP419d() {
        return p419d;
    }

    @JsonProperty("p419d")
    public void setP419d(Integer p419d) {
        this.p419d = p419d;
    }

    @JsonProperty("p419e")
    public Double getP419e() {
        return p419e;
    }

    @JsonProperty("p419e")
    public void setP419e(Double p419e) {
        this.p419e = p419e;
    }

    @JsonProperty("p420")
    public Double getP420() {
        return p420;
    }

    @JsonProperty("p420")
    public void setP420(Double p420) {
        this.p420 = p420;
    }

    @JsonProperty("p421")
    public Integer getP421() {
        return p421;
    }

    @JsonProperty("p421")
    public void setP421(Integer p421) {
        this.p421 = p421;
    }

    @JsonProperty("p422")
    public Integer getP422() {
        return p422;
    }

    @JsonProperty("p422")
    public void setP422(Integer p422) {
        this.p422 = p422;
    }

    @JsonProperty("p423")
    public List<P423> getP423() {
        return p423;
    }

    @JsonProperty("p423")
    public void setP423(List<P423> p423) {
        this.p423 = p423;
    }

    @JsonProperty("p424")
    public String getP424() {
        return p424;
    }

    @JsonProperty("p424")
    public void setP424(String p424) {
        this.p424 = p424;
    }

    @JsonProperty("p424_otro")
    public String getP424Otro() {
        return p424Otro;
    }

    @JsonProperty("p424_otro")
    public void setP424Otro(String p424Otro) {
        this.p424Otro = p424Otro;
    }

    @JsonProperty("p425a")
    public Double getP425a() {
        return p425a;
    }

    @JsonProperty("p425a")
    public void setP425a(Double p425a) {
        this.p425a = p425a;
    }

    @JsonProperty("p425b")
    public Integer getP425b() {
        return p425b;
    }

    @JsonProperty("p425b")
    public void setP425b(Integer p425b) {
        this.p425b = p425b;
    }

    @JsonProperty("p425c")
    public Integer getP425c() {
        return p425c;
    }

    @JsonProperty("p425c")
    public void setP425c(Integer p425c) {
        this.p425c = p425c;
    }

    @JsonProperty("p425d")
    public Double getP425d() {
        return p425d;
    }

    @JsonProperty("p425d")
    public void setP425d(Double p425d) {
        this.p425d = p425d;
    }

    @JsonProperty("p426a")
    public String getP426a() {
        return p426a;
    }

    @JsonProperty("p426a")
    public void setP426a(String p426a) {
        this.p426a = p426a;
    }

    @JsonProperty("p426a_otro")
    public String getP426aOtro() {
        return p426aOtro;
    }

    @JsonProperty("p426a_otro")
    public void setP426aOtro(String p426aOtro) {
        this.p426aOtro = p426aOtro;
    }

    @JsonProperty("p426b")
    public String getP426b() {
        return p426b;
    }

    @JsonProperty("p426b")
    public void setP426b(String p426b) {
        this.p426b = p426b;
    }

    @JsonProperty("p426b_otro")
    public String getP426bOtro() {
        return p426bOtro;
    }

    @JsonProperty("p426b_otro")
    public void setP426bOtro(String p426bOtro) {
        this.p426bOtro = p426bOtro;
    }

    @JsonProperty("p427")
    public String getP427() {
        return p427;
    }

    @JsonProperty("p427")
    public void setP427(String p427) {
        this.p427 = p427;
    }

    @JsonProperty("p427_otro")
    public String getP427Otro() {
        return p427Otro;
    }

    @JsonProperty("p427_otro")
    public void setP427Otro(String p427Otro) {
        this.p427Otro = p427Otro;
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
