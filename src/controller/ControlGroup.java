package controller;

import model.element.robot.Robot;
import view.RobotViewer;

import java.io.InputStream;
import java.io.PrintStream;


public class ControlGroup {
    public ControlGroup(Robot robot, RobotViewer view, InputStream inputStream, PrintStream outputStream) {

        Thread controllerRobotController = new Thread(new StreamsRobotController(robot, view, inputStream, outputStream));

        controllerRobotController.start();
    }
}
