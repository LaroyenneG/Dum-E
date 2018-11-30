package model.element.connexion.constant.axis.move;

import model.element.connexion.constant.axis.AxisMove;

import javax.media.j3d.Transform3D;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

public class MoveY extends AxisMove {

    public MoveY(double distance) {
        super(distance);
    }

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        Transform3D nTrans = new Transform3D();

        nTrans.setTranslation(new Vector3d(0, getValue(), 0));

        transform3D.mul(nTrans);

        return transform3D;
    }

    @Override
    public Point3d getAxis() {
        return new Point3d(0.0, getValue(), 0.0);
    }
}
