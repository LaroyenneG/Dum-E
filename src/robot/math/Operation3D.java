package robot.math;

import javax.vecmath.Point3d;

public interface Operation3D {

    Operation3D translate(Point3d point3d);

    Operation3D rotoationOnX(double d);

    Operation3D rotoationOnY(double d);

    Operation3D rotoationOnZ(double d);
}
