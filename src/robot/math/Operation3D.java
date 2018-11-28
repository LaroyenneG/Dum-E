package robot.math;

/* In this interface only methods must return a clone of current entity  */

public interface Operation3D {

    Operation3D move(double distance);

    Operation3D rotationOnX(double d);

    Operation3D rotationOnY(double d);

    Operation3D rotationOnZ(double d);
}
