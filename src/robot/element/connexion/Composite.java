package robot.element.connexion;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.math.ConstructionFrame;

public abstract class Composite extends Connexion {

    private Connexion[] connexions;

    public Composite(Connexion... connexions) {
        this.connexions = connexions;
    }

    @Override
    public int jointsNumber() {

        int n = 0;

        for (Connexion c : connexions) {
            n += c.jointsNumber();
        }

        return n;
    }

    @Override
    public ConstructionFrame changeFrame(ConstructionFrame frame) {

        setFrame(frame);

        for (Connexion c : connexions) {
            frame = c.changeFrame(frame);
        }

        return frame;
    }

    @Override
    public void draw(SimpleUniverse universe) {

        for (Connexion c : connexions) {
            c.draw(universe);
        }
    }
}
