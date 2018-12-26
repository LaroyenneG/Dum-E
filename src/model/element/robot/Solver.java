package model.element.robot;

import model.element.connexion.joint.Joint;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Solver {

    private static final double MINIMAL_DISTANCE = 0.0000001;
    private static final double MINIMAL_COMPUTE_STEP = MINIMAL_DISTANCE / 2.0;

    private static final double DEFAULT_STEP = 0.0001;

    private final Robot robot;

    private boolean[] lockJoints;

    private double step;

    private Robot session;

    public Solver(Robot robot) {

        this.robot = robot;

        lockJoints = new boolean[robot.jointsNumber()];

        for (int i = 0; i < lockJoints.length; i++) {
            lockJoints[i] = false;
        }

        session = null;

        step = DEFAULT_STEP;
    }

    private static double distance(Robot subject, Point3d point) {

        subject.build();

        return Math.abs(point.distance(subject.getTerminalOrganPosition()));
    }

    static double[] findSolution(StringBuffer journal, boolean[] lockJoints, Robot subject, Point3d point) {

        Joint[] joints = subject.getJoints();

        double d = 0.0;

        double computeStep = distance(subject, point);

        while ((d = distance(subject, point)) > MINIMAL_DISTANCE) {

            boolean failed = true;

            for (int j = 0; j < joints.length; j++) {

                Joint joint = joints[j];

                if (lockJoints == null || !lockJoints[j]) {

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
                printLineInJournal(journal, subject, d);
            }
        }

        double[] solution = new double[joints.length];

        for (int i = 0; i < solution.length; i++) {
            solution[i] = joints[i].getValue();
        }

        return solution;
    }

    public static void printJournalHeader(StringBuffer journal, int jointNumber) {

        for (int i = 1; i <= jointNumber; i++) {
            journal.append('q');
            journal.append(i);
            journal.append(';');
        }
        journal.append("distance\n");
    }

    private static void printLineInJournal(StringBuffer journal, Robot robot, double distance) {

        final DecimalFormat decimalFormat = new DecimalFormat("##.#######");

        for (Joint joint : robot.getJoints()) {
            journal.append(decimalFormat.format(joint.getValue()));
            journal.append(';');
        }

        journal.append(decimalFormat.format(distance));
        journal.append('\n');
    }

    private static Double computeTmax(Vector3d vector, Point3d origin, Point3d destination) {

        if (vector.x != 0) {
            return Math.abs((origin.x - destination.x) / -vector.x);
        } else if (vector.y != 0) {
            return Math.abs((origin.y - destination.y) / -vector.y);
        } else if (vector.z != 0) {
            return Math.abs((origin.z - destination.z) / -vector.z);
        }
        return null;
    }

    private static Point3d nextPoint(Vector3d vector, double t, Point3d origin) {

        return new Point3d(vector.x * t + origin.x, vector.y * t + origin.y, vector.z * t + origin.z);
    }

    private double[] compute(Robot subject, Point3d point) {

        return findSolution(null, lockJoints, subject, point);
    }

    public double[][] computeTrajectory(final Point3d destination) {

        Robot subject = getSubject();

        if (distance(subject, destination) <= MINIMAL_DISTANCE) {  // First building
            return new double[0][0];
        }

        final Point3d origin = subject.getTerminalOrganPosition();

        Vector3d vector = new Vector3d(destination.x - origin.x, destination.y - origin.y, destination.z - origin.z);

        final Double tMax = computeTmax(vector, origin, destination);
        if (tMax == null) {
            return null;
        }

        List<double[]> values = new ArrayList<>();

        Point3d point;

        for (double t = 0.0; t <= tMax; t += step) {

            point = nextPoint(vector, t, origin);

            double[] value = compute(subject, point);

            if (value == null) {
                return null;
            }

            values.add(value);
        }

        values.add(compute(subject, destination));

        double[][] result = new double[values.size()][];

        for (int i = 0; i < result.length; i++) {
            result[i] = values.get(i);
            if (result[i] == null) {
                return null;
            }
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

    public double[] reachDirectlyPoint(Point3d destination) {

        Robot subject = getSubject();

        if (distance(subject, destination) <= MINIMAL_DISTANCE) {  // First building
            return new double[0];
        }

        return compute(subject, destination);
    }

    public void startSession() {
        session = (Robot) this.robot.clone();
    }

    public void closeSession() {
        session = null;
    }

    private Robot getSubject() {
        return (session == null) ? (Robot) this.robot.clone() : session;
    }
}
