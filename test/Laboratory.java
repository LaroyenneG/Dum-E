import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import java.awt.*;


public class Laboratory extends JFrame {

    private Laboratory(Node node) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas3D myCanvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());

        SimpleUniverse simpUniv = new SimpleUniverse(myCanvas3D);

        simpUniv.getViewingPlatform().setNominalViewingTransform();

        createSceneGraph(simpUniv, node);

        addLight(simpUniv);

        addAxis(simpUniv);

        OrbitBehavior ob = new OrbitBehavior(myCanvas3D);
        ob.setSchedulingBounds(new BoundingSphere(new Point3d(), Double.MAX_VALUE));
        simpUniv.getViewingPlatform().setViewPlatformBehavior(ob);

        setTitle(getClass().getSimpleName());
        setSize(900, 900);
        getContentPane().add("Center", myCanvas3D);
        setVisible(true);
        setResizable(false);
    }

    /**
     * =====> User control <======
     */
    private static BranchGroup observable() {

        BranchGroup branchGroup = new BranchGroup();

        /*
         * to complete
         */

        return branchGroup;
    }

    public static void main(String[] args) {

        BranchGroup branchGroup = observable();

        branchGroup.compile();

        new Laboratory(branchGroup);
    }

    private void createSceneGraph(SimpleUniverse su, Node node) {

        BranchGroup group = new BranchGroup();

        group.addChild(node);

        group.compile();

        su.addBranchGraph(group);
    }

    private void addAxis(SimpleUniverse su) {

        BranchGroup group = new BranchGroup();

        Appearance app = null;
        ColoringAttributes c = null;

        app = new Appearance();
        c = new ColoringAttributes();
        c.setColor(new Color3f(Color.RED));
        app.setColoringAttributes(c);

        LineArray lineX = new LineArray(2, LineArray.COORDINATES);
        lineX.setCoordinate(0, new Point3d());
        lineX.setCoordinate(1, new Point3d(Float.MAX_VALUE, 0, 0));
        Shape3D x = new Shape3D(lineX);
        x.setAppearance(app);
        group.addChild(x);

        app = new Appearance();
        c = new ColoringAttributes();
        c.setColor(new Color3f(Color.GREEN));
        app.setColoringAttributes(c);


        LineArray lineY = new LineArray(2, LineArray.COORDINATES);
        lineY.setCoordinate(0, new Point3d());
        lineY.setCoordinate(1, new Point3d(0, Float.MAX_VALUE, 0));
        Shape3D y = new Shape3D(lineY);
        y.setAppearance(app);
        group.addChild(y);


        app = new Appearance();
        c = new ColoringAttributes();
        c.setColor(new Color3f(Color.BLUE));
        app.setColoringAttributes(c);


        LineArray lineZ = new LineArray(2, LineArray.COORDINATES);
        lineZ.setCoordinate(0, new Point3d());
        lineZ.setCoordinate(1, new Point3d(0, 0, Float.MAX_VALUE));
        Shape3D z = new Shape3D(lineZ);
        z.setAppearance(app);
        group.addChild(z);

        group.compile();

        su.addBranchGraph(group);
    }

    private void addLight(SimpleUniverse su) {

        BranchGroup bgLight = new BranchGroup();

        final Background background = new Background(new Color3f(Color.WHITE));
        final BoundingSphere sphere = new BoundingSphere(new Point3d(), Double.MAX_VALUE);

        background.setApplicationBounds(sphere);
        bgLight.addChild(background);

        su.addBranchGraph(bgLight);
    }
}
