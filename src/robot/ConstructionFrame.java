package robot;

import javax.vecmath.Vector3d;

public class ConstructionFrame implements Cloneable {

    private Vector3d x;
    private Vector3d y;
    private Vector3d z;

    public ConstructionFrame(Vector3d x, Vector3d y, Vector3d z) {
        this.x = new Vector3d(x);
        this.y = new Vector3d(y);
        this.z = new Vector3d(z);
    }

    public Vector3d getX() {
        return new Vector3d(x);
    }

    public void setX(Vector3d x) {
        this.x = new Vector3d(x);
    }

    public Vector3d getY() {
        return new Vector3d(y);
    }

    public void setY(Vector3d y) {
        this.y = new Vector3d(y);
    }

    public Vector3d getZ() {
        return new Vector3d(y);
    }

    public void setZ(Vector3d z) {
        this.z = new Vector3d(z);
    }

    public boolean isOrthogonal() {
        return true;
    }

    @Override
    public Object clone() {

        return new ConstructionFrame(x, y, z);
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof ConstructionFrame)) {
            return false;
        }

        ConstructionFrame constructionFrame = (ConstructionFrame) object;

        return x.equals(constructionFrame.x) && y.equals(constructionFrame.y) && z.equals(constructionFrame.z);
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
