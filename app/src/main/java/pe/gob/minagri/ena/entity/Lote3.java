package pe.gob.minagri.ena.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "Lote3")
public class Lote3 {

    @Id(autoincrement = true)
    @Property(nameInDb = "_id")
    private Long id;

    @Generated(hash = 962470124)
    public Lote3() {
    }

    private String index;
    private String json;
    private String dni;
    private String segmento;
    private String parcela;

    @Generated(hash = 983432767)
    public Lote3(Long id, String index, String json, String dni, String segmento, String parcela) {
        this.id = id;
        this.index = index;
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

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
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
