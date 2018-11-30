package model.element.connexion.joint;

public abstract class Rotation extends Joint {

    public Rotation(double value) {
        super(value);
    }

    @Override
    public double clearValue(double v) {
        return v % Math.PI;
    }
}
