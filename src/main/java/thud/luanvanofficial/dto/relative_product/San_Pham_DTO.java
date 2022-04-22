package thud.luanvanofficial.dto.relative_product;


import thud.luanvanofficial.dto.relative_user.Admin_DTO;

import java.util.List;

public class San_Pham_DTO {
    private long id;
    private String name;
    private float original_price;
    private float new_price;
    private String discription;
    private float rate;
    private List<String> image_urls;
    private String brand;
    private Boolean tra_gop;
    private Doanh_Muc_DTO san_pham_doanh_muc;
    private Khuyen_Mai_DTO san_pham_km;
    private Admin_DTO created_by;
}
