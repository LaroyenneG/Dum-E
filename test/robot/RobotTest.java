package robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import robot.element.connexion.Connexion;

public class RobotTest {

    @Test
    public void testNumberOfConnexions() {

        TRobot tRobot = new TRobot();

        Assertions.assertEquals(0, tRobot.jointsNumber());
    }

    private static class TRobot extends Robot {
        public TRobot(Connexion... cs) {
            super(cs);
        }
    }
}
