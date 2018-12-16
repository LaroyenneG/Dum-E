package model.dume.components;

import model.element.connexion.Composite;
import model.element.connexion.Simple;
import model.element.connexion.constant.axis.distance.Distance;
import model.element.connexion.joint.rotation.Twisting;

public class Turret extends Composite {

    private static final Distance D1 = new Distance(0.35);

    private static final Twisting Q1 = new Twisting(0.0);

    public Turret() {
        super((Simple) Q1.clone(), D1);
    }
}
