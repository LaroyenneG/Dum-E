package model.element.connexion;

import javax.media.j3d.Transform3D;

public abstract class Simple extends Connexion {

    @Override
    public boolean isSimple() {
        return true;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    public abstract boolean isJoint();

    public abstract boolean isConstant();

    @Override
    public void applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        transform3D.mul(transformation());

    }
}
