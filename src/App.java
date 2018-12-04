import controller.ControlGroup;
import model.element.connexion.constant.axis.move.MoveY;
import model.element.connexion.constant.axis.move.MoveZ;
import model.element.connexion.constant.axis.rotation.Rolling;
import model.element.connexion.joint.rotation.Revolving;
import model.element.connexion.joint.rotation.Rotational;
import model.element.connexion.joint.rotation.Twisting;
import model.element.robot.Robot;
import view.RobotView;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Robot robot = new TestRobot();
            RobotView view = new RobotView();
            new ControlGroup(robot, view);
        });
    }

    private static class TestRobot extends Robot {
        public TestRobot() {
            super(new MoveY(0.1), new Twisting(0.0), new MoveZ(0.2), new Rotational(Math.PI / 2.0), new MoveY(0.1), new Revolving(Math.PI / 3.0), new Rolling(-Math.PI / 2.0), new MoveY(0.6));
        }
    }
}
