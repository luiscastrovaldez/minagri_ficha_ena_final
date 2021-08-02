
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
        "visita",
        "fecha_final",
        "resultado_visita_final",
        "resultado_visita_final_otro",
        "observacion"
})

public class Capitulo12 {

    @JsonProperty("visita")
    private List<Visitum> visita = null;
    @JsonProperty("fecha_final")
    private String fechaFinal;
    @JsonProperty("resultado_visita_final")
    private Integer resultadoVisitaFinal;
    @JsonProperty("resultado_visita_final_otro")
    private String resultadoVisitaFinalOtro;
    @JsonProperty("observacion")
    private String observacion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("visita")
    public List<Visitum> getVisita() {
        return visita;
    }

    @JsonProperty("visita")
    public void setVisita(List<Visitum> visita) {
        this.visita = visita;
    }

    @JsonProperty("fecha_final")
    public String getFechaFinal() {
        return fechaFinal;
    }

    @JsonProperty("fecha_final")
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @JsonProperty("resultado_visita_final")
    public Integer getResultadoVisitaFinal() {
        return resultadoVisitaFinal;
    }

    @JsonProperty("resultado_visita_final")
    public void setResultadoVisitaFinal(Integer resultadoVisitaFinal) { this.resultadoVisitaFinal = resultadoVisitaFinal; }

    @JsonProperty("resultado_visita_final_otro")
    public String getResultadoVisitaFinalOtro() {
        return resultadoVisitaFinalOtro;
    }

    @JsonProperty("resultado_visita_final_otro")
    public void setResultadoVisitaFinalOtro(String resultadoVisitaFinalOtro) { this.resultadoVisitaFinalOtro = resultadoVisitaFinalOtro; }

    @JsonProperty("observacion")
    public String getObservacion() { return observacion; }

    @JsonProperty("observacion")
    public void setObservacion(String observacion) { this.observacion = observacion; }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
