package view.dume;

import com.sun.j3d.utils.geometry.Box;
import view.ElementVirtualization;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Node;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;
import java.awt.*;

public class DraftBase {


    private static final float CYLINDER_OFFSET = 20f / 100;

    public static void buildWheels(BranchGroup branchGroup, final float radius, final float length) {

    }

    public static void buildPlate(BranchGroup branchGroup, final float radius, final float length) {

        float size = length / 2.0f;
        size -= size * CYLINDER_OFFSET;

        Box plate = new Box(radius * 10f, size, radius * 10f, ElementVirtualization.buildAppearance(Color.DARK_GRAY));

        Transform3D transformPlate = new Transform3D();
        transformPlate.setTranslation(new Vector3d(0.0, plate.getYdimension(), 0.0));

        TransformGroup groupPlate = new TransformGroup(transformPlate);
        groupPlate.addChild(plate);

        branchGroup.addChild(groupPlate);
    }

    public static void buildCylinder(BranchGroup branchGroup, final float radius, final float length) {

        Node cylinder = ElementVirtualization.buildCylinder(radius * 5f, length * CYLINDER_OFFSET, Color.yellow);

        Transform3D transformCylinder = new Transform3D();
        transformCylinder.setTranslation(new Vector3d(0.0, length - length * CYLINDER_OFFSET, 0.));

        TransformGroup groupCylinder = new TransformGroup(transformCylinder);
        groupCylinder.addChild(cylinder);

        branchGroup.addChild(groupCylinder);
    }
}
