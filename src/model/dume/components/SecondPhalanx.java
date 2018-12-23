package model.dume.components;

import model.element.connexion.Composite;
import model.element.connexion.Simple;
import model.element.connexion.constant.axis.distance.Distance;

public class SecondPhalanx extends Composite {

    private static final Distance D6 = new Distance(0.1);

    public SecondPhalanx() {
        super((Simple) D6);
    }
}
