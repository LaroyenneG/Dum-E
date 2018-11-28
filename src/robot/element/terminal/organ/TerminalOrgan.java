package robot.element.terminal.organ;

import robot.element.Element;
import robot.math.Operation3D;

public abstract class TerminalOrgan extends Element {

    @Override
    public Operation3D changeFrame(Operation3D frame) {
        setOperation3D(frame);
        return null;
    }
}
