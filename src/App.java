import controller.ControlGroup;
import model.element.connexion.constant.axis.move.MoveY;
import model.element.connexion.constant.axis.rotation.Pitching;
import model.element.connexion.joint.JointInvalidValueException;
import model.element.connexion.joint.linear.Collinear;
import model.element.connexion.joint.rotation.Revolving;
import model.element.connexion.joint.rotation.Rotational;
import model.element.connexion.joint.rotation.Twisting;
import model.element.robot.Robot;
import view.RobotView;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Robot robot = null;
            try {
                robot = new TestRobot();
            } catch (JointInvalidValueException e) {
                e.printStackTrace();
            }
            RobotView view = new RobotView();
            new ControlGroup(robot, view);
        });
    }

    private static class TestRobot extends Robot {
        public TestRobot() throws JointInvalidValueException {
            super(new Twisting(0.0), new MoveY(0.35), new Rotational(0.0, -Math.PI / 6.0, Math.PI / 4.0), new MoveY(0.45), new Pitching(Math.PI / 2.0), new Collinear(0.55, 0.3, 0.7), new Rotational(0.0, -Math.PI / 2.0, Math.PI / 2.0), new MoveY(0.1), new Revolving(0.0, -Math.PI / 2.0, Math.PI / 2.0));
        }
    }
}
