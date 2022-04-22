package thud.luanvanofficial.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "khuyen_mai")
public class Khuyen_Mai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "DATE")
    private Date start_km;
    @Column(columnDefinition = "DATE")
    private Date end_km;
    @Column(columnDefinition = "text")
    private String km_description;
    @OneToMany(mappedBy = "khuyen_mai", cascade = CascadeType.ALL)
    //    Xóa một khuyến mãi thì những khuyến mãi trong sản phẩm bị xóa khuyến mãi.
    private List<San_Pham> khuyen_mai_san_phams = new ArrayList<San_Pham>();

}
