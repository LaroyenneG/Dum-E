package robot.element;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.math.ConstructionFrame;
import robot.math.Operation3D;

public abstract class Element {

    private Operation3D operation3D;

    public Element() {
        operation3D = new ConstructionFrame();
    }

    public Operation3D getOperation3D() {
        return operation3D;
    }

    public void setOperation3D(Operation3D frame) {
        this.operation3D = frame;
    }

    @Override
    public abstract String toString();

    public abstract Operation3D changeFrame(Operation3D frame);

    public abstract void draw(SimpleUniverse universe);
}
