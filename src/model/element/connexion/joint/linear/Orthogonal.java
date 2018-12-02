package model.element.connexion.joint.linear;

import model.ElementVisitor;
import model.element.connexion.joint.Linear;

import javax.media.j3d.Transform3D;

public class Orthogonal extends Linear {

    public Orthogonal(int value) {
        super(value);
    }

    @Override
    public Transform3D transformation() {
        return new Transform3D();
    }

    @Override
    public void accept(ElementVisitor sv) {

    }
}
