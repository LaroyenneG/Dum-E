package robot;

import javax.vecmath.Point3d;

public class ConstructionFrame implements Cloneable {

    private Point3d o;
    private Point3d x;
    private Point3d y;
    private Point3d z;

    public ConstructionFrame(Point3d o, Point3d x, Point3d y, Point3d z) {
        this.x = new Point3d(x);
        this.y = new Point3d(y);
        this.z = new Point3d(z);
        this.o = new Point3d(o);
    }

    public Point3d getX() {
        return new Point3d(x);
    }

    public void setX(Point3d x) {
        this.x = new Point3d(x);
    }

    public Point3d getY() {
        return new Point3d(y);
    }

    public void setY(Point3d y) {
        this.y = new Point3d(y);
    }

    public Point3d getZ() {
        return new Point3d(y);
    }

    public void setZ(Point3d z) {
        this.z = new Point3d(z);
    }

    public Point3d getO() {
        return new Point3d(o);
    }

    public void setO(Point3d o) {
        this.o = new Point3d(o);
    }

    public boolean isOrthonormal() {

        return o.distance(x) == o.distance(y) && o.distance(y) == o.distance(z);
    }

    @Override
    public Object clone() {

        return new ConstructionFrame(o, x, y, z);
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof ConstructionFrame)) {
            return false;
        }

        ConstructionFrame constructionFrame = (ConstructionFrame) object;

        return o.equals(constructionFrame.o) && x.equals(constructionFrame.x) && y.equals(constructionFrame.y) && z.equals(constructionFrame.z);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("ConstructionFrame[");
        builder.append("\n\t");
        builder.append(x);
        builder.append("\n\t");
        builder.append(y);
        builder.append("\n\t");
        builder.append(z);
        builder.append("]\n");

        return new String(builder);
    }
}
