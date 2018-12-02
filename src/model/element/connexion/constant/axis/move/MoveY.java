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
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        transform3D.setTranslation(new Vector3d(0, getValue(), 0));

        return null;
    }

    @Override
    public Point3d getAxis() {
        return new Point3d(0.0, getValue(), 0.0);
    }
}
