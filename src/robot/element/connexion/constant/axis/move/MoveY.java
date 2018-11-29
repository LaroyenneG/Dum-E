package robot.element.connexion.constant.axis.move;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.element.connexion.constant.axis.AxisMove;
import robot.math.ConstructionFrame;

public class MoveY extends AxisMove {

    public MoveY(double distance) {
        super(distance);
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
