package model.element.terminal.organ;

import model.ElementVisitor;

public class Default extends TerminalOrgan {

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizedDefault(this);
    }
}
