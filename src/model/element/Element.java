package model.element;

import model.ElementVisitor;

import javax.media.j3d.Transform3D;

public abstract class Element {

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

        sv.virtualizedElement(this);
    }
}
