package model.element.robot;

import model.element.connexion.joint.Joint;

import javax.vecmath.Point3d;
import java.util.ArrayList;
import java.util.List;

public class Solver {

    private static final double MINIMAL_DISTANCE = 0.0000001;
    private static final double MINIMAL_COMPUTE_STEP = MINIMAL_DISTANCE / 2.0;

    private static final double DEFAULT_STEP = 0.0001;

    private final Robot robot;

    private boolean[] lockJoints;

    private double step;

    private StringBuffer journal;

    public Solver(Robot robot) {

        this.robot = robot;

        lockJoints = new boolean[robot.jointsNumber()];

        for (int i = 0; i < lockJoints.length; i++) {
            lockJoints[i] = false;
        }

        step = DEFAULT_STEP;
        journal = null;
    }

    public void enableJournal() {
        journal = new StringBuffer();
    }

    public void disableJournal() {
        journal = null;
    }

    private static double distance(Robot subject, Point3d point) {

        subject.build();

        return Math.abs(point.distance(subject.getTerminalOrganPosition()));
    }

    private double[] compute(Robot subject, Point3d point) {

        Joint[] joints = subject.getJoints();

        double d = 0.0;

        double computeStep = distance(subject, point);

        while ((d = distance(subject, point)) > MINIMAL_DISTANCE) {

            boolean failed = true;

            for (int j = joints.length - 1; j >= 0; j--) {

                Joint joint = joints[j];

                if (!lockJoints[j]) {

                    double value = joint.getValue();

                    double[] testValues = {value + computeStep, value - computeStep};

                    for (double testValue : testValues) {

                            joint.setValueSafe(testValue);

                        if (distance(subject, point) >= d) {
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

    private static double nextPoint(double a, double t, double b) {
        return a * t + b;
    }

    public double[][] computeTrajectory(final Point3d destination) {

        Robot subject = (Robot) this.robot.clone();

        final Point3d origin = subject.getTerminalOrganPosition();

        Point3d vector = new Point3d(destination.x - origin.x, destination.y - origin.y, destination.z - origin.z);

        final double tMax = Math.abs((origin.x - destination.x) / -vector.x);

        List<double[]> values = new ArrayList<>();

        boolean success = true;

        Point3d point;

        for (double t = 0.0; t <= tMax; t += step) {

            point = new Point3d(nextPoint(vector.x, t, origin.x), nextPoint(vector.y, t, origin.y), nextPoint(vector.z, t, origin.z));

            double[] value = compute(subject, point);

            values.add(value);

            if (value == null) {
                success = false;
                break;
            }
        }

        if (!success) {
            return null;
        }

        double[][] result = new double[values.size()][];

        for (int i = 0; i < result.length; i++) {
            result[i] = values.get(i);
        }

        return result;
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
