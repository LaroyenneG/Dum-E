package model.element.connexion.joint.linear;

import model.element.ElementVisitor;
import model.element.connexion.joint.Linear;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;

public class Orthogonal extends Linear {

    public Orthogonal(int value) {
        super(value);
    }

    public Orthogonal(double value, double min, double max) {
        super(value, min, max);
    }

    @Override
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        transform3D.setTranslation(new Vector3d(0.0, getValue(), 0.0));
        transform3D.rotZ(-Math.PI);

        return transform3D;
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizationOrthogonal(this);
    }
}
