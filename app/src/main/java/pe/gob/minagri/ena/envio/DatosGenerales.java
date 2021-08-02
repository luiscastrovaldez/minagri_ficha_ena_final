
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
        "cod_geocodigo",
        "cod_ubigeo",
        "cod_region_natural",
        "cod_piso_ecologico",
        "cod_subestrato",
        "cod_tipo_grilla",
        "cod_serpentin",
        "cod_cc_cn",
        "cod_segmento_empresa",
        "num_parcela_sm",
        "num_total_parcelas_sm",
        "cod_ccpp",
        "fec_encuesta"
})

public class DatosGenerales {

    @JsonProperty("cod_geocodigo")
    private String codGeocodigo;
    @JsonProperty("cod_ubigeo")
    private String codUbigeo;
    @JsonProperty("cod_region_natural")
    private Integer codRegionNatural;
    @JsonProperty("cod_piso_ecologico")
    private Integer codPisoEcologico;
    @JsonProperty("cod_subestrato")
    private String codSubestrato;
    @JsonProperty("cod_tipo_grilla")
    private Integer codTipoGrilla;
    @JsonProperty("cod_serpentin")
    private String codSerpentin;
    @JsonProperty("cod_cc_cn")
    private String codCcCn;
    @JsonProperty("cod_segmento_empresa")
    private String codSegmentoEmpresa;
    @JsonProperty("num_parcela_sm")
    private Integer numParcelaSm;
    @JsonProperty("num_total_parcelas_sm")
    private Integer numTotalParcelasSm;
    @JsonProperty("cod_ccpp")
    private String codCcpp;
    @JsonProperty("fec_encuesta")
    private String fecEncuesta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cod_geocodigo")
    public String getCodGeocodigo() {
        return codGeocodigo;
    }

    @JsonProperty("cod_geocodigo")
    public void setCodGeocodigo(String codGeocodigo) {
        this.codGeocodigo = codGeocodigo;
    }

    @JsonProperty("cod_ubigeo")
    public String getCodUbigeo() {
        return codUbigeo;
    }

    @JsonProperty("cod_ubigeo")
    public void setCodUbigeo(String codUbigeo) {
        this.codUbigeo = codUbigeo;
    }

    @JsonProperty("cod_region_natural")
    public Integer getCodRegionNatural() {
        return codRegionNatural;
    }

    @JsonProperty("cod_region_natural")
    public void setCodRegionNatural(Integer codRegionNatural) {
        this.codRegionNatural = codRegionNatural;
    }

    @JsonProperty("cod_piso_ecologico")
    public Integer getCodPisoEcologico() {
        return codPisoEcologico;
    }

    @JsonProperty("cod_piso_ecologico")
    public void setCodPisoEcologico(Integer codPisoEcologico) {
        this.codPisoEcologico = codPisoEcologico;
    }

    @JsonProperty("cod_subestrato")
    public String getCodSubestrato() {
        return codSubestrato;
    }

    @JsonProperty("cod_subestrato")
    public void setCodSubestrato(String codSubestrato) {
        this.codSubestrato = codSubestrato;
    }

    @JsonProperty("cod_tipo_grilla")
    public Integer getCodTipoGrilla() {
        return codTipoGrilla;
    }

    @JsonProperty("cod_tipo_grilla")
    public void setCodTipoGrilla(Integer codTipoGrilla) {
        this.codTipoGrilla = codTipoGrilla;
    }

    @JsonProperty("cod_serpentin")
    public String getCodSerpentin() {
        return codSerpentin;
    }

    @JsonProperty("cod_serpentin")
    public void setCodSerpentin(String codSerpentin) {
        this.codSerpentin = codSerpentin;
    }

    @JsonProperty("cod_cc_cn")
    public String getCodCcCn() {
        return codCcCn;
    }

    @JsonProperty("cod_cc_cn")
    public void setCodCcCn(String codCcCn) {
        this.codCcCn = codCcCn;
    }

    @JsonProperty("cod_segmento_empresa")
    public String getCodSegmentoEmpresa() {
        return codSegmentoEmpresa;
    }

    @JsonProperty("cod_segmento_empresa")
    public void setCodSegmentoEmpresa(String codSegmentoEmpresa) {
        this.codSegmentoEmpresa = codSegmentoEmpresa;
    }

    @JsonProperty("num_parcela_sm")
    public Integer getNumParcelaSm() {
        return numParcelaSm;
    }

    @JsonProperty("num_parcela_sm")
    public void setNumParcelaSm(Integer numParcelaSm) {
        this.numParcelaSm = numParcelaSm;
    }

    @JsonProperty("num_total_parcelas_sm")
    public Integer getNumTotalParcelasSm() {
        return numTotalParcelasSm;
    }

    @JsonProperty("num_total_parcelas_sm")
    public void setNumTotalParcelasSm(Integer numTotalParcelasSm) {
        this.numTotalParcelasSm = numTotalParcelasSm;
    }

    @JsonProperty("cod_ccpp")
    public String getCodCcpp() {
        return codCcpp;
    }

    @JsonProperty("cod_ccpp")
    public void setCodCcpp(String codCcpp) {
        this.codCcpp = codCcpp;
    }

    @JsonProperty("fec_encuesta")
    public String getFecEncuesta() {
        return fecEncuesta;
    }

    @JsonProperty("fec_encuesta")
    public void setFecEncuesta(String fecEncuesta) {
        this.fecEncuesta = fecEncuesta;
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
