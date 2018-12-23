package model.dume.components;

import model.element.ElementVisitor;
import model.element.connexion.Composite;
import model.element.connexion.Simple;
import model.element.connexion.constant.axis.distance.Distance;
import model.element.connexion.joint.rotation.Revolving;

public class FirstPhalanx extends Composite {

    public static final Distance D5 = new Distance(0.05);
    private static final Revolving Q5 = new Revolving(0.0, -Math.PI / 2.0, Math.PI / 2.0);

    public FirstPhalanx() {
        super(D5, (Simple) Q5.clone());
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizationFirstPhalanx(this);
    }
}
