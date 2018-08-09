package by.htp.car_catalog.entity;

import java.io.Serializable;

public class BrandCar implements Serializable {

    private static final long serialVersionUID = -6226794434941096791L;

    private int id;
    private String brand;

    private BrandCar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandCar brandCar = (BrandCar) o;

        if (id != brandCar.id) return false;
        return brand != null ? brand.equals(brandCar.brand) : brandCar.brand == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        return result;
    }

    public static Builder newBuilder() {
        return new BrandCar().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setId(int id) {
            BrandCar.this.id = id;
            return this;
        }

        public Builder setBrand(String brand) {
            BrandCar.this.brand = brand;
            return this;
        }

        public BrandCar build() {
            return BrandCar.this;
        }
    }
}
