package model.dume.components;

import model.element.ElementVisitor;
import model.element.connexion.Composite;
import model.element.connexion.Simple;
import model.element.connexion.joint.linear.Collinear;
import model.element.connexion.joint.rotation.Rotational;

public class Pole extends Composite {

    private static final Collinear Q3 = new Collinear(0.3, 0.275, 0.55);

    private static final Rotational Q4 = new Rotational(0.0, -Math.PI / 2.0, Math.PI / 2.0);

    public Pole() {
        super((Simple) Q3.clone(), (Simple) Q4.clone());
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizationPole(this);
    }
}
