package view;


import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import model.dume.components.*;
import model.element.Element;
import model.element.ElementVisitor;
import model.element.connexion.constant.axis.AxisRotation;
import model.element.connexion.constant.axis.distance.Distance;
import model.element.connexion.joint.Rotation;
import model.element.connexion.joint.linear.Collinear;
import model.element.connexion.joint.linear.Orthogonal;
import model.element.terminal.organ.Default;
import view.dume.*;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import java.awt.*;

public class ElementVirtualization implements ElementVisitor {

    private static final float RADIUS = 0.01f;

    private static final Color DEFAULT_COLOR = Color.BLACK;

    private BranchGroup branchGroup;

    public ElementVirtualization() {
        branchGroup = new BranchGroup();
        branchGroup.setCapability(BranchGroup.ALLOW_DETACH);
    }

    public BranchGroup getResult() {
        return branchGroup;
    }

    public static Appearance buildAppearance(Color color) {

        Appearance appearance = new Appearance();
        ColoringAttributes coloringAttributes = new ColoringAttributes();
        coloringAttributes.setColor(new Color3f(color));
        appearance.setColoringAttributes(coloringAttributes);

        return appearance;
    }

    public static Node buildCylinder(float r, float h, Color color) {

        Transform3D transform3D = new Transform3D();

        transform3D.setTranslation(new Vector3d(0.0, h / 2.0, 0.0));

        TransformGroup transformGroup = new TransformGroup(transform3D);

        Cylinder cylinder = new Cylinder(r, h);
        cylinder.setAppearance(buildAppearance(color));

        transformGroup.addChild(cylinder);

        return transformGroup;
    }

    private void addToScene(Node node, Element element) {

        TransformGroup transformGroup = new TransformGroup(element.getTransform3D());

        transformGroup.addChild(node);

        branchGroup.addChild(transformGroup);
    }

    @Override
    public void virtualizationDefault(Default organ) {

        Node cylinder = buildCylinder(RADIUS, RADIUS / 2, Color.MAGENTA);

        addToScene(cylinder, organ);
    }


    @Override
    public void virtualizationElement(Element element) {

        Sphere sphere = new Sphere(RADIUS / 2);

        addToScene(sphere, element);
    }

    @Override
    public void virtualizationDistance(Distance axisMove) {

        Node cylinder = buildCylinder(RADIUS, (float) axisMove.getValue(), DEFAULT_COLOR);

        addToScene(cylinder, axisMove);
    }

    @Override
    public void virtualizationAxisRotation(AxisRotation axisRotation) {

        Sphere sphere = new Sphere(RADIUS);

        addToScene(sphere, axisRotation);
    }

    @Override
    public void virtualizationRotation(Rotation rotation) {

        Appearance appearance = new Appearance();
        ColoringAttributes coloringAttributes = new ColoringAttributes();
        coloringAttributes.setColor(new Color3f(Color.RED));
        appearance.setColoringAttributes(coloringAttributes);

        Sphere sphere = new Sphere(RADIUS * 1.5f);
        sphere.setAppearance(appearance);

        addToScene(sphere, rotation);
    }

    @Override
    public void virtualizationCollinear(Collinear collinear) {

        Node cylinder = buildCylinder(RADIUS, (float) collinear.getValue(), Color.RED);

        addToScene(cylinder, collinear);
    }

    @Override
    public void virtualizationOrthogonal(Orthogonal orthogonal) {

        Node cylinder = buildCylinder(RADIUS, (float) orthogonal.getValue(), Color.RED);

        addToScene(cylinder, orthogonal);
    }


    /**
     * Dum-E component draft man
     */


    /*
     * DraftGrapnel
     */
    @Override
    public void virtualizationGrapnel(Grapnel grapnel) {

        final float radius = RADIUS * 1.5f;

        BranchGroup branchGroup = new BranchGroup();

        DraftGrapnel.drawPoints(this.branchGroup, radius, grapnel.getPoint3ds());

        DraftGrapnel.buildBell(branchGroup, radius);

        final double offset = radius / 3;

        for (int i = 1; i <= 3; i++) {

            double angle = (Math.PI * 2.0 * i) / 3.0;

            DraftGrapnel.buildPliers(branchGroup, radius, new Vector3d(Math.cos(angle) * (radius - offset), radius, Math.sin(angle) * (radius - offset)));
        }

        addToScene(branchGroup, grapnel);
    }


    /*
     * DraftPole
     */
    @Override
    public void virtualizationPole(Pole pole) {

        BranchGroup branchGroup = new BranchGroup();

        DraftPole.buildMasterCylinder(branchGroup, RADIUS, (float) pole.getJoints()[0].getValue(), (float) pole.getJoints()[0].min);
        DraftPole.buildContentCylinder(branchGroup, RADIUS, (float) pole.getJoints()[0].min);

        addToScene(branchGroup, pole);
    }

    /*
     * First Phalanx
     */
    @Override
    public void virtualizationFirstPhalanx(FirstPhalanx firstPhalanx) {

        BranchGroup branchGroup = new BranchGroup();

        DraftFirstPhalanx.buildPatella(branchGroup, RADIUS);
        DraftFirstPhalanx.buildBloc(branchGroup, RADIUS, (float) FirstPhalanx.D5.getValue());

        addToScene(branchGroup, firstPhalanx);
    }


    /*
     * Second Phalanx
     */
    @Override
    public void virtualizationSecondPhalanx(SecondPhalanx secondPhalanx) {

        BranchGroup branchGroup = new BranchGroup();

        DraftSecondPhalanx.buildPatella(branchGroup, RADIUS);
        DraftSecondPhalanx.buildBloc(branchGroup, RADIUS, (float) SecondPhalanx.D6.getValue());

        addToScene(branchGroup, secondPhalanx);
    }

    /*
     * Girder
     */
    @Override
    public void virtualizationGirder(Girder girder) {

        BranchGroup branchGroup = new BranchGroup();

        DraftGirder.buildPrincipalGirder(branchGroup, RADIUS, (float) Girder.D3.getValue());
        DraftGirder.buildCylindersFixation(branchGroup, RADIUS, (float) Girder.D3.getValue());
        DraftGirder.buildPoleFixation(branchGroup, RADIUS, (float) Girder.D3.getValue());

        addToScene(branchGroup, girder);
    }

    /*
     * Turret
     */
    @Override
    public void virtualizationTurret(Turret turret) {

        BranchGroup branchGroup = new BranchGroup();

        DraftTurret.buildPrincipalCylinder(branchGroup, RADIUS, (float) Turret.D1.getValue());
        DraftTurret.buildCylinders(branchGroup, RADIUS, (float) Turret.D1.getValue(), (float) turret.getJoints()[0].getValue());

        addToScene(branchGroup, turret);
    }

    /*
     * Base
     */
    @Override
    public void virtualizationBase(Base base) {

        BranchGroup branchGroup = new BranchGroup();

        DraftBase.buildCylinder(branchGroup, RADIUS, (float) Base.D0.getValue());
        DraftBase.buildWheels(branchGroup, RADIUS, (float) Base.D0.getValue());
        DraftBase.buildPlate(branchGroup, RADIUS, (float) Base.D0.getValue());

        addToScene(branchGroup, base);
    }
}
