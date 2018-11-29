package model.element.connexion;

import model.element.Element;
import model.element.connexion.joint.Joint;

public abstract class Connexion extends Element {

    public abstract Joint[] getJoints();

    public abstract int jointsNumber();
}
