package robot.element.connexion.constant;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.math.Operation3D;

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
    public Operation3D changeFrame(Operation3D frame) {
        return null;
    }

    @Override
    public void draw(SimpleUniverse universe) {

    }
}
