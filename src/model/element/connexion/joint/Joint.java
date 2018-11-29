package model.element.connexion.joint;

import model.element.connexion.SimpleConnexion;

public abstract class Joint extends SimpleConnexion {

    @Override
    public boolean isJoint() {
        return true;
    }
}
