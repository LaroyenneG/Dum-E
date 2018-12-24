package controller;

import model.element.robot.Robot;
import view.RobotViewer;
import view.ViewRobotController;


public class ControlGroup {

    public ControlGroup(Robot robot, RobotViewer view, ViewRobotController viewRobotController) {
        ControllerRobotController controllerRobotController = new ControllerRobotController(robot, view, viewRobotController);
        viewRobotController.setActionEvent(controllerRobotController);
    }
}
