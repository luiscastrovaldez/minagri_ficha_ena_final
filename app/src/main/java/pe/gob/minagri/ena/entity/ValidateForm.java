package pe.gob.minagri.ena.entity;

import org.greenrobot.greendao.annotation.Convert;

import java.util.List;

import pe.gob.minagri.ena.util.StringArrayConverter;

public class ValidateForm {

    public ValidateForm() {

    }
    private String dni;
    private String idParcela;
    private String id;

    private String cod_departamento;
    private String departamento;
    private String cod_provincia;
    private String provincia;
    private String cod_distrito;
    private String distrito;

    private String cod_geocodigo;
    private String cod_ubigeo;

    private int cod_region_natural;
    private String region_natural;
    private int cod_piso_ecologico;
    private String piso_ecologico;
    private String cod_subestrato;
    private int cod_tipo_grilla;

    private String cod_serpentin;
    private String cod_cc;
    private String cc;
    private String cod_cn;
    private String cn;

    private String cod_segmento_empresa;
    private int num_parcela_sm;
    private int num_total_parcelas_sm;
    private String cod_ccpp;
    private String ccpp;
    private String fec_encuesta;


    @Convert(converter = StringArrayConverter.class, columnType = String.class)
    public List<String> p101;
    private String p101_observaciones;

    private int p201_tipo_productor;
    private String p201_otro;
    private int p202;
    private String p203_nombres;
    private String p203_apellidos;

    private String p204;
    private String p205_fijo;
    private String p205_celular;

    private String p206;
    private int p207_cargo;
    private String p207_otro;
    private String p208_nombres;
    private String p208_apellidos;
    private String p209_fijo;
    private String p209_celular;
    private int p210;
    private String p210_cod_ccpp;
    private int p211;
    private String p211_observacion;
    private String p212;
    private String p213;
    private String p214_nombres;
    private String p214_apellidos;
    private String p215_cod_ccpp;
    private int p216_tipo_via;
    private String p216_otra_via;
    private String p216_nombre_avenida;
    private int p216_puerta;
    private int p216_block;
    private int p216_interior;
    private int p216_piso;
    private int p216_manzana;
    private int p216_lote;
    private String p217_nombres;
    private String p217_apellidos;
    private int p218_cargo;
    private String p218_otro_cargo;
    private String p219_fijo;
    private String p219_celular;
    private String p220;
    private String p221;
    private String p221_observaciones;

    public ValidateForm(String dni, String idParcela, String id, String cod_departamento, String departamento, String cod_provincia, String provincia, String cod_distrito, String distrito, String cod_geocodigo, String cod_ubigeo, int cod_region_natural, String region_natural, int cod_piso_ecologico, String piso_ecologico, String cod_subestrato, int cod_tipo_grilla, String cod_serpentin, String cod_cc, String cc, String cod_cn, String cn, String cod_segmento_empresa, int num_parcela_sm, int num_total_parcelas_sm, String cod_ccpp, String ccpp, String fec_encuesta, List<String> p101, String p101_observaciones, int p201_tipo_productor, String p201_otro, int p202, String p203_nombres, String p203_apellidos, String p204, String p205_fijo, String p205_celular, String p206, int p207_cargo, String p207_otro, String p208_nombres, String p208_apellidos, String p209_fijo, String p209_celular, int p210, String p210_cod_ccpp, int p211, String p211_observacion, String p212, String p213, String p214_nombres, String p214_apellidos, String p215_cod_ccpp, int p216_tipo_via, String p216_otra_via, String p216_nombre_avenida, int p216_puerta, int p216_block, int p216_interior, int p216_piso, int p216_manzana, int p216_lote, String p217_nombres, String p217_apellidos, int p218_cargo, String p218_otro_cargo, String p219_fijo, String p219_celular, String p220, String p221, String p221_observaciones) {
        this.dni = dni;
        this.idParcela = idParcela;
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
        this.p101 = p101;
        this.p101_observaciones = p101_observaciones;
        this.p201_tipo_productor = p201_tipo_productor;
        this.p201_otro = p201_otro;
        this.p202 = p202;
        this.p203_nombres = p203_nombres;
        this.p203_apellidos = p203_apellidos;
        this.p204 = p204;
        this.p205_fijo = p205_fijo;
        this.p205_celular = p205_celular;
        this.p206 = p206;
        this.p207_cargo = p207_cargo;
        this.p207_otro = p207_otro;
        this.p208_nombres = p208_nombres;
        this.p208_apellidos = p208_apellidos;
        this.p209_fijo = p209_fijo;
        this.p209_celular = p209_celular;
        this.p210 = p210;
        this.p210_cod_ccpp = p210_cod_ccpp;
        this.p211 = p211;
        this.p211_observacion = p211_observacion;
        this.p212 = p212;
        this.p213 = p213;
        this.p214_nombres = p214_nombres;
        this.p214_apellidos = p214_apellidos;
        this.p215_cod_ccpp = p215_cod_ccpp;
        this.p216_tipo_via = p216_tipo_via;
        this.p216_otra_via = p216_otra_via;
        this.p216_nombre_avenida = p216_nombre_avenida;
        this.p216_puerta = p216_puerta;
        this.p216_block = p216_block;
        this.p216_interior = p216_interior;
        this.p216_piso = p216_piso;
        this.p216_manzana = p216_manzana;
        this.p216_lote = p216_lote;
        this.p217_nombres = p217_nombres;
        this.p217_apellidos = p217_apellidos;
        this.p218_cargo = p218_cargo;
        this.p218_otro_cargo = p218_otro_cargo;
        this.p219_fijo = p219_fijo;
        this.p219_celular = p219_celular;
        this.p220 = p220;
        this.p221 = p221;
        this.p221_observaciones = p221_observaciones;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(String idParcela) {
        this.idParcela = idParcela;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getCod_region_natural() {
        return cod_region_natural;
    }

    public void setCod_region_natural(int cod_region_natural) {
        this.cod_region_natural = cod_region_natural;
    }

    public String getRegion_natural() {
        return region_natural;
    }

    public void setRegion_natural(String region_natural) {
        this.region_natural = region_natural;
    }

    public int getCod_piso_ecologico() {
        return cod_piso_ecologico;
    }

    public void setCod_piso_ecologico(int cod_piso_ecologico) {
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

    public int getCod_tipo_grilla() {
        return cod_tipo_grilla;
    }

    public void setCod_tipo_grilla(int cod_tipo_grilla) {
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

    public int getNum_parcela_sm() {
        return num_parcela_sm;
    }

    public void setNum_parcela_sm(int num_parcela_sm) {
        this.num_parcela_sm = num_parcela_sm;
    }

    public int getNum_total_parcelas_sm() {
        return num_total_parcelas_sm;
    }

    public void setNum_total_parcelas_sm(int num_total_parcelas_sm) {
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

    public List<String> getP101() {
        return p101;
    }

    public void setP101(List<String> p101) {
        this.p101 = p101;
    }

    public String getP101_observaciones() {
        return p101_observaciones;
    }

    public void setP101_observaciones(String p101_observaciones) {
        this.p101_observaciones = p101_observaciones;
    }

    public int getP201_tipo_productor() {
        return p201_tipo_productor;
    }

    public void setP201_tipo_productor(int p201_tipo_productor) {
        this.p201_tipo_productor = p201_tipo_productor;
    }

    public String getP201_otro() {
        return p201_otro;
    }

    public void setP201_otro(String p201_otro) {
        this.p201_otro = p201_otro;
    }

    public int getP202() {
        return p202;
    }

    public void setP202(int p202) {
        this.p202 = p202;
    }

    public String getP203_nombres() {
        return p203_nombres;
    }

    public void setP203_nombres(String p203_nombres) {
        this.p203_nombres = p203_nombres;
    }

    public String getP203_apellidos() {
        return p203_apellidos;
    }

    public void setP203_apellidos(String p203_apellidos) {
        this.p203_apellidos = p203_apellidos;
    }

    public String getP204() {
        return p204;
    }

    public void setP204(String p204) {
        this.p204 = p204;
    }

    public String getP205_fijo() {
        return p205_fijo;
    }

    public void setP205_fijo(String p205_fijo) {
        this.p205_fijo = p205_fijo;
    }

    public String getP205_celular() {
        return p205_celular;
    }

    public void setP205_celular(String p205_celular) {
        this.p205_celular = p205_celular;
    }

    public String getP206() {
        return p206;
    }

    public void setP206(String p206) {
        this.p206 = p206;
    }

    public int getP207_cargo() {
        return p207_cargo;
    }

    public void setP207_cargo(int p207_cargo) {
        this.p207_cargo = p207_cargo;
    }

    public String getP207_otro() {
        return p207_otro;
    }

    public void setP207_otro(String p207_otro) {
        this.p207_otro = p207_otro;
    }

    public String getP208_nombres() {
        return p208_nombres;
    }

    public void setP208_nombres(String p208_nombres) {
        this.p208_nombres = p208_nombres;
    }

    public String getP208_apellidos() {
        return p208_apellidos;
    }

    public void setP208_apellidos(String p208_apellidos) {
        this.p208_apellidos = p208_apellidos;
    }

    public String getP209_fijo() {
        return p209_fijo;
    }

    public void setP209_fijo(String p209_fijo) {
        this.p209_fijo = p209_fijo;
    }

    public String getP209_celular() {
        return p209_celular;
    }

    public void setP209_celular(String p209_celular) {
        this.p209_celular = p209_celular;
    }

    public int getP210() {
        return p210;
    }

    public void setP210(int p210) {
        this.p210 = p210;
    }

    public String getP210_cod_ccpp() {
        return p210_cod_ccpp;
    }

    public void setP210_cod_ccpp(String p210_cod_ccpp) {
        this.p210_cod_ccpp = p210_cod_ccpp;
    }

    public int getP211() {
        return p211;
    }

    public void setP211(int p211) {
        this.p211 = p211;
    }

    public String getP211_observacion() {
        return p211_observacion;
    }

    public void setP211_observacion(String p211_observacion) {
        this.p211_observacion = p211_observacion;
    }

    public String getP212() {
        return p212;
    }

    public void setP212(String p212) {
        this.p212 = p212;
    }

    public String getP213() {
        return p213;
    }

    public void setP213(String p213) {
        this.p213 = p213;
    }

    public String getP214_nombres() {
        return p214_nombres;
    }

    public void setP214_nombres(String p214_nombres) {
        this.p214_nombres = p214_nombres;
    }

    public String getP214_apellidos() {
        return p214_apellidos;
    }

    public void setP214_apellidos(String p214_apellidos) {
        this.p214_apellidos = p214_apellidos;
    }

    public String getP215_cod_ccpp() {
        return p215_cod_ccpp;
    }

    public void setP215_cod_ccpp(String p215_cod_ccpp) {
        this.p215_cod_ccpp = p215_cod_ccpp;
    }

    public int getP216_tipo_via() {
        return p216_tipo_via;
    }

    public void setP216_tipo_via(int p216_tipo_via) {
        this.p216_tipo_via = p216_tipo_via;
    }

    public String getP216_otra_via() {
        return p216_otra_via;
    }

    public void setP216_otra_via(String p216_otra_via) {
        this.p216_otra_via = p216_otra_via;
    }

    public String getP216_nombre_avenida() {
        return p216_nombre_avenida;
    }

    public void setP216_nombre_avenida(String p216_nombre_avenida) {
        this.p216_nombre_avenida = p216_nombre_avenida;
    }

    public int getP216_puerta() {
        return p216_puerta;
    }

    public void setP216_puerta(int p216_puerta) {
        this.p216_puerta = p216_puerta;
    }

    public int getP216_block() {
        return p216_block;
    }

    public void setP216_block(int p216_block) {
        this.p216_block = p216_block;
    }

    public int getP216_interior() {
        return p216_interior;
    }

    public void setP216_interior(int p216_interior) {
        this.p216_interior = p216_interior;
    }

    public int getP216_piso() {
        return p216_piso;
    }

    public void setP216_piso(int p216_piso) {
        this.p216_piso = p216_piso;
    }

    public int getP216_manzana() {
        return p216_manzana;
    }

    public void setP216_manzana(int p216_manzana) {
        this.p216_manzana = p216_manzana;
    }

    public int getP216_lote() {
        return p216_lote;
    }

    public void setP216_lote(int p216_lote) {
        this.p216_lote = p216_lote;
    }

    public String getP217_nombres() {
        return p217_nombres;
    }

    public void setP217_nombres(String p217_nombres) {
        this.p217_nombres = p217_nombres;
    }

    public String getP217_apellidos() {
        return p217_apellidos;
    }

    public void setP217_apellidos(String p217_apellidos) {
        this.p217_apellidos = p217_apellidos;
    }

    public int getP218_cargo() {
        return p218_cargo;
    }

    public void setP218_cargo(int p218_cargo) {
        this.p218_cargo = p218_cargo;
    }

    public String getP218_otro_cargo() {
        return p218_otro_cargo;
    }

    public void setP218_otro_cargo(String p218_otro_cargo) {
        this.p218_otro_cargo = p218_otro_cargo;
    }

    public String getP219_fijo() {
        return p219_fijo;
    }

    public void setP219_fijo(String p219_fijo) {
        this.p219_fijo = p219_fijo;
    }

    public String getP219_celular() {
        return p219_celular;
    }

    public void setP219_celular(String p219_celular) {
        this.p219_celular = p219_celular;
    }

    public String getP220() {
        return p220;
    }

    public void setP220(String p220) {
        this.p220 = p220;
    }

    public String getP221() {
        return p221;
    }

    public void setP221(String p221) {
        this.p221 = p221;
    }

    public String getP221_observaciones() {
        return p221_observaciones;
    }

    public void setP221_observaciones(String p221_observaciones) {
        this.p221_observaciones = p221_observaciones;
    }
}
