package model.element.connexion.joint;

import model.element.connexion.Connexion;

public abstract class Joint extends Connexion {

    @Override
    public Joint[] getJoints() {
        return new Joint[]{this};
    }

    @Override
    public int jointsNumber() {
        return 1;
    }
}
