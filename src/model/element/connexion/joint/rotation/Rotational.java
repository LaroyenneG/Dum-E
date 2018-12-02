package model.element.connexion.joint.rotation;

import model.element.connexion.joint.Rotation;

import javax.media.j3d.Transform3D;

public class Rotational extends Rotation {

    public Rotational(double value) {
        super(value);
    }

    @Override
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        transform3D.rotZ(getValue());

        return transform3D;
    }
}
