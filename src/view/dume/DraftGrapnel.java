package view.dume;

import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import java.awt.*;

public class DraftGrapnel {

    public static void buildGrapnelPliers(BranchGroup branchGroup, final float radius, Vector3d translator) {

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

    public static void buildGrapnelBell(BranchGroup branchGroup, final float radius) {

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
}
