package model.dume.components;

import model.element.connexion.Composite;
import model.element.connexion.Simple;
import model.element.connexion.constant.axis.rotation.Pitching;
import model.element.connexion.joint.linear.Collinear;

public class Pole extends Composite {

    private static final Pitching A3 = new Pitching(Math.PI / 2.0);

    private static final Collinear Q3 = new Collinear(2.75, 2.75, 5.5);

    public Pole() {
        super(A3, (Simple) Q3.clone());
    }
}
