package robot.element.terminal.organ;

import robot.element.Element;

import javax.media.j3d.Transform3D;

public abstract class TerminalOrgan extends Element {

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {
        setTransform3D(transform3D);
        return null;
    }
}
