package thud.luanvanofficial.dto.relative_product;

import thud.luanvanofficial.dto.relative_user.Admin_DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Khuyen_Mai_DTO {
    private long id;
    private Date start_km, end_km;
    private String km_description;
    private List<San_Pham_DTO> khuyen_mai_san_phams = new ArrayList<San_Pham_DTO>();
    private Admin_DTO created_by;
}
