package robot.element.connexion.joint;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.math.Operation3D;

public class Collinear extends Linear {

    public Collinear(int value) {
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
