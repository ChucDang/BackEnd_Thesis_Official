package thud.luanvanofficial.enums;

public enum LaptopBrand_Enum {
    LaptopBRAND_1(1,"Điện thoại"),
    LaptopBRAND_2(2,"Laptop"),
    LaptopBRAND_3(3,"Tablet"),
    LaptopBRAND_4(4, "Phụ kiện"),
    LaptopBRAND_5(5, "Watch");
    private int brand_Num;
    private String brand_Name;

    LaptopBrand_Enum(int brand_Num, String brand_Name) {
        this.brand_Num = brand_Num;
        this.brand_Name = brand_Name;
    }
}