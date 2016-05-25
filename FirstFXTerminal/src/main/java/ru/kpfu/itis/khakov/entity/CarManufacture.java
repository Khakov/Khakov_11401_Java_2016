package ru.kpfu.itis.khakov.entity;


public class CarManufacture {
    private Long id;
    private String manufacture;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarManufacture that = (CarManufacture) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (manufacture != null ? !manufacture.equals(that.manufacture) : that.manufacture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (manufacture != null ? manufacture.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CarManufacture{" +
                "id=" + id +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }
}
