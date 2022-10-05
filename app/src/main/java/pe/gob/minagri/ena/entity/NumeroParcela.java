package pe.gob.minagri.ena.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "NumeroParcela")
public class NumeroParcela {

    @Id(autoincrement = true)
    @Property(nameInDb = "_id")
    private Long id;

    @Generated(hash = 1487524259)
    public NumeroParcela() {
    }


    private String dni;
    private String segmento;
    private String parcela;

    @Generated(hash = 670087422)
    public NumeroParcela(Long id, String dni, String segmento, String parcela) {
        this.id = id;
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
