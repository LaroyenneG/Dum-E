package controller;

import model.element.Solver;
import model.element.connexion.joint.Joint;
import model.element.robot.Robot;
import view.ElementVirtualization;
import view.RobotView;

import javax.vecmath.Point3d;

public abstract class AbstractRobotController {

    private static final int TIME_TO_SLEEP = 100;
    public static final double DEFAULT_STEP = 0.01;

    private static double step = DEFAULT_STEP;

    protected Robot model;
    protected RobotView view;

    public AbstractRobotController(Robot model, RobotView view) {
        this.model = model;
        this.view = view;
    }

    public static synchronized double getStep() {
        return step;
    }


    protected void computeAndSleepAndDisplay() {

        Thread[] threads = new Thread[2];

        threads[0] = new Thread(() -> model.build());

        threads[1] = new Thread(() -> {
            try {
                Thread.sleep(TIME_TO_SLEEP);
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

    public static synchronized void setStep(double step) {
        AbstractRobotController.step = step;
    }

    protected boolean setTerminalOrganOnPoint(Point3d point3d) {

        Solver<Robot> solver = new Solver<>(model, point3d);

        double[] solution = solver.compute();

        if (solution == null) {
            return false;
        }

        Joint[] joints = model.getJoints();

        for (int i = 0; i < joints.length; i++) {
            joints[i].setValue(solution[i]);
        }

        return true;
    }
}
