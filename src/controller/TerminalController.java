package controller;

import model.element.robot.Robot;
import view.RobotView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TerminalController extends AbstractController {

    private Thread thread;

    public TerminalController(Robot model, RobotView view) {
        super(model, view);
        thread = new TerminalReader(System.in, this);
        thread.start();
    }

    private void execute(String line) {

    }

    private static class TerminalReader extends Thread {

        private TerminalController controller;
        private BufferedReader reader;

        public TerminalReader(InputStream stream, TerminalController controller) {
            reader = new BufferedReader(new InputStreamReader(stream));
            this.controller = controller;
        }

        @Override
        public void run() {

            while (!isInterrupted()) {

                try {
                    String line = reader.readLine();

                    controller.execute(line);

                } catch (IOException e) {
                    break;
                }
            }
        }
    }
}
