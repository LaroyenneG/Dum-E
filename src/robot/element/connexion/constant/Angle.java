package robot.element.connexion.constant;

public class Angle extends Constant {

    private final double angle;

    public Angle(double angle) {
        this.angle = angle % (Math.PI * 2.0);
    }

    @Override
    public String toString() {
        return null;
    }
}
