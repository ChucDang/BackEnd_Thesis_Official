package thud.luanvanofficial.entity.catalog;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cpus")
public class CPU {
    @Id
    private String code;

    @Transient
    private static String icon = "/icons/ic_cpu.png";

}
