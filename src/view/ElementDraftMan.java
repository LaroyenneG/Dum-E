package view;


import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import model.ElementVisitor;
import model.element.Element;
import model.element.connexion.constant.axis.AxisMove;
import model.element.terminal.organ.Default;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Node;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;

public class ElementDraftMan implements ElementVisitor {

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

        TransformGroup group = new TransformGroup(element.getTransform3D());
        group.addChild(node);

        branchGroup.addChild(group);
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
    public void virtualizedMove(AxisMove axisMove) {

        virtualizedElement(axisMove);
        /*

        Point3d axis = axisMove.getAxis();

        Transform3D transformation = new Transform3D();

        Node cylinder = buildCylinder(0.02f, (float) axisMove.getValue());


        TransformGroup transformGroup = new TransformGroup(transformation);
        transformGroup.addChild(cylinder);

        addToScene(transformGroup, axisMove);
        */
    }
}
