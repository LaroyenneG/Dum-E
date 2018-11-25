package robot;

import robot.element.connexion.Connexion;
import robot.element.terminal.organ.TerminalOrgan;

public abstract class Robot {

    private TerminalOrgan terminalOrgan;
    private Connexion[] connexions;

    public Robot(TerminalOrgan terminalOrgan, Connexion... connexions) {
        this.connexions = connexions;
        this.terminalOrgan = terminalOrgan;
    }

    public Robot(Connexion... connexions) {
        this(null, connexions);
    }

    public int jointsNumber() {

        int n = 0;

        for (Connexion c : connexions) {
            if (!c.isStatic()) {
                n++;
            }
        }

        return n;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        return new String(builder);
    }
}
