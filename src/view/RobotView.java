package view;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
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

    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = (int) (DEFAULT_WIDTH / 1.61803398875);

    private SimpleUniverse simpleUniverse;
    private BranchGroup scene;
    private Canvas3D canvas3D;

    public RobotView() {

        scene = null;

        canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());

        getContentPane().add(canvas3D);

        simpleUniverse = new SimpleUniverse(canvas3D);
        simpleUniverse.getViewingPlatform().setNominalViewingTransform();

        addBackground();
        addOrbitBehavior();

        setTitle("Robot Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    private void addBackground() {

        final Background background = new Background(new Color3f(Color.WHITE));
        final BoundingSphere sphere = new BoundingSphere(new Point3d(), Double.MAX_VALUE);

        background.setApplicationBounds(sphere);

        final BranchGroup branchGroup = new BranchGroup();
        branchGroup.addChild(background);
        branchGroup.compile();

        simpleUniverse.addBranchGraph(branchGroup);
    }

    private void addOrbitBehavior() {

        final OrbitBehavior orbitBehavior = new OrbitBehavior(canvas3D);
        orbitBehavior.setSchedulingBounds(new BoundingSphere(new Point3d(), Double.MAX_VALUE));

        simpleUniverse.getViewingPlatform().setViewPlatformBehavior(orbitBehavior);
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
