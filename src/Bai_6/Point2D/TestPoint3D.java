package Bai_6.Point2D;

public class TestPoint3D {
    public static void main(String[] args) {
        // Kiểm thử constructor không tham số
        Point3D point1 = new Point3D();
        System.out.println("point1: " + point1); // Kỳ vọng: (0.0,0.0,0.0)

        // Kiểm thử constructor với tham số
        Point3D point2 = new Point3D(3.5f, 4.5f, 5.5f);
        System.out.println("point2: " + point2); // Kỳ vọng: (3.5,4.5,5.5)

        // Kiểm thử getter và setter cho z
        point1.setZ(1.5f);
        System.out.println("point1: " + point1); // Kỳ vọng: (0.0,0.0,1.5)

        // Kiểm thử phương thức setXYZ và getXYZ
        point1.setXYZ(5.0f, 6.0f, 7.0f);
        float[] coords = point1.getXYZ();
        System.out.println("point1: " + point1); // Kỳ vọng: (5.0,6.0,7.0)
        System.out.println("Coordinates: " + coords[0] + "," + coords[1] + "," + coords[2]); // Kỳ vọng: 5.0,6.0,7.0
    }
}
