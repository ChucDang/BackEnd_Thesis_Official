package thud.luanvanofficial.dto.relative_user;

import thud.luanvanofficial.dto.relative_giohang_thanhtoan.GioHang_Shipping;
import thud.luanvanofficial.dto.relative_giohang_thanhtoan.HoaDon_DTO;

import java.util.List;

public class NhanVien_DTO extends User_DTO{
    private List<HoaDon_DTO> created_by;
    private List<GioHang_Shipping> gioHang_shippings;

    public List<HoaDon_DTO> getCreated_by() {
        return created_by;
    }

    public void setCreated_by(List<HoaDon_DTO> created_by) {
        this.created_by = created_by;
    }

    public List<GioHang_Shipping> getGioHang_shippings() {
        return gioHang_shippings;
    }

    public void setGioHang_shippings(List<GioHang_Shipping> gioHang_shippings) {
        this.gioHang_shippings = gioHang_shippings;
    }
}
