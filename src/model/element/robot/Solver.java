package model.element.robot;

import model.element.connexion.joint.Joint;

import javax.vecmath.Point3d;

public class Solver {

    private static final double MINIMAL_DISTANCE = 0.0000001;
    private static final double MINIMAL_COMPUTE_STEP = MINIMAL_DISTANCE / 2.0;

    private static final double DEFAULT_STEP = 0.001;

    private final Robot robot;

    private boolean[] lockJoints;

    private Point3d point;

    private double step;

    private StringBuffer journal;

    public Solver(Robot robot, Point3d point) {

        this.robot = (Robot) robot.clone();

        lockJoints = new boolean[robot.jointsNumber()];

        for (int i = 0; i < lockJoints.length; i++) {
            lockJoints[i] = false;
        }

        this.point = point;

        step = DEFAULT_STEP;
        journal = null;
    }

    public void enableJournal() {
        journal = new StringBuffer();
    }

    public void disableJournal() {
        journal = null;
    }

    private double distance() {

        robot.build();

        return Math.abs(point.distance(robot.getTerminalOrganPosition()));
    }

    public double[] compute() {

        Joint[] joints = robot.getJoints();

        double d = 0.0;

        double computeStep = distance();

        while ((d = distance()) > MINIMAL_DISTANCE) {

            boolean failed = true;

            for (int j = joints.length - 1; j >= 0; j--) {

                Joint joint = joints[j];

                if (!lockJoints[j]) {

                    double value = joint.getValue();

                    double[] testValues = {value + computeStep, value - computeStep};

                    for (double testValue : testValues) {

                            joint.setValueSafe(testValue);

                        if (distance() >= d) {
                                joint.setValue(value);
                            } else {
                            failed = false;
                                break;
                            }
                    }
                }
            }

            if (failed) {
                computeStep /= 2.0;
            }

            if (computeStep <= MINIMAL_COMPUTE_STEP) {
                return null;
            }

            if (journal != null) {
                journal.append(this.robot.stringValuesForCSV());
                journal.append('\n');
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

    public String getJournal() {
        return new String(journal);
    }

    public void purgeJournal() {
        journal = new StringBuffer();
    }
}
