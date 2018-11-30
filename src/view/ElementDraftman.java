package view;


import com.sun.j3d.utils.universe.SimpleUniverse;
import model.ElementVisitor;

import javax.media.j3d.*;

public class ElementDraftman implements ElementVisitor {

    private SimpleUniverse universe;
    private BranchGroup theScene;

    public ElementDraftman(Canvas3D canvas3D) {

        theScene = new BranchGroup();
        universe = new SimpleUniverse(canvas3D);
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.cleanup();
    }


    public void display() {

        theScene.compile();
        universe.addBranchGraph(theScene);

        TransformGroup tgPlatform = new TransformGroup(new Transform3D());
    }


    private void addToScene(Node node, Transform3D transform3D) {

        TransformGroup group = new TransformGroup(transform3D);
        group.addChild(node);

        theScene.addChild(group);
    }
}
