package poly.edu.bean;

import java.util.Date;
import java.util.Objects;

public class Staff {
    private String id;
    private String fullname;
    private String photo;
    private Boolean gender;
    private Date birthday;
    private Double salary;
    private Integer level;

    // Default constructor
    public Staff() {
    }

    // All-args constructor
    public Staff(String id, String fullname, String photo, Boolean gender, 
                Date birthday, Double salary, Integer level) {
        this.id = id;
        this.fullname = fullname;
        this.photo = photo;
        this.gender = gender;
        this.birthday = birthday;
        this.salary = salary;
        this.level = level;
    }

    // Getters and Setters
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
        this.photo = photo;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(id, staff.id) &&
               Objects.equals(fullname, staff.fullname) &&
               Objects.equals(photo, staff.photo) &&
               Objects.equals(gender, staff.gender) &&
               Objects.equals(birthday, staff.birthday) &&
               Objects.equals(salary, staff.salary) &&
               Objects.equals(level, staff.level);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, photo, gender, birthday, salary, level);
    }

    // toString method
    @Override
    public String toString() {
        return "Staff{" +
               "id='" + id + '\'' +
               ", fullname='" + fullname + '\'' +
               ", photo='" + photo + '\'' +
               ", gender=" + gender +
               ", birthday=" + birthday +
               ", salary=" + salary +
               ", level=" + level +
               '}';
    }

    // Builder pattern implementation
    public static StaffBuilder builder() {
        return new StaffBuilder();
    }

    public static class StaffBuilder {
        private String id;
        private String fullname;
        private String photo;
        private Boolean gender;
        private Date birthday;
        private Double salary;
        private Integer level;

        public StaffBuilder id(String id) {
            this.id = id;
            return this;
        }

        public StaffBuilder fullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public StaffBuilder photo(String photo) {
            this.photo = photo;
            return this;
        }

        public StaffBuilder gender(Boolean gender) {
            this.gender = gender;
            return this;
        }

        public StaffBuilder birthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public StaffBuilder salary(Double salary) {
            this.salary = salary;
            return this;
        }

        public StaffBuilder level(Integer level) {
            this.level = level;
            return this;
        }

        public Staff build() {
            return new Staff(id, fullname, photo, gender, birthday, salary, level);
        }
    }
}