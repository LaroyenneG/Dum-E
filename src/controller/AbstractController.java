package controller;

import model.element.robot.Robot;
import view.ElementVirtualization;
import view.RobotView;

public abstract class AbstractController {

    protected Robot model;
    protected RobotView view;

    public AbstractController(Robot model, RobotView view) {
        this.model = model;
        this.view = view;
    }


    protected void displayView() {

        ElementVirtualization elementDraftman = new ElementVirtualization();

        model.accept(elementDraftman);

        view.setNewScene(elementDraftman.getResult());
    }
}
