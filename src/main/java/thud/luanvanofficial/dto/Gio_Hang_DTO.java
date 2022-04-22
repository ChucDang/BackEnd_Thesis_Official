package thud.luanvanofficial.dto;

import thud.luanvanofficial.dto.relative_giohang_thanhtoan.Shipping_DTO;
import thud.luanvanofficial.dto.relative_product.San_Pham_DTO;
import thud.luanvanofficial.dto.relative_user.Admin_DTO;
import thud.luanvanofficial.dto.relative_user.KhachHang_DTO;

import java.util.List;

public class Gio_Hang_DTO {
    private long id;
    private KhachHang_DTO gio_hang_khachhang;
    private List<San_Pham_DTO> gio_hang_sanphams;
    private Admin_DTO created_by;
    private Shipping_DTO gioHang_shipping;
}
