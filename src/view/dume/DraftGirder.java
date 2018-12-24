package view.dume;

import com.sun.j3d.utils.geometry.Cylinder;
import view.ElementVirtualization;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;
import java.awt.*;

public class DraftGirder {

    public static final float POLE_FIXATION_OFFSET = 10f / 100f;
    public static final float CYLINDERS_FIXATION_OFFSET = 13f / 100f;


    public static void buildPoleFixation(BranchGroup branchGroup, final float radius, final float length) {

        Cylinder poleFixation = new Cylinder(radius * 2.0f, length * POLE_FIXATION_OFFSET);
        poleFixation.setAppearance(ElementVirtualization.buildAppearance(Color.DARK_GRAY));

        Transform3D transformFixation = new Transform3D();
        transformFixation.setTranslation(new Vector3d(0.0, length - poleFixation.getHeight() / 2.0f, 0.0));
        TransformGroup groupFixation = new TransformGroup(transformFixation);
        groupFixation.addChild(poleFixation);

        branchGroup.addChild(groupFixation);
    }

    public static void buildCylindersFixation(BranchGroup branchGroup, final float radius, final float length) {


        com.sun.j3d.utils.geometry.Box fixation = new com.sun.j3d.utils.geometry.Box(radius * 2.0f, (length * CYLINDERS_FIXATION_OFFSET) / 2.0f, radius * 4.0f, ElementVirtualization.buildAppearance(Color.DARK_GRAY));
        Transform3D transformFixation = new Transform3D();
        transformFixation.setTranslation(new Vector3d(0.0, length - fixation.getYdimension() - length * POLE_FIXATION_OFFSET, 0.0));

        TransformGroup groupFixation = new TransformGroup(transformFixation);
        groupFixation.addChild(fixation);


        Cylinder cylinder = new Cylinder(radius, fixation.getXdimension() * 2.0f + radius);
        cylinder.setAppearance(ElementVirtualization.buildAppearance(Color.BLACK));

        Transform3D transformCylinder = new Transform3D();
        transformCylinder.rotZ(Math.PI / 2.0);
        Transform3D translation = new Transform3D();
        translation.setTranslation(new Vector3d(length - fixation.getYdimension() - length * POLE_FIXATION_OFFSET, 0.0, 0.0));
        transformCylinder.mul(translation);

        TransformGroup groupCylinder = new TransformGroup(transformCylinder);
        groupCylinder.addChild(cylinder);

        branchGroup.addChild(groupFixation);
        branchGroup.addChild(groupCylinder);
    }

    public static void buildPrincipalGirder(BranchGroup branchGroup, final float radius, final float length) {

        float size = length / 2.0f;
        size -= size * POLE_FIXATION_OFFSET;
        size -= size * CYLINDERS_FIXATION_OFFSET;

        com.sun.j3d.utils.geometry.Box box = new com.sun.j3d.utils.geometry.Box(radius * 2.0f, size, radius * 2.0f, ElementVirtualization.buildAppearance(Color.DARK_GRAY));
        Transform3D transformBox = new Transform3D();
        transformBox.setTranslation(new Vector3d(0.0, box.getYdimension(), 0.0));
        TransformGroup groupBox = new TransformGroup(transformBox);
        groupBox.addChild(box);

        branchGroup.addChild(groupBox);
    }
}
