import com.sun.istack.internal.NotNull;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.awt.*;


public class Ouf3D extends JFrame {

    //The canvas to be drawn upon.
    public Canvas3D myCanvas3D;


    public Ouf3D() {
        //Mechanism for closing the window and ending the program.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Default settings for the viewer parameters.
        myCanvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());


        //Construct the SimpleUniverse:
        //First generate it using the Canvas.
        SimpleUniverse simpUniv = new SimpleUniverse(myCanvas3D);


        //Default position of the viewer.
        simpUniv.getViewingPlatform().setNominalViewingTransform();


        //The scene is generated in this method.
        createSceneGraph(simpUniv);


        //Add some light to the scene.
        addLight(simpUniv);

        addAxis(simpUniv);


        //The following three lines enable navigation through the scene using the mouse.
        OrbitBehavior ob = new OrbitBehavior(myCanvas3D);
        ob.setSchedulingBounds(new BoundingSphere(new Point3d(0.0, 0.0, 0.0), Double.MAX_VALUE));
        simpUniv.getViewingPlatform().setViewPlatformBehavior(ob);


        //Show the canvas/window.
        setTitle(getClass().getSimpleName());
        setSize(700, 700);
        getContentPane().add("Center", myCanvas3D);
        setVisible(true);
    }


    @NotNull
    public static void main(String[] args) {
        Ouf3D staticScene = new Ouf3D();
    }


    //In this method, the objects for the scene are generated and added to
    //the SimpleUniverse.
    @NotNull
    public void createSceneGraph(SimpleUniverse su) {

        BranchGroup group = new BranchGroup();

        float h = 0.5f, r = 0.1f;

        Transform3D transform3D = new Transform3D();

        transform3D.setTranslation(new Vector3d(0.0, h / 2.0, 0.0));

        TransformGroup transformGroup = new TransformGroup(transform3D);

        Cylinder cylinder = new Cylinder(r, h);

        transformGroup.addChild(cylinder);

        group.addChild(transformGroup);

        group.compile();

        su.addBranchGraph(group);
    }

    public void addAxis(SimpleUniverse su) {

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
        c.setColor(new Color3f(Color.BLUE));
        app.setColoringAttributes(c);


        LineArray lineY = new LineArray(2, LineArray.COORDINATES);
        lineY.setCoordinate(0, new Point3d());
        lineY.setCoordinate(1, new Point3d(0, Float.MAX_VALUE, 0));
        Shape3D y = new Shape3D(lineY);
        y.setAppearance(app);
        group.addChild(y);


        app = new Appearance();
        c = new ColoringAttributes();
        c.setColor(new Color3f(Color.GREEN));
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


    //Some light is added to the scene here.
    public void addLight(SimpleUniverse su) {

        BranchGroup bgLight = new BranchGroup();

        final Background background = new Background(new Color3f(Color.WHITE));
        final BoundingSphere sphere = new BoundingSphere(new Point3d(), Double.MAX_VALUE);

        background.setApplicationBounds(sphere);
        bgLight.addChild(background);

        su.addBranchGraph(bgLight);
    }
}
