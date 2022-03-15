package thud.luanvanofficial.entity;
import thud.luanvanofficial.dto.Doanh_Muc_DTO;
import thud.luanvanofficial.dto.Khuyen_Mai_DTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "san_pham")
public class San_Pham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "nvarchar(25) not null")
    private String name;
    @Column(columnDefinition = "decimal(15) not null")
    private float original_price;
    @Column(columnDefinition = "decimal(15) not null")
    private float new_price;
    @Column(columnDefinition = "text")
    private String discription;
    @Column(columnDefinition = "decimal(1,2)")
    private float rate;
    private List<String> image_urls;
    @Column(columnDefinition = "varchar(20)")
    private String brand;
    private Boolean tra_gop;
    @ManyToOne
    @JoinColumn( name = "doanh_muc_id")
    private Doanh_Muc catergory;
    @ManyToOne
    @JoinColumn(name = "khuyen_mai_id")
    private Khuyen_Mai_DTO san_pham_km;
}
