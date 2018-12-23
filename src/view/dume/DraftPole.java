package view.dume;

import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import view.ElementVirtualization;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import java.awt.*;

public class DraftPole {

    private static final float RADIUS_C = (1.0f / 6);

    private static final float OFFSET = 10f / 100;

    public static void buildMasterCylinder(BranchGroup branchGroup, final float radius, final float size, float minimalSize) {

        if (minimalSize < 0) {
            minimalSize = 0f;
        }

        Node toe = ElementVirtualization.buildCylinder(radius + radius * RADIUS_C, minimalSize * OFFSET, Color.DARK_GRAY);

        Transform3D transformToe = new Transform3D();
        transformToe.setTranslation(new Vector3d(0.0, size - minimalSize * OFFSET, 0.0));

        TransformGroup groupToe = new TransformGroup(transformToe);
        groupToe.addChild(toe);

        branchGroup.addChild(ElementVirtualization.buildCylinder(radius, size, Color.GRAY));
        branchGroup.addChild(groupToe);
    }

    public static void buildContentCylinder(BranchGroup branchGroup, final float radius, float minimalSize) {

        if (minimalSize < 0) {
            minimalSize = 0f;
        }

        Appearance appearance = new Appearance();
        ColoringAttributes coloringAttributes = new ColoringAttributes();
        coloringAttributes.setColor(new Color3f(Color.DARK_GRAY));
        appearance.setColoringAttributes(coloringAttributes);

        Node contentCylinder = ElementVirtualization.buildCylinder(radius + radius * RADIUS_C, minimalSize - minimalSize * OFFSET, Color.DARK_GRAY);

        Cylinder engine = new Cylinder(radius * 2.0f, radius * 5.0f);

        Transform3D transformEngine = new Transform3D();
        transformEngine.setTranslation(new Vector3d(0.0, -engine.getHeight() * 2.0, 0.0));
        TransformGroup groupEngine = new TransformGroup(transformEngine);
        groupEngine.addChild(engine);

        Cylinder engineFixation = new Cylinder(radius + radius * RADIUS_C, engine.getHeight() * 2.0f);
        engineFixation.setAppearance(appearance);
        Transform3D engineTransformFix = new Transform3D();
        engineTransformFix.setTranslation(new Vector3d(0.0, -engineFixation.getHeight() / 2.0, 0.0));
        TransformGroup groupEngineFix = new TransformGroup(engineTransformFix);
        groupEngineFix.addChild(engineFixation);

        Sphere fixation = new Sphere(radius * 2);
        fixation.setAppearance(appearance);


        branchGroup.addChild(contentCylinder);
        branchGroup.addChild(fixation);
        branchGroup.addChild(groupEngine);
        branchGroup.addChild(groupEngineFix);
    }
}
