package view;


import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.universe.SimpleUniverse;
import model.ElementVisitor;
import model.element.terminal.organ.Default;

import javax.media.j3d.*;
import javax.vecmath.Point3d;

public class ElementDraftman implements ElementVisitor {

    private SimpleUniverse universe;
    private BranchGroup theScene;

    public ElementDraftman(Canvas3D canvas3D) {
        theScene = new BranchGroup();
        universe = new SimpleUniverse(canvas3D);
        universe.cleanup();
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


    private void addToScene(Node node, Transform3D transform3D) {

        TransformGroup group = new TransformGroup(transform3D);
        group.addChild(node);

        theScene.addChild(group);
    }

    @Override
    public void virtualizedDefault(Default organ) {

        Cone cone = new Cone(0.3f, 0.5f);

        addToScene(cone, organ.getTransform3D());
    }
}
