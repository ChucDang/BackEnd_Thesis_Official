package thud.luanvanofficial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import thud.luanvanofficial.entity.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "screens")
public class Screen {
    @Id
    private int id;
    private String size;
    private String tech;
    private String resolution;
    private String color;
    private int frequent;
    private String material;
    private String standard;
//    @OneToMany(mappedBy = "map_screen")
//    private Set<Product> products = new HashSet<>();
}
