package model.element.connexion.joint.rotation;

import model.element.connexion.joint.Rotation;

import javax.media.j3d.Transform3D;

public class Twisting extends Rotation {

    public Twisting(double value) {
        super(value);
    }

    @Override
    public Transform3D transformation() {
        return new Transform3D();
    }
}
