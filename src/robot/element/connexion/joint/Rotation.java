package robot.element.connexion.joint;

public abstract class Rotation extends Joint {

    private double value;

    public Rotation(double value) {
        setValue(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value % Math.PI;
    }
}
