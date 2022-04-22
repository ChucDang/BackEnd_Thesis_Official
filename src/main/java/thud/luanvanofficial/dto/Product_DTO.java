package thud.luanvanofficial.dto;


import java.util.List;

public class San_Pham_DTO extends AbstractDTO<San_Pham_DTO>{
    private long id;
    private String name;
    private float original_price;
    private float new_price;
    private String discription;
    private float rate;
    private List<String> image_urls;
    private String brand;
    private Boolean tra_gop;
    private String san_pham_doanh_muc;
    private String san_pham_km;
}
