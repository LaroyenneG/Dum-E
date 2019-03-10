package controller;

import model.element.robot.Robot;
import view.ElementVirtualization;
import view.RobotViewer;

public abstract class AbstractRobotController {


    private static final int CLOCK = 50;
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
