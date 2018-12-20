import model.dume.DumE;
import model.element.Solver;
import model.element.robot.Robot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.vecmath.Point3d;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SolverTest {

    private Robot sut;

    @BeforeEach
    public void setUp() {
        sut = new DumE();
    }

    @Test
    public void testCompute() {

        Point3d point = new Point3d();

        Solver solver = new Solver(sut, point);

        double[] solution = solver.compute();

        assertNotNull(solution);
    }

    @AfterEach
    public void stop() {
        sut = null;
    }
}
