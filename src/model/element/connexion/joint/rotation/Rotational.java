package model.element.connexion.joint.rotation;

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
    public Transform3D transformation() {
        return new Transform3D();
    }
}
