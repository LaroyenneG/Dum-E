package model.element.connexion.joint.rotation;

import model.element.connexion.joint.JointInvalidValueException;
import model.element.connexion.joint.Rotation;

import javax.media.j3d.Transform3D;

public class Twisting extends Rotation {

    public Twisting(double value) {
        super(value);
    }

    public Twisting(double value, double min, double max) throws JointInvalidValueException {
        super(value, min, max);
    }

    @Override
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        transform3D.rotY(getValue());

        return transform3D;
    }
}
