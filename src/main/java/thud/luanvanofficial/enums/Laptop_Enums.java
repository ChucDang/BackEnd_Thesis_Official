package thud.luanvanofficial.enums;
public enum Laptop_Enums {
    Laptop_1(1,"DELL"),
    Laptop_2(2,"ASUS"),
    Laptop_3(3,"MACBOOK"),
    Laptop_4(4, "LENOVO");
    private int index;
    private String value;

    Laptop_Enums(int index, String value) {
        this.index = index;
        this.value = value;
    }
}