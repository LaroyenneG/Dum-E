import controller.ControlGroup;
import model.element.connexion.constant.axis.move.MoveY;
import model.element.connexion.constant.axis.rotation.Pitching;
import model.element.connexion.joint.linear.Collinear;
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
            super(new Twisting(0.0), new MoveY(0.35), new Rotational(0.0), new MoveY(0.45), new Pitching(Math.PI / 2.0), new Collinear(0.55));
        }
    }
}
