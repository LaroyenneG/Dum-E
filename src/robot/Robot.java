package robot;

import robot.element.connexion.Composite;
import robot.element.terminal.organ.TerminalOrgan;

public abstract class Robot {

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
}
