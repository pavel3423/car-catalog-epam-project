package by.htp.car_catalog.entity;

import java.io.Serializable;

public class Role implements Serializable {

    private static final long serialVersionUID = -6226794434941096791L;

    private int id;
    private String role;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (id != role1.id) return false;
        return role != null ? role.equals(role1.role) : role1.role == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    public static Builder newBuilder() {
        return new Role().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setId(int id) {
            Role.this.id = id;
            return this;
        }

        public Builder setRole(String role) {
            Role.this.role = role;
            return this;
        }

        public Role build() {
            return Role.this;
        }
    }
}
