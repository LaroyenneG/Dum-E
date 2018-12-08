package model.element;

import model.element.connexion.joint.Joint;
import model.element.connexion.joint.JointInvalidValueException;

import javax.media.j3d.Transform3D;
import javax.vecmath.Point3d;

public class Solver<Fragment extends Element & NumerousJoints & Cloneable> {

    private static final double DEFAULT_STEP = 0.001;

    private Fragment fragment;

    private boolean[] lockJoints;

    private Point3d point;

    private double step;

    public Solver(Fragment fragment, Point3d point) {

        this.fragment = (Fragment) fragment.clone();

        lockJoints = new boolean[fragment.jointsNumber()];

        for (int i = 0; i < lockJoints.length; i++) {
            lockJoints[i] = false;
        }

        this.point = point;

        step = DEFAULT_STEP;
    }


    private double distance() {

        Transform3D transform3D = fragment.getTransform3D();
        transform3D.mul(fragment.transformation());

        Point3d position = new Point3d();
        transform3D.transform(position);

        return Math.abs(point.distance(position));
    }

    public double[] compute() {

        double d = 0.0;

        Joint[] joints = fragment.getJoints();

        while ((d = distance()) > step) {

            boolean stop = true;

            for (int j = 0; j < joints.length; j++) {

                Joint joint = joints[j];

                if (!lockJoints[j]) {

                    double value = joint.getValue();

                    double[] testValues = {value + step, value - step};

                    for (double testValue : testValues) {

                        try {

                            joint.setValueSafe(testValue);

                            if (distance() >= d) {
                                joint.setValue(value);
                            } else {
                                stop = false;
                                break;
                            }

                        } catch (JointInvalidValueException ignored) {
                        }
                    }
                }
            }

            if (stop) {
                return null;
            }
        }

        double[] solution = new double[joints.length];

        for (int i = 0; i < solution.length; i++) {
            solution[i] = joints[i].getValue();
        }

        return solution;
    }

    public void lockJoint(int j) {

        if (j < 0 || j > lockJoints.length) {
            return;
        }

        lockJoints[j] = true;
    }

    public void unlockJoint(int j) {

        if (j < 0 || j > lockJoints.length) {
            return;
        }

        lockJoints[j] = false;
    }

    public void setStep(double step) {
        this.step = step;
    }
}
