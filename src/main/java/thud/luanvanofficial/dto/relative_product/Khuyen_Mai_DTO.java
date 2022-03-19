package thud.luanvanofficial.dto.relative_product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Khuyen_Mai_DTO {
    private long khuyen_mai_id;
    private Date start_km, end_km;
    private String km_description;
    private List<San_Pham_DTO> khuyen_mai_san_phams = new ArrayList<San_Pham_DTO>();

    public long getKhuyen_mai_id() {
        return khuyen_mai_id;
    }

    public List<San_Pham_DTO> getKhuyen_mai_san_phams() {
        return khuyen_mai_san_phams;
    }

    public void setKhuyen_mai_san_phams(List<San_Pham_DTO> khuyen_mai_san_phams) {
        this.khuyen_mai_san_phams = khuyen_mai_san_phams;
    }

    public void setKhuyen_mai_id(long khuyen_mai_id) {
        this.khuyen_mai_id = khuyen_mai_id;
    }

    public Date getStart_km() {
        return start_km;
    }

    public void setStart_km(Date start_km) {
        this.start_km = start_km;
    }

    public Date getEnd_km() {
        return end_km;
    }

    public void setEnd_km(Date end_km) {
        this.end_km = end_km;
    }

    public String getKm_description() {
        return km_description;
    }

    public void setKm_description(String km_description) {
        this.km_description = km_description;
    }
}
