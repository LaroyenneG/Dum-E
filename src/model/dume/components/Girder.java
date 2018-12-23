package model.dume.components;

import model.element.ElementVisitor;
import model.element.connexion.Composite;
import model.element.connexion.constant.axis.distance.Distance;
import model.element.connexion.constant.axis.rotation.Pitching;

public class Girder extends Composite {

    private static final Pitching A3 = new Pitching(Math.PI / 2.0);

    public static final Distance D3 = new Distance(0.166);

    public Girder() {
        super(D3, A3);
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizationGirder(this);
    }
}
