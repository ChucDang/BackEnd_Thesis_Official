package thud.luanvanofficial.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "khuyen_mai")
public class Khuyen_Mai {
    @Column(columnDefinition = "DATE")
    private Date start_km;
    @Column(columnDefinition = "DATE")
    private Date end_km;
    @Column(columnDefinition = "text")
    private String km_description;
    @OneToMany(mappedBy = "khuyen_mai")
    private List<San_Pham> san_phams = new ArrayList<San_Pham>();

}
