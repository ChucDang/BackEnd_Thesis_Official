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
    private long khuyen_mai_id;
    private Date start_km;
    private Date end_km;
    @Column(columnDefinition = "text")
    private String km_description;
    @OneToMany(mappedBy = "san_pham_km", cascade = CascadeType.ALL)
    //    Xóa một khuyến mãi thì những khuyến mãi trong sản phẩm bị xóa theo
    private List<San_Pham> khuyen_mai_san_phams = new ArrayList<San_Pham>();

}
