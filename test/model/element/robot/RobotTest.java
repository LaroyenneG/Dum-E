package model.element.robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTest {

    @Test
    public void testNumberOfConnexions() {

        TRobot tRobot = new TRobot();

        Assertions.assertEquals(0, tRobot.jointsNumber());
    }

    private static class TRobot extends Robot {
        public TRobot() {
            super(null);
        }
    }
}
