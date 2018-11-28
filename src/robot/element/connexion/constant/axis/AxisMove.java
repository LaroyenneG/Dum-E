package robot.element.connexion.constant.axis;

import robot.element.connexion.constant.Constant;

public abstract class AxisMove extends Constant {


    private final double distance;

    public AxisMove(double distance) {
        this.distance = distance;
    }
}
