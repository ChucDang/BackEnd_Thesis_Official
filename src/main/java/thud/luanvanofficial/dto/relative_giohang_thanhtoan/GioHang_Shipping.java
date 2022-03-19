package thud.luanvanofficial.dto.relative_giohang_thanhtoan;

import thud.luanvanofficial.dto.enums.States_Enum;
import thud.luanvanofficial.dto.relative_product.San_Pham_DTO;

import java.util.List;

public class GioHang_Shipping {
    private Gio_Hang_DTO gio_hang;
    private States_Enum state;
    private List<San_Pham_DTO> san_phams_shipping;
    private int fee;

    public Gio_Hang_DTO getGio_hang() {
        return gio_hang;
    }

    public void setGio_hang(Gio_Hang_DTO gio_hang) {
        this.gio_hang = gio_hang;
    }

    public States_Enum getState() {
        return state;
    }

    public void setState(States_Enum state) {
        this.state = state;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public List<San_Pham_DTO> getSan_phams_shipping() {
        return san_phams_shipping;
    }

    public void setSan_phams_shipping(List<San_Pham_DTO> san_phams_shipping) {
        this.san_phams_shipping = san_phams_shipping;
    }
}
