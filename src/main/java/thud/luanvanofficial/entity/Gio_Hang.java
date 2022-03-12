package thud.luanvanofficial.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gio_hang")
public class Gio_Hang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Khach_Hang khach_hang;
    private List<San_Pham> san_phams;

    public Gio_Hang() {
    }

    public Gio_Hang(Khach_Hang khach_hang, List<San_Pham> san_phams) {
        this.khach_hang = khach_hang;
        this.san_phams = san_phams;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Khach_Hang getKhach_hang() {
        return khach_hang;
    }

    public void setKhach_hang(Khach_Hang khach_hang) {
        this.khach_hang = khach_hang;
    }

    public List<San_Pham> getSan_phams() {
        return san_phams;
    }

    public void setSan_phams(List<San_Pham> san_phams) {
        this.san_phams = san_phams;
    }
}
