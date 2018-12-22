import model.dume.DumE;
import model.element.robot.Robot;
import model.element.robot.Solver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.vecmath.Point3d;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolverTest {

    private Robot sut;

    @BeforeEach
    public void setUp() {
        sut = new DumE();
    }

    @Test
    public void testComputeImpossiblePosition() {

        Point3d point = new Point3d(0.0, 0.0, 0.0);

        Solver solver = new Solver(sut);

        double[][] solutions = solver.computeTrajectory(point);

        assertNull(solutions);
    }

    @Test
    public void testComputePoint() {

        Point3d point = new Point3d(0.5, 0.5, 0.6);

        Solver solver = new Solver(sut);
        solver.enableJournal();

        double[][] solutions = solver.computeTrajectory(point);

        assertNotNull(solutions);
    }

    @AfterEach
    public void stop() {
        sut = null;
    }
}
