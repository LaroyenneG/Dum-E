package controller;

import model.element.robot.Robot;
import view.RobotView;


public class ControlGroup {

    public ControlGroup(Robot robot, RobotView view) {
        new TerminalController(robot, view);
    }
}
