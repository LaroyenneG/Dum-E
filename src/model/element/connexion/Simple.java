package model.element.connexion;

public abstract class Simple extends Connexion {

    @Override
    public boolean isSimple() {
        return true;
    }

    @Override
    public boolean isConnexion() {
        return false;
    }

    public abstract boolean isJoint();

    public abstract boolean isConstant();
}
