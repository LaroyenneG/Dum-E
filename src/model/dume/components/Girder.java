package model.dume.components;

import model.element.connexion.Composite;
import model.element.connexion.constant.axis.distance.Distance;

public class Girder extends Composite {

    private static final Distance D3 = new Distance(4.5);

    public Girder() {
        super(D3);
    }
}
