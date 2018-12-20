package model.element;

import model.element.connexion.joint.Joint;
import model.element.robot.Robot;

import javax.vecmath.Point3d;

public class Solver {

    private static final double MINIMAL_DISTANCE = 0.001;
    private static final double DEFAULT_STEP = 0.001;
    private static final double MINIMAL_STEP = 0.00005;

    private Robot robot;

    private boolean[] lockJoints;

    private Point3d point;

    private double step;

    public Solver(Robot robot, Point3d point) {

        this.robot = (Robot) robot.clone();

        lockJoints = new boolean[robot.jointsNumber()];

        for (int i = 0; i < lockJoints.length; i++) {
            lockJoints[i] = false;
        }

        this.point = point;

        step = DEFAULT_STEP;
    }


    private double distance() {

        robot.build();

        return Math.abs(point.distance(robot.getTerminalOrganPosition()));
    }

    public double[] compute() {

        double d = 0.0;

        double divisor = 1.0;

        Joint[] joints = robot.getJoints();

        while ((d = distance()) > MINIMAL_DISTANCE) {

            final double step = d / divisor;

            boolean notBetter = true;

            for (int j = joints.length - 1; j >= 0; j--) {

                Joint joint = joints[j];

                if (!lockJoints[j]) {

                    double value = joint.getValue();

                    double[] testValues = {value + step, value - step};

                    for (double testValue : testValues) {

                            joint.setValueSafe(testValue);

                            if (distance() > d) {
                                joint.setValue(value);
                            } else {
                                notBetter = false;
                                break;
                            }
                    }
                }
            }

            System.out.println(robot.stringValuesForCSV());

            if (notBetter) {
                divisor++;
            }

            if (step < MINIMAL_STEP) {
                return null;
            }
        }

        double[] solution = new double[joints.length];

        for (int i = 0; i < solution.length; i++) {
            solution[i] = joints[i].getValue();
        }

        return solution;
    }

    public double[][] computeTrajectory() {

        final int nbValues = 10;

        double[][] values = new double[nbValues][robot.jointsNumber()];


        return values;
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
