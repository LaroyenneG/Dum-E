package robot.math;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

public class ConstructionFrame implements Cloneable, Operation3D {

    private Point3d o;
    private Point3d x;
    private Point3d y;
    private Point3d z;

    public ConstructionFrame(Point3d o, Point3d x, Point3d y, Point3d z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.o = o;
    }

    public ConstructionFrame() {
        this(new Point3d(0, 0, 0), new Point3d(1, 0, 0), new Point3d(0, 1, 0), new Point3d(0, 0, 1));
    }

    public boolean isOrthogonal() {

        Vector3d vX = new Vector3d(x.x - o.x, x.y - o.y, x.z - o.z);
        Vector3d vY = new Vector3d(y.x - o.x, y.y - o.y, y.z - o.z);
        Vector3d vZ = new Vector3d(z.x - o.x, z.y - o.y, z.z - o.z);

        double d1 = vX.angle(vY);
        double d2 = vY.angle(vZ);
        double d3 = vZ.angle(vX);


        return d1 == d2 && d2 == d3 && d1 == Math.PI / 2.0;
    }

    public boolean axisHaveSameLength() {
        return o.distance(x) == o.distance(y) && o.distance(y) == o.distance(z) && o.distance(x) == o.distance(z);
    }

    @Override
    public Object clone() {

        return new ConstructionFrame(new Point3d(o), new Point3d(x), new Point3d(y), new Point3d(z));
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
        builder.append(o);
        builder.append("\n\t");
        builder.append(x);
        builder.append("\n\t");
        builder.append(y);
        builder.append("\n\t");
        builder.append(z);
        builder.append("]\n");

        return new String(builder);
    }


    /*
     * Getter and Setter
     */
    public Point3d getO() {
        return o;
    }

    public void setO(Point3d o) {
        this.o = o;
    }

    public Point3d getX() {
        return x;
    }

    public void setX(Point3d x) {
        this.x = x;
    }

    public Point3d getY() {
        return y;
    }

    public void setY(Point3d y) {
        this.y = y;
    }

    public Point3d getZ() {
        return z;
    }

    public void setZ(Point3d z) {
        this.z = z;
    }


    /*
     * Operation3D
     */

    @Override
    public Operation3D translate(Point3d point3d) {
        return null;
    }

    @Override
    public Operation3D rotoationOnX(double d) {
        return null;
    }

    @Override
    public Operation3D rotoationOnY(double d) {
        return null;
    }

    @Override
    public Operation3D rotoationOnZ(double d) {
        return null;
    }
}
