package thud.luanvanofficial.dto.relative_user;

import thud.luanvanofficial.dto.Gio_Hang_DTO;
import thud.luanvanofficial.dto.relative_giohang_thanhtoan.HoaDon_DTO;

import java.util.List;

public class KhachHang_DTO extends User_DTO{
    private List<HoaDon_DTO> khachhang_hoadons;
    private Gio_Hang_DTO khachhang_giohang;
}
