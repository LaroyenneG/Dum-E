package model.element.connexion.joint;

public class JointInvalidValueException extends Exception {

    public JointInvalidValueException(Joint joint) {
        super("Joint value must be between [" + joint.min + "," + joint.max + "]");
    }
}
