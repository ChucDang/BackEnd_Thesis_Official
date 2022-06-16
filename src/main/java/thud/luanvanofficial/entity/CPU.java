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
    @Column(columnDefinition = "varchar(10) default null")
    private String brand;
    private String version;
    private String type;
    private int core;
    private float speed;
    private String max_speed;
    @Column(columnDefinition = "boolean default false")
    private Boolean sp_64bits;
    @Column(columnDefinition = "int default 0")
    private int thread;
    @Column(columnDefinition = "int default 0")
    private int buffer;
    @Column(columnDefinition = "int default 0",nullable = true)
    private int bus;
}
