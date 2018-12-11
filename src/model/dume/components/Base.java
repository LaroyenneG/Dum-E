package model.dume.components;

import model.dume.DumE;
import model.element.connexion.Composite;
import model.element.connexion.constant.axis.distance.Distance;

public class Base extends Composite {

    private static final Distance D1 = new Distance(1.0 * DumE.MULTIPLIER);

    public Base() {
        super(D1);
    }
}
