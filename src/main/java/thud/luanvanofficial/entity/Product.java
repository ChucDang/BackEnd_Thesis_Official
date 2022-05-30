package thud.luanvanofficial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
//    @Column(columnDefinition = "nvarchar(25) not null")
    private String name;
//    @Column(columnDefinition = "decimal(15) not null")
    private float original_price;
//    @Column(columnDefinition = "decimal(15) not null")
    private float new_price;
//    @Column(columnDefinition = "text")
    private String description;
//    @Column(columnDefinition = "decimal(1,2)")
    private float rate;

    public Product(String name, float original_price, float new_price, String description, float rate, Boolean amortization, Catergory category, Brand brand) {
        this.name = name;
        this.original_price = original_price;
        this.new_price = new_price;
        this.description = description;
        this.rate = rate;
//        this.image_url = image_url;
        this.amortization = amortization;
        this.category = category;
        this.brand = brand;
    }

//    @ElementCollection
//    private List<String> image_url;
    private Boolean amortization;
    @ManyToOne
    private Catergory category;
    @OneToOne
    private Brand brand;
}
