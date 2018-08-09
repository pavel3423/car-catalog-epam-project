package by.htp.car_catalog.entity;

import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = 1984566728743718380L;

    private int id;
    private int modelID;
    private int year;
    private String bodyType;
    private int length;
    private int width;
    private int height;
    private int base;
    private int numberOfDoors;
    private int clearance;
    private int trunk;
    private int volumeOfTheTank;
    private int numberOfPlaces;
    private int price;

    private Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModelID() {
        return modelID;
    }

    public void setModelID(int modelID) {
        this.modelID = modelID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getClearance() {
        return clearance;
    }

    public void setClearance(int clearance) {
        this.clearance = clearance;
    }

    public int getTrunk() {
        return trunk;
    }

    public void setTrunk(int trunk) {
        this.trunk = trunk;
    }

    public int getVolumeOfTheTank() {
        return volumeOfTheTank;
    }

    public void setVolumeOfTheTank(int volumeOfTheTank) {
        this.volumeOfTheTank = volumeOfTheTank;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (modelID != car.modelID) return false;
        if (year != car.year) return false;
        if (length != car.length) return false;
        if (width != car.width) return false;
        if (height != car.height) return false;
        if (base != car.base) return false;
        if (numberOfDoors != car.numberOfDoors) return false;
        if (clearance != car.clearance) return false;
        if (trunk != car.trunk) return false;
        if (volumeOfTheTank != car.volumeOfTheTank) return false;
        if (numberOfPlaces != car.numberOfPlaces) return false;
        if (price != car.price) return false;
        return bodyType != null ? bodyType.equals(car.bodyType) : car.bodyType == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + modelID;
        result = 31 * result + year;
        result = 31 * result + (bodyType != null ? bodyType.hashCode() : 0);
        result = 31 * result + length;
        result = 31 * result + width;
        result = 31 * result + height;
        result = 31 * result + base;
        result = 31 * result + numberOfDoors;
        result = 31 * result + clearance;
        result = 31 * result + trunk;
        result = 31 * result + volumeOfTheTank;
        result = 31 * result + numberOfPlaces;
        result = 31 * result + price;
        return result;
    }

    public static Builder newBuilder() {
        return new Car().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setId(int id) {
            Car.this.id = id;
            return this;
        }

        public Builder setModelID(int modelID) {
            Car.this.modelID = modelID;
            return this;
        }

        public Builder setYear(int year) {
            Car.this.year = year;
            return this;
        }

        public Builder setBodyType(String bodyType) {
            Car.this.bodyType = bodyType;
            return this;
        }

        public Builder setLength(int length) {
            Car.this.length = length;
            return this;
        }

        public Builder setWidth(int width) {
            Car.this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            Car.this.height = height;
            return this;
        }

        public Builder setBase(int base) {
            Car.this.base = base;
            return this;
        }

        public Builder setNumberOfDoors(int numberOfDoors) {
            Car.this.numberOfDoors = numberOfDoors;
            return this;
        }

        public Builder setClearance(int clearance) {
            Car.this.clearance = clearance;
            return this;
        }

        public Builder setTrunk(int trunk) {
            Car.this.trunk = trunk;
            return this;
        }

        public Builder setVolumeOfTheTank(int volumeOfTheTank) {
            Car.this.volumeOfTheTank = volumeOfTheTank;
            return this;
        }

        public Builder setNumberOfPlaces(int numberOfPlaces) {
            Car.this.numberOfPlaces = numberOfPlaces;
            return this;
        }

        public Builder setPrice(int price) {
            Car.this.price = price;
            return this;
        }

        public Car build() {
            return Car.this;
        }
    }
}
