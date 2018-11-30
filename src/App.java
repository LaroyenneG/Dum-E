import controller.ControlGroup;
import model.element.connexion.constant.axis.move.MoveY;
import model.element.connexion.constant.axis.rotation.Rolling;
import model.element.robot.Robot;
import view.RobotView;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Robot robot = new TestRobot();
                RobotView view = new RobotView("Test");
                new ControlGroup(robot, view);
            }
        });
    }

    private static class TestRobot extends Robot {
        public TestRobot() {
            super(new MoveY(0.5), new Rolling(Math.PI / 2.0));
        }
    }
}
