package model.element.connexion.joint;

import model.element.connexion.Simple;

public abstract class Joint extends Simple {

    public final double max;
    public final double min;

    private double value;

    public Joint(double value, double min, double max) throws JointInvalidValueException {
        this.min = min;
        this.max = max;
        setValueSafe(value);
    }

    public Joint(double value) {
        min = Double.MIN_VALUE;
        max = Double.MAX_VALUE;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValueSafe(double value) throws JointInvalidValueException {

        if (value <= min || value >= max) {
            throw new JointInvalidValueException(this);
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
