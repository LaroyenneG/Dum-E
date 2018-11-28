package robot.element;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.math.ConstructionFrame;
import robot.math.Operation3D;

public abstract class Element {

    private Operation3D frame;

    public Element() {
        frame = new ConstructionFrame();
    }

    public Operation3D getFrame() {
        return frame;
    }

    public void setFrame(Operation3D frame) {
        this.frame = frame;
    }

    @Override
    public abstract String toString();

    public abstract Operation3D changeFrame(Operation3D frame);

    public abstract void draw(SimpleUniverse universe);
}
