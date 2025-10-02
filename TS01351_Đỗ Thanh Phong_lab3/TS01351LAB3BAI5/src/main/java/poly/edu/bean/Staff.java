package poly.edu.bean;

public class Staff {
    private String id;
    private String fullname;
    private int level;

    public Staff() {
    }

    public Staff(String id, String fullname, int level) {
        this.id = id;
        this.fullname = fullname;
        this.level = level;
    }

    // getter và setter
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // Builder thủ công
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String fullname;
        private int level;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder fullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder level(int level) {
            this.level = level;
            return this;
        }

        public Staff build() {
            return new Staff(id, fullname, level);
        }
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", level=" + level +
                '}';
    }
}
