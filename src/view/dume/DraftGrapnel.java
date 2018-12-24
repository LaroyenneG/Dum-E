package view.dume;

import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import view.ElementVirtualization;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.awt.*;
import java.util.List;

public class DraftGrapnel {

    public static void buildPliers(BranchGroup branchGroup, final float radius, Vector3d translator) {

        Cylinder cylinder = new Cylinder(radius / 10, radius * 2.0f);
        cylinder.setAppearance(ElementVirtualization.buildAppearance(Color.GRAY));

        Transform3D transformCylinder = new Transform3D();

        transformCylinder.setTranslation(new Vector3d(translator.x, cylinder.getHeight() / 2.0 + translator.y, translator.z));

        TransformGroup groupCylinder = new TransformGroup(transformCylinder);
        groupCylinder.addChild(cylinder);

        branchGroup.addChild(groupCylinder);
    }

    public static void buildBell(BranchGroup branchGroup, final float radius) {


        Sphere sphere = new Sphere(radius);
        sphere.setAppearance(ElementVirtualization.buildAppearance(Color.DARK_GRAY));

        Transform3D transformSphere = new Transform3D();
        transformSphere.setTranslation(new Vector3d(0.0, radius, 0.0));

        TransformGroup groupSphere = new TransformGroup(transformSphere);
        groupSphere.addChild(sphere);


        Cylinder cylinder = new Cylinder(radius, radius);
        cylinder.setAppearance(ElementVirtualization.buildAppearance(Color.DARK_GRAY));

        Transform3D transformCylinder = new Transform3D();
        transformCylinder.setTranslation(new Vector3d(0.0, radius / 2.0, 0.0));

        TransformGroup groupCylinder = new TransformGroup(transformCylinder);
        groupCylinder.addChild(cylinder);


        Cylinder crown = new Cylinder(radius + radius / 5, radius / 5);
        crown.setAppearance(ElementVirtualization.buildAppearance(Color.DARK_GRAY));

        Transform3D transformCrown = new Transform3D();
        transformCrown.setTranslation(new Vector3d(0.0, crown.getHeight() / 2.0, 0.0));

        TransformGroup groupCrown = new TransformGroup(transformCrown);

        groupCrown.addChild(crown);

        branchGroup.addChild(groupSphere);
        branchGroup.addChild(groupCylinder);
        branchGroup.addChild(groupCrown);
    }

    public static void drawPoints(BranchGroup branchGroup, float radius, List<Point3d> point3ds) {

        for (Point3d point3d : point3ds) {

            Sphere sphere = new Sphere(radius / 4.0f);
            sphere.setAppearance(ElementVirtualization.buildAppearance(Color.green));

            Transform3D transform3D = new Transform3D();
            transform3D.setTranslation(new Vector3d(point3d));

            TransformGroup group = new TransformGroup(transform3D);
            group.addChild(sphere);

            branchGroup.addChild(group);
        }
    }
}
