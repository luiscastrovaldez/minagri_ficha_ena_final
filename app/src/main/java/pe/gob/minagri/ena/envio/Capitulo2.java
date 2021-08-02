
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
        "p201_tipo_productor",
        "p201_otro",
        "p202",
        "p203_nombres",
        "p203_apellidos",
        "p204",
        "p205_fijo",
        "p205_celular",
        "p206",
        "p207_cargo",
        "p207_otro",
        "p208_nombres",
        "p208_apellidos",
        "p209_fijo",
        "p209_celular",
        "p210",
        "p210_cod_ccpp",
        "p211",
        "p211_observacion",
        "p212",
        "p213",
        "p214_nombres",
        "p214_apellidos",
        "p215_cod_ccpp",
        "p216_tipo_via",
        "p216_otra_via",
        "p216_nombre_avenida",
        "p216_puerta",
        "p216_block",
        "p216_interior",
        "p216_piso",
        "p216_manzana",
        "p216_lote",
        "p217_nombres",
        "p217_apellidos",
        "p218_cargo",
        "p218_otro_cargo",
        "p219_fijo",
        "p219_celular",
        "p220",
        "p221",
        "p221_observaciones"
})

public class Capitulo2 {

    @JsonProperty("p201_tipo_productor")
    private Integer p201TipoProductor;
    @JsonProperty("p201_otro")
    private String p201Otro;
    @JsonProperty("p202")
    private Integer p202;
    @JsonProperty("p203_nombres")
    private String p203Nombres;
    @JsonProperty("p203_apellidos")
    private String p203Apellidos;
    @JsonProperty("p204")
    private String p204;
    @JsonProperty("p205_fijo")
    private String p205Fijo;
    @JsonProperty("p205_celular")
    private String p205Celular;
    @JsonProperty("p206")
    private String p206;
    @JsonProperty("p207_cargo")
    private Integer p207Cargo;
    @JsonProperty("p207_otro")
    private String p207Otro;
    @JsonProperty("p208_nombres")
    private String p208Nombres;
    @JsonProperty("p208_apellidos")
    private String p208Apellidos;
    @JsonProperty("p209_fijo")
    private String p209Fijo;
    @JsonProperty("p209_celular")
    private String p209Celular;
    @JsonProperty("p210")
    private Integer p210;
    @JsonProperty("p210_cod_ccpp")
    private Object p210CodCcpp;
    @JsonProperty("p211")
    private Integer p211;
    @JsonProperty("p211_observacion")
    private String p211Observacion;
    @JsonProperty("p212")
    private String p212;
    @JsonProperty("p213")
    private String p213;
    @JsonProperty("p214_nombres")
    private String p214Nombres;
    @JsonProperty("p214_apellidos")
    private String p214Apellidos;
    @JsonProperty("p215_cod_ccpp")
    private String p215CodCcpp;
    @JsonProperty("p216_tipo_via")
    private Integer p216TipoVia;
    @JsonProperty("p216_otra_via")
    private String p216OtraVia;
    @JsonProperty("p216_nombre_avenida")
    private String p216NombreAvenida;
    @JsonProperty("p216_puerta")
    private String p216Puerta;
    @JsonProperty("p216_block")
    private String p216Block;
    @JsonProperty("p216_interior")
    private String p216Interior;
    @JsonProperty("p216_piso")
    private String p216Piso;
    @JsonProperty("p216_manzana")
    private String p216Manzana;
    @JsonProperty("p216_lote")
    private String p216Lote;
    @JsonProperty("p217_nombres")
    private String p217Nombres;
    @JsonProperty("p217_apellidos")
    private String p217Apellidos;
    @JsonProperty("p218_cargo")
    private Integer p218Cargo;
    @JsonProperty("p218_otro_cargo")
    private String p218OtroCargo;
    @JsonProperty("p219_fijo")
    private String p219Fijo;
    @JsonProperty("p219_celular")
    private String p219Celular;
    @JsonProperty("p220")
    private String p220;
    @JsonProperty("p221")
    private String p221;
    @JsonProperty("p221_observaciones")
    private String p221Observaciones;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p201_tipo_productor")
    public Integer getP201TipoProductor() {
        return p201TipoProductor;
    }

    @JsonProperty("p201_tipo_productor")
    public void setP201TipoProductor(Integer p201TipoProductor) {
        this.p201TipoProductor = p201TipoProductor;
    }

    @JsonProperty("p201_otro")
    public String getP201Otro() {
        return p201Otro;
    }

    @JsonProperty("p201_otro")
    public void setP201Otro(String p201Otro) {
        this.p201Otro = p201Otro;
    }

    @JsonProperty("p202")
    public Integer getP202() {
        return p202;
    }

    @JsonProperty("p202")
    public void setP202(Integer p202) {
        this.p202 = p202;
    }

    @JsonProperty("p203_nombres")
    public String getP203Nombres() {
        return p203Nombres;
    }

    @JsonProperty("p203_nombres")
    public void setP203Nombres(String p203Nombres) {
        this.p203Nombres = p203Nombres;
    }

    @JsonProperty("p203_apellidos")
    public String getP203Apellidos() {
        return p203Apellidos;
    }

    @JsonProperty("p203_apellidos")
    public void setP203Apellidos(String p203Apellidos) {
        this.p203Apellidos = p203Apellidos;
    }

    @JsonProperty("p204")
    public String getP204() {
        return p204;
    }

    @JsonProperty("p204")
    public void setP204(String p204) {
        this.p204 = p204;
    }

    @JsonProperty("p205_fijo")
    public String getP205Fijo() {
        return p205Fijo;
    }

    @JsonProperty("p205_fijo")
    public void setP205Fijo(String p205Fijo) {
        this.p205Fijo = p205Fijo;
    }

    @JsonProperty("p205_celular")
    public String getP205Celular() {
        return p205Celular;
    }

    @JsonProperty("p205_celular")
    public void setP205Celular(String p205Celular) {
        this.p205Celular = p205Celular;
    }

    @JsonProperty("p206")
    public String getP206() {
        return p206;
    }

    @JsonProperty("p206")
    public void setP206(String p206) {
        this.p206 = p206;
    }

    @JsonProperty("p207_cargo")
    public Integer getP207Cargo() {
        return p207Cargo;
    }

    @JsonProperty("p207_cargo")
    public void setP207Cargo(Integer p207Cargo) {
        this.p207Cargo = p207Cargo;
    }

    @JsonProperty("p207_otro")
    public String getP207Otro() {
        return p207Otro;
    }

    @JsonProperty("p207_otro")
    public void setP207Otro(String p207Otro) {
        this.p207Otro = p207Otro;
    }

    @JsonProperty("p208_nombres")
    public String getP208Nombres() {
        return p208Nombres;
    }

    @JsonProperty("p208_nombres")
    public void setP208Nombres(String p208Nombres) {
        this.p208Nombres = p208Nombres;
    }

    @JsonProperty("p208_apellidos")
    public String getP208Apellidos() {
        return p208Apellidos;
    }

    @JsonProperty("p208_apellidos")
    public void setP208Apellidos(String p208Apellidos) {
        this.p208Apellidos = p208Apellidos;
    }

    @JsonProperty("p209_fijo")
    public String getP209Fijo() {
        return p209Fijo;
    }

    @JsonProperty("p209_fijo")
    public void setP209Fijo(String p209Fijo) {
        this.p209Fijo = p209Fijo;
    }

    @JsonProperty("p209_celular")
    public String getP209Celular() {
        return p209Celular;
    }

    @JsonProperty("p209_celular")
    public void setP209Celular(String p209Celular) {
        this.p209Celular = p209Celular;
    }

    @JsonProperty("p210")
    public Integer getP210() {
        return p210;
    }

    @JsonProperty("p210")
    public void setP210(Integer p210) {
        this.p210 = p210;
    }

    @JsonProperty("p210_cod_ccpp")
    public Object getP210CodCcpp() {
        return p210CodCcpp;
    }

    @JsonProperty("p210_cod_ccpp")
    public void setP210CodCcpp(Object p210CodCcpp) {
        this.p210CodCcpp = p210CodCcpp;
    }

    @JsonProperty("p211")
    public Integer getP211() {
        return p211;
    }

    @JsonProperty("p211")
    public void setP211(Integer p211) {
        this.p211 = p211;
    }

    @JsonProperty("p211_observacion")
    public String getP211Observacion() {
        return p211Observacion;
    }

    @JsonProperty("p211_observacion")
    public void setP211Observacion(String p211Observacion) {
        this.p211Observacion = p211Observacion;
    }

    @JsonProperty("p212")
    public String getP212() {
        return p212;
    }

    @JsonProperty("p212")
    public void setP212(String p212) {
        this.p212 = p212;
    }

    @JsonProperty("p213")
    public String getP213() {
        return p213;
    }

    @JsonProperty("p213")
    public void setP213(String p213) {
        this.p213 = p213;
    }

    @JsonProperty("p214_nombres")
    public String getP214Nombres() {
        return p214Nombres;
    }

    @JsonProperty("p214_nombres")
    public void setP214Nombres(String p214Nombres) {
        this.p214Nombres = p214Nombres;
    }

    @JsonProperty("p214_apellidos")
    public String getP214Apellidos() {
        return p214Apellidos;
    }

    @JsonProperty("p214_apellidos")
    public void setP214Apellidos(String p214Apellidos) {
        this.p214Apellidos = p214Apellidos;
    }

    @JsonProperty("p215_cod_ccpp")
    public String getP215CodCcpp() {
        return p215CodCcpp;
    }

    @JsonProperty("p215_cod_ccpp")
    public void setP215CodCcpp(String p215CodCcpp) {
        this.p215CodCcpp = p215CodCcpp;
    }

    @JsonProperty("p216_tipo_via")
    public Integer getP216TipoVia() {
        return p216TipoVia;
    }

    @JsonProperty("p216_tipo_via")
    public void setP216TipoVia(Integer p216TipoVia) {
        this.p216TipoVia = p216TipoVia;
    }

    @JsonProperty("p216_otra_via")
    public String getP216OtraVia() {
        return p216OtraVia;
    }

    @JsonProperty("p216_otra_via")
    public void setP216OtraVia(String p216OtraVia) {
        this.p216OtraVia = p216OtraVia;
    }

    @JsonProperty("p216_nombre_avenida")
    public String getP216NombreAvenida() {
        return p216NombreAvenida;
    }

    @JsonProperty("p216_nombre_avenida")
    public void setP216NombreAvenida(String p216NombreAvenida) {
        this.p216NombreAvenida = p216NombreAvenida;
    }

    @JsonProperty("p216_puerta")
    public String getP216Puerta() {
        return p216Puerta;
    }

    @JsonProperty("p216_puerta")
    public void setP216Puerta(String p216Puerta) {
        this.p216Puerta = p216Puerta;
    }

    @JsonProperty("p216_block")
    public String getP216Block() {
        return p216Block;
    }

    @JsonProperty("p216_block")
    public void setP216Block(String p216Block) {
        this.p216Block = p216Block;
    }

    @JsonProperty("p216_interior")
    public String getP216Interior() {
        return p216Interior;
    }

    @JsonProperty("p216_interior")
    public void setP216Interior(String p216Interior) {
        this.p216Interior = p216Interior;
    }

    @JsonProperty("p216_piso")
    public String getP216Piso() {
        return p216Piso;
    }

    @JsonProperty("p216_piso")
    public void setP216Piso(String p216Piso) {
        this.p216Piso = p216Piso;
    }

    @JsonProperty("p216_manzana")
    public String getP216Manzana() {
        return p216Manzana;
    }

    @JsonProperty("p216_manzana")
    public void setP216Manzana(String p216Manzana) {
        this.p216Manzana = p216Manzana;
    }

    @JsonProperty("p216_lote")
    public String getP216Lote() {
        return p216Lote;
    }

    @JsonProperty("p216_lote")
    public void setP216Lote(String p216Lote) {
        this.p216Lote = p216Lote;
    }

    @JsonProperty("p217_nombres")
    public String getP217Nombres() {
        return p217Nombres;
    }

    @JsonProperty("p217_nombres")
    public void setP217Nombres(String p217Nombres) {
        this.p217Nombres = p217Nombres;
    }

    @JsonProperty("p217_apellidos")
    public String getP217Apellidos() {
        return p217Apellidos;
    }

    @JsonProperty("p217_apellidos")
    public void setP217Apellidos(String p217Apellidos) {
        this.p217Apellidos = p217Apellidos;
    }

    @JsonProperty("p218_cargo")
    public Integer getP218Cargo() {
        return p218Cargo;
    }

    @JsonProperty("p218_cargo")
    public void setP218Cargo(Integer p218Cargo) {
        this.p218Cargo = p218Cargo;
    }

    @JsonProperty("p218_otro_cargo")
    public String getP218OtroCargo() {
        return p218OtroCargo;
    }

    @JsonProperty("p218_otro_cargo")
    public void setP218OtroCargo(String p218OtroCargo) {
        this.p218OtroCargo = p218OtroCargo;
    }

    @JsonProperty("p219_fijo")
    public String getP219Fijo() {
        return p219Fijo;
    }

    @JsonProperty("p219_fijo")
    public void setP219Fijo(String p219Fijo) {
        this.p219Fijo = p219Fijo;
    }

    @JsonProperty("p219_celular")
    public String getP219Celular() {
        return p219Celular;
    }

    @JsonProperty("p219_celular")
    public void setP219Celular(String p219Celular) {
        this.p219Celular = p219Celular;
    }

    @JsonProperty("p220")
    public String getP220() {
        return p220;
    }

    @JsonProperty("p220")
    public void setP220(String p220) {
        this.p220 = p220;
    }

    @JsonProperty("p221")
    public String getP221() {
        return p221;
    }

    @JsonProperty("p221")
    public void setP221(String p221) {
        this.p221 = p221;
    }

    @JsonProperty("p221_observaciones")
    public String getP221Observaciones() {
        return p221Observaciones;
    }

    @JsonProperty("p221_observaciones")
    public void setP221Observaciones(String p221Observaciones) {
        this.p221Observaciones = p221Observaciones;
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
