package thud.luanvanofficial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import thud.luanvanofficial.entity.Product;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cpus")
public class CPU {
    @Id
    private int id;
    private String model;
    private String version;
    private String type;
    private int core;
    private float speed;
    private Boolean sp_64bits;
//    @OneToMany(mappedBy = "map_cpu")
//    private Set<Product> products = new HashSet<>();
}
