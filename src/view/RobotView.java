package view;

import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import java.awt.*;

public class RobotView extends JFrame {

    private static final int DEFAULT_WIDTH = 550;
    private static final int DEFAULT_HEIGHT = 550;

    private SimpleUniverse simpleUniverse;
    private BranchGroup scene;
    private Canvas3D canvas3D;

    public RobotView() {

        scene = null;

        canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());

        getContentPane().add(canvas3D);

        simpleUniverse = new SimpleUniverse(canvas3D);
        simpleUniverse.getViewingPlatform().setNominalViewingTransform();

        simpleUniverse.addBranchGraph(createBackground());

        setTitle("Robot View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
    }

    private BranchGroup createBackground() {

        final Background background = new Background(new Color3f(Color.WHITE));
        final BoundingSphere sphere = new BoundingSphere(new Point3d(), Double.MAX_VALUE);

        background.setApplicationBounds(sphere);

        BranchGroup branchGroup = new BranchGroup();
        branchGroup.addChild(background);
        branchGroup.compile();

        return branchGroup;
    }


    public SimpleUniverse getSimpleUniverse() {
        return simpleUniverse;
    }

    public Canvas3D getCanvas3D() {
        return canvas3D;
    }

    public void setNewScene(BranchGroup scene) {

        simpleUniverse.addBranchGraph(scene);

        if (this.scene != null) {
            this.scene.detach();
        }

        this.scene = scene;
    }
}
