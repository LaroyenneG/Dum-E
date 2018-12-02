package model.element.connexion.joint;

import model.element.connexion.Simple;

public abstract class Joint extends Simple {

    public final double max;
    public final double min;

    private double value;

    public Joint(double value, double min, double max) {
        setValue(value);
        this.min = min;
        this.max = max;
    }

    public Joint(double value) {
        this(value, 0, 0);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = clearValue(value);
    }

    public double clearValue(double v) {
        return v;
    }

    @Override
    public boolean isJoint() {
        return true;
    }

    @Override
    public boolean isConstant() {
        return false;
    }
}
