package thud.luanvanofficial.dto.relative_giohang_thanhtoan;

import thud.luanvanofficial.dto.relative_product.San_Pham_DTO;
import thud.luanvanofficial.dto.relative_user.Admin_DTO;
import thud.luanvanofficial.dto.relative_user.KhachHang_DTO;

import java.util.List;

public class Gio_Hang_DTO {
    private long gio_hang_id;
    private KhachHang_DTO gio_hang_khachhang;
    private List<San_Pham_DTO> gio_hang_sanphams;
    private Admin_DTO created_by;

    public long getGio_hang_id() {
        return gio_hang_id;
    }

    public void setGio_hang_id(long gio_hang_id) {
        this.gio_hang_id = gio_hang_id;
    }

    public KhachHang_DTO getGio_hang_khachhang() {
        return gio_hang_khachhang;
    }

    public void setGio_hang_khachhang(KhachHang_DTO gio_hang_khachhang) {
        this.gio_hang_khachhang = gio_hang_khachhang;
    }

    public List<San_Pham_DTO> getGio_hang_sanphams() {
        return gio_hang_sanphams;
    }

    public void setGio_hang_sanphams(List<San_Pham_DTO> gio_hang_sanphams) {
        this.gio_hang_sanphams = gio_hang_sanphams;
    }

    public Admin_DTO getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Admin_DTO created_by) {
        this.created_by = created_by;
    }
}
