package thud.luanvanofficial.enums;

public enum RAM_Enums {
    RAM_512(1,"512M"),
    RAM_1(2,"1G"),
    RAM_2(3,"2G"),
    RAM_4(4, "4G"),
    RAM_8(5, "8G"),
    RAM_16(6, "16G"),
    RAM_256(7, "256G"),
    RAM_1T(8, "1T");
    private int ram_Num;
    private String ram_Name;

    RAM_Enums(int ram_Num, String ram_Name) {
        this.ram_Num = ram_Num;
        this.ram_Name = ram_Name;
    }
}
