package model.dume.components;

import model.element.ElementVisitor;
import model.element.terminal.organ.TerminalOrgan;

import javax.media.j3d.Transform3D;
import javax.vecmath.Point3d;
import java.util.ArrayList;
import java.util.List;

public class Grapnel extends TerminalOrgan {

    public static final int DRAW_CMD_ID = 0;
    public static final int STOP_DRAW_CMD_ID = 1;
    public static final int PURGE_CMD_ID = 2;

    private boolean action;

    private List<Point3d> point3ds;

    public Grapnel() {
        point3ds = new ArrayList<>();
        action = false;
    }

    public void addPoint(Point3d point3d) {
        point3ds.add(point3d);
    }

    public void purge() {
        point3ds.clear();
    }

    @Override
    public void applyTransformation(Transform3D transform3D) {

        super.applyTransformation(transform3D);

        if (action) {
            double[] data = new double[16];
            getTransform3D().get(data);
            addPoint(new Point3d(data[3], data[7], data[11]));
        }
    }

    @Override
    public void command(int id) {

        switch (id) {

            case DRAW_CMD_ID:
                action = true;
                break;

            case STOP_DRAW_CMD_ID:
                action = false;
                break;

            case PURGE_CMD_ID:
                purge();
                break;

            default:

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

        grapnel.point3ds = new ArrayList<>(point3ds);

        return grapnel;
    }
}
