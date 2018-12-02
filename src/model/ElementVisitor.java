package model;

import model.element.Element;
import model.element.connexion.constant.axis.AxisRotation;
import model.element.connexion.constant.axis.move.MoveX;
import model.element.connexion.constant.axis.move.MoveY;
import model.element.connexion.constant.axis.move.MoveZ;
import model.element.connexion.joint.Rotation;
import model.element.connexion.joint.linear.Collinear;
import model.element.connexion.joint.linear.Orthogonal;
import model.element.terminal.organ.Default;

public interface ElementVisitor {

    void virtualizedElement(Element element);

    void virtualizedDefault(Default organ);

    void virtualizedMoveY(MoveY axisMove);

    void virtualizedMoveX(MoveX axisMove);

    void virtualizedMoveZ(MoveZ axisMove);

    void virtualizedAxisRotation(AxisRotation axisRotation);

    void virtualizedRotation(Rotation rotation);

    void virtualizedCollinear(Collinear collinear);

    void virtualizedOrthogonal(Orthogonal orthogonal);
}
