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
        sut = new Solver(robot);
        journal = new StringBuffer();
        Solver.printJournalHeader(journal, robot.jointsNumber());
    }

    @Test
    public void testFindSolutionInAlphaZone() {

        double[] solution = Solver.findSolution(journal, null, robot, new Point3d(0.2, 0.3, 0.4));

        assertNotNull(solution);
    }

    @Test
    public void testFindSolutionInBetaZone() {

        double[] solution = Solver.findSolution(journal, null, robot, new Point3d(-0.2, 0.3, 0.4));

        assertNotNull(solution);
    }


    @Test
    public void testFindSolutionInOmegaZone() {


        double[] solution = Solver.findSolution(journal, null, robot, new Point3d(-0.2, 0.3, -0.4));

        assertNotNull(solution);
    }

    @Test
    public void testFindSolutionInGamaZone() {

        double[] solution = Solver.findSolution(journal, null, robot, new Point3d(0.2, 0.3, -0.4));

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

        Point3d point = new Point3d(0.2, 0.2, 0.4);

        double[][] solutions = sut.computeTrajectory(point);

        assertNotNull(solutions);
    }

    @Test
    public void testComputePointInZoneBeta() {

        Point3d point = new Point3d(-0.2, 0.2, 0.4);

        double[][] solutions = sut.computeTrajectory(point);

        assertNotNull(solutions);
    }

    @Test
    public void testFindLine() {

        robot.getJoints()[0].setValueSafe(0.011999933487043868);
        robot.getJoints()[1].setValueSafe(0.5343132674535181);
        robot.getJoints()[2].setValueSafe(0.27553434510088654);
        robot.getJoints()[3].setValueSafe(0.8671663965624079);
        robot.getJoints()[4].setValueSafe(0.06003396891462865);

        double[] solution = Solver.findSolution(journal, null, robot, new Point3d(0.3, 0.3, 0));

        assertNotNull(solution);
    }

    @Test
    public void testFindSamePoint() {

        double[] solution = Solver.findSolution(journal, null, robot, robot.getTerminalOrganPosition());

        assertNotNull(solution);
    }

    @Test
    public void testComputeTrajectorySamePoint() {

        double[][] solutions = sut.computeTrajectory(robot.getTerminalOrganPosition());

        assertNotNull(solutions);
    }

    @Test
    public void testFindOpposedPoint() {


        Point3d point3d = robot.getTerminalOrganPosition();

        point3d.z = -point3d.z;

        double[] solution = Solver.findSolution(journal, null, robot, point3d);

        assertNotNull(solution);
    }


    @Test
    public void testComputeImpossibleTrajectory() {

        Point3d point3d = robot.getTerminalOrganPosition();

        point3d.z = -point3d.z;

        double[][] solutions = sut.computeTrajectory(point3d);

        assertNull(solutions);
    }

    @Test
    public void testComputeLineTrajectory() {

        double[][] solutions = sut.computeTrajectory(new Point3d(0.0, 0.4, 0.4));

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
