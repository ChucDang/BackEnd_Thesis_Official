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
@Table(name = "storages")
public class Storage {
    @Id
    private int id;
    @Column(columnDefinition = "varchar(10) default null")
    private String code;
    private String storage;
    private String type;
    private Boolean optane;
    private byte slot;
    private byte remain;
}
