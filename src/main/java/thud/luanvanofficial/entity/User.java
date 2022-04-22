package thud.luanvanofficial.entity;

import thud.luanvanofficial.dto.enums.Role_Enum;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
    @Column(columnDefinition = "int(1)")
    private Role_Enum role;

}
