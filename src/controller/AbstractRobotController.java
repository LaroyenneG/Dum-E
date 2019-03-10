package controller;

import ia.DolorisException;
import model.element.connexion.joint.Joint;
import model.element.robot.Robot;
import view.ElementVirtualization;
import view.RobotViewer;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

public abstract class AbstractRobotController {

    protected static final int CLOCK = 50;
    public static final double DEFAULT_STEP = 0.02;

    private static double step = DEFAULT_STEP;

    protected Robot model;
    protected RobotViewer view;

    public AbstractRobotController(Robot model, RobotViewer view) {
        this.model = model;
        this.view = view;
    }

    protected static synchronized double getStep() {
        return step;
    }

    protected static synchronized void setStep(double step) {
        AbstractRobotController.step = step;
    }

    protected void changeJoint(double range, double value) throws DolorisException {

        final int jointNumber = model.jointsNumber();

        final int tmp = (int) (Math.abs(range) * jointNumber % jointNumber);

        int jointId = (tmp < 0) ? tmp + jointNumber : tmp;

        Joint joint = model.getJoints()[jointId];

        final double nValue = joint.getValue() + step * value;

        joint.setValueSafe(nValue);

        if (nValue >= joint.max || nValue <= joint.min) {
            throw new DolorisException();
        }
    }

    protected double distanceWithGround() {

        Vector3d vector = model.getTerminalOrgan().getVector();
        Point3d position = model.getTerminalOrgan().getPosition();

        double t = -position.y / vector.y;

        Point3d ground = new Point3d(vector.x * t + position.x, vector.y * t + position.y, vector.z * t + position.z);

        return position.distance(ground);
    }

    protected void checkPosition() throws DolorisException {

        Joint[] joints = model.getJoints();

        for (Joint joint : joints) {

            Point3d position = joint.getPosition();

            if (position.y < 0) {
                throw new DolorisException();
            }
        }
    }

    protected void computeAndSleepAndDisplay() {

        Thread[] threads = new Thread[2];

        threads[0] = new Thread(() -> model.build());

        threads[1] = new Thread(() -> {
            try {
                Thread.sleep(CLOCK);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        displayView();
    }

    protected void displayView() {

        ElementVirtualization virtualization = new ElementVirtualization();

        model.accept(virtualization);

        view.setNewScene(virtualization.getResult());
    }
}
