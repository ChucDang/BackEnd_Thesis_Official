package thud.luanvanofficial.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "doanh_muc")
public class Doanh_Muc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(nullable = false, unique = true, length = 25)
    private String name;
}
