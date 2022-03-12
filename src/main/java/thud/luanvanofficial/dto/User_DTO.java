package thud.luanvanofficial.dto;

import java.util.Date;
import java.util.List;

public class User_DTO {
    private Long people_id;
    private String name;
    private String address;
    private Date birthday;
    private Boolean sex;
    private String avatar_url;
    private String phone;
    private String email;
    private Gio_Hang_DTO user_gio_hang;
    private List<Don_Hang_DTO> user_don_hangs;

    public Long getPeople_id() {
        return people_id;
    }

    public void setPeople_id(Long people_id) {
        this.people_id = people_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gio_Hang_DTO getUser_gio_hang() {
        return user_gio_hang;
    }

    public void setUser_gio_hang(Gio_Hang_DTO user_gio_hang) {
        this.user_gio_hang = user_gio_hang;
    }

    public List<Don_Hang_DTO> getUser_don_hangs() {
        return user_don_hangs;
    }

    public void setUser_don_hangs(List<Don_Hang_DTO> user_don_hangs) {
        this.user_don_hangs = user_don_hangs;
    }
}
