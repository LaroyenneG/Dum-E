package view;


import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import model.ElementVisitor;
import model.element.Element;
import model.element.connexion.constant.axis.move.MoveX;
import model.element.connexion.constant.axis.move.MoveY;
import model.element.connexion.constant.axis.move.MoveZ;
import model.element.terminal.organ.Default;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Node;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;

public class ElementDraftMan implements ElementVisitor {

    private static final double R_CYLINDER_MOVE = 0.01;

    private BranchGroup branchGroup;

    public ElementDraftMan() {
        branchGroup = new BranchGroup();
        branchGroup.setCapability(BranchGroup.ALLOW_DETACH);
    }

    public BranchGroup getResult() {
        return branchGroup;
    }

    private static Node buildCylinder(float r, float h) {

        Transform3D transform3D = new Transform3D();

        transform3D.setTranslation(new Vector3d(0.0, h / 2.0, 0.0));

        TransformGroup transformGroup = new TransformGroup(transform3D);

        Cylinder cylinder = new Cylinder(r, h);

        transformGroup.addChild(cylinder);

        return transformGroup;
    }

    private void addToScene(Node node, Element element) {

        TransformGroup transformGroup = new TransformGroup(element.getTransform3D());

        transformGroup.addChild(node);

        branchGroup.addChild(transformGroup);
    }

    @Override
    public void virtualizedDefault(Default organ) {

        Node cylinder = buildCylinder(0.01f, 0.1f);

        addToScene(cylinder, organ);
    }


    @Override
    public void virtualizedElement(Element element) {

        Sphere sphere = new Sphere(0.01f);

        addToScene(sphere, element);
    }

    @Override
    public void virtualizedMoveY(MoveY axisMove) {

        Node cylinder = buildCylinder((float) R_CYLINDER_MOVE, (float) axisMove.getValue());

        addToScene(cylinder, axisMove);
    }

    @Override
    public void virtualizedMoveX(MoveX axisMove) {

        Node cylinder = buildCylinder((float) R_CYLINDER_MOVE, (float) axisMove.getValue());

        Transform3D transform3D = new Transform3D();

        transform3D.rotZ(-Math.PI / 2.0);

        TransformGroup transformGroup = new TransformGroup(transform3D);

        transformGroup.addChild(cylinder);

        addToScene(transformGroup, axisMove);
    }

    @Override
    public void virtualizedMoveZ(MoveZ axisMove) {

        Node cylinder = buildCylinder((float) R_CYLINDER_MOVE, (float) axisMove.getValue());

        Transform3D transform3D = new Transform3D();

        transform3D.rotX(Math.PI / 2.0);

        TransformGroup transformGroup = new TransformGroup(transform3D);

        transformGroup.addChild(cylinder);

        addToScene(transformGroup, axisMove);
    }
}
