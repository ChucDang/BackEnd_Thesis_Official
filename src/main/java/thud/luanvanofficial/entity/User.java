package thud.luanvanofficial.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
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
    private Role role;
    @OneToOne
    private Cart cart;
}