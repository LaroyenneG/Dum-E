package model.dume.components;

import model.element.ElementVisitor;
import model.element.connexion.Composite;
import model.element.connexion.Simple;
import model.element.connexion.joint.linear.Collinear;

public class Pole extends Composite {

    private static final Collinear Q3 = new Collinear(0.3, 0.275, 0.55);

    public Pole() {
        super((Simple) Q3.clone());
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizationPole(this);
    }
}
