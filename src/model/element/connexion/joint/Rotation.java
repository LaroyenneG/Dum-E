package model.element.connexion.joint;

import model.ElementVisitor;

public abstract class Rotation extends Joint {

    public Rotation(double value) {
        super(value);
    }

    public Rotation(double value, double min, double max) throws JointInvalidValueException {
        super(value, min, max);
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizationRotation(this);
    }
}
