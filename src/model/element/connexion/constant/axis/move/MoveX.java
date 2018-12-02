package model.element.connexion.constant.axis.move;

import model.element.connexion.constant.axis.AxisMove;

import javax.media.j3d.Transform3D;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

public class MoveX extends AxisMove {

    public MoveX(double distance) {
        super(distance);
    }

    @Override
    public Point3d getAxis() {
        return new Point3d(getValue(), 0.0, 0.0);
    }

    @Override
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        transform3D.setTranslation(new Vector3d(getValue(), 0, 0));

        return transform3D;
    }
}
