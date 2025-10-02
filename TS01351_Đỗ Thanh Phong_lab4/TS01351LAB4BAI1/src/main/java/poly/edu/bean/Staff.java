package poly.edu.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Staff {
    private String id;
    private String fullname;
    private String photo = "photo.jpg";
    private Boolean gender = true;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Phù hợp với <input type="date">
    private Date birthday = new Date();
    private double salary = 12345.6789;
    private Integer level = 0;

    public Staff() {
    }

    public Staff(String id, String fullname, String photo, Boolean gender, Date birthday, double salary, Integer level) {
        this.id = id;
        this.fullname = fullname;
        this.photo = photo != null ? photo : "photo.jpg";
        this.gender = gender != null ? gender : true;
        this.birthday = birthday != null ? birthday : new Date();
        this.salary = salary;
        this.level = level != null ? level : 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = (photo != null && !photo.isEmpty()) ? photo : "photo.jpg";
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}