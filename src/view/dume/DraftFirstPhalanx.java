package view.dume;

import com.sun.j3d.utils.geometry.Cylinder;
import view.ElementVirtualization;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;
import java.awt.*;

public class DraftFirstPhalanx {

    public static void buildPatella(BranchGroup branchGroup, final float radius) {


        Cylinder patella = new Cylinder(radius * 1.5f, radius * 2.0f);
        patella.setAppearance(ElementVirtualization.buildApperance(Color.DARK_GRAY));


        Cylinder pin = new Cylinder(radius / 3.0f, radius * 2.0f + radius / 2.0f);
        pin.setAppearance(ElementVirtualization.buildApperance(Color.GRAY));

        Transform3D transformPatella = new Transform3D();
        transformPatella.rotZ(Math.PI / 2.0);
        TransformGroup groupPatella = new TransformGroup(transformPatella);

        groupPatella.addChild(pin);
        groupPatella.addChild(patella);

        branchGroup.addChild(groupPatella);
    }

    public static void buildBloc(BranchGroup branchGroup, final float radius, final float length) {

        com.sun.j3d.utils.geometry.Box box = new com.sun.j3d.utils.geometry.Box(radius, length / 2.0f, radius / 1.5f, ElementVirtualization.buildApperance(Color.DARK_GRAY));
        Transform3D transformBox = new Transform3D();
        transformBox.setTranslation(new Vector3d(0.0, box.getYdimension(), 0.0));
        TransformGroup groupBox = new TransformGroup(transformBox);
        groupBox.addChild(box);

        branchGroup.addChild(groupBox);
    }
}
