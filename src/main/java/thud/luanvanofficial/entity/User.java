package thud.luanvanofficial.entity;

import thud.luanvanofficial.dto.Don_Hang_DTO;
import thud.luanvanofficial.dto.Gio_Hang_DTO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    @Column(nullable = false ,length = 25, columnDefinition = "nvarchar(25)")
    private String name;
    @Column(length = 100, columnDefinition = "nvarchar(100)")
    private String address;
    private Date birthday;
    private Boolean sex;
    private String avatar_url;
    @Column(length = 10, columnDefinition = "varchar(10)")
    private String phone;
    @Column(length = 25, columnDefinition = "varchar(25)")
    private String email;
    @OneToOne

    private Gio_Hang user_gio_hang;
    private List<Don_Hang> user_don_hangs;
}
