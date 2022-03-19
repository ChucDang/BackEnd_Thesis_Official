package thud.luanvanofficial.dto.relative_user;

import thud.luanvanofficial.dto.relative_giohang_thanhtoan.Gio_Hang_DTO;
import thud.luanvanofficial.dto.relative_giohang_thanhtoan.HoaDon_DTO;

import java.util.List;

public class KhachHang_DTO extends User_DTO{
    private List<HoaDon_DTO> khachhang_hoadons;
    private Gio_Hang_DTO khachhang_giohang;

    public List<HoaDon_DTO> getKhachhang_hoadons() {
        return khachhang_hoadons;
    }

    public void setKhachhang_hoadons(List<HoaDon_DTO> khachhang_hoadons) {
        this.khachhang_hoadons = khachhang_hoadons;
    }

    public Gio_Hang_DTO getKhachhang_giohang() {
        return khachhang_giohang;
    }

    public void setKhachhang_giohang(Gio_Hang_DTO khachhang_giohang) {
        this.khachhang_giohang = khachhang_giohang;
    }
}
