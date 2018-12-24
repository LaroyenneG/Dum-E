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
    private static final String BUILD = "build";
    private static final String JOINTS_TEST = "test";
    private static final String STEP = "step";
    private static final String POINT = "point";
    private static final String WHERE = "where";
    private static final String DRAW = "draw";
    private static final String LOCKER = "locker";
    private static final String JOINT = "joint";
    private static final String ORGAN = "organ";
    private static final String REACH = "reach";


    static {
        COMMANDS.add(DISPLAY);
        COMMANDS.add(AXIS);
        COMMANDS.add(LIGHT);
        COMMANDS.add(ORBIT);
        COMMANDS.add(CLEAR);
        COMMANDS.add(EXIT);
        COMMANDS.add(BASIC);
        COMMANDS.add(AUTO);
        COMMANDS.add(ANIMATION);
        COMMANDS.add(HELP);
        COMMANDS.add(MATRIX);
        COMMANDS.add(BUILD);
        COMMANDS.add(JOINTS_TEST);
        COMMANDS.add(STEP);
        COMMANDS.add(POINT);
        COMMANDS.add(WHERE);
        COMMANDS.add(DRAW);
        COMMANDS.add(LOCKER);
        COMMANDS.add(JOINT);
        COMMANDS.add(ORGAN);
        COMMANDS.add(REACH);
    }


    public ControllerRobotController(Robot model, RobotViewer view, ViewRobotController viewRobotController) {
        super(model, view, viewRobotController);
    }

    private void usage(String cmd, String args) {
        viewRobotController.addTextInConsole("Usage : " + cmd + " " + args);
    }

    private void execute(String line) {

        String[] args = line.split(" ");

        if (args.length < 1) {
            return;
        }

        if (!COMMANDS.contains(args[0])) {
            viewRobotController.addTextInConsole("Unknown command " + args[0]);
            return;
        }

        switch (args[0]) {

            case DISPLAY:
                displayView();
                break;

            case BUILD:
                model.build();
                break;

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
                    randomAnimation(300, getStep());
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
                viewRobotController.addTextInConsole(model.toString());
                break;

            case HELP:
                viewRobotController.addTextInConsole("Commands list :");
                for (String cmd : COMMANDS) {
                    viewRobotController.addTextInConsole("\t- " + cmd);
                }
                break;

            case JOINTS_TEST:
                try {
                    int number = -1;
                    if (args.length >= 2) {
                        number = Integer.parseInt(args[1]);
                    }
                    jointsTest(getStep(), number);
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

            case POINT:
                if (args.length < 4) {
                    usage(POINT, "<x> <y> <z>");
                } else {
                    try {
                        Point3d point3d = new Point3d(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));

                        if (terminalOrganGotoPoint(point3d)) {
                            viewRobotController.addTextInConsole("Can't find solution...");
                        }
                    } catch (NumberFormatException e) {
                        usage(POINT, "<x> <y> <z>");
                    }
                }
                break;

            case WHERE:
                viewRobotController.addTextInConsole("The terminal organ of the robot is here : " + model.getTerminalOrganPosition());
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
                        viewRobotController.addTextInConsole("Can't read file '" + args[1] + "'");
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
                    usage(LOCKER, "<number> <value>");
                } else {
                    try {
                        int number = Integer.parseInt(args[1]) - 1;
                        double value = Double.parseDouble(args[2]);

                        Joint[] joints = model.getJoints();

                        if (number < 0 || number >= joints.length) {
                            viewRobotController.addTextInConsole("Invalid joint number");
                            return;
                        }

                        if (joints[number].max <= value || value <= joints[number].min) {
                            viewRobotController.addTextInConsole("Invalid value, value must be between [" + joints[number].min + ", " + joints[number].max + "]");
                            return;
                        }

                        joints[number].setValueSafe(value);

                        computeAndSleepAndDisplay();

                    } catch (NumberFormatException e) {
                        usage(LOCKER, "<number> <value>");
                    }
                }
                break;

            case ORGAN:
                if (args.length < 2) {
                    usage(LOCKER, "<on/off>");
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
                    } catch (NumberFormatException e) {
                        usage(LOCKER, "<on/off>");
                    }
                }
                break;

            case REACH:
                if (args.length < 4) {
                    usage(POINT, "<x> <y> <z>");
                } else {
                    try {
                        Point3d point3d = new Point3d(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));

                        if (terminalOrganReachPoint(point3d)) {
                            viewRobotController.addTextInConsole("Can't find solution...");
                        }
                    } catch (NumberFormatException e) {
                        usage(POINT, "<x> <y> <z>");
                    }
                }
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
