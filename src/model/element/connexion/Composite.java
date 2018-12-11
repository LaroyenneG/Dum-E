package model.element.connexion;

import model.element.ElementVisitor;
import model.element.NumerousJoints;
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
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        for (Connexion connexion : simples) {
            transform3D.mul(connexion.transformation());
        }

        return transform3D;
    }

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        for (Simple simple : simples) {
            simple.applyTransformation(transform3D);
        }

        return transform3D;
    }

    @Override
    public void accept(ElementVisitor sv) {

        for (Simple simple : simples) {
            simple.accept(sv);
        }
    }

    @Override
    public boolean isSimple() {
        return false;
    }

    @Override
    public boolean isComposite() {
        return true;
    }


    @Override
    public Object clone() {

        Composite composite = null;

        composite = (Composite) super.clone();

        composite.simples = simples.clone();

        return composite;
    }
}
