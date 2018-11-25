package robot.element.connexion.joint;

import robot.element.connexion.Connexion;

public abstract class Joint extends Connexion {

    @Override
    public boolean isStatic() {
        return false;
    }
}
