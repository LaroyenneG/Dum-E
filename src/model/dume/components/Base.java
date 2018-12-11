package model.dume.components;

import model.element.connexion.Composite;
import model.element.connexion.constant.axis.distance.Distance;

public class Base extends Composite {

    private static final Distance D1 = new Distance(0.1);

    public Base() {
        super(D1);
    }
}
