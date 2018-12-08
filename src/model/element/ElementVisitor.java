package model.element;

import model.element.connexion.constant.axis.AxisRotation;
import model.element.connexion.constant.axis.distance.Distance;
import model.element.connexion.joint.Rotation;
import model.element.connexion.joint.linear.Collinear;
import model.element.connexion.joint.linear.Orthogonal;
import model.element.terminal.organ.Default;

public interface ElementVisitor {

    void virtualizationElement(Element element);

    void virtualizationDefault(Default organ);

    void virtualizationDistance(Distance axisMove);

    void virtualizationAxisRotation(AxisRotation axisRotation);

    void virtualizationRotation(Rotation rotation);

    void virtualizationCollinear(Collinear collinear);

    void virtualizationOrthogonal(Orthogonal orthogonal);
}
