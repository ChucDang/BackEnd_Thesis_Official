package thud.luanvanofficial.dto;

public class RAMDTO {
    private String type;
    private int storage;
    //Tốc độ RAM
    private float speed;
    private float supportMaxSpeed;
    public RAMDTO(String type, int storage, float speed, float supportMaxSpeed) {
        this.type = type;
        this.storage = storage;
        this.speed = speed;
        this.supportMaxSpeed = supportMaxSpeed;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getStorage() {
        return storage;
    }
    public void setStorage(int storage) {
        this.storage = storage;
    }
    public float getSpeed() {
        return speed;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }
    public float getSupportMaxSpeed() {
        return supportMaxSpeed;
    }
    public void setSupportMaxSpeed(float supportMaxSpeed) {
        this.supportMaxSpeed = supportMaxSpeed;
    }
 
}
