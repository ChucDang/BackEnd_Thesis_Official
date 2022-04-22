package thud.luanvanofficial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Role")
public class Role extends BaseEntity{
    @Column(columnDefinition = "nvarchar(10) not null")
    private String code;
    @Column(columnDefinition = "nvarchar(25) not null")
    private String name;
    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();
}
