package thud.luanvanofficial.entity;

import javax.persistence.*;

@Entity
@Table(name = "thanh_toan")
public class Thanh_Toan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gio_hang_id")
    private Gio_Hang gio_hang;
    private boolean state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gio_Hang getGio_hang() {
        return gio_hang;
    }
}
