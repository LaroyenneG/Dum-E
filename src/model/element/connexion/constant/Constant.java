package model.element.connexion.constant;

import model.element.connexion.Connexion;
import model.element.connexion.joint.Joint;

public abstract class Constant extends Connexion {

    @Override
    public Joint[] getJoints() {

        return new Joint[]{};
    }


    @Override
    public int jointsNumber() {
        return 0;
    }
}
