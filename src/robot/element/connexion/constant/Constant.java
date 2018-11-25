package robot.element.connexion.constant;

import robot.element.connexion.Connexion;

public abstract class Constant extends Connexion {

    @Override
    public boolean isStatic() {
        return true;
    }
}
