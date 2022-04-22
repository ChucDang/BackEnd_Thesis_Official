package thud.luanvanofficial.dto.relative_giohang_thanhtoan;

import thud.luanvanofficial.dto.Gio_Hang_DTO;
import thud.luanvanofficial.dto.enums.States_Enum;
import thud.luanvanofficial.dto.relative_product.San_Pham_DTO;
import thud.luanvanofficial.dto.relative_user.NhanVien_DTO;

import java.util.List;

public class Shipping_DTO {
    private Gio_Hang_DTO gio_hang;
    private States_Enum state;
    private List<San_Pham_DTO> san_phams_shipping;
    private int fee;
    private HoaDon_DTO hoa_don;
    private NhanVien_DTO nhan_vien_duyet;
}
