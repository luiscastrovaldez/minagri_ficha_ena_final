package pe.gob.minagri.ena.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "Point")
public class Point {

    @Id(autoincrement = true)
    @Property(nameInDb = "_id")
    private Long id;
    public Long idPolygon;
    public Double latitude;
    public Double longitude;

    @Generated(hash = 1977038299)
    public Point() {
    }

    @Generated(hash = 1202020846)
    public Point(Long id, Long idPolygon, Double latitude, Double longitude) {
        this.id = id;
        this.idPolygon = idPolygon;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPolygon() {
        return idPolygon;
    }

    public void setIdPolygon(Long idPolygon) {
        this.idPolygon = idPolygon;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
