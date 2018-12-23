package view.dume;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import view.ElementVirtualization;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;
import java.awt.*;

public class DraftTurret {

    public static void buildCylinders(BranchGroup branchGroup, final float radius, final float length, final float angle) {

    }

    public static void buildPrincipalCylinder(BranchGroup branchGroup, final float radius, final float length) {

        Cylinder cylinder = new Cylinder(radius * 4.0f, length);
        cylinder.setAppearance(ElementVirtualization.buildApperance(Color.DARK_GRAY));
        Transform3D transformCylinder = new Transform3D();
        transformCylinder.setTranslation(new Vector3d(0.0, cylinder.getHeight() / 2.0f, 0.0));

        TransformGroup groupCylinder = new TransformGroup(transformCylinder);
        groupCylinder.addChild(cylinder);


        Box supportCylinders = new Box(cylinder.getRadius(), cylinder.getRadius(), cylinder.getRadius(), ElementVirtualization.buildApperance(Color.DARK_GRAY));

        Transform3D transformSupport = new Transform3D();
        transformSupport.setTranslation(new Vector3d(0.0, length - supportCylinders.getYdimension(), supportCylinders.getZdimension()));

        TransformGroup groupSupport = new TransformGroup(transformSupport);
        groupSupport.addChild(supportCylinders);

        Cylinder headSupport = new Cylinder(supportCylinders.getYdimension(), supportCylinders.getXdimension() * 2.0f);
        headSupport.setAppearance(ElementVirtualization.buildApperance(Color.DARK_GRAY));

        Transform3D transformHead = new Transform3D();
        transformHead.rotZ(Math.PI / 2.0f);

        Transform3D translateHead = new Transform3D();
        transformHead.setTranslation(new Vector3d(0.0, length - headSupport.getRadius(), cylinder.getRadius() + supportCylinders.getZdimension()));

        transformHead.mul(translateHead);

        TransformGroup groupHead = new TransformGroup(transformHead);
        groupHead.addChild(headSupport);

        Cylinder pin = new Cylinder(radius * 3.0f, cylinder.getRadius() * 2.0f + radius);
        pin.setAppearance(ElementVirtualization.buildApperance(Color.yellow));

        Transform3D transformPin = new Transform3D();
        transformPin.rotZ(Math.PI / 2.0);

        Transform3D translatePin = new Transform3D();
        transformPin.setTranslation(new Vector3d(0.0, length - supportCylinders.getYdimension(), cylinder.getRadius()));
        transformPin.mul(translatePin);

        TransformGroup groupPin = new TransformGroup(transformPin);
        groupPin.addChild(pin);

        Sphere sphere = new Sphere(cylinder.getRadius());
        sphere.setAppearance(ElementVirtualization.buildApperance(Color.DARK_GRAY));

        Transform3D transformSphere = new Transform3D();
        transformSphere.setTranslation(new Vector3d(0.0, length, 0.0));

        TransformGroup groupSphere = new TransformGroup(transformSphere);
        groupSphere.addChild(sphere);

        branchGroup.addChild(groupSupport);
        branchGroup.addChild(groupHead);
        branchGroup.addChild(groupCylinder);
        branchGroup.addChild(groupPin);
        branchGroup.addChild(groupSphere);
    }
}
