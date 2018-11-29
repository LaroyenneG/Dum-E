package model.element.connexion.constant.axis;

import model.element.connexion.constant.Constant;

public abstract class AxisMove extends Constant {


    private final double distance;

    public AxisMove(double distance) {
        this.distance = distance;
    }
}
