package model.element.connexion.constant.axis.rotation;

import model.ElementVisitor;
import model.element.connexion.constant.axis.AxisRotation;

import javax.media.j3d.Transform3D;

public class Pitching extends AxisRotation {

    public Pitching(double value) {
        super(value);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        transform3D.rotX(getValue());

        return transform3D;
    }

    @Override
    public void accept(ElementVisitor sv) {

    }
}