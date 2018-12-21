package controller;

import model.element.connexion.joint.Joint;
import model.element.robot.Robot;
import view.RobotView;

import javax.vecmath.Point3d;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TerminalController extends AbstractRobotController {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private static final Map<String, Integer> COMMANDS = new HashMap<>();

    private static final String DISPLAY = "display";
    private static final String AXIS = "axis";
    private static final String LIGHT = "light";
    private static final String ORBIT = "orbit";
    private static final String CLEAR = "clear";
    private static final String EXIT = "exit";
    private static final String BASIC = "basic";
    private static final String AUTO = "auto";
    private static final String ANIMATION = "animation";
    private static final String HELP = "help";
    private static final String MATRIX = "matrix";
    private static final String COMPUTE = "compute";
    private static final String JOINTS_TEST = "test";
    private static final String STEP = "step";
    private static final String POINT = "point";
    private static final String WHERE = "where";
    private static final String DRAW = "draw";


    static {
        COMMANDS.put(DISPLAY, 0);
        COMMANDS.put(AXIS, 1);
        COMMANDS.put(LIGHT, 1);
        COMMANDS.put(ORBIT, 1);
        COMMANDS.put(CLEAR, 0);
        COMMANDS.put(EXIT, 0);
        COMMANDS.put(BASIC, 0);
        COMMANDS.put(AUTO, 0);
        COMMANDS.put(ANIMATION, 1);
        COMMANDS.put(HELP, 0);
        COMMANDS.put(MATRIX, 0);
        COMMANDS.put(COMPUTE, 0);
        COMMANDS.put(JOINTS_TEST, 0);
        COMMANDS.put(STEP, 1);
        COMMANDS.put(POINT, 3);
        COMMANDS.put(WHERE, 0);
        COMMANDS.put(DRAW, 1);
    }

    private final Thread thread;


    public TerminalController(Robot model, RobotView view) {
        super(model, view);
        thread = new TerminalReader(this);
        thread.start();
    }

    private static boolean myRandom(int v) {

        final Random random = new SecureRandom();

        boolean result = true;

        for (int i = 0; i < v; i++) {
            result &= random.nextBoolean();
        }

        return result;
    }

    private void randomAnimation(int cycle, double p) {

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
                    System.out.println("bad parameters" + v);
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

    private static void usage(String cmd, String args) {
        System.out.println("Usage : " + cmd + " " + args);
    }

    private void execute(String line) {

        String[] args = line.split(" ");

        if (args.length < 1) {
            return;
        }

        if (COMMANDS.get(args[0]) == null) {
            System.out.println("Unknown command " + args[0]);
            return;
        }

        if (COMMANDS.get(args[0]) != args.length - 1) {
            System.out.println("invalid argument number");
            return;
        }

        switch (args[0]) {

            case DISPLAY:
                displayView();
                break;

            case COMPUTE:
                model.build();
                break;

            case LIGHT:
                if (args[1].equals("on")) {
                    view.addBackground();
                } else if (args[1].equals("off")) {
                    view.removeBackground();
                } else {
                    usage(LIGHT, "<on/off>");
                }
                break;

            case AXIS:
                if (args[1].equals("on")) {
                    view.addAxis();
                } else if (args[1].equals("off")) {
                    view.removeAxis();
                } else {
                    usage(AXIS, "<on/off>");
                }
                break;

            case ORBIT:
                if (args[1].equals("on")) {
                    view.addOrbitBehavior();
                } else if (args[1].equals("off")) {
                    view.removeOrbitBehavior();
                } else {
                    usage(ORBIT, "<on/off>");
                }
                break;

            case CLEAR:
                if (args.length == 1) {
                    view.clear();
                } else if (args.length == 2 && args[1].equals("all")) {
                    view.clearAll();
                } else {
                    usage(CLEAR, "<option>");
                }
                break;

            case ANIMATION:
                if (args[1].equals("max")) {
                    args[1] = String.valueOf(Integer.MAX_VALUE);
                }

                try {
                    randomAnimation(Integer.parseInt(args[1]), getStep());
                } catch (NumberFormatException e) {
                    usage(ANIMATION, "<cycles>");
                }
                break;

            case EXIT:
                System.exit(0);
                break;

            case BASIC:
                view.addOrbitBehavior();
                view.addBackground();
                view.addAxis();
                break;

            case AUTO:
                model.build();
                view.addOrbitBehavior();
                view.addBackground();
                view.addAxis();
                displayView();
                break;

            case MATRIX:
                System.out.println(model);
                break;

            case HELP:
                System.out.println("Commands list :");
                for (String cmd : COMMANDS.keySet()) {
                    System.out.println("\t\t\t\t- " + cmd);
                }
                break;

            case JOINTS_TEST:
                jointsTest(getStep());
                break;

            case STEP:
                try {
                    setStep(Double.parseDouble(args[1]));
                } catch (NumberFormatException e) {
                    usage(STEP, "<pas>");
                }
                break;

            case POINT:
                try {
                    Point3d point3d = new Point3d(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));

                    if (setTerminalOrganOnPoint(point3d)) {
                        System.out.println("Can't find solution...");
                    }
                } catch (NumberFormatException e) {
                    usage(POINT, "<x> <y> <z>");
                }
                break;

            case WHERE:
                System.out.println("The terminal organ of the robot is here : " + model.getTerminalOrganPosition());
                break;

            case DRAW:
                try {
                    FileInputStream inputStream = new FileInputStream("asset/" + args[1] + ".robot");
                    automate(inputStream);
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("Can't read file '" + args[1] + "'");
                }
                break;

            default:
                throw new IllegalStateException("");
        }
    }

    private void jointsTest(double pas) {

        System.out.println("Test is running...");

        Joint[] joints = model.getJoints();

        for (int i = 0; i < joints.length; i++) {

            System.out.println("\t- Test joint number " + i);

            Joint joint = joints[i];

            final int maxCycle = (joint.min == Double.MIN_VALUE || joint.max == Double.MAX_VALUE) ? (int) (1 / pas * Math.PI * 2) : Integer.MAX_VALUE;

            int cycle = 0;

            for (double v = joint.getValue(); v > joint.min; v -= pas, cycle++) {

                joint.setValue(v);
                computeAndSleepAndDisplay();

                if (cycle > maxCycle) {
                    break;
                }
            }

            for (double v = joint.getValue(); v < joint.max; v += pas, cycle++) {

                joint.setValue(v);
                computeAndSleepAndDisplay();

                if (cycle > maxCycle) {
                    break;
                }
            }
        }

    }

    private static class TerminalReader extends Thread {

        private TerminalController controller;
        private BufferedReader reader;

        public TerminalReader(TerminalController controller) {
            this.controller = controller;
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        @Override
        public void run() {

            System.out.println("--------------------------------------------------------------------------------------------------------");

            while (!isInterrupted()) {

                try {

                    System.out.print(">>> ");

                    String line = reader.readLine();

                    controller.execute(line);

                } catch (IOException e) {
                    break;
                }
            }
        }
    }
}
