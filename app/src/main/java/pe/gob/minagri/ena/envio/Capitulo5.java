
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

import pe.gob.minagri.ena.envio.capitulo5.P501;
import pe.gob.minagri.ena.envio.capitulo5.P502;
import pe.gob.minagri.ena.envio.capitulo5.P509;
import pe.gob.minagri.ena.envio.capitulo5.P516;
import pe.gob.minagri.ena.envio.capitulo5.P524;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
        "p501",
        "p502",
        "p509",
        "p516",
        "p523",
        "p524",
        "p530",
        "p530_otro",
        "p531",
        "p532",
        "p532_otro",
        "p533",
        "p533_otro",
        "p534a",
        "p534b_pollo",
        "p534b_pollo_otro",
        "p534b_pavo",
        "p534b_pavo_otro",
        "p534b_gallina",
        "p534b_gallina_otro",
        "p534b_vacuno",
        "p534b_vacuno_otro",
        "p534b_porcino",
        "p534b_porcino_otro",
        "p535",
        "p535a_vacuno",
        "p535a_ovino",
        "p535b_ave",
        "p535b_porcino",
        "p535b_vacuno",
        "p536",
        "p536a",
        "p536a_otro",
        "p537",
        "p538",
        "p539",
        "p540",
        "p541_bovino",
        "p541_bovino_otro",
        "p541_porcino",
        "p541_porcino_otro",
        "p541_ovino",
        "p541_ovino_otro",
        "p541_caprino",
        "p541_caprino_otro",
        "p541_alpaca",
        "p541_llama",
        "p541_cuyes",
        "p541_cuyes_otro",
        "p541_observacion"
})

public class Capitulo5 {

    @JsonProperty("p501")
    private List<P501> p501 = null;
    @JsonProperty("p502")
    private List<P502> p502 = null;
    @JsonProperty("p509")
    private List<P509> p509 = null;
    @JsonProperty("p516")
    private List<P516> p516 = null;
    @JsonProperty("p523")
    private Integer p523;
    @JsonProperty("p524")
    private List<P524> p524 = null;
    @JsonProperty("p530")
    private String p530;
    @JsonProperty("p530_otro")
    private String p530Otro;
    @JsonProperty("p531")
    private Integer p531;
    @JsonProperty("p532")
    private Integer p532;
    @JsonProperty("p532_otro")
    private String p532Otro;
    @JsonProperty("p533")
    private String p533;
    @JsonProperty("p533_otro")
    private String p533Otro;
    @JsonProperty("p534a")
    private Integer p534a;
    @JsonProperty("p534b_pollo")
    private String p534bPollo;
    @JsonProperty("p534b_pollo_otro")
    private String p534bPolloOtro;
    @JsonProperty("p534b_pavo")
    private String p534bPavo;
    @JsonProperty("p534b_pavo_otro")
    private String p534bPavoOtro;
    @JsonProperty("p534b_gallina")
    private String p534bGallina;
    @JsonProperty("p534b_gallina_otro")
    private String p534bGallinaOtro;
    @JsonProperty("p534b_vacuno")
    private String p534bVacuno;
    @JsonProperty("p534b_vacuno_otro")
    private String p534bVacunoOtro;
    @JsonProperty("p534b_porcino")
    private String p534bPorcino;
    @JsonProperty("p534b_porcino_otro")
    private String p534bPorcinoOtro;
    @JsonProperty("p535")
    private Integer p535;
    @JsonProperty("p535a_vacuno")
    private String p535aVacuno;
    @JsonProperty("p535a_ovino")
    private String p535aOvino;
    @JsonProperty("p535b_ave")
    private String p535bAve;
    @JsonProperty("p535b_porcino")
    private String p535bPorcino;
    @JsonProperty("p535b_vacuno")
    private String p535bVacuno;
    @JsonProperty("p536")
    private Integer p536;
    @JsonProperty("p536a")
    private String p536a;
    @JsonProperty("p536a_otro")
    private String p536aOtro;
    @JsonProperty("p537")
    private String p537;
    @JsonProperty("p538")
    private Integer p538;
    @JsonProperty("p539")
    private String p539;
    @JsonProperty("p540")
    private Integer p540;
    @JsonProperty("p541_bovino")
    private String p541Bovino;
    @JsonProperty("p541_bovino_otro")
    private String p541BovinoOtro;
    @JsonProperty("p541_porcino")
    private String p541Porcino;
    @JsonProperty("p541_porcino_otro")
    private String p541PorcinoOtro;
    @JsonProperty("p541_ovino")
    private String p541Ovino;
    @JsonProperty("p541_ovino_otro")
    private String p541OvinoOtro;
    @JsonProperty("p541_caprino")
    private String p541Caprino;
    @JsonProperty("p541_caprino_otro")
    private String p541CaprinoOtro;
    @JsonProperty("p541_alpaca")
    private String p541Alpaca;
    @JsonProperty("p541_llama")
    private String p541Llama;
    @JsonProperty("p541_cuyes")
    private String p541Cuyes;
    @JsonProperty("p541_cuyes_otro")
    private String p541CuyesOtro;
    @JsonProperty("p541_observacion")
    private String p541Observacion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("p501")
    public List<P501> getP501() {
        return p501;
    }

    @JsonProperty("p501")
    public void setP501(List<P501> p501) {
        this.p501 = p501;
    }

    @JsonProperty("p502")
    public List<P502> getP502() {
        return p502;
    }

    @JsonProperty("p502")
    public void setP502(List<P502> p502) {
        this.p502 = p502;
    }

    @JsonProperty("p509")
    public List<P509> getP509() {
        return p509;
    }

    @JsonProperty("p509")
    public void setP509(List<P509> p509) {
        this.p509 = p509;
    }

    @JsonProperty("p516")
    public List<P516> getP516() {
        return p516;
    }

    @JsonProperty("p516")
    public void setP516(List<P516> p516) {
        this.p516 = p516;
    }

    @JsonProperty("p523")
    public Integer getP523() {
        return p523;
    }

    @JsonProperty("p523")
    public void setP523(Integer p523) {
        this.p523 = p523;
    }

    @JsonProperty("p524")
    public List<P524> getP524() {
        return p524;
    }

    @JsonProperty("p524")
    public void setP524(List<P524> p524) {
        this.p524 = p524;
    }

    @JsonProperty("p530")
    public String getP530() {
        return p530;
    }

    @JsonProperty("p530")
    public void setP530(String p530) {
        this.p530 = p530;
    }

    @JsonProperty("p530_otro")
    public String getP530Otro() {
        return p530Otro;
    }

    @JsonProperty("p530_otro")
    public void setP530Otro(String p530Otro) {
        this.p530Otro = p530Otro;
    }

    @JsonProperty("p531")
    public Integer getP531() {
        return p531;
    }

    @JsonProperty("p531")
    public void setP531(Integer p531) {
        this.p531 = p531;
    }

    @JsonProperty("p532")
    public Integer getP532() {
        return p532;
    }

    @JsonProperty("p532")
    public void setP532(Integer p532) {
        this.p532 = p532;
    }

    @JsonProperty("p532_otro")
    public String getP532Otro() {
        return p532Otro;
    }

    @JsonProperty("p532_otro")
    public void setP532Otro(String p532Otro) {
        this.p532Otro = p532Otro;
    }

    @JsonProperty("p533")
    public String getP533() {
        return p533;
    }

    @JsonProperty("p533")
    public void setP533(String p533) {
        this.p533 = p533;
    }

    @JsonProperty("p533_otro")
    public String getP533Otro() {
        return p533Otro;
    }

    @JsonProperty("p533_otro")
    public void setP533Otro(String p533Otro) {
        this.p533Otro = p533Otro;
    }

    @JsonProperty("p534a")
    public Integer getP534a() {
        return p534a;
    }

    @JsonProperty("p534a")
    public void setP534a(Integer p534a) {
        this.p534a = p534a;
    }

    @JsonProperty("p534b_pollo")
    public String getP534bPollo() {
        return p534bPollo;
    }

    @JsonProperty("p534b_pollo")
    public void setP534bPollo(String p534bPollo) {
        this.p534bPollo = p534bPollo;
    }

    @JsonProperty("p534b_pollo_otro")
    public String getP534bPolloOtro() {
        return p534bPolloOtro;
    }

    @JsonProperty("p534b_pollo_otro")
    public void setP534bPolloOtro(String p534bPolloOtro) {
        this.p534bPolloOtro = p534bPolloOtro;
    }

    @JsonProperty("p534b_pavo")
    public String getP534bPavo() {
        return p534bPavo;
    }

    @JsonProperty("p534b_pavo")
    public void setP534bPavo(String p534bPavo) {
        this.p534bPavo = p534bPavo;
    }

    @JsonProperty("p534b_pavo_otro")
    public String getP534bPavoOtro() {
        return p534bPavoOtro;
    }

    @JsonProperty("p534b_pavo_otro")
    public void setP534bPavoOtro(String p534bPavoOtro) {
        this.p534bPavoOtro = p534bPavoOtro;
    }

    @JsonProperty("p534b_gallina")
    public String getP534bGallina() {
        return p534bGallina;
    }

    @JsonProperty("p534b_gallina")
    public void setP534bGallina(String p534bGallina) {
        this.p534bGallina = p534bGallina;
    }

    @JsonProperty("p534b_gallina_otro")
    public String getP534bGallinaOtro() {
        return p534bGallinaOtro;
    }

    @JsonProperty("p534b_gallina_otro")
    public void setP534bGallinaOtro(String p534bGallinaOtro) {
        this.p534bGallinaOtro = p534bGallinaOtro;
    }

    @JsonProperty("p534b_vacuno")
    public String getP534bVacuno() {
        return p534bVacuno;
    }

    @JsonProperty("p534b_vacuno")
    public void setP534bVacuno(String p534bVacuno) {
        this.p534bVacuno = p534bVacuno;
    }

    @JsonProperty("p534b_vacuno_otro")
    public String getP534bVacunoOtro() {
        return p534bVacunoOtro;
    }

    @JsonProperty("p534b_vacuno_otro")
    public void setP534bVacunoOtro(String p534bVacunoOtro) {
        this.p534bVacunoOtro = p534bVacunoOtro;
    }

    @JsonProperty("p534b_porcino")
    public String getP534bPorcino() {
        return p534bPorcino;
    }

    @JsonProperty("p534b_porcino")
    public void setP534bPorcino(String p534bPorcino) {
        this.p534bPorcino = p534bPorcino;
    }

    @JsonProperty("p534b_porcino_otro")
    public String getP534bPorcinoOtro() {
        return p534bPorcinoOtro;
    }

    @JsonProperty("p534b_porcino_otro")
    public void setP534bPorcinoOtro(String p534bPorcinoOtro) {
        this.p534bPorcinoOtro = p534bPorcinoOtro;
    }

    @JsonProperty("p535")
    public Integer getP535() {
        return p535;
    }

    @JsonProperty("p535")
    public void setP535(Integer p535) {
        this.p535 = p535;
    }

    @JsonProperty("p535a_vacuno")
    public String getP535aVacuno() {
        return p535aVacuno;
    }

    @JsonProperty("p535a_vacuno")
    public void setP535aVacuno(String p535aVacuno) {
        this.p535aVacuno = p535aVacuno;
    }

    @JsonProperty("p535a_ovino")
    public String getP535aOvino() {
        return p535aOvino;
    }

    @JsonProperty("p535a_ovino")
    public void setP535aOvino(String p535aOvino) {
        this.p535aOvino = p535aOvino;
    }

    @JsonProperty("p535b_ave")
    public String getP535bAve() {
        return p535bAve;
    }

    @JsonProperty("p535b_ave")
    public void setP535bAve(String p535bAve) {
        this.p535bAve = p535bAve;
    }

    @JsonProperty("p535b_porcino")
    public String getP535bPorcino() {
        return p535bPorcino;
    }

    @JsonProperty("p535b_porcino")
    public void setP535bPorcino(String p535bPorcino) {
        this.p535bPorcino = p535bPorcino;
    }

    @JsonProperty("p535b_vacuno")
    public String getP535bVacuno() {
        return p535bVacuno;
    }

    @JsonProperty("p535b_vacuno")
    public void setP535bVacuno(String p535bVacuno) {
        this.p535bVacuno = p535bVacuno;
    }

    @JsonProperty("p536")
    public Integer getP536() {
        return p536;
    }

    @JsonProperty("p536")
    public void setP536(Integer p536) {
        this.p536 = p536;
    }

    @JsonProperty("p536a")
    public String getP536a() {
        return p536a;
    }

    @JsonProperty("p536a")
    public void setP536a(String p536a) {
        this.p536a = p536a;
    }

    @JsonProperty("p536a_otro")
    public String getP536aOtro() {
        return p536aOtro;
    }

    @JsonProperty("p536a_otro")
    public void setP536aOtro(String p536aOtro) {
        this.p536aOtro = p536aOtro;
    }

    @JsonProperty("p537")
    public String getP537() {
        return p537;
    }

    @JsonProperty("p537")
    public void setP537(String p537) {
        this.p537 = p537;
    }

    @JsonProperty("p538")
    public Integer getP538() {
        return p538;
    }

    @JsonProperty("p538")
    public void setP538(Integer p538) {
        this.p538 = p538;
    }

    @JsonProperty("p539")
    public String getP539() {
        return p539;
    }

    @JsonProperty("p539")
    public void setP539(String p539) {
        this.p539 = p539;
    }

    @JsonProperty("p540")
    public Integer getP540() {
        return p540;
    }

    @JsonProperty("p540")
    public void setP540(Integer p540) {
        this.p540 = p540;
    }

    @JsonProperty("p541_bovino")
    public String getP541Bovino() {
        return p541Bovino;
    }

    @JsonProperty("p541_bovino")
    public void setP541Bovino(String p541Bovino) {
        this.p541Bovino = p541Bovino;
    }

    @JsonProperty("p541_bovino_otro")
    public String getP541BovinoOtro() {
        return p541BovinoOtro;
    }

    @JsonProperty("p541_bovino_otro")
    public void setP541BovinoOtro(String p541BovinoOtro) {
        this.p541BovinoOtro = p541BovinoOtro;
    }

    @JsonProperty("p541_porcino")
    public String getP541Porcino() {
        return p541Porcino;
    }

    @JsonProperty("p541_porcino")
    public void setP541Porcino(String p541Porcino) {
        this.p541Porcino = p541Porcino;
    }

    @JsonProperty("p541_porcino_otro")
    public String getP541PorcinoOtro() {
        return p541PorcinoOtro;
    }

    @JsonProperty("p541_porcino_otro")
    public void setP541PorcinoOtro(String p541PorcinoOtro) {
        this.p541PorcinoOtro = p541PorcinoOtro;
    }

    @JsonProperty("p541_ovino")
    public String getP541Ovino() {
        return p541Ovino;
    }

    @JsonProperty("p541_ovino")
    public void setP541Ovino(String p541Ovino) {
        this.p541Ovino = p541Ovino;
    }

    @JsonProperty("p541_ovino_otro")
    public String getP541OvinoOtro() {
        return p541OvinoOtro;
    }

    @JsonProperty("p541_ovino_otro")
    public void setP541OvinoOtro(String p541OvinoOtro) {
        this.p541OvinoOtro = p541OvinoOtro;
    }

    @JsonProperty("p541_caprino")
    public String getP541Caprino() {
        return p541Caprino;
    }

    @JsonProperty("p541_caprino")
    public void setP541Caprino(String p541Caprino) {
        this.p541Caprino = p541Caprino;
    }

    @JsonProperty("p541_caprino_otro")
    public String getP541CaprinoOtro() {
        return p541CaprinoOtro;
    }

    @JsonProperty("p541_caprino_otro")
    public void setP541CaprinoOtro(String p541CaprinoOtro) {
        this.p541CaprinoOtro = p541CaprinoOtro;
    }

    @JsonProperty("p541_alpaca")
    public String getP541Alpaca() {
        return p541Alpaca;
    }

    @JsonProperty("p541_alpaca")
    public void setP541Alpaca(String p541Alpaca) {
        this.p541Alpaca = p541Alpaca;
    }

    @JsonProperty("p541_llama")
    public String getP541Llama() {
        return p541Llama;
    }

    @JsonProperty("p541_llama")
    public void setP541Llama(String p541Llama) {
        this.p541Llama = p541Llama;
    }

    @JsonProperty("p541_cuyes")
    public String getP541Cuyes() {
        return p541Cuyes;
    }

    @JsonProperty("p541_cuyes")
    public void setP541Cuyes(String p541Cuyes) {
        this.p541Cuyes = p541Cuyes;
    }

    @JsonProperty("p541_cuyes_otro")
    public String getP541CuyesOtro() {
        return p541CuyesOtro;
    }

    @JsonProperty("p541_cuyes_otro")
    public void setP541CuyesOtro(String p541CuyesOtro) {
        this.p541CuyesOtro = p541CuyesOtro;
    }

    @JsonProperty("p541_observacion")
    public String getP541Observacion() {
        return p541Observacion;
    }

    @JsonProperty("p541_observacion")
    public void setP541Observacion(String p541Observacion) {
        this.p541Observacion = p541Observacion;
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
