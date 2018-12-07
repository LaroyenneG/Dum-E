package model.element.connexion.constant.axis.distance;

import model.ElementVisitor;
import model.element.connexion.constant.axis.AxisMove;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;

public class Distance extends AxisMove {

    public Distance(double distance) {
        super(distance);
    }

    @Override
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        transform3D.setTranslation(new Vector3d(0, getValue(), 0));

        return transform3D;
    }

    @Override
    public void accept(ElementVisitor sv) {

        sv.virtualizationDistance(this);
    }
}
