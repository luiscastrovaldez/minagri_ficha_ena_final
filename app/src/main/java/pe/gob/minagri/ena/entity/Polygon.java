package pe.gob.minagri.ena.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "Polygon")
public class Polygon {

    @Id(autoincrement = true)
    @Property(nameInDb = "_id")
    private Long id;
    public Double area;
    public String name;
    public String dni;
    public String type;
    public Long idParent;

    @Generated(hash = 1695442607)
    public Polygon() {
    }

    @Generated(hash = 2132180573)
    public Polygon(Long id, Double area, String name, String dni, String type, Long idParent) {
        this.id = id;
        this.area = area;
        this.name = name;
        this.dni = dni;
        this.type = type;
        this.idParent = idParent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getIdParent() {
        return idParent;
    }

    public void setIdParent(Long idParent) {
        this.idParent = idParent;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}

