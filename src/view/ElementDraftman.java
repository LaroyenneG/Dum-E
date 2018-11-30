package view;


import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.universe.SimpleUniverse;
import model.ElementVisitor;
import model.element.Element;
import model.element.connexion.constant.axis.AxisMove;
import model.element.terminal.organ.Default;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.awt.*;

public class ElementDraftman implements ElementVisitor {

    private SimpleUniverse universe;
    private BranchGroup theScene;

    public ElementDraftman(Canvas3D canvas3D) {
        theScene = new BranchGroup();

        Background background = new Background(new Color3f(Color.WHITE));
        BoundingSphere sphere = new BoundingSphere(new Point3d(), Double.MAX_VALUE);
        background.setApplicationBounds(sphere);
        theScene.addChild(background);
        universe = new SimpleUniverse(canvas3D);
        universe.getViewingPlatform().setNominalViewingTransform();
        addOrbitator(canvas3D);
    }

    private void addOrbitator(Canvas3D canvas3D) {

        OrbitBehavior ob = new OrbitBehavior(canvas3D);
        ob.setSchedulingBounds(new BoundingSphere(new Point3d(), Double.MAX_VALUE));
        universe.getViewingPlatform().setViewPlatformBehavior(ob);
    }

    public void display() {
        theScene.compile();
        universe.addBranchGraph(theScene);
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

        theScene.addChild(group);
    }

    @Override
    public void virtualizedDefault(Default organ) {

        Node cylinder = buildCylinder(0.01f, 0.1f);

        addToScene(cylinder, organ);
    }

    @Override
    public void virtualizedMove(AxisMove axisMove) {

        Point3d axis = axisMove.getAxis();

        Transform3D transform3D = new Transform3D();

        Node cylinder = buildCylinder(0.02f, (float) axisMove.getValue());

        if (axis.getX() != 0.0 && axis.getY() != 0.0 && axis.getZ() != 0.0) {
            throw new IllegalStateException("invalid axis");
        }

        if (axis.getX() != 0.0) {
            transform3D.rotZ(Math.PI / 2.0);
        }

        if (axis.getZ() != 0.0) {
            transform3D.rotX(Math.PI / 2.0);
        }

        TransformGroup transformGroup = new TransformGroup(transform3D);
        transformGroup.addChild(cylinder);

        addToScene(transformGroup, axisMove);
    }
}
