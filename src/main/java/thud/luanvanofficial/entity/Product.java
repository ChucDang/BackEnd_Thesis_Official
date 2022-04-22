package thud.luanvanofficial.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product extends BaseEntity {
    @Column(columnDefinition = "nvarchar(25) not null")
    private String name;
    @Column(columnDefinition = "decimal(15) not null")
    private float original_price;
    @Column(columnDefinition = "decimal(15) not null")
    private float new_price;
    @Column(columnDefinition = "text")
    private String description;
    @Column(columnDefinition = "decimal(1,2)")
    private float rate;
    private List<String> image_urls;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @Column(columnDefinition = "Boolean")
    private Boolean amortization;
    @ManyToOne
    @JoinColumn( name = "category_id")
    private Catergory category;
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;
    @ManyToMany
    @JoinTable(name = "cart_item")
    private List<Cart> carts = new ArrayList<>();
}
