package model.element.connexion.joint.linear;

import model.ElementVisitor;
import model.element.connexion.joint.Linear;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;

public class Collinear extends Linear {

    public Collinear(double value) {
        super(value);
    }

    @Override
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        transform3D.setTranslation(new Vector3d(getValue(), getValue(), getValue()));

        return transform3D;
    }


    @Override
    public void accept(ElementVisitor sv) {

    }
}
