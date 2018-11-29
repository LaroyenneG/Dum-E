package model.element.connexion;

import model.element.connexion.joint.Joint;

import javax.media.j3d.Transform3D;

public abstract class Composite extends Connexion {

    private SimpleConnexion[] simpleConnexions;

    public Composite(SimpleConnexion... simpleConnexions) {
        this.simpleConnexions = simpleConnexions;
    }

    public Joint[] getJoints() {

        Joint[] joints = new Joint[jointsNumber()];

        int count = 0;
        for (SimpleConnexion simpleConnexion : simpleConnexions) {
            if (simpleConnexion.isJoint()) {
                joints[count] = (Joint) simpleConnexion;
                count++;
            }
        }

        return joints;
    }


    public int jointsNumber() {

        int n = 0;

        for (SimpleConnexion simpleConnexion : simpleConnexions) {
            if (simpleConnexion.isJoint()) {
                n++;
            }
        }

        return n;
    }

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        for (Connexion c : simpleConnexions) {
            transform3D = c.applyTransformation(transform3D);
        }

        return transform3D;
    }

    @Override
    public boolean isSimple() {
        return true;
    }
}
