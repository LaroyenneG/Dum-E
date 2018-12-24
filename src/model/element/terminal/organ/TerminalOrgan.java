package model.element.terminal.organ;

import model.element.Element;

public abstract class TerminalOrgan extends Element {

    private boolean action;

    public TerminalOrgan() {
        action = false;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }
}
