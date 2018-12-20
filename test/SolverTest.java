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

        Solver solver = new Solver(sut, point);

        double[] solution = solver.compute();

        assertNull(solution);
    }

    @Test
    public void testComputePoint() {

        Point3d point = new Point3d(0.7, 0.4, 0.6);

        Solver solver = new Solver(sut, point);
        solver.enableJournal();

        double[] solution = solver.compute();

        System.out.println(solver.getJournal());

        assertNotNull(solution);
    }

    @AfterEach
    public void stop() {
        sut = null;
    }
}
