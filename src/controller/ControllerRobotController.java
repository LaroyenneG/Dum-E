package controller;

import model.element.connexion.joint.Joint;
import model.element.robot.Robot;
import view.RobotViewer;
import view.ViewRobotController;

import javax.vecmath.Point3d;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ControllerRobotController extends AbstractRobotController implements ActionListener {

    private static final Set<String> COMMANDS = new HashSet<>();

    private static final String AXIS = "axis";
    private static final String LIGHT = "light";
    private static final String ORBIT = "orbit";
    private static final String CLEAR = "clear";
    private static final String EXIT = "exit";
    private static final String AUTO = "auto";
    private static final String ANIMATION = "animation";
    private static final String HELP = "help";
    private static final String MATRIX = "matrix";
    private static final String JOINTS_TEST = "test";
    private static final String STEP = "step";
    private static final String GO = "go";
    private static final String WHERE = "where";
    private static final String DRAW = "draw";
    private static final String LOCKER = "locker";
    private static final String JOINT = "joint";
    private static final String ORGAN = "organ";
    private static final String REACH = "reach";
    private static final String VALUES = "values";


    static {
        COMMANDS.add(AXIS);
        COMMANDS.add(LIGHT);
        COMMANDS.add(ORBIT);
        COMMANDS.add(CLEAR);
        COMMANDS.add(EXIT);
        COMMANDS.add(AUTO);
        COMMANDS.add(ANIMATION);
        COMMANDS.add(HELP);
        COMMANDS.add(MATRIX);
        COMMANDS.add(JOINTS_TEST);
        COMMANDS.add(STEP);
        COMMANDS.add(GO);
        COMMANDS.add(WHERE);
        COMMANDS.add(DRAW);
        COMMANDS.add(LOCKER);
        COMMANDS.add(JOINT);
        COMMANDS.add(ORGAN);
        COMMANDS.add(REACH);
        COMMANDS.add(VALUES);
    }


    public ControllerRobotController(Robot model, RobotViewer view, ViewRobotController viewRobotController) {
        super(model, view, viewRobotController);
        computeAndSleepAndDisplay();
    }

    private void usage(String cmd, String args) {
        viewRobotController.printLineInConsole("Usage : " + cmd + " " + args);
    }

    private void execute(String line) {

        String[] args = line.trim().split(" ");

        if (args.length < 1) {
            return;
        }

        if (!COMMANDS.contains(args[0])) {
            viewRobotController.printLineInConsole("Unknown command " + args[0]);
            return;
        }

        switch (args[0]) {

            case LIGHT:
                if (args.length < 2) {
                    usage(LIGHT, "<on/off>");
                } else {
                    if (args[1].equals("on")) {
                        view.addBackground();
                    } else if (args[1].equals("off")) {
                        view.removeBackground();
                    } else {
                        usage(LIGHT, "<on/off>");
                    }
                }
                break;

            case AXIS:
                if (args.length < 2) {
                    usage(AXIS, "<on/off>");
                } else {
                    if (args[1].equals("on")) {
                        view.addAxis();
                    } else if (args[1].equals("off")) {
                        view.removeAxis();
                    } else {
                        usage(AXIS, "<on/off>");
                    }
                }
                break;

            case ORBIT:
                if (args.length < 2) {
                    usage(ORBIT, "<on/off>");
                } else {
                    if (args[1].equals("on")) {
                        view.addOrbitBehavior();
                    } else if (args[1].equals("off")) {
                        view.removeOrbitBehavior();
                    } else {
                        usage(ORBIT, "<on/off>");
                    }
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
                if (args.length == 2 && args[1].equals("max")) {
                    args[1] = String.valueOf(Integer.MAX_VALUE);
                } else if (args.length == 2) {
                    try {
                        randomAnimation(Integer.parseInt(args[1]), getStep());
                    } catch (NumberFormatException e) {
                        usage(ANIMATION, "<cycles>");
                    }
                } else {
                    randomAnimation(300, getStep() / 2);
                }
                break;

            case EXIT:
                System.exit(0);
                break;

            case AUTO:
                model.build();
                view.addOrbitBehavior();
                view.addBackground();
                view.addAxis();
                displayView();
                break;

            case MATRIX:
                viewRobotController.printLineInConsole(model.toString());
                break;

            case HELP:
                StringBuilder builder = new StringBuilder();
                builder.append("Commands list :\n");
                for (String cmd : COMMANDS) {
                    builder.append("\t- ");
                    builder.append(cmd);
                    builder.append('\n');
                }
                viewRobotController.printLineInConsole(new String(builder));
                break;

            case JOINTS_TEST:
                try {
                    if (args.length >= 2) {
                        int number = Integer.parseInt(args[1]) - 1;
                        testJoint(getStep(), number);
                    } else {
                        testAllJoints(getStep());
                    }
                } catch (NumberFormatException e) {
                    usage(JOINTS_TEST, "<joint number>");
                }
                break;

            case STEP:
                if (args.length < 2) {
                    usage(STEP, "<pas>");
                } else {
                    try {
                        setStep(Double.parseDouble(args[1]));
                    } catch (NumberFormatException e) {
                        usage(STEP, "<pas>");
                    }
                }
                break;

            case GO:
                if (args.length < 4) {
                    usage(GO, "<x> <y> <z>");
                } else {
                    try {
                        Point3d point3d = new Point3d(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));

                        if (terminalOrganGotoPoint(point3d)) {
                            viewRobotController.printLineInConsole("Can't find solution...");
                        }
                    } catch (NumberFormatException e) {
                        usage(GO, "<x> <y> <z>");
                    }
                }
                break;

            case WHERE:
                viewRobotController.printLineInConsole("The terminal organ of the robot is here : " + model.getTerminalOrganPosition());
                break;

            case DRAW:
                if (args.length < 2) {
                    usage(DRAW, "<file name>");
                } else {
                    try {
                        FileInputStream inputStream = new FileInputStream("asset/" + args[1] + ".robot");
                        automate(inputStream);
                        inputStream.close();
                    } catch (IOException e) {
                        viewRobotController.printLineInConsole("Can't read file '" + args[1] + "'");
                    }
                }
                break;

            case LOCKER:
                if (args.length < 3) {
                    usage(LOCKER, "<number> <on/off>");
                } else {
                    try {
                        int number = Integer.parseInt(args[1]) - 1;
                        boolean state;

                        if (args[2].equals("on")) {
                            state = true;
                        } else if (args[2].equals("off")) {
                            state = false;
                        } else {
                            usage(LOCKER, "<number> <on/off>");
                            return;
                        }
                        jointLocker(number, state);
                    } catch (NumberFormatException e) {
                        usage(LOCKER, "<number> <on/off>");
                    }
                }
                break;

            case JOINT:
                if (args.length < 3) {
                    usage(JOINT, "<number> <value>");
                } else {
                    try {
                        int number = Integer.parseInt(args[1]) - 1;
                        double value = Double.parseDouble(args[2]);

                        Joint[] joints = model.getJoints();

                        if (number < 0 || number >= joints.length) {
                            viewRobotController.printLineInConsole("Invalid joint number");
                            return;
                        }

                        if (joints[number].max <= value || value <= joints[number].min) {
                            viewRobotController.printLineInConsole("Invalid value, value must be between [" + joints[number].min + ", " + joints[number].max + "]");
                            return;
                        }

                        joints[number].setValueSafe(value);

                        computeAndSleepAndDisplay();

                    } catch (NumberFormatException e) {
                        usage(JOINT, "<number> <value>");
                    }
                }
                break;

            case ORGAN:
                if (args.length < 2) {
                    usage(ORGAN, "<on/off>");
                } else {
                    try {
                        boolean state;
                        if (args[1].equals("on")) {
                            state = true;
                        } else if (args[1].equals("off")) {
                            state = false;
                        } else {
                            usage(LOCKER, "<on/off>");
                            return;
                        }
                        model.getTerminalOrgan().setAction(state);
                        displayView();
                    } catch (NumberFormatException e) {
                        usage(ORGAN, "<on/off>");
                    }
                }
                break;

            case REACH:
                if (args.length < 4) {
                    usage(GO, "<x> <y> <z>");
                } else {
                    try {
                        Point3d point3d = new Point3d(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));

                        if (terminalOrganReachPoint(point3d)) {
                            viewRobotController.printLineInConsole("Can't find solution...");
                        }
                    } catch (NumberFormatException e) {
                        usage(GO, "<x> <y> <z>");
                    }
                }
                break;

            case VALUES:
                Joint[] joints = model.getJoints();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[");
                for (int j = 0; j < joints.length; j++) {
                    stringBuilder.append("q").append(j + 1).append("=").append(joints[j].getValue());
                    if (j < joints.length - 1) {
                        stringBuilder.append(", ");
                    }
                }
                stringBuilder.append("]");
                viewRobotController.printLineInConsole(new String(stringBuilder));
                break;

            default:
                throw new IllegalStateException("XD");
        }
    }

    private synchronized void readCommand() {

        final String cmd = viewRobotController.purgeInputText();

        viewRobotController.disableInput();

        Thread thread = new Thread(() -> {
            execute(cmd);
            viewRobotController.enableInput();
        });

        thread.start();
    }

    @Override // execute button
    public void actionPerformed(ActionEvent actionEvent) {
        readCommand();
    }
}
