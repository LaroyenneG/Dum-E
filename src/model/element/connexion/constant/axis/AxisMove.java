package model.element.connexion.constant.axis;

import model.ElementVisitor;
import model.element.connexion.constant.Constant;

import javax.vecmath.Point3d;

public abstract class AxisMove extends Constant {

    public AxisMove(double distance) {
        super(distance);
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizedMove(this);
    }

    public abstract Point3d getAxis();
}
