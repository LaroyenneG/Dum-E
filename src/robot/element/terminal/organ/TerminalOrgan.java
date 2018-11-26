package robot.element.terminal.organ;

import robot.element.Element;

import javax.vecmath.Point3d;

public abstract class TerminalOrgan extends Element {

    @Override
    public Point3d changeFrame(Point3d frame) {
        setFrame(frame);
        return getFrame();
    }
}
