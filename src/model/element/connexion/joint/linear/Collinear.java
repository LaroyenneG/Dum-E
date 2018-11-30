package model.element.connexion.joint.linear;

import model.ElementVisitor;
import model.element.connexion.joint.Linear;

import javax.media.j3d.Transform3D;

public class Collinear extends Linear {

    public Collinear(double value) {
        super(value);
    }

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {

        return transform3D;
    }

    @Override
    public void accept(ElementVisitor sv) {

    }
}
