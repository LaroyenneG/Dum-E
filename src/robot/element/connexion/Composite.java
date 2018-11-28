package robot.element.connexion;

import com.sun.j3d.utils.universe.SimpleUniverse;
import robot.math.Operation3D;

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
    public Operation3D changeFrame(Operation3D frame) {

        setOperation3D(frame);

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
