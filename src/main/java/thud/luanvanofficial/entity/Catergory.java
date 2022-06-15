package thud.luanvanofficial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@Table(name = "catergories")
@CrossOrigin(origins = "*")
public class Catergory {
    @Id
    private Long id;
    private String code;
    private String name;
//    @OneToMany
//    private Set<Product> products = new HashSet<>();
}
