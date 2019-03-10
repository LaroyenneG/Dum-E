package controller;

import ia.DolorisException;
import model.element.robot.Robot;
import view.RobotViewer;

import java.io.*;

public class StreamsRobotController extends AbstractRobotController implements Runnable {


    private InputStream inputStream;
    private PrintStream outputStream;

    public StreamsRobotController(Robot model, RobotViewer view, InputStream inputStream, PrintStream outputStream) {
        super(model, view);
        computeAndSleepAndDisplay();
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }


    private void execute(String line) {

        String[] args = line.trim().split(" ");

        if (args.length == 2) {

            double joint = Double.parseDouble(args[0]);
            double value = Double.parseDouble(args[1]);

            try {
                changeJoint(joint, value);
            } catch (DolorisException e) {
                e.apply(outputStream);
            }
        }
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
