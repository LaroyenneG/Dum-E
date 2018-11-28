package robot.element.connexion.constant.axis.rotation;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.element.connexion.constant.axis.AxisRotation;
import robot.math.Operation3D;

public class Rolling extends AxisRotation {

    public Rolling(double value) {
        super(value);
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
