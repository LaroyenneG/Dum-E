package view;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import java.awt.*;

public class RobotView extends JFrame {

    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = (int) (DEFAULT_WIDTH / 1.61803398875);

    private SimpleUniverse simpleUniverse;

    private Canvas3D canvas3D;

    private BranchGroup axis;
    private BranchGroup background;
    private BranchGroup scene;

    private OrbitBehavior orbitBehavior;


    public RobotView() {

        canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());

        getContentPane().add(canvas3D);

        createSimpleUniverse();
        createBackground();
        createOrbitBehavior();
        createAxis();

        scene = new BranchGroup();

        setTitle("Robot Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    private void createSimpleUniverse() {

        simpleUniverse = new SimpleUniverse(canvas3D);
        simpleUniverse.getViewingPlatform().setNominalViewingTransform();
    }

    private void createBackground() {

        Background background = new Background(new Color3f(Color.WHITE));
        BoundingSphere sphere = new BoundingSphere(new Point3d(), Double.MAX_VALUE);

        background.setApplicationBounds(sphere);

        this.background = new BranchGroup();
        this.background.setCapability(BranchGroup.ALLOW_DETACH);
        this.background.addChild(background);
        this.background.compile();
    }

    private void createOrbitBehavior() {

        orbitBehavior = new OrbitBehavior(canvas3D);
        orbitBehavior.setSchedulingBounds(new BoundingSphere(new Point3d(), Double.MAX_VALUE));
    }

    private void createAxis() {

        axis = new BranchGroup();
        axis.setCapability(BranchGroup.ALLOW_DETACH);

        Appearance appearance;
        ColoringAttributes coloringAttributes;

        appearance = new Appearance();
        coloringAttributes = new ColoringAttributes();
        coloringAttributes.setColor(new Color3f(Color.RED));
        appearance.setColoringAttributes(coloringAttributes);

        LineArray lineX = new LineArray(2, LineArray.COORDINATES);
        lineX.setCoordinate(0, new Point3d());
        lineX.setCoordinate(1, new Point3d(Float.MAX_VALUE, 0, 0));
        Shape3D x = new Shape3D(lineX);
        x.setAppearance(appearance);
        axis.addChild(x);

        appearance = new Appearance();
        coloringAttributes = new ColoringAttributes();
        coloringAttributes.setColor(new Color3f(Color.GREEN));
        appearance.setColoringAttributes(coloringAttributes);


        LineArray lineY = new LineArray(2, LineArray.COORDINATES);
        lineY.setCoordinate(0, new Point3d());
        lineY.setCoordinate(1, new Point3d(0, Float.MAX_VALUE, 0));
        Shape3D y = new Shape3D(lineY);
        y.setAppearance(appearance);
        axis.addChild(y);


        appearance = new Appearance();
        coloringAttributes = new ColoringAttributes();
        coloringAttributes.setColor(new Color3f(Color.BLUE));
        appearance.setColoringAttributes(coloringAttributes);


        LineArray lineZ = new LineArray(2, LineArray.COORDINATES);
        lineZ.setCoordinate(0, new Point3d());
        lineZ.setCoordinate(1, new Point3d(0, 0, Float.MAX_VALUE));
        Shape3D z = new Shape3D(lineZ);
        z.setAppearance(appearance);
        axis.addChild(z);

        axis.compile();
    }

    public void removeOrbitBehavior() {
        simpleUniverse.getViewingPlatform().setViewPlatformBehavior(null);
    }

    public void addOrbitBehavior() {

        removeOrbitBehavior();
        simpleUniverse.getViewingPlatform().setViewPlatformBehavior(orbitBehavior);
    }

    public void removeBackground() {
        background.detach();
    }

    public void addBackground() {
        removeBackground();
        simpleUniverse.addBranchGraph(background);
    }

    public void removeAxis() {
        axis.detach();
    }

    public void addAxis() {
        removeAxis();
        simpleUniverse.addBranchGraph(axis);
    }


    public SimpleUniverse getSimpleUniverse() {
        return simpleUniverse;
    }

    public Canvas3D getCanvas3D() {
        return canvas3D;
    }

    public void setNewScene(BranchGroup scene) {

        scene.compile();

        simpleUniverse.addBranchGraph(scene);
        clear();
        this.scene = scene;
    }

    public void clear() {
        scene.detach();
    }

    public void clearAll() {
        removeOrbitBehavior();
        removeBackground();
        removeAxis();
        clear();
    }
}
