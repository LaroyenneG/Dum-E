package model.dume.components;

import model.element.ElementVisitor;
import model.element.terminal.organ.TerminalOrgan;

import javax.media.j3d.Transform3D;

public class Grapnel extends TerminalOrgan {

    @Override
    public Transform3D transformation() {
        return new Transform3D();
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizationGrapnel(this);
    }
}
