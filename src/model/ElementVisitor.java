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

    void virtualizationElement(Element element);

    void virtualizationDefault(Default organ);

    void virtualizationMoveY(MoveY axisMove);

    void virtualizationMoveX(MoveX axisMove);

    void virtualizationMoveZ(MoveZ axisMove);

    void virtualizationAxisRotation(AxisRotation axisRotation);

    void virtualizationRotation(Rotation rotation);

    void virtualizationCollinear(Collinear collinear);

    void virtualizationOrthogonal(Orthogonal orthogonal);
}
