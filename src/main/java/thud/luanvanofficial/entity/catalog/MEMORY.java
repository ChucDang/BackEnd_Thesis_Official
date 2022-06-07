package thud.luanvanofficial.entity.catalog;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "memory")
public class MEMORY {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String code;
    @Transient
    private static String icon = "/icons/ic_memory.png";
}
