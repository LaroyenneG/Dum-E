package view.dume;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import model.dume.components.Girder;
import view.ElementVirtualization;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Node;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point2d;
import javax.vecmath.Vector3d;
import java.awt.*;

public class DraftTurret {

    public static void buildCylinders(BranchGroup branchGroup, final float radius, final float length, final float angle) {

        float r = (float) Girder.D3.getValue();
        r -= r * DraftGirder.POLE_FIXATION_OFFSET;
        r -= r * (DraftGirder.CYLINDERS_FIXATION_OFFSET / 2.0);

        Point2d a = new Point2d();
        a.x = Math.sin(angle) * r;
        a.y = Math.cos(angle) * r;

        Point2d b = new Point2d();
        b.x = radius * 9.0f;
        b.y = 0;

        float translate = radius * 3.0f;
        float sphereRayon = radius / 1.5f;

        Sphere rightUp = new Sphere(sphereRayon);

        Transform3D transRightUp = new Transform3D();
        transRightUp.setTranslation(new Vector3d(translate, a.y + length, a.x));

        TransformGroup groupRightUp = new TransformGroup(transRightUp);
        groupRightUp.addChild(rightUp);

        Sphere rightDown = new Sphere(sphereRayon);

        Transform3D transRightDown = new Transform3D();
        transRightDown.setTranslation(new Vector3d(translate, b.y + length, b.x));

        TransformGroup groupRightDown = new TransformGroup(transRightDown);
        groupRightDown.addChild(rightDown);


        Sphere leftUp = new Sphere(sphereRayon);

        Transform3D transleftUp = new Transform3D();
        transleftUp.setTranslation(new Vector3d(-translate, a.y + length, a.x));

        TransformGroup groupleftUp = new TransformGroup(transleftUp);
        groupleftUp.addChild(leftUp);

        Sphere leftDown = new Sphere(sphereRayon);

        Transform3D transleftDown = new Transform3D();
        transleftDown.setTranslation(new Vector3d(-translate, b.y + length, b.x));

        TransformGroup groupleftDown = new TransformGroup(transleftDown);
        groupleftDown.addChild(leftDown);


        float cylinderSize = (float) a.distance(b);

        Node leftCylinder = ElementVirtualization.buildCylinder(sphereRayon, cylinderSize, Color.GRAY);
        Node rightCylinder = ElementVirtualization.buildCylinder(sphereRayon, cylinderSize, Color.GRAY);

        double cylindersAngle = (a.x <= b.x) ? Math.PI / 2.0 - Math.asin(a.y / cylinderSize) : (Math.PI / 2.0 - Math.asin(-a.y / cylinderSize)) + Math.PI;


        Transform3D transformCylinders = new Transform3D();
        transformCylinders.rotX(-cylindersAngle);

        Transform3D translateLeft = new Transform3D();
        translateLeft.setTranslation(new Vector3d(translate, b.y + length, b.x));
        translateLeft.mul(transformCylinders);

        TransformGroup groupLeft = new TransformGroup(translateLeft);
        groupLeft.addChild(leftCylinder);


        Transform3D translateRight = new Transform3D();
        translateRight.setTranslation(new Vector3d(-translate, b.y + length, b.x));
        translateRight.mul(transformCylinders);

        TransformGroup groupRigth = new TransformGroup(translateRight);
        groupRigth.addChild(rightCylinder);

        branchGroup.addChild(groupRightUp);
        branchGroup.addChild(groupRightDown);
        branchGroup.addChild(groupleftUp);
        branchGroup.addChild(groupleftDown);
        branchGroup.addChild(groupLeft);
        branchGroup.addChild(groupRigth);
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
