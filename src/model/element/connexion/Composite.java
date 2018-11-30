package model.element.connexion;

import model.NumerousJoints;
import model.element.connexion.joint.Joint;

import javax.media.j3d.Transform3D;

public abstract class Composite extends Connexion implements NumerousJoints {

    private Simple[] simples;

    public Composite(Simple... simples) {
        this.simples = simples;
    }

    @Override
    public Joint[] getJoints() {

        Joint[] joints = new Joint[jointsNumber()];

        int count = 0;
        for (Simple simple : simples) {
            if (simple.isJoint()) {
                joints[count] = (Joint) simple;
                count++;
            }
        }

        return joints;
    }


    @Override
    public int jointsNumber() {

        int n = 0;

        for (Simple simple : simples) {
            if (simple.isJoint()) {
                n++;
            }
        }

        return n;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(super.toString());

        for (Simple simple : simples) {
            builder.append("\n");
            builder.append(simple);
        }

        return new String(builder);
    }

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        for (Connexion connexion : simples) {
            connexion.applyTransformation(transform3D);
        }

        return transform3D;
    }

    @Override
    public boolean isSimple() {
        return false;
    }

    @Override
    public boolean isComposite() {
        return true;
    }
}
