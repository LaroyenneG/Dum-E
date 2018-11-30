package model.element.connexion.joint;

public abstract class Linear extends Joint {

    public Linear(double value) {
        super(value);
    }

    @Override
    public double clearValue(double v) {
        return (v < 0.0) ? 0.0 : v;
    }
}
