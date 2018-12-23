package view.dume;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;
import view.ElementVirtualization;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;
import java.awt.*;

public class DraftTurret {

    public static void buildPrincipalCylinder(BranchGroup branchGroup, final float radius, final float length) {

        Cylinder cylinder = new Cylinder(radius * 4.0f, length);
        cylinder.setAppearance(ElementVirtualization.buildApperance(Color.DARK_GRAY));
        Transform3D transformCylinder = new Transform3D();
        transformCylinder.setTranslation(new Vector3d(0.0, cylinder.getHeight() / 2.0f, 0.0));

        TransformGroup groupCylinder = new TransformGroup(transformCylinder);
        groupCylinder.addChild(cylinder);


        Box supportCylinder = new Box(cylinder.getRadius(), cylinder.getRadius(), cylinder.getRadius(), ElementVirtualization.buildApperance(Color.DARK_GRAY));

        Transform3D transformSupport = new Transform3D();
        transformSupport.setTranslation(new Vector3d(0.0, length - supportCylinder.getYdimension(), supportCylinder.getZdimension()));

        TransformGroup groupSupport = new TransformGroup(transformSupport);
        groupSupport.addChild(supportCylinder);

        Cylinder pin = new Cylinder(radius * 3.0f, cylinder.getRadius() * 2.0f + radius);
        pin.setAppearance(ElementVirtualization.buildApperance(Color.yellow));

        Transform3D transformPin = new Transform3D();
        transformPin.rotZ(Math.PI / 2.0);

        Transform3D translatePin = new Transform3D();
        transformPin.setTranslation(new Vector3d(0.0, length - supportCylinder.getYdimension(), cylinder.getRadius()));
        transformPin.mul(translatePin);

        TransformGroup groupPin = new TransformGroup(transformPin);
        groupPin.addChild(pin);

        branchGroup.addChild(groupSupport);
        branchGroup.addChild(groupCylinder);
        branchGroup.addChild(groupPin);
    }
}
