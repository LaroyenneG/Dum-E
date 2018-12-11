package model.element.connexion.joint;

import model.element.ElementVisitor;

public abstract class Rotation extends Joint {

    public Rotation(double value) {
        super(value);
    }

    public Rotation(double value, double min, double max) {
        super(value, min, max);
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizationRotation(this);
    }
}
