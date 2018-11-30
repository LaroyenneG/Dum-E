package controller;

import model.element.robot.Robot;
import view.ElementDraftman;
import view.RobotView;

import javax.media.j3d.Canvas3D;

public abstract class AbstractController {

    private Robot model;
    private RobotView view;

    public AbstractController(Robot model, RobotView view) {
        this.model = model;
        this.view = view;
    }

    private void virtualized(Canvas3D canvas3D) {

        ElementDraftman elementDraftman = new ElementDraftman(canvas3D);

        model.accept(elementDraftman);

        elementDraftman.display();
    }


    protected void displayView() {

        model.build();

        Canvas3D canvas3D = view.getCanvas3D();

        virtualized(canvas3D);

        view.repaint();

        System.out.println(model);
    }
}
