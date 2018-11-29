package view;


import com.sun.j3d.utils.universe.SimpleUniverse;
import model.ElementVisitor;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;

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
    }
}
