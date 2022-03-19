package thud.luanvanofficial.entity;

import thud.luanvanofficial.dto.relative_giohang_thanhtoan.Gio_Hang_DTO;
import thud.luanvanofficial.dto.relative_product.San_Pham_DTO;

import javax.persistence.OneToOne;
import java.util.List;

public class Hoa_Don {
    @OneToOne
    private Gio_Hang_DTO don_hang_gio_hang;
    private List<San_Pham_DTO> don_hang_sanphams;
}
