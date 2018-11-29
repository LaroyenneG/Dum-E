package model.element.connexion.joint.rotation;

import model.ElementVisitor;
import model.element.connexion.joint.Rotation;

import javax.media.j3d.Transform3D;

public class Rotational extends Rotation {

    public Rotational(double value) {
        super(value);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {
        return null;
    }

    @Override
    public void accept(ElementVisitor sv) {

    }
}
