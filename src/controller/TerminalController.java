package controller;

import model.element.robot.Robot;
import view.RobotView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalController extends AbstractController {

    private Thread thread;

    public TerminalController(Robot model, RobotView view) {
        super(model, view);
        thread = new TerminalReader(this);
        thread.start();
    }

    private void execute(String line) {

        String[] args = line.split(" ");

        switch (args[0]) {

            case "random":
                model.getJoints()[0].setValue(Double.parseDouble(args[1]));
                break;

            case "draw":
                displayView();
                break;

            default:
                System.err.println("Unknown command " + args[0]);
                break;
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
