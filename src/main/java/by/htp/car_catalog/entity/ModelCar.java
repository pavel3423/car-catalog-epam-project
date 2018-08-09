package by.htp.car_catalog.entity;

import java.io.Serializable;

public class ModelCar implements Serializable {

    private static final long serialVersionUID = 6379681683695619732L;

    private int id;
    private int brandID;
    private String model;

    private ModelCar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelCar modelCar = (ModelCar) o;

        if (id != modelCar.id) return false;
        if (brandID != modelCar.brandID) return false;
        return model != null ? model.equals(modelCar.model) : modelCar.model == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + brandID;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    public static Builder newBuilder() {
        return new ModelCar().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setId(int id) {
            ModelCar.this.id = id;
            return this;
        }

        public Builder setBrandID(int brandID) {
            ModelCar.this.brandID = brandID;
            return this;
        }

        public Builder setModel(String model) {
            ModelCar.this.model = model;
            return this;
        }

        public ModelCar build() {
            return ModelCar.this;
        }
    }
}
