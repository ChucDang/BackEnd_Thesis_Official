package thud.luanvanofficial.entity;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "User")
public class User extends BaseEntity{
    @Column(columnDefinition = "nvarchar(25) not null")
    private String name;
    @Column(columnDefinition = "nvarchar(50) not null")
    private String address;
    @Column(columnDefinition = "Date")
    private Date birthday;
    @Column(columnDefinition = "Boolean")
    private Boolean sex;
    private String avatar_url;
    @Column(columnDefinition = "varchar(10) not null")
    private String phone;
    private String email;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
