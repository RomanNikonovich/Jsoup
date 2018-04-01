package parseHTML.entity.carForForm;

public class ModelRealm {
    private String modelCarR;
    private int idModelR;

    public ModelRealm(String modelCar, int idModel) {

        this.modelCarR = modelCar;
        this.idModelR = idModel;
    }

    public String getModelCarR() {

        return modelCarR;
    }

    public int getIdModelR() {
        return idModelR;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelRealm model = (ModelRealm) o;

        if (idModelR != model.idModelR) return false;
        return modelCarR != null ? modelCarR.equals(model.modelCarR) : model.modelCarR == null;
    }

    @Override
    public int hashCode() {
        int result = modelCarR != null ? modelCarR.hashCode() : 0;
        result = 31 * result + idModelR;
        return result;
    }

}