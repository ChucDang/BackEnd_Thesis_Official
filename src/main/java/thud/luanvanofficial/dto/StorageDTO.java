package thud.luanvanofficial.dto;

public class StorageDTO {
    private String code;
    private String storage;
    private String type;
    private Boolean supportOptane;
    public StorageDTO(String code, String storage, String type, Boolean supportOptane) {
        this.code = code;
        this.storage = storage;
        this.type = type;
        this.supportOptane = supportOptane;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getStorage() {
        return storage;
    }
    public void setStorage(String storage) {
        this.storage = storage;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Boolean getSupportOptane() {
        return supportOptane;
    }
    public void setSupportOptane(Boolean supportOptane) {
        this.supportOptane = supportOptane;
    }
    
}
