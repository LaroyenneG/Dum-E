package robot.element.connexion;

import javax.media.j3d.Transform3D;

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
    public Transform3D applyTransformation(Transform3D transform3D) {

        setTransform3D(transform3D);

        for (Connexion c : connexions) {
            transform3D = c.applyTransformation(transform3D);
        }

        return transform3D;
    }
}
