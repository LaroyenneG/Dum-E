package controller;

import model.element.connexion.joint.Joint;
import model.element.robot.Robot;
import model.element.robot.Solver;
import view.ElementVirtualization;
import view.RobotViewer;
import view.ViewRobotController;

import javax.vecmath.Point3d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.SecureRandom;

public abstract class AbstractRobotController {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private static final int CLOCK = 50;
    public static final double DEFAULT_STEP = 0.01;

    private static double step = DEFAULT_STEP;

    private static Solver solver;

    protected Robot model;
    protected RobotViewer view;
    protected ViewRobotController viewRobotController;


    public AbstractRobotController(Robot model, RobotViewer view, ViewRobotController viewRobotController) {
        this.model = model;
        this.view = view;
        this.viewRobotController = viewRobotController;
    }

    private synchronized Solver getSolver() {

        if (solver == null) {
            solver = new Solver(model);
        }

        return solver;
    }

    protected static boolean myRandom(int v) {

        boolean result = true;

        for (int i = 0; i < v; i++) {
            result &= SECURE_RANDOM.nextBoolean();
        }

        return result;
    }

    protected void jointsTest(double step, int number) {

        viewRobotController.addTextInConsole("Test is running...");

        Joint[] joints = model.getJoints();

        if (number >= joints.length) {
            number = -1;
        }

        for (int i = (number < 0) ? 0 : number; i < ((number < 0) ? joints.length : number); i++) {

            viewRobotController.addTextInConsole("\t- Test joint number " + (i + 1));

            Joint joint = joints[i];

            final int maxCycle = (joint.min == -Double.MAX_VALUE || joint.max == Double.MAX_VALUE) ? (int) (1 / step * Math.PI * 2) : Integer.MAX_VALUE;

            int cycle = 0;

            for (double v = joint.getValue(); v > joint.min; v -= step, cycle++) {

                joint.setValue(v);
                computeAndSleepAndDisplay();

                if (cycle > maxCycle) {
                    break;
                }
            }

            for (double v = joint.getValue(); v < joint.max; v += step, cycle++) {

                joint.setValue(v);
                computeAndSleepAndDisplay();

                if (cycle > maxCycle) {
                    break;
                }
            }
        }

    }

    protected void randomAnimation(int cycle, double p) {

        Joint[] joints = model.getJoints();

        boolean[] status = new boolean[joints.length]; // true + / false -

        for (int i = 0; i < status.length; i++) {
            status[i] = SECURE_RANDOM.nextBoolean();
        }

        for (int i = 0; i < cycle; i++) {

            for (int j = 0; j < joints.length; j++) {

                double v = joints[j].getValue();

                if (status[j]) { // +
                    if (v + p >= joints[j].max) {
                        status[j] = false;
                    }
                } else { // -
                    if (v - p <= joints[j].min) {
                        status[j] = true;
                    }
                }

                v += (status[j]) ? p : -p;

                if (v < joints[j].max && v > joints[j].min) {
                    joints[j].setValue(v);
                } else {
                    viewRobotController.addTextInConsole("bad parameters" + v);
                    return;
                }
            }

            if (myRandom(4)) {
                for (int s = 0; s < status.length; s++) {
                    status[s] = SECURE_RANDOM.nextBoolean();
                }
            }

            computeAndSleepAndDisplay();
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

    public static synchronized void setStep(double step) {
        AbstractRobotController.step = step;
    }

    public static synchronized double getStep() {
        return step;
    }

    protected boolean terminalOrganGotoPoint(Point3d point) {

        Solver solver = getSolver();

        solver.setStep(getStep());

        double[][] solutions = solver.computeTrajectory(point);

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

    protected boolean terminalOrganReachPoint(Point3d point) {

        Solver solver = getSolver();

        solver.setStep(getStep());

        double[] solution = solver.reachDirectlyPoint(point);

        if (solution == null) {
            return true;
        }

        final Joint[] joints = model.getJoints();

        for (int i = 0; i < solution.length; i++) {
            joints[i].setValue(solution[i]);
        }

        computeAndSleepAndDisplay();

        return false;
    }

    protected void automate(InputStream stream) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] parameters = line.split(" ");

            if (parameters.length != 3) {
                viewRobotController.addTextInConsole("Invalid data format");
                return;
            }

            try {
                double x = Double.parseDouble(parameters[0]);
                double y = Double.parseDouble(parameters[1]);
                double z = Double.parseDouble(parameters[2]);

                Point3d point = new Point3d(x, y, z);

                if (terminalOrganGotoPoint(point)) {
                    viewRobotController.addTextInConsole("Can't set terminal organ at this position " + point);
                    return;
                }
            } catch (NumberFormatException e) {
                viewRobotController.addTextInConsole("Invalid number format");
                return;
            }
        }
    }

    protected void jointLocker(int number, boolean state) {

        if (number < 0 || number >= model.jointsNumber()) {
            viewRobotController.addTextInConsole("Invalid joint number");
            return;
        }

        Solver solver = getSolver();

        if (state) {
            solver.lockJoint(number);
        } else {
            solver.unlockJoint(number);
        }
    }
}
