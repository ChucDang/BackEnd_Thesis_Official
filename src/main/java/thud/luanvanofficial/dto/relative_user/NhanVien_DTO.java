package thud.luanvanofficial.dto.relative_user;

import thud.luanvanofficial.dto.relative_giohang_thanhtoan.Shipping_DTO;
import thud.luanvanofficial.dto.relative_giohang_thanhtoan.HoaDon_DTO;

import java.util.List;

public class NhanVien_DTO extends User_DTO{
    private List<HoaDon_DTO> created_by;
    private List<Shipping_DTO> duyet_boi;
}
