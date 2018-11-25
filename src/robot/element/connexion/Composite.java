package robot.element.connexion;

import robot.element.Element;

public abstract class Composite extends Element {

    private Connexion[] connexions;

    public Composite(Connexion... connexions) {
        this.connexions = connexions;
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
}
