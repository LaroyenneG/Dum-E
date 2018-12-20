package model.element;

import javax.media.j3d.Transform3D;
import javax.vecmath.Point3d;

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

    public Transform3D applyTransformation(Transform3D transform3D) {

        setTransform3D(new Transform3D(transform3D));

        return transform3D;
    }

    public void accept(ElementVisitor sv) {

        sv.virtualizationElement(this);
    }

    public Point3d getPosition() {

        final double[] u0 = new double[16];

        transform3D.get(u0);

        return new Point3d(u0[3], u0[7], u0[11]);
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
