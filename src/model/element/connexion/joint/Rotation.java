package model.element.connexion.joint;

import model.ElementVisitor;

public abstract class Rotation extends Joint {

    public Rotation(double value) {
        super(value);
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizedRotation(this);
    }
}
