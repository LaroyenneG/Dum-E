package robot.element.connexion.constant;

import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.vecmath.Point3d;

public class Distance extends Constant {

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
        return null;
    }

    @Override
    public void draw(SimpleUniverse universe) {

    }
}
