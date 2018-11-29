package robot;

import robot.element.Element;
import robot.element.connexion.Composite;
import robot.element.connexion.Connexion;
import robot.element.terminal.organ.Default;
import robot.element.terminal.organ.TerminalOrgan;

import javax.media.j3d.Transform3D;

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
    public Transform3D applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        for (Connexion c : connexions) {
            transform3D = c.applyTransformation(transform3D);
        }

        return terminalOrgan.applyTransformation(transform3D);
    }
}
