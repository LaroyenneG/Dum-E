package model.element.connexion.joint;

public abstract class Linear extends Joint {

    public Linear(double value, double min, double max) throws JointInvalidValueException {
        super(value, min, max);
        if (min < 0.0) {
            throw new JointInvalidValueException(this);
        }
    }

    public Linear(double value) {
        super(value);
    }
}
