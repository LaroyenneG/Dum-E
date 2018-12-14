package model.dume.components;

import model.dume.DumE;
import model.element.connexion.Composite;
import model.element.connexion.Simple;
import model.element.connexion.constant.axis.distance.Distance;
import model.element.connexion.joint.rotation.Rotational;

public class FirstPhalanx extends Composite {

    private static final Rotational Q4 = new Rotational(0.0, -Math.PI / 2.0, Math.PI / 2.0);

    private static final Distance D5 = new Distance(0.5 * DumE.MULTIPLIER);

    public FirstPhalanx() {
        super((Simple) Q4.clone(), D5);
    }
}
