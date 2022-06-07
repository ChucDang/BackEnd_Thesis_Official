package thud.luanvanofficial.enums;

public enum Catergory_Enum {
    CATER_1(1,"Điện thoại"),
    CATER_2(2,"Laptop"),
    CATER_3(3,"Tablet"),
    CATER_4(4, "Phụ kiện"),
    CATER_5(5, "Watch");
    private int catergory_Num;
    private String catergory_Name;
    Catergory_Enum(int num, String name){
        this.catergory_Num = num;
        this.catergory_Name = name;
    }
}
