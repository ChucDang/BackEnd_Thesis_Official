package thud.luanvanofficial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import thud.luanvanofficial.entity.catalog.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
//    @Column(columnDefinition = "nvarchar(25) not null")
    private String name;
////    @Column(columnDefinition = "decimal(15) not null")
//    private float original_price;
////    @Column(columnDefinition = "decimal(15) not null")
//    private float new_price;
////    @Column(columnDefinition = "text")
//    private String description;
////    @Column(columnDefinition = "decimal(1,2)")
//    private float rate;
    private int catergory_id;

    //    @ElementCollection
//    private List<String> image_url;
//    private Boolean amortization;
//    private int brand_id;
//    @ManyToOne
//    private CPU cpu;
//    private float monitor;
//    @ManyToOne
//    private RAM ram;
//    @ManyToOne
//    private MEMORY memory;
}
