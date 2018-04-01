package parseHTML.entity.carForForm;

import java.util.List;

public class ChooseCarsRealm  {
    private List<MakeCarRealm> makeCarsR;

    public ChooseCarsRealm(List<MakeCarRealm> makeCars) {
        this.makeCarsR = makeCars;
    }

    public List<MakeCarRealm> getMakeCarsR() {
        return makeCarsR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChooseCarsRealm that = (ChooseCarsRealm) o;

        return makeCarsR != null ? makeCarsR.equals(that.makeCarsR) : that.makeCarsR == null;
    }

    @Override
    public int hashCode() {
        return makeCarsR != null ? makeCarsR.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ChooseCarsRealm{" +
                "makeCarsR=" + makeCarsR +
                '}';
    }
}