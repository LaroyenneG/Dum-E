package controller;

import model.element.robot.Robot;
import view.ElementDraftMan;
import view.RobotView;

public abstract class AbstractController {

    protected Robot model;
    protected RobotView view;

    public AbstractController(Robot model, RobotView view) {
        this.model = model;
        this.view = view;
    }


    protected void displayView() {

        ElementDraftMan elementDraftman = new ElementDraftMan();

        model.accept(elementDraftman);

        view.setNewScene(elementDraftman.getResult());
    }
}
