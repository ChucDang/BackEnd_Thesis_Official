package thud.luanvanofficial.dto;

import java.util.List;

public class Doanh_Muc_DTO {
    private Long doanh_muc_id;
    private String name;
    private List<San_Pham_DTO> doanh_muc_sanphams;

    public Long getDoanh_muc_id() {
        return doanh_muc_id;
    }

    public void setDoanh_muc_id(Long doanh_muc_id) {
        this.doanh_muc_id = doanh_muc_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<San_Pham_DTO> getDoanh_muc_sanphams() {
        return doanh_muc_sanphams;
    }

    public void setDoanh_muc_sanphams(List<San_Pham_DTO> doanh_muc_sanphams) {
        this.doanh_muc_sanphams = doanh_muc_sanphams;
    }
}
