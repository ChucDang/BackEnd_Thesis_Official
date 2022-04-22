package thud.luanvanofficial.dto.relative_product;

import thud.luanvanofficial.dto.relative_user.Admin_DTO;

import java.util.List;

public class Doanh_Muc_DTO {
    private long id;
    private String name;
    private List<San_Pham_DTO> doanh_muc_sanphams;
    private Admin_DTO created_by;
}
