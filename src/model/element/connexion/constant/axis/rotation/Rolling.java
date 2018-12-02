package model.element.connexion.constant.axis.rotation;

import model.element.connexion.constant.axis.AxisRotation;

import javax.media.j3d.Transform3D;

public class Rolling extends AxisRotation {

    public Rolling(double value) {
        super(value);
    }

    @Override
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        transform3D.rotZ(getValue());

        return transform3D;
    }
}
