package model.element.connexion.joint;

public abstract class Linear extends Joint {

    private double value;

    public Linear(double value) {
        setValue(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = (value < 0.0) ? value : 0.0;
    }
}
