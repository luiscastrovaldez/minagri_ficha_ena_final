
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
        "codigo_usuario",
        "num_visita",
        "fecha_encuesta",
        "hora_inicio",
        "hora_fin",
        "fecha_proxima",
        "hora_proxima",
        "resultado_visita",
        "resultado_visita_otro",
        "modifico"
})

public class Visitum {

    @JsonProperty("codigo_usuario")
    private Integer codigoUsuario;
    @JsonProperty("num_visita")
    private Integer numVisita;
    @JsonProperty("fecha_encuesta")
    private String fechaEncuesta;
    @JsonProperty("hora_inicio")
    private String horaInicio;
    @JsonProperty("hora_fin")
    private String horaFin;
    @JsonProperty("fecha_proxima")
    private String fechaProxima;
    @JsonProperty("hora_proxima")
    private String horaProxima;
    @JsonProperty("resultado_visita")
    private Integer resultadoVisita;
    @JsonProperty("resultado_visita_otro")
    private String resultadoVisitaOtro;
    @JsonProperty("modifico")
    private Integer modifico;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("codigo_usuario")
    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    @JsonProperty("codigo_usuario")
    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @JsonProperty("num_visita")
    public Integer getNumVisita() {
        return numVisita;
    }

    @JsonProperty("num_visita")
    public void setNumVisita(Integer numVisita) {
        this.numVisita = numVisita;
    }

    @JsonProperty("fecha_encuesta")
    public String getFechaEncuesta() {
        return fechaEncuesta;
    }

    @JsonProperty("fecha_encuesta")
    public void setFechaEncuesta(String fechaEncuesta) {
        this.fechaEncuesta = fechaEncuesta;
    }

    @JsonProperty("hora_inicio")
    public String getHoraInicio() {
        return horaInicio;
    }

    @JsonProperty("hora_inicio")
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    @JsonProperty("hora_fin")
    public String getHoraFin() {
        return horaFin;
    }

    @JsonProperty("hora_fin")
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    @JsonProperty("fecha_proxima")
    public String getFechaProxima() {
        return fechaProxima;
    }

    @JsonProperty("fecha_proxima")
    public void setFechaProxima(String fechaProxima) {
        this.fechaProxima = fechaProxima;
    }

    @JsonProperty("hora_proxima")
    public String getHoraProxima() {
        return horaProxima;
    }

    @JsonProperty("hora_proxima")
    public void setHoraProxima(String horaProxima) {
        this.horaProxima = horaProxima;
    }

    @JsonProperty("resultado_visita")
    public Integer getResultadoVisita() {
        return resultadoVisita;
    }

    @JsonProperty("resultado_visita")
    public void setResultadoVisita(Integer resultadoVisita) { this.resultadoVisita = resultadoVisita; }

    @JsonProperty("resultado_visita_otro")
    public String getResultadoVisitaOtro() {
        return resultadoVisitaOtro;
    }

    @JsonProperty("resultado_visita_otro")
    public void setResultadoVisitaOtro(String resultadoVisitaOtro) { this.resultadoVisitaOtro = resultadoVisitaOtro; }

    @JsonProperty("modifico")
    public Integer getModifico() { return modifico; }

    @JsonProperty("modifico")
    public void setModifico(Integer modifico) { this.modifico = modifico; }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
