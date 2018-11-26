package robot;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.element.Element;
import robot.element.connexion.Composite;
import robot.element.terminal.organ.TerminalOrgan;

import javax.vecmath.Point3d;

public abstract class Robot extends Element {

    private TerminalOrgan terminalOrgan;
    private Composite[] composites;

    public Robot(TerminalOrgan terminalOrgan, Composite... composites) {
        this.composites = composites;
        this.terminalOrgan = terminalOrgan;
    }

    public Robot(Composite composites) {
        this(null, composites);
    }

    public int jointsNumber() {

        int n = 0;

        for (Composite c : composites) {
            n += c.jointsNumber();
        }

        return n;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        return new String(builder);
    }

    @Override
    public Point3d changeFrame(Point3d frame) {
        return null;
    }

    @Override
    public void draw(SimpleUniverse universe) {

    }
}
