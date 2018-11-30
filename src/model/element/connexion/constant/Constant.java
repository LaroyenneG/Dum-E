package model.element.connexion.constant;

import model.element.connexion.Simple;

public abstract class Constant extends Simple {

    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public boolean isConstant() {
        return true;
    }

    @Override
    public boolean isJoint() {
        return false;
    }
}
