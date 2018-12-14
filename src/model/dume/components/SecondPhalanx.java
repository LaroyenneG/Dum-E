package model.dume.components;

import model.dume.DumE;
import model.element.connexion.Composite;
import model.element.connexion.Simple;
import model.element.connexion.constant.axis.distance.Distance;
import model.element.connexion.joint.rotation.Revolving;

public class SecondPhalanx extends Composite {

    private static final Revolving Q5 = new Revolving(0.0, -Math.PI / 2.0, Math.PI / 2.0);

    private static final Distance D6 = new Distance(0.5 * DumE.MULTIPLIER);

    public SecondPhalanx() {
        super((Simple) Q5.clone(), D6);
    }
}
