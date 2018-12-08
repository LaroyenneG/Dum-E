package controller;

import model.element.robot.Robot;
import view.ElementVirtualization;
import view.RobotView;

public abstract class AbstractController {

    private static final int TIME_TO_SLEEP = 100;

    protected Robot model;
    protected RobotView view;

    public AbstractController(Robot model, RobotView view) {
        this.model = model;
        this.view = view;
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
}
