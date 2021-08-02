
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "datos_generales",
        "capitulo_1",
        "capitulo_2",
        "capitulo_3",
        "capitulo_4",
        "capitulo_5",
        "capitulo_6",
        "capitulo_7",
        "capitulo_8",
        "capitulo_9",
        "capitulo_10",
        "capitulo_11",
        "capitulo_12"
})

public class Envio {

    @JsonProperty("datos_generales")
    private DatosGenerales datosGenerales;
    @JsonProperty("capitulo_1")
    private Capitulo1 capitulo1;
    @JsonProperty("capitulo_2")
    private Capitulo2 capitulo2;
    @JsonProperty("capitulo_3")
    private Capitulo3 capitulo3;
    @JsonProperty("capitulo_4")
    private Capitulo4 capitulo4;
    @JsonProperty("capitulo_5")
    private Capitulo5 capitulo5;
    @JsonProperty("capitulo_6")
    private Capitulo6 capitulo6;
    @JsonProperty("capitulo_7")
    private Capitulo7 capitulo7;
    @JsonProperty("capitulo_8")
    private Capitulo8 capitulo8;
    @JsonProperty("capitulo_9")
    private Capitulo9 capitulo9;
    @JsonProperty("capitulo_10")
    private List<Capitulo10> capitulo10 = null;
    @JsonProperty("capitulo_11")
    private Capitulo11 capitulo11;
    @JsonProperty("capitulo_12")
    private Capitulo12 capitulo12;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("datos_generales")
    public DatosGenerales getDatosGenerales() {
        return datosGenerales;
    }

    @JsonProperty("datos_generales")
    public void setDatosGenerales(DatosGenerales datosGenerales) {
        this.datosGenerales = datosGenerales;
    }

    @JsonProperty("capitulo_1")
    public Capitulo1 getCapitulo1() {
        return capitulo1;
    }

    @JsonProperty("capitulo_1")
    public void setCapitulo1(Capitulo1 capitulo1) {
        this.capitulo1 = capitulo1;
    }

    @JsonProperty("capitulo_2")
    public Capitulo2 getCapitulo2() {
        return capitulo2;
    }

    @JsonProperty("capitulo_2")
    public void setCapitulo2(Capitulo2 capitulo2) {
        this.capitulo2 = capitulo2;
    }

    @JsonProperty("capitulo_3")
    public Capitulo3 getCapitulo3() {
        return capitulo3;
    }

    @JsonProperty("capitulo_3")
    public void setCapitulo3(Capitulo3 capitulo3) {
        this.capitulo3 = capitulo3;
    }

    @JsonProperty("capitulo_4")
    public Capitulo4 getCapitulo4() {
        return capitulo4;
    }

    @JsonProperty("capitulo_4")
    public void setCapitulo4(Capitulo4 capitulo4) {
        this.capitulo4 = capitulo4;
    }

    @JsonProperty("capitulo_5")
    public Capitulo5 getCapitulo5() {
        return capitulo5;
    }

    @JsonProperty("capitulo_5")
    public void setCapitulo5(Capitulo5 capitulo5) {
        this.capitulo5 = capitulo5;
    }

    @JsonProperty("capitulo_6")
    public Capitulo6 getCapitulo6() {
        return capitulo6;
    }

    @JsonProperty("capitulo_6")
    public void setCapitulo6(Capitulo6 capitulo6) {
        this.capitulo6 = capitulo6;
    }

    @JsonProperty("capitulo_7")
    public Capitulo7 getCapitulo7() {
        return capitulo7;
    }

    @JsonProperty("capitulo_7")
    public void setCapitulo7(Capitulo7 capitulo7) {
        this.capitulo7 = capitulo7;
    }

    @JsonProperty("capitulo_8")
    public Capitulo8 getCapitulo8() {
        return capitulo8;
    }

    @JsonProperty("capitulo_8")
    public void setCapitulo8(Capitulo8 capitulo8) {
        this.capitulo8 = capitulo8;
    }

    @JsonProperty("capitulo_9")
    public Capitulo9 getCapitulo9() {
        return capitulo9;
    }

    @JsonProperty("capitulo_9")
    public void setCapitulo9(Capitulo9 capitulo9) {
        this.capitulo9 = capitulo9;
    }

    @JsonProperty("capitulo_10")
    public List<Capitulo10> getCapitulo10() {
        return capitulo10;
    }

    @JsonProperty("capitulo_10")
    public void setCapitulo10(List<Capitulo10> capitulo10) {
        this.capitulo10 = capitulo10;
    }

    @JsonProperty("capitulo_11")
    public Capitulo11 getCapitulo11() {
        return capitulo11;
    }

    @JsonProperty("capitulo_11")
    public void setCapitulo11(Capitulo11 capitulo11) {
        this.capitulo11 = capitulo11;
    }

    @JsonProperty("capitulo_12")
    public Capitulo12 getCapitulo12() {
        return capitulo12;
    }

    @JsonProperty("capitulo_12")
    public void setCapitulo12(Capitulo12 capitulo12) {
        this.capitulo12 = capitulo12;
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
