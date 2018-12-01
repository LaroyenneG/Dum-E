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

    private void virtualized() {


        ElementDraftMan elementDraftman = new ElementDraftMan(view.getSimpleUniverse());

        model.accept(elementDraftman);

        elementDraftman.display();
    }


    protected void displayView() {

        model.build();

        virtualized();
    }
}
