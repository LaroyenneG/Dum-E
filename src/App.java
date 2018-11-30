import controller.ControlGroup;
import model.element.connexion.constant.axis.rotation.Rolling;
import model.element.robot.Robot;
import view.RobotView;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Robot robot = new TestRobot();
            RobotView view = new RobotView("Test");
            new ControlGroup(robot, view);
        });
    }

    private static class TestRobot extends Robot {
        public TestRobot() {
            super(new Rolling(Math.PI / 2.0));
        }
    }
}
