package model.element.connexion.constant.axis.rotation;

import model.ElementVisitor;
import model.element.connexion.constant.axis.AxisRotation;

import javax.media.j3d.Transform3D;

public class Rolling extends AxisRotation {

    public Rolling(double value) {
        super(value);
    }

    @Override
    public Transform3D transformation() {
        return new Transform3D();
    }

    @Override
    public void accept(ElementVisitor sv) {

    }
}
