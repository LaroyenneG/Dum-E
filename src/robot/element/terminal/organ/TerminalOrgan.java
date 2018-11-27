package robot.element.terminal.organ;

import robot.element.Element;
import robot.math.ConstructionFrame;

public abstract class TerminalOrgan extends Element {

    @Override
    public ConstructionFrame changeFrame(ConstructionFrame frame) {
        setFrame(frame);
        return getFrame();
    }
}
