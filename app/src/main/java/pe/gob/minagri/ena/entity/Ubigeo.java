package pe.gob.minagri.ena.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "Ubigeo")
public class Ubigeo {

    @Id(autoincrement = true)
    @Property(nameInDb = "_id")
    private Long id;

    private String cod_departamento;
    private String departamento;
    private String cod_provincia;
    private String provincia;
    private String cod_distrito;
    private String distrito;

    private String cod_geocodigo;
    private String cod_ubigeo;

    private String cod_region_natural;
    private String region_natural;
    private String cod_piso_ecologico;
    private String piso_ecologico;
    private String cod_subestrato;
    private String cod_tipo_grilla;

    private String cod_serpentin;
    private String cod_cc;
    private String cc;
    private String cod_cn;
    private String cn;

    private String cod_segmento_empresa;
    private String num_parcela_sm;
    private String num_total_parcelas_sm;
    private String cod_ccpp;
    private String ccpp;
    private String fec_encuesta;
    private String dni;

    @Generated(hash = 1920155935)
    public Ubigeo() {
    }

    @Generated(hash = 140925768)
    public Ubigeo(Long id, String cod_departamento, String departamento, String cod_provincia, String provincia, String cod_distrito, String distrito, String cod_geocodigo, String cod_ubigeo, String cod_region_natural, String region_natural,
            String cod_piso_ecologico, String piso_ecologico, String cod_subestrato, String cod_tipo_grilla, String cod_serpentin, String cod_cc, String cc, String cod_cn, String cn, String cod_segmento_empresa, String num_parcela_sm,
            String num_total_parcelas_sm, String cod_ccpp, String ccpp, String fec_encuesta, String dni) {
        this.id = id;
        this.cod_departamento = cod_departamento;
        this.departamento = departamento;
        this.cod_provincia = cod_provincia;
        this.provincia = provincia;
        this.cod_distrito = cod_distrito;
        this.distrito = distrito;
        this.cod_geocodigo = cod_geocodigo;
        this.cod_ubigeo = cod_ubigeo;
        this.cod_region_natural = cod_region_natural;
        this.region_natural = region_natural;
        this.cod_piso_ecologico = cod_piso_ecologico;
        this.piso_ecologico = piso_ecologico;
        this.cod_subestrato = cod_subestrato;
        this.cod_tipo_grilla = cod_tipo_grilla;
        this.cod_serpentin = cod_serpentin;
        this.cod_cc = cod_cc;
        this.cc = cc;
        this.cod_cn = cod_cn;
        this.cn = cn;
        this.cod_segmento_empresa = cod_segmento_empresa;
        this.num_parcela_sm = num_parcela_sm;
        this.num_total_parcelas_sm = num_total_parcelas_sm;
        this.cod_ccpp = cod_ccpp;
        this.ccpp = ccpp;
        this.fec_encuesta = fec_encuesta;
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod_departamento() {
        return cod_departamento;
    }

    public void setCod_departamento(String cod_departamento) {
        this.cod_departamento = cod_departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCod_provincia() {
        return cod_provincia;
    }

    public void setCod_provincia(String cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCod_distrito() {
        return cod_distrito;
    }

    public void setCod_distrito(String cod_distrito) {
        this.cod_distrito = cod_distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCod_geocodigo() {
        return cod_geocodigo;
    }

    public void setCod_geocodigo(String cod_geocodigo) {
        this.cod_geocodigo = cod_geocodigo;
    }

    public String getCod_ubigeo() {
        return cod_ubigeo;
    }

    public void setCod_ubigeo(String cod_ubigeo) {
        this.cod_ubigeo = cod_ubigeo;
    }

    public String getCod_region_natural() {
        return cod_region_natural;
    }

    public void setCod_region_natural(String cod_region_natural) {
        this.cod_region_natural = cod_region_natural;
    }

    public String getRegion_natural() {
        return region_natural;
    }

    public void setRegion_natural(String region_natural) {
        this.region_natural = region_natural;
    }

    public String getCod_piso_ecologico() {
        return cod_piso_ecologico;
    }

    public void setCod_piso_ecologico(String cod_piso_ecologico) {
        this.cod_piso_ecologico = cod_piso_ecologico;
    }

    public String getPiso_ecologico() {
        return piso_ecologico;
    }

    public void setPiso_ecologico(String piso_ecologico) {
        this.piso_ecologico = piso_ecologico;
    }

    public String getCod_subestrato() {
        return cod_subestrato;
    }

    public void setCod_subestrato(String cod_subestrato) {
        this.cod_subestrato = cod_subestrato;
    }

    public String getCod_tipo_grilla() {
        return cod_tipo_grilla;
    }

    public void setCod_tipo_grilla(String cod_tipo_grilla) {
        this.cod_tipo_grilla = cod_tipo_grilla;
    }

    public String getCod_serpentin() {
        return cod_serpentin;
    }

    public void setCod_serpentin(String cod_serpentin) {
        this.cod_serpentin = cod_serpentin;
    }

    public String getCod_cc() {
        return cod_cc;
    }

    public void setCod_cc(String cod_cc) {
        this.cod_cc = cod_cc;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCod_cn() {
        return cod_cn;
    }

    public void setCod_cn(String cod_cn) {
        this.cod_cn = cod_cn;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getCod_segmento_empresa() {
        return cod_segmento_empresa;
    }

    public void setCod_segmento_empresa(String cod_segmento_empresa) {
        this.cod_segmento_empresa = cod_segmento_empresa;
    }

    public String getNum_parcela_sm() {
        return num_parcela_sm;
    }

    public void setNum_parcela_sm(String num_parcela_sm) {
        this.num_parcela_sm = num_parcela_sm;
    }

    public String getNum_total_parcelas_sm() {
        return num_total_parcelas_sm;
    }

    public void setNum_total_parcelas_sm(String num_total_parcelas_sm) {
        this.num_total_parcelas_sm = num_total_parcelas_sm;
    }

    public String getCod_ccpp() {
        return cod_ccpp;
    }

    public void setCod_ccpp(String cod_ccpp) {
        this.cod_ccpp = cod_ccpp;
    }

    public String getCcpp() {
        return ccpp;
    }

    public void setCcpp(String ccpp) {
        this.ccpp = ccpp;
    }

    public String getFec_encuesta() {
        return fec_encuesta;
    }

    public void setFec_encuesta(String fec_encuesta) {
        this.fec_encuesta = fec_encuesta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
