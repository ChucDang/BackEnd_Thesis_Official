package thud.luanvanofficial.dto.relative_giohang_thanhtoan;

import thud.luanvanofficial.dto.enums.States_Enum;
import thud.luanvanofficial.dto.relative_product.San_Pham_DTO;

import java.util.List;

public class GioHang_Shipping {
    private Gio_Hang_DTO gio_hang;
    private States_Enum state;
    private List<San_Pham_DTO> san_phams_shipping;
    private int fee;
}
