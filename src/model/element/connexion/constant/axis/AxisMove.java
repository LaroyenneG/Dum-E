package model.element.connexion.constant.axis;

import model.ElementVisitor;
import model.element.connexion.constant.Constant;

public abstract class AxisMove extends Constant {

    public AxisMove(double distance) {
        super(distance);
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizedMove(this);
    }
}
