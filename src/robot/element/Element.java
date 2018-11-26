package robot.element;

import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.vecmath.Point3d;

public abstract class Element {

    private Point3d frame;

    public Element() {
        frame = new Point3d();
    }

    public Point3d getFrame() {
        return new Point3d(frame);
    }

    public void setFrame(Point3d frame) {
        this.frame.x = frame.x;
        this.frame.y = frame.y;
        this.frame.z = frame.z;
    }

    @Override
    public abstract String toString();

    public abstract Point3d changeFrame(Point3d frame);

    public abstract void draw(SimpleUniverse universe);
}
