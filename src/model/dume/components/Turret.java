package model.dume.components;

import model.element.ElementVisitor;
import model.element.connexion.Composite;
import model.element.connexion.Simple;
import model.element.connexion.constant.axis.distance.Distance;
import model.element.connexion.joint.rotation.Rotational;

public class Turret extends Composite {

    private static final Rotational Q2 = new Rotational(0.0, -Math.PI / 4.0, Math.PI / 4.0);

    public static final Distance D1 = new Distance(0.1533);

    public Turret() {
        super(D1, (Simple) Q2.clone());
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizationTurret(this);
    }
}
