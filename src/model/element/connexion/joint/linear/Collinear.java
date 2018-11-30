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
    public Transform3D applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        Transform3D nTranf = new Transform3D();
        nTranf.setTranslation(new Vector3d(getValue(), getValue(), getValue()));

        transform3D.mul(nTranf);

        return transform3D;
    }

    @Override
    public void accept(ElementVisitor sv) {

    }
}
