package robot.element.connexion.constant.axis;

import robot.element.connexion.constant.Constant;

public abstract class Axis extends Constant {

    protected double value;

    public Axis(double value) {
        setValue(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value % (Math.PI * 2.0);
    }
}
