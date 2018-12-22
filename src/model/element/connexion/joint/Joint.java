package model.element.connexion.joint;

import model.element.connexion.Simple;

public abstract class Joint extends Simple {

    public final double max;
    public final double min;

    private double value;

    public Joint(double value, double min, double max) {
        this.min = min;
        this.max = max;
        setValueSafe(value);
    }

    public Joint(double value) {
        min = -Double.MAX_VALUE;
        max = Double.MAX_VALUE;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValueSafe(double value) {

        if (value <= min || value >= max) {
            return;
        }

        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
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
