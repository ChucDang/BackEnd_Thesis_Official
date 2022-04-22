package thud.luanvanofficial.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "san_pham")
public class San_Pham {
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
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;
    @Column(columnDefinition = "Boolean")
    private Boolean tra_gop;
    @ManyToOne
    @JoinColumn( name = "doanh_muc_id")
    private Doanh_Muc catergory;
    @ManyToOne
    @JoinColumn(name = "khuyen_mai_id")
    private Khuyen_Mai khuyen_mai;
    @ManyToMany
    @JoinTable(name = "cart_item")
    private List<Gio_Hang> gio_hangs = new ArrayList<>();
}
