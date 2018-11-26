package robot.element.connexion.constant;

import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.vecmath.Point3d;

public class Angle extends Constant {

    private final double angle;

    public Angle(double angle) {
        this.angle = angle % (Math.PI * 2.0);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Point3d changeFrame(Point3d frame) {
        return null;
    }

    @Override
    public void draw(SimpleUniverse universe) {

    }
}
