package view.dume;

import com.sun.j3d.utils.geometry.Cylinder;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import java.awt.*;

public class DraftFirstPhalanx {

    public static void buildPatella(BranchGroup branchGroup, final float radius) {

        Appearance appPatella = new Appearance();
        ColoringAttributes coloringAttributes1 = new ColoringAttributes();
        coloringAttributes1.setColor(new Color3f(Color.DARK_GRAY));
        appPatella.setColoringAttributes(coloringAttributes1);

        Cylinder patella = new Cylinder(radius * 1.5f, radius * 2.0f);
        patella.setAppearance(appPatella);

        Appearance appPin = new Appearance();
        ColoringAttributes coloringAttributes2 = new ColoringAttributes();
        coloringAttributes2.setColor(new Color3f(Color.GRAY));
        appPin.setColoringAttributes(coloringAttributes2);

        Cylinder pin = new Cylinder(radius / 3.0f, radius * 2.0f + radius / 2.0f);
        pin.setAppearance(appPin);

        Transform3D transformPatella = new Transform3D();
        transformPatella.rotZ(Math.PI / 2.0);
        TransformGroup groupPatella = new TransformGroup(transformPatella);

        groupPatella.addChild(pin);
        groupPatella.addChild(patella);

        branchGroup.addChild(groupPatella);
    }

    public static void buildBloc(BranchGroup branchGroup, final float radius, final float length) {

        Appearance appearance = new Appearance();
        ColoringAttributes coloringAttributes = new ColoringAttributes();
        coloringAttributes.setColor(new Color3f(Color.DARK_GRAY));
        appearance.setColoringAttributes(coloringAttributes);

        com.sun.j3d.utils.geometry.Box box = new com.sun.j3d.utils.geometry.Box(radius, length / 2.0f, radius / 1.5f, appearance);
        Transform3D transformBox = new Transform3D();
        transformBox.setTranslation(new Vector3d(0.0, box.getYdimension(), 0.0));
        TransformGroup groupBox = new TransformGroup(transformBox);
        groupBox.addChild(box);

        branchGroup.addChild(groupBox);
    }
}
