package thud.luanvanofficial.dto.relative_user;

import thud.luanvanofficial.dto.relative_product.Doanh_Muc_DTO;
import thud.luanvanofficial.dto.relative_giohang_thanhtoan.Gio_Hang_DTO;
import thud.luanvanofficial.dto.relative_product.Khuyen_Mai_DTO;
import thud.luanvanofficial.dto.relative_product.San_Pham_DTO;

import java.util.List;

public class Admin_DTO extends User_DTO {
    private List<San_Pham_DTO> created_sanphams;
    private List<Doanh_Muc_DTO> created_doanhmucs;
    private List<Khuyen_Mai_DTO> created_khuyenmais;
    private List<User_DTO> created_users;
    private List<Gio_Hang_DTO> created_giohangs;

    public List<San_Pham_DTO> getCreated_sanphams() {
        return created_sanphams;
    }

    public void setCreated_sanphams(List<San_Pham_DTO> created_sanphams) {
        this.created_sanphams = created_sanphams;
    }

    public List<Doanh_Muc_DTO> getCreated_doanhmucs() {
        return created_doanhmucs;
    }

    public void setCreated_doanhmucs(List<Doanh_Muc_DTO> created_doanhmucs) {
        this.created_doanhmucs = created_doanhmucs;
    }

    public List<Khuyen_Mai_DTO> getCreated_khuyenmais() {
        return created_khuyenmais;
    }

    public void setCreated_khuyenmais(List<Khuyen_Mai_DTO> created_khuyenmais) {
        this.created_khuyenmais = created_khuyenmais;
    }

    public List<User_DTO> getCreated_users() {
        return created_users;
    }

    public void setCreated_users(List<User_DTO> created_users) {
        this.created_users = created_users;
    }

    public List<Gio_Hang_DTO> getCreated_giohangs() {
        return created_giohangs;
    }

    public void setCreated_giohangs(List<Gio_Hang_DTO> created_giohangs) {
        this.created_giohangs = created_giohangs;
    }
}
