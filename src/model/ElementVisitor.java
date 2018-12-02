package model;

import model.element.Element;
import model.element.connexion.constant.axis.move.MoveX;
import model.element.connexion.constant.axis.move.MoveY;
import model.element.connexion.constant.axis.move.MoveZ;
import model.element.terminal.organ.Default;

public interface ElementVisitor {

    void virtualizedElement(Element element);

    void virtualizedDefault(Default organ);

    void virtualizedMoveY(MoveY axisMove);

    void virtualizedMoveX(MoveX axisMove);

    void virtualizedMoveZ(MoveZ axisMove);
}
