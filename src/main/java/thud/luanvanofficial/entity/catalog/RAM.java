package thud.luanvanofficial.entity.catalog;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ram")
public class RAM {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String code;
    @Transient
    private static String icon = "/icons/ic_ram.png";
}
