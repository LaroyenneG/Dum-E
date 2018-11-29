package model.element.connexion;

public abstract class SimpleConnexion extends Connexion {

    @Override
    public boolean isSimple() {
        return true;
    }

    public abstract boolean isJoint();
}
