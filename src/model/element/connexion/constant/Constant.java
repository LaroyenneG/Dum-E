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

    @Override
    public boolean isJoint() {
        return false;
    }

    @Override
    public boolean isConstant() {
        return true;
    }
}
