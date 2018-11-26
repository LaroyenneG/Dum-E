package robot.element.connexion;

public abstract class Composite extends Connexion {

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
