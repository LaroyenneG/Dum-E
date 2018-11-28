package robot.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.vecmath.Point3d;

public class ConstructionFrameTest {

    @Test
    public void testDefaultConstructor() {

        ConstructionFrame constructionFrame = new ConstructionFrame();

        Assertions.assertTrue(constructionFrame.isOrthogonal());
        Assertions.assertTrue(constructionFrame.axisHaveSameLength());
    }

    @Test
    public void testOrthogonal() {

        ConstructionFrame constructionFrame = new ConstructionFrame(new Point3d(2, 2, 2), new Point3d(4, 2, 2), new Point3d(2, 4, 2), new Point3d(2, 2, 4));

        Assertions.assertTrue(constructionFrame.isOrthogonal());
    }
}
