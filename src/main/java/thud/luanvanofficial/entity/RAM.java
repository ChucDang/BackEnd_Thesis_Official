package thud.luanvanofficial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "rams")
public class RAM {
    @Id
    private int id;
    @Column(columnDefinition = "varchar(10) default null")
    private String code;
    private int storage;
    private int frequent;
}
