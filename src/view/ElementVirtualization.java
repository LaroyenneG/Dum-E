package view;


import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import model.dume.components.Grapnel;
import model.element.Element;
import model.element.ElementVisitor;
import model.element.connexion.constant.axis.AxisRotation;
import model.element.connexion.constant.axis.distance.Distance;
import model.element.connexion.joint.Rotation;
import model.element.connexion.joint.linear.Collinear;
import model.element.connexion.joint.linear.Orthogonal;
import model.element.terminal.organ.Default;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import java.awt.*;

public class ElementVirtualization implements ElementVisitor {

    private static final Color DEFAULT_COLOR = Color.BLACK;

    private BranchGroup branchGroup;

    public ElementVirtualization() {
        branchGroup = new BranchGroup();
        branchGroup.setCapability(BranchGroup.ALLOW_DETACH);
    }

    public BranchGroup getResult() {
        return branchGroup;
    }

    private static Node buildCylinder(float r, float h, Color color) {

        Appearance appearance = new Appearance();
        ColoringAttributes coloringAttributes = new ColoringAttributes();
        coloringAttributes.setColor(new Color3f(color));
        appearance.setColoringAttributes(coloringAttributes);

        Transform3D transform3D = new Transform3D();

        transform3D.setTranslation(new Vector3d(0.0, h / 2.0, 0.0));

        TransformGroup transformGroup = new TransformGroup(transform3D);

        Cylinder cylinder = new Cylinder(r, h);
        cylinder.setAppearance(appearance);

        transformGroup.addChild(cylinder);

        return transformGroup;
    }

    private void addToScene(Node node, Element element) {

        TransformGroup transformGroup = new TransformGroup(element.getTransform3D());

        transformGroup.addChild(node);

        branchGroup.addChild(transformGroup);
    }

    @Override
    public void virtualizationDefault(Default organ) {

        Node cylinder = buildCylinder(0.01f, 0.05f, Color.MAGENTA);

        addToScene(cylinder, organ);
    }


    @Override
    public void virtualizationElement(Element element) {

        Sphere sphere = new Sphere(0.05f);

        addToScene(sphere, element);
    }

    @Override
    public void virtualizationDistance(Distance axisMove) {

        Node cylinder = buildCylinder((float) 0.01, (float) axisMove.getValue(), DEFAULT_COLOR);

        addToScene(cylinder, axisMove);
    }

    @Override
    public void virtualizationAxisRotation(AxisRotation axisRotation) {

        Sphere sphere = new Sphere(0.01f);

        addToScene(sphere, axisRotation);
    }

    @Override
    public void virtualizationRotation(Rotation rotation) {

        Appearance appearance = new Appearance();
        ColoringAttributes coloringAttributes = new ColoringAttributes();
        coloringAttributes.setColor(new Color3f(Color.RED));
        appearance.setColoringAttributes(coloringAttributes);

        Sphere sphere = new Sphere(0.02f);
        sphere.setAppearance(appearance);

        addToScene(sphere, rotation);
    }

    @Override
    public void virtualizationCollinear(Collinear collinear) {

        Node cylinder = buildCylinder(0.01f, (float) collinear.getValue(), Color.RED);

        addToScene(cylinder, collinear);
    }

    @Override
    public void virtualizationOrthogonal(Orthogonal orthogonal) {

        Node cylinder = buildCylinder(0.01f, (float) orthogonal.getValue(), Color.RED);

        addToScene(cylinder, orthogonal);
    }


    private static void buildGrapnelPliers(BranchGroup branchGroup, final float radius, Vector3d translator) {

        Appearance appearance = new Appearance();
        ColoringAttributes coloringAttributes = new ColoringAttributes();
        coloringAttributes.setColor(new Color3f(Color.GRAY));
        appearance.setColoringAttributes(coloringAttributes);

        Cylinder cylinder = new Cylinder(radius / 10, radius * 2.0f);
        cylinder.setAppearance(appearance);

        Transform3D transformCylinder = new Transform3D();

        transformCylinder.setTranslation(new Vector3d(translator.x, cylinder.getHeight() / 2.0 + translator.y, translator.z));

        TransformGroup groupCylinder = new TransformGroup(transformCylinder);
        groupCylinder.addChild(cylinder);

        branchGroup.addChild(groupCylinder);
    }

    private static void buildGrapnelBell(BranchGroup branchGroup, final float radius) {

        Appearance appearance = new Appearance();
        ColoringAttributes coloringAttributes = new ColoringAttributes();
        coloringAttributes.setColor(new Color3f(Color.DARK_GRAY));
        appearance.setColoringAttributes(coloringAttributes);


        Sphere sphere = new Sphere(radius);
        sphere.setAppearance(appearance);

        Transform3D transformSphere = new Transform3D();
        transformSphere.setTranslation(new Vector3d(0.0, radius, 0.0));

        TransformGroup groupSphere = new TransformGroup(transformSphere);
        groupSphere.addChild(sphere);


        Cylinder cylinder = new Cylinder(radius, radius);
        cylinder.setAppearance(appearance);

        Transform3D transformCylinder = new Transform3D();
        transformCylinder.setTranslation(new Vector3d(0.0, radius / 2.0, 0.0));

        TransformGroup groupCylinder = new TransformGroup(transformCylinder);
        groupCylinder.addChild(cylinder);


        Cylinder crown = new Cylinder(radius + radius / 5, radius / 5);
        crown.setAppearance(appearance);

        Transform3D transformCrown = new Transform3D();
        transformCrown.setTranslation(new Vector3d(0.0, crown.getHeight() / 2.0, 0.0));

        TransformGroup groupCrown = new TransformGroup(transformCrown);

        groupCrown.addChild(crown);

        branchGroup.addChild(groupSphere);
        branchGroup.addChild(groupCylinder);
        branchGroup.addChild(groupCrown);
    }

    /**
     * Dum-E component draft man
     */


    /*
     * Grapnel
     */
    @Override
    public void virtualizationGrapnel(Grapnel grapnel) {

        BranchGroup branchGroup = new BranchGroup();

        final float radius = 0.01f;

        buildGrapnelBell(branchGroup, radius);

        final double offset = radius / 3;

        for (int i = 1; i <= 3; i++) {

            double angle = (Math.PI * 2.0 * i) / 3.0;

            buildGrapnelPliers(branchGroup, radius, new Vector3d(Math.cos(angle) * (radius - offset), radius, Math.sin(angle) * (radius - offset)));
        }

        addToScene(branchGroup, grapnel);
    }
}
