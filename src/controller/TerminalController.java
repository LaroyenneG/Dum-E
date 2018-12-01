package controller;

import model.element.robot.Robot;
import view.RobotView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TerminalController extends AbstractController {

    private static final Map<String, Integer> COMMANDS = new HashMap<>();

    private static final String DRAW = "draw";
    private static final String RANDOM = "random";

    static {
        COMMANDS.put(DRAW, 0);
        COMMANDS.put(RANDOM, 1);
    }

    private Thread thread;

    public TerminalController(Robot model, RobotView view) {
        super(model, view);
        thread = new TerminalReader(this);
        thread.start();
    }

    private void execute(String line) {

        String[] args = line.split(" ");

        if (args.length < 1) {
            return;
        }

        if (COMMANDS.get(args[0]) == null) {
            System.err.println("Unknown command " + args[0]);
            return;
        }

        if (COMMANDS.get(args[0]) != args.length - 1) {
            System.err.println("invalid argument number");
            return;
        }

        switch (args[0]) {

            case RANDOM:
                model.getJoints()[0].setValue(Double.parseDouble(args[1]));
                break;

            case DRAW:
                displayView();
                break;

            default:
                throw new IllegalStateException("");
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

            while (!isInterrupted()) {

                try {

                    System.out.print(">>>");

                    String line = reader.readLine();

                    controller.execute(line);

                } catch (IOException e) {
                    break;
                }
            }
        }
    }
}
