package model.dume.components;

import model.element.connexion.Composite;
import model.element.connexion.constant.axis.distance.Distance;

public class Base extends Composite {

    private static final Distance D0 = new Distance(1.0);

    public Base() {
        super(D0);
    }
}
