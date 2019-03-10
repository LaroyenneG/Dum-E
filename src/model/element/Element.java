package model.element;

import javax.media.j3d.Transform3D;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

public abstract class Element implements Cloneable {

    private Transform3D transform3D;

    public Element() {
        transform3D = new Transform3D();
    }

    public Transform3D getTransform3D() {
        return transform3D;
    }

    public void setTransform3D(Transform3D transform3D) {
        this.transform3D = transform3D;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(this.getClass().getSimpleName());
        builder.append('\n');
        builder.append(transform3D);

        return new String(builder);
    }

    public abstract Transform3D transformation();

    public void applyTransformation(Transform3D transform3D) {

        setTransform3D(new Transform3D(transform3D));
    }

    public void accept(ElementVisitor sv) {

        sv.virtualizationElement(this);
    }

    public Point3d getPosition() {

        final double[] u0 = new double[16];

        transform3D.get(u0);

        return new Point3d(u0[3], u0[7], u0[11]);
    }

    public Vector3d getVector() {

        final Vector3d vector3d = new Vector3d(0.0, 1.0, 0.0);

        Transform3D transform3D = new Transform3D(this.transform3D);
        Transform3D translation = new Transform3D();
        translation.setTranslation(vector3d);

        transform3D.mul(translation);

        final double[] u1 = new double[16];

        transform3D.get(u1);

        Point3d p0 = getPosition();

        Point3d p1 = new Point3d(u1[3], u1[7], u1[11]);

        return new Vector3d(p1.x - p0.x, p1.y - p0.y, p1.z - p0.z);
    }

    @Override
    public Object clone() {

        Element element = null;

        try {

            element = (Element) super.clone();

            element.transform3D = new Transform3D(transform3D);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return element;
    }
}
