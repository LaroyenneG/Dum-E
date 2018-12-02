package model.element.connexion.constant.axis.rotation;

import model.element.connexion.constant.axis.AxisRotation;

import javax.media.j3d.Transform3D;

public class Pitching extends AxisRotation {

    public Pitching(double value) {
        super(value);
    }

    @Override
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        transform3D.rotX(getValue());

        return transform3D;
    }
}
