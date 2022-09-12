package thud.luanvanofficial.group_id;

import java.io.Serializable;

public class CPU_IDs implements Serializable{
    private String brand;
    private String version;
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    
}