package model.element.robot;

import model.ElementVisitor;
import model.element.Element;
import model.element.connexion.Connexion;
import model.element.terminal.organ.Default;
import model.element.terminal.organ.TerminalOrgan;

import javax.media.j3d.Transform3D;

public abstract class Robot extends Element {

    private Connexion[] connexions;
    private TerminalOrgan terminalOrgan;

    public Robot(TerminalOrgan terminalOrgan, Connexion... connexions) {
        this.terminalOrgan = terminalOrgan;
        this.connexions = connexions;
    }

    public Robot(Connexion... connexions) {
        this(new Default(), connexions);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(super.toString());

        builder.append("\nConnexions :\n");
        builder.append(connexions);
        builder.append("\nTerminal organ :\n");
        builder.append(terminalOrgan);

        return new String(builder);
    }

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        for (Connexion connexion : connexions) {
            connexion.applyTransformation(transform3D);
        }

        return terminalOrgan.applyTransformation(transform3D);
    }

    @Override
    public void accept(ElementVisitor sv) {

    }
}
