package thud.luanvanofficial.dto;

import java.util.List;

public class Don_Hang_DTO {
    private Gio_Hang_DTO don_hang_gio_hang;
    private List<San_Pham_DTO> don_hang_sanphams;

    public Gio_Hang_DTO getDon_hang_gio_hang() {
        return don_hang_gio_hang;
    }

    public void setDon_hang_gio_hang(Gio_Hang_DTO don_hang_gio_hang) {
        this.don_hang_gio_hang = don_hang_gio_hang;
    }

    public List<San_Pham_DTO> getDon_hang_sanphams() {
        return don_hang_sanphams;
    }

    public void setDon_hang_sanphams(List<San_Pham_DTO> don_hang_sanphams) {
        this.don_hang_sanphams = don_hang_sanphams;
    }
}
