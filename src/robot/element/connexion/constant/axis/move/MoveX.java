package robot.element.connexion.constant.axis.move;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.element.connexion.constant.axis.AxisMove;
import robot.math.Operation3D;

public class MoveX extends AxisMove {

    public MoveX(double distance) {
        super(distance);
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
