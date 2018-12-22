package model.element.robot;

import model.dume.DumE;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.vecmath.Point3d;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolverTest {

    private StringBuffer journal;
    private Robot robot;
    private Solver sut;

    @BeforeEach
    public void setUp() {
        robot = new DumE();
        robot.build();
        sut = new Solver(new DumE());
        journal = new StringBuffer();
        Solver.printJournalHeader(journal, robot.jointsNumber());
    }

    @Test
    public void testFindSolutionInAlphaZone() {

        double[] solution = Solver.findSolution(journal, null, robot, new Point3d(0.3, 0.5, 0.4));

        assertNotNull(solution);
    }

    @Test
    public void testFindSolutionInBetaZone() {

        double[] solution = Solver.findSolution(journal, null, robot, new Point3d(-0.3, 0.5, 0.4));

        assertNotNull(solution);
    }


    @Test
    public void testFindSolutionInOmegaZone() {


        double[] solution = Solver.findSolution(journal, null, robot, new Point3d(-0.3, 0.5, -0.4));

        assertNotNull(solution);
    }

    @Test
    public void testFindSolutionInGamaZone() {

        double[] solution = Solver.findSolution(journal, null, robot, new Point3d(0.3, 0.5, -0.4));

        assertNotNull(solution);
    }

    @Test
    public void testComputeOrigin() {

        Point3d point = new Point3d(0.0, 0.0, 0.0);

        double[][] solutions = sut.computeTrajectory(point);

        assertNull(solutions);
    }

    @Test
    public void testComputeOversizePoint() {

        Point3d point = new Point3d(5.0, 9.0, 7.0);

        double[][] solutions = sut.computeTrajectory(point);

        assertNull(solutions);
    }

    @Test
    public void testComputePointInZoneAlpha() {

        Point3d point = new Point3d(0.5, 0.5, 0.6);

        double[][] solutions = sut.computeTrajectory(point);

        assertNotNull(solutions);
    }

    @Test
    public void testComputePointInZoneBeta() {

        Point3d point = new Point3d(-0.5, 0.5, 0.6);

        double[][] solutions = sut.computeTrajectory(point);

        assertNotNull(solutions);
    }

    @AfterEach
    public void stop() {
        System.out.println(journal);
        journal = null;
        sut = null;
        robot = null;
    }
}
