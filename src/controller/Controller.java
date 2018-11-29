package controller;

import model.element.robot.Robot;
import view.RobotView;

public abstract class Controller {

    private Robot model;
    private RobotView view;

    public Controller(Robot model, RobotView view) {
        this.model = model;
        this.view = view;
    }
}
