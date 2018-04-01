package parseHTML.entity.carForForm;

import java.util.List;

public class MakeCarRealm {
    private String makeCarR;
    private int idCarR;
    private List<ModelRealm> modelsCarsR;

    public MakeCarRealm(String makeCar, int idCar) {
        this.makeCarR = makeCar;
        this.idCarR = idCar;
    }

    public String getMakeCarR() {

        return makeCarR;
    }

    public int getIdCarR() {
        return idCarR;
    }

    public List<ModelRealm> getModelsCarsR() {
        return modelsCarsR;
    }

    public void setModelsCarsR(List<ModelRealm> modelsCarsR) {
        this.modelsCarsR = modelsCarsR;
    }

    @Override
    public String toString() {
        return "MakeCarRealm{" +
                "makeCarR='" + makeCarR + '\'' +
                ", idCarR=" + idCarR +
                ", modelsCarsR=" + modelsCarsR +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MakeCarRealm that = (MakeCarRealm) o;

        if (idCarR != that.idCarR) return false;
        return makeCarR != null ? makeCarR.equals(that.makeCarR) : that.makeCarR == null;
    }

    @Override
    public int hashCode() {
        int result = makeCarR != null ? makeCarR.hashCode() : 0;
        result = 31 * result + idCarR;
        return result;
    }
}
