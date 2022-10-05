package pe.gob.minagri.ena.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "ModuloACapitulo5")
public class ModuloACapitulo5 {

    @Id(autoincrement = true)
    @Property(nameInDb = "_id")
    private Long id;

    @Generated(hash = 2104324724)
    public ModuloACapitulo5() {
    }


    private String json;
    private String dni;
    private String segmento;
    private String parcela;


    @Generated(hash = 712517884)
    public ModuloACapitulo5(Long id, String json, String dni, String segmento, String parcela) {
        this.id = id;
        this.json = json;
        this.dni = dni;
        this.segmento = segmento;
        this.parcela = parcela;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }
}
