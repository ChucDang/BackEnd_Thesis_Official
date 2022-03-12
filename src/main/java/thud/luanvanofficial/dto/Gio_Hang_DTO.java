package thud.luanvanofficial.dto;

import java.util.List;

public class Gio_Hang_DTO {
    private Long gio_hang_id;
    private User_DTO gio_hang_user;
    private List<San_Pham_DTO> gio_hang_sanphams;

    public Long getGio_hang_id() {
        return gio_hang_id;
    }

    public void setGio_hang_id(Long gio_hang_id) {
        this.gio_hang_id = gio_hang_id;
    }

    public User_DTO getGio_hang_user() {
        return gio_hang_user;
    }

    public void setGio_hang_user(User_DTO gio_hang_user) {
        this.gio_hang_user = gio_hang_user;
    }

    public List<San_Pham_DTO> getGio_hang_sanphams() {
        return gio_hang_sanphams;
    }

    public void setGio_hang_sanphams(List<San_Pham_DTO> gio_hang_sanphams) {
        this.gio_hang_sanphams = gio_hang_sanphams;
    }
}
