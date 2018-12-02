package model.element.connexion.constant.axis.rotation;

import model.ElementVisitor;
import model.element.connexion.constant.axis.AxisRotation;

import javax.media.j3d.Transform3D;

public class Yawing extends AxisRotation {

    public Yawing(double value) {
        super(value);
    }

    @Override
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        transform3D.rotY(getValue());

        return transform3D;
    }

    @Override
    public void accept(ElementVisitor sv) {

    }
}
