package model.element.terminal.organ;

import model.element.Element;

import javax.media.j3d.Transform3D;

public abstract class TerminalOrgan extends Element {

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        return transform3D;
    }
}
