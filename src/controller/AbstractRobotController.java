package controller;

import model.element.connexion.joint.Joint;
import model.element.robot.Robot;
import model.element.robot.Solver;
import view.ElementVirtualization;
import view.RobotView;

import javax.vecmath.Point3d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class AbstractRobotController {

    private static final int CLOCK = 50;
    public static final double DEFAULT_STEP = 0.01;

    private static double step = DEFAULT_STEP;

    protected Robot model;
    protected RobotView view;

    public AbstractRobotController(Robot model, RobotView view) {
        this.model = model;
        this.view = view;
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

    public static synchronized void setStep(double step) {
        AbstractRobotController.step = step;
    }

    public static synchronized double getStep() {
        return step;
    }

    protected boolean setTerminalOrganOnPoint(Point3d point3d) {

        Solver solver = new Solver(model, point3d);
        solver.setStep(getStep());

        double[][] solutions = solver.computeTrajectory();

        if (solutions == null) {
            return true;
        }

        final Joint[] joints = model.getJoints();

        for (double[] solution : solutions) {

            for (int i = 0; i < joints.length; i++) {
                joints[i].setValue(solution[i]);
            }

            computeAndSleepAndDisplay();
        }

        return false;
    }

    protected void automate(InputStream stream) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] parameters = line.split(" ");

            if (parameters.length != 3) {
                System.out.println("Invalid data format");
                return;
            }

            try {
                double x = Double.parseDouble(parameters[0]);
                double y = Double.parseDouble(parameters[1]);
                double z = Double.parseDouble(parameters[2]);

                Point3d point = new Point3d(x, y, z);

                if (setTerminalOrganOnPoint(point)) {
                    System.out.println("Can't set terminal organ at this position " + point);
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
                return;
            }
        }
    }

    protected void jointLocker(int number, boolean state) {

        if (number < 0 || number >= model.jointsNumber()) {
            System.out.println("Invalid joint number");
            return;
        }


    }
}
