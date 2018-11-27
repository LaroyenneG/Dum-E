package robot.element;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.math.ConstructionFrame;

public abstract class Element {

    private ConstructionFrame frame;

    public Element() {
        frame = new ConstructionFrame();
    }

    public ConstructionFrame getFrame() {
        return (ConstructionFrame) frame.clone();
    }

    public void setFrame(ConstructionFrame frame) {
        this.frame = (ConstructionFrame) frame.clone();
    }

    @Override
    public abstract String toString();

    public abstract ConstructionFrame changeFrame(ConstructionFrame frame);

    public abstract void draw(SimpleUniverse universe);
}
