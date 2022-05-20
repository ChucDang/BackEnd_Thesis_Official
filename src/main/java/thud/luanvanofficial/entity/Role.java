package thud.luanvanofficial.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "nvarchar(10) not null")
    private String code;
    @Column(columnDefinition = "nvarchar(25) not null")
    private String name;
    @OneToMany
    private List<User> users = new ArrayList<>();
}
