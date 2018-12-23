package model.dume.components;

import model.element.connexion.Composite;
import model.element.connexion.Simple;
import model.element.connexion.constant.axis.distance.Distance;
import model.element.connexion.joint.rotation.Twisting;

public class Base extends Composite {

    private static final Twisting Q1 = new Twisting(0.0);

    private static final Distance D0 = new Distance(0.1);

    public Base() {
        super(D0, (Simple) Q1.clone());
    }
}
