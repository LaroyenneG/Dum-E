package robot;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.element.Element;
import robot.element.connexion.Composite;
import robot.element.connexion.Connexion;
import robot.element.terminal.organ.Default;
import robot.element.terminal.organ.TerminalOrgan;
import robot.math.Operation3D;

public abstract class Robot extends Element {

    private TerminalOrgan terminalOrgan;
    private Connexion[] connexions;

    public Robot(TerminalOrgan terminalOrgan, Connexion... connexions) {
        this.connexions = connexions;
        this.terminalOrgan = terminalOrgan;
    }

    public Robot(Composite connexions) {
        this(new Default(), connexions);
    }

    public int jointsNumber() {

        int n = 0;

        for (Connexion c : connexions) {
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
    public Operation3D changeFrame(Operation3D frame) {

        setFrame(frame);

        for (Connexion c : connexions) {
            frame = c.changeFrame(frame);
        }

        return terminalOrgan.changeFrame(frame);
    }

    @Override
    public void draw(SimpleUniverse universe) {

        for (Connexion c : connexions) {
            c.draw(universe);
        }

        terminalOrgan.draw(universe);
    }
}
