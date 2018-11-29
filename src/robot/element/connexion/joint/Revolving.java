package robot.element.connexion.joint;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.math.ConstructionFrame;

public class Revolving extends Rotation {

    public Revolving(double value) {
        super(value);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public ConstructionFrame changeFrame(ConstructionFrame frame) {
        return null;
    }

    @Override
    public void draw(SimpleUniverse universe) {

    }
}
