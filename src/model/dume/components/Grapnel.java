package model.dume.components;

import model.element.ElementVisitor;
import model.element.terminal.organ.TerminalOrgan;

import javax.media.j3d.Transform3D;
import javax.vecmath.Point3d;
import java.util.ArrayList;
import java.util.List;

public class Grapnel extends TerminalOrgan {

    private List<Point3d> point3ds;

    public Grapnel() {
        point3ds = new ArrayList<>();
    }

    public void addPoint(Point3d point3d) {
        point3ds.add(point3d);
    }

    public void purge() {
        point3ds.clear();
    }

    @Override
    public Transform3D applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        if (isAction()) {
            double[] data = new double[16];
            getTransform3D().get(data);
            addPoint(new Point3d(data[3], data[7], data[11]));
        }

        return transform3D;
    }

    @Override
    public void setAction(boolean action) {
        super.setAction(action);
        if (!action) {
            purge();
        }
    }

    @Override
    public Transform3D transformation() {
        return new Transform3D();
    }

    @Override
    public void accept(ElementVisitor sv) {
        sv.virtualizationGrapnel(this);
    }

    public List<Point3d> getPoint3ds() {
        return point3ds;
    }

    @Override
    public Object clone() {

        Grapnel grapnel = null;

        grapnel = (Grapnel) super.clone();

        grapnel.point3ds = new ArrayList<>();

        return grapnel;
    }
}
