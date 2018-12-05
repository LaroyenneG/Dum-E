package model.element.connexion.joint.rotation;

import model.element.connexion.joint.JointInvalidValueException;
import model.element.connexion.joint.Rotation;

import javax.media.j3d.Transform3D;

public class Rotational extends Rotation {

    public Rotational(double value) {
        super(value);
    }

    public Rotational(double value, double min, double max) throws JointInvalidValueException {
        super(value, min, max);
    }

    @Override
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        transform3D.rotX(getValue());

        return transform3D;
    }
}
