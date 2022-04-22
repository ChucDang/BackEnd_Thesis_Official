package thud.luanvanofficial.dto.relative_user;

import thud.luanvanofficial.dto.relative_product.Doanh_Muc_DTO;
import thud.luanvanofficial.dto.Gio_Hang_DTO;
import thud.luanvanofficial.dto.relative_product.Khuyen_Mai_DTO;
import thud.luanvanofficial.dto.relative_product.San_Pham_DTO;

import java.util.List;

public class Admin_DTO extends User_DTO {
    private List<San_Pham_DTO> created_sanphams;
    private List<Doanh_Muc_DTO> created_doanhmucs;
    private List<Khuyen_Mai_DTO> created_khuyenmais;
    private List<User_DTO> created_users;
    private List<Gio_Hang_DTO> created_giohangs;
}
