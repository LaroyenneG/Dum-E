package model.dume.components;

import model.element.ElementVisitor;
import model.element.connexion.Composite;
import model.element.connexion.Simple;
import model.element.connexion.constant.axis.distance.Distance;

public class SecondPhalanx extends Composite {

    public static final Distance D6 = new Distance(0.05);

    public SecondPhalanx() {
        super((Simple) D6);
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizationSecondPhalanx(this);
    }
}
