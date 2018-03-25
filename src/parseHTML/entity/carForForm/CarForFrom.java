package parseHTML.entity.carForForm;

import java.util.Map;

public class CarForFrom {
    private String makeCar;
    private int idCar;
    private Map<String, Integer> listModels;

    public String getMakekCar() {
        return makeCar;
    }

    public void setMakeCar(String makeCar) {
        this.makeCar = makeCar;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public Map<String, Integer> getListModels() {
        return listModels;
    }

    public void setListModels(Map<String, Integer> listModels) {
        this.listModels = listModels;
    }
    @Override
    public String toString() {
        return "CarForFrom{" +
                "makeCar='" + makeCar + '\'' +
                ", idCar=" + idCar +
                ", listModels=" + listModels +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarForFrom that = (CarForFrom) o;

        if (idCar != that.idCar) return false;
        return makeCar != null ? makeCar.equals(that.makeCar) : that.makeCar == null;
    }

    @Override
    public int hashCode() {
        int result = makeCar != null ? makeCar.hashCode() : 0;
        result = 31 * result + idCar;
        return result;
    }
}
