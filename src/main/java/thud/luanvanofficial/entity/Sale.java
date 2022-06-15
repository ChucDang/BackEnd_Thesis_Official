package thud.luanvanofficial.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Sale")
public class Sale {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Date start;
    private Date end;
    private String description;
//    @OneToMany(targetEntity = Product.class)
//    private List<Product> products = new ArrayList<Product>();

}
