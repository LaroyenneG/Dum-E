package model.element.robot;

import model.element.Element;
import model.element.ElementVisitor;
import model.element.NumerousJoints;
import model.element.connexion.Composite;
import model.element.connexion.Connexion;
import model.element.connexion.Simple;
import model.element.connexion.joint.Joint;
import model.element.terminal.organ.Default;
import model.element.terminal.organ.TerminalOrgan;

import javax.media.j3d.Transform3D;
import javax.vecmath.Point3d;

public abstract class Robot extends Element implements NumerousJoints {

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
    public int jointsNumber() {

        int n = 0;

        for (Connexion connexion : connexions) {

            if (connexion.isComposite()) {
                n += ((Composite) connexion).jointsNumber();
            }

            if (connexion.isSimple()) {
                if (((Simple) connexion).isJoint()) {
                    n++;
                }
            }
        }

        return n;
    }

    @Override
    public Joint[] getJoints() {

        Joint[] joints = new Joint[jointsNumber()];


        int count = 0;
        for (Connexion connexion : connexions) {

            if (connexion.isSimple()) {

                Simple simple = (Simple) connexion;

                if (simple.isJoint()) {
                    joints[count] = (Joint) simple;
                    count++;
                }
            }

            if (connexion.isComposite()) {

                Composite composite = (Composite) connexion;

                Joint[] tmp = composite.getJoints();

                System.arraycopy(tmp, 0, joints, count, tmp.length);

                count += tmp.length;
            }
        }

        return joints;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(super.toString());

        builder.append("\nConnexions :\n");
        for (Connexion connexion : connexions) {
            builder.append("\n");
            builder.append(connexion);
        }
        builder.append("\nTerminal organ :\n");
        builder.append(terminalOrgan);

        return new String(builder);
    }

    @Override
    public Transform3D transformation() {

        Transform3D transform3D = new Transform3D();

        for (Connexion connexion : connexions) {
            transform3D.mul(connexion.transformation());
        }

        transform3D.mul(terminalOrgan.transformation());

        return transform3D;
    }

    @Override
    public void applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        for (Connexion connexion : connexions) {
            connexion.applyTransformation(transform3D);
        }

        terminalOrgan.applyTransformation(transform3D);

    }

    @Override
    public void accept(ElementVisitor sv) {

        for (Connexion connexion : connexions) {
            connexion.accept(sv);
        }

        terminalOrgan.accept(sv);
    }

    public void build() {
        applyTransformation(getTransform3D());
    }

    public Point3d getTerminalOrganPosition() {

        return terminalOrgan.getPosition();
    }

    @Override
    public Object clone() {

        Robot robot = (Robot) super.clone();

        robot.connexions = connexions.clone();
        for (int i = 0; i < connexions.length; i++) {
            robot.connexions[i] = (Connexion) connexions[i].clone();
        }

        robot.terminalOrgan = (TerminalOrgan) terminalOrgan.clone();

        return robot;
    }

    public TerminalOrgan getTerminalOrgan() {
        return terminalOrgan;
    }
}
