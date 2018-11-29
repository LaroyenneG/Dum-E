package model.element.connexion;

import model.element.connexion.joint.Joint;

import javax.media.j3d.Transform3D;

public abstract class Composite extends Connexion {

    private Connexion[] connexions;

    public Composite(Connexion... connexions) {
        this.connexions = connexions;
    }


    @Override
    public Joint[] getJoints() {

        Joint[] joints = new Joint[jointsNumber()];

        int count = 0;
        for (Connexion connexion : connexions) {
            if (connexion.jointsNumber() > 0) {

                Joint[] tmp = connexion.getJoints();

                System.arraycopy(tmp, 0, joints, count, tmp.length);
                count += tmp.length;
            }
        }

        return joints;
    }

    @Override
    public int jointsNumber() {

        int n = 0;

        for (Connexion c : connexions) {
            n += c.jointsNumber();
        }

        return n;
    }

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        for (Connexion c : connexions) {
            transform3D = c.applyTransformation(transform3D);
        }

        return transform3D;
    }
}
