package model;

import model.element.terminal.organ.Default;

public interface ElementVisitor {

    void virtualizedDefault(Default organ);

}
