package thud.luanvanofficial.enums;
public enum Catergory_Enums {
    Laptop_1(1,"DELL"),
    Laptop_2(2,"ASUS"),
    Laptop_3(3,"MACBOOK"),
    Laptop_4(4, "LENOVO");
    private int brand_Num;
    private String brand_Name;

    Catergory_Enums(int lap_Num, String lap_Name) {
        this.brand_Num = lap_Num;
        this.brand_Name = lap_Name;
    }

}