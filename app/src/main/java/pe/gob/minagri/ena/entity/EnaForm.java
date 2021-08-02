package pe.gob.minagri.ena.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "EnaForm")
public class EnaForm {

    @Id(autoincrement = true)
    @Property(nameInDb = "_id")
    private Long id;

    private String capitulo1;
    private String capitulo2;
    private String capitulo3;
    private String capitulo4;
    private String capitulo5;
    private String capitulo6;
    private String capitulo7;
    private String capitulo8;
    private String capitulo9;
    private String capitulo10;
    private String capitulo11;
    private String capitulo12;
    private String json;
    private String dni;
    private String nroParcela;
    private String segmentoEmpresa;

    private String code;


    @Generated(hash = 1553731956)
    public EnaForm() {
    }

    @Generated(hash = 1968491846)
    public EnaForm(Long id, String capitulo1, String capitulo2, String capitulo3, String capitulo4, String capitulo5, String capitulo6, String capitulo7, String capitulo8, String capitulo9, String capitulo10, String capitulo11, String capitulo12, String json, String dni, String nroParcela, String segmentoEmpresa, String code) {
        this.id = id;
        this.capitulo1 = capitulo1;
        this.capitulo2 = capitulo2;
        this.capitulo3 = capitulo3;
        this.capitulo4 = capitulo4;
        this.capitulo5 = capitulo5;
        this.capitulo6 = capitulo6;
        this.capitulo7 = capitulo7;
        this.capitulo8 = capitulo8;
        this.capitulo9 = capitulo9;
        this.capitulo10 = capitulo10;
        this.capitulo11 = capitulo11;
        this.capitulo12 = capitulo12;
        this.json = json;
        this.dni = dni;
        this.nroParcela = nroParcela;
        this.segmentoEmpresa = segmentoEmpresa;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCapitulo1() {
        return capitulo1;
    }

    public void setCapitulo1(String capitulo1) {
        this.capitulo1 = capitulo1;
    }

    public String getCapitulo2() {
        return capitulo2;
    }

    public void setCapitulo2(String capitulo2) {
        this.capitulo2 = capitulo2;
    }

    public String getCapitulo3() {
        return capitulo3;
    }

    public void setCapitulo3(String capitulo3) {
        this.capitulo3 = capitulo3;
    }

    public String getCapitulo4() {
        return capitulo4;
    }

    public void setCapitulo4(String capitulo4) {
        this.capitulo4 = capitulo4;
    }

    public String getCapitulo5() {
        return capitulo5;
    }

    public void setCapitulo5(String capitulo5) {
        this.capitulo5 = capitulo5;
    }

    public String getCapitulo6() {
        return capitulo6;
    }

    public void setCapitulo6(String capitulo6) {
        this.capitulo6 = capitulo6;
    }

    public String getCapitulo7() {
        return capitulo7;
    }

    public void setCapitulo7(String capitulo7) {
        this.capitulo7 = capitulo7;
    }

    public String getCapitulo8() {
        return capitulo8;
    }

    public void setCapitulo8(String capitulo8) {
        this.capitulo8 = capitulo8;
    }

    public String getCapitulo9() {
        return capitulo9;
    }

    public void setCapitulo9(String capitulo9) {
        this.capitulo9 = capitulo9;
    }

    public String getCapitulo10() {
        return capitulo10;
    }

    public void setCapitulo10(String capitulo10) {
        this.capitulo10 = capitulo10;
    }

    public String getCapitulo11() {
        return capitulo11;
    }

    public void setCapitulo11(String capitulo11) {
        this.capitulo11 = capitulo11;
    }

    public String getCapitulo12() {
        return capitulo12;
    }

    public void setCapitulo12(String capitulo12) {
        this.capitulo12 = capitulo12;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNroParcela() {
        return nroParcela;
    }

    public void setNroParcela(String nroParcela) {
        this.nroParcela = nroParcela;
    }

    public String getSegmentoEmpresa() {
        return segmentoEmpresa;
    }

    public void setSegmentoEmpresa(String segmentoEmpresa) {
        this.segmentoEmpresa = segmentoEmpresa;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "EnaForm{" +
                "id=" + id +
                ", capitulo1='" + capitulo1 + '\'' +
                ", capitulo2='" + capitulo2 + '\'' +
                ", capitulo3='" + capitulo3 + '\'' +
                ", capitulo4='" + capitulo4 + '\'' +
                ", capitulo5='" + capitulo5 + '\'' +
                ", capitulo6='" + capitulo6 + '\'' +
                ", capitulo7='" + capitulo7 + '\'' +
                ", capitulo8='" + capitulo8 + '\'' +
                ", capitulo9='" + capitulo9 + '\'' +
                ", capitulo10='" + capitulo10 + '\'' +
                ", capitulo11='" + capitulo11 + '\'' +
                ", capitulo12='" + capitulo12 + '\'' +
                ", json='" + json + '\'' +
                ", dni='" + dni + '\'' +
                ", nroParcela='" + nroParcela + '\'' +
                ", segmentoEmpresa='" + segmentoEmpresa + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

