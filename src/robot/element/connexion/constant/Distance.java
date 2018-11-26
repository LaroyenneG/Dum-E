package robot.element.connexion.constant;

import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.vecmath.Point3d;

public class Distance extends Constant {

    private static final double COEFFICIENT = Math.cos(Math.PI / 3.0);

    private final double distance;

    public Distance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Point3d changeFrame(Point3d frame) {

        setFrame(frame);

        final double d = distance * COEFFICIENT;

        frame.x += d;
        frame.y += d;
        frame.z += d;

        return frame;
    }

    @Override
    public void draw(SimpleUniverse universe) {

    }
}
