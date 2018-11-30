package view;


import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.universe.SimpleUniverse;
import model.ElementVisitor;
import model.element.terminal.organ.Default;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
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
        //addOrbitator(canvas3D);
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


    private void addToScene(Node node, Transform3D transform3D) {

        TransformGroup group = new TransformGroup(transform3D);
        group.addChild(node);

        theScene.addChild(group);
    }

    @Override
    public void virtualizedDefault(Default organ) {

        addToScene(new Cylinder(0.01f, 0.2f), organ.getTransform3D());
    }
}
