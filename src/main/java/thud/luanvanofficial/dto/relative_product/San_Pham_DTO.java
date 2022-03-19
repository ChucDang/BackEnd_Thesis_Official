package thud.luanvanofficial.dto.relative_product;


import java.util.List;

public class San_Pham_DTO {
    private long san_pham_id;
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

    public Khuyen_Mai_DTO getSan_pham_km() {
        return san_pham_km;
    }

    public void setSan_pham_km(Khuyen_Mai_DTO san_pham_km) {
        this.san_pham_km = san_pham_km;
    }

    public Doanh_Muc_DTO getSan_pham_doanh_muc() {
        return san_pham_doanh_muc;
    }

    public void setSan_pham_doanh_muc(Doanh_Muc_DTO san_pham_doanh_muc) {
        this.san_pham_doanh_muc = san_pham_doanh_muc;
    }

    public long getSan_pham_id() {
        return san_pham_id;
    }

    public void setSan_pham_id(long san_pham_id) {
        this.san_pham_id = san_pham_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(float original_price) {
        this.original_price = original_price;
    }

    public float getNew_price() {
        return new_price;
    }

    public void setNew_price(float new_price) {
        this.new_price = new_price;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public List<String> getImage_urls() {
        return image_urls;
    }

    public void setImage_urls(List<String> image_urls) {
        this.image_urls = image_urls;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getTra_gop() {
        return tra_gop;
    }

    public void setTra_gop(Boolean tra_gop) {
        this.tra_gop = tra_gop;
    }
}
