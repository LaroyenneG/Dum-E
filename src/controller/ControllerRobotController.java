package controller;

import model.element.robot.Robot;
import view.RobotViewer;

import java.io.*;

public class ControllerRobotController extends AbstractRobotController implements Runnable {

    private InputStream inputStream;
    private PrintStream outputStream;

    public ControllerRobotController(Robot model, RobotViewer view, InputStream inputStream, PrintStream outputStream) {
        super(model, view);
        computeAndSleepAndDisplay();
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }


    private void execute(String line) {

        String[] args = line.trim().split(" ");


    }

    @Override
    public void run() {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                execute(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
