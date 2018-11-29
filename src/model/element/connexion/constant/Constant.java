package model.element.connexion.constant;

import model.element.connexion.SimpleConnexion;

public abstract class Constant extends SimpleConnexion {

    @Override
    public boolean isJoint() {
        return false;
    }
}
