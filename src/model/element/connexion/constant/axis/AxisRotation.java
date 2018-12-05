package model.element.connexion.constant.axis;

import model.ElementVisitor;
import model.element.connexion.constant.Constant;

public abstract class AxisRotation extends Constant {

    public AxisRotation(double value) {
        super(value % (Math.PI * 2.0));
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizationAxisRotation(this);
    }
}
