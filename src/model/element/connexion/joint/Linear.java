package model.element.connexion.joint;

public abstract class Linear extends Joint {

    private double value;

    public Linear(double value) {
        super(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double clearValue(double v) {
        return (v < 0.0) ? 0.0 : v;
    }
}
