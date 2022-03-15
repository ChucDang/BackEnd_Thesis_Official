package thud.luanvanofficial.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gio_hang")
public class Gio_Hang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private List<San_Pham> san_phams;
}
