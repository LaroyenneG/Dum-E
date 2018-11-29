package model.element.connexion.constant.axis.move;

import model.ElementVisitor;
import model.element.connexion.constant.axis.AxisMove;

import javax.media.j3d.Transform3D;

public class MoveZ extends AxisMove {

    public MoveZ(double distance) {
        super(distance);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {
        return null;
    }

    @Override
    public void accept(ElementVisitor sv) {

    }
}
