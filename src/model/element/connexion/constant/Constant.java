package model.element.connexion.constant;

import model.element.connexion.SimpleConnexion;

public abstract class Constant extends SimpleConnexion {

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
}
