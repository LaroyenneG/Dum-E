package model.dume;

import model.element.connexion.constant.axis.distance.Distance;
import model.element.connexion.constant.axis.rotation.Pitching;
import model.element.connexion.joint.JointInvalidValueException;
import model.element.connexion.joint.linear.Collinear;
import model.element.connexion.joint.rotation.Revolving;
import model.element.connexion.joint.rotation.Rotational;
import model.element.connexion.joint.rotation.Twisting;
import model.element.robot.Robot;

public class DumE extends Robot {

    public DumE() throws JointInvalidValueException {

        super(new Twisting(0.0), new Distance(0.35 * 100), new Rotational(0.0, -Math.PI / 6.0, Math.PI / 4.0), new Distance(0.45 * 100), new Pitching(Math.PI / 2.0), new Collinear(0.55 * 100, 0.3 * 100, 0.7 * 100), new Rotational(0.0, -Math.PI / 2.0, Math.PI / 2.0), new Distance(0.1 * 100), new Revolving(0.0, -Math.PI / 2.0, Math.PI / 2.0));
    }
}

