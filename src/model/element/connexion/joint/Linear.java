package model.element.connexion.joint;

public abstract class Linear extends Joint {

    public Linear(double value, double min, double max) {
        super(value, (min >= 0.0) ? min : 0.0, max);
    }

    public Linear(double value) {
        super(value);
    }
}
