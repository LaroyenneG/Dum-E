package model.element.connexion.joint.rotation;

import model.ElementVisitor;
import model.element.connexion.joint.Rotation;

public class Twisting extends Rotation {

    public Twisting(double value) {
        super(value);
    }

    @Override
    public void accept(ElementVisitor sv) {

    }
}
