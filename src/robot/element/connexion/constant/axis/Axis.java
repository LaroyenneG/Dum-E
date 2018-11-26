package robot.element.connexion.constant.axis;

import robot.element.connexion.constant.Constant;

public abstract class Axis extends Constant {

    protected final double value;

    public Axis(double value) {
        this.value = value % (Math.PI * 2.0);
    }
}
