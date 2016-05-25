package ru.kpfu.itis.khakov.entity;


public class Car {
    private Long id;
    private Double kof;
    private CarManufacture manufacture;
    private Model model;
    private int price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarManufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(CarManufacture manufacture) {
        this.manufacture = manufacture;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Double getKof() {
        return kof;
    }

    public void setKof(Double kof) {
        this.kof = kof;
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

        if (price != car.price) return false;
        if (id != null ? !id.equals(car.id) : car.id != null) return false;
        if (kof != null ? !kof.equals(car.kof) : car.kof != null) return false;
        if (manufacture != null ? !manufacture.equals(car.manufacture) : car.manufacture != null) return false;
        return model != null ? model.equals(car.model) : car.model == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (kof != null ? kof.hashCode() : 0);
        result = 31 * result + (manufacture != null ? manufacture.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return manufacture.getManufacture() + " - " + model.getModel();
    }
}
