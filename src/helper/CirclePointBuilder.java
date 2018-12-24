package helper;

import javax.vecmath.Point3d;

public class CirclePointBuilder {

    private static final double A = 0.0;
    private static final double B = 0.0;
    private static final double R = 0.3;
    private static final double H = 0.5;

    private static String buildLine(double angle) {

        Point3d point3d = new Point3d(A + R * Math.cos(angle), H, B + R * Math.sin(angle));

        return point3d.x + " " + point3d.y + " " + point3d.z;
    }

    public static void main(String[] args) {

        for (double a = 0.0; a <= Math.PI * 2; a += 0.5) {
            System.out.println(buildLine(a));
        }
    }
}
