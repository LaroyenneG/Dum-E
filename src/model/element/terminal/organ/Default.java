package model.element.terminal.organ;

import model.ElementVisitor;

import javax.media.j3d.Transform3D;

public class Default extends TerminalOrgan {

    @Override
    public Transform3D transformation() {
        return new Transform3D();
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizedDefault(this);
    }
}
