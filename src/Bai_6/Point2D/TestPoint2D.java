package Bai_6.Point2D;

public class TestPoint2D {
    public static void main(String[] args) {
        // Kiểm thử constructor không tham số
        Point2D point1 = new Point2D();
        System.out.println("point1: " + point1); // Kỳ vọng: (0.0,0.0)

        // Kiểm thử constructor với tham số
        Point2D point2 = new Point2D(3.5f, 4.5f);
        System.out.println("point2: " + point2); // Kỳ vọng: (3.5,4.5)

        // Kiểm thử getter và setter cho x và y
        point1.setX(2.5f);
        point1.setY(1.5f);
        System.out.println("point1: " + point1); // Kỳ vọng: (2.5,1.5)

        // Kiểm thử phương thức setXY và getXY
        point1.setXY(5.0f, 6.0f);
        float[] coords = point1.getXY();
        System.out.println("point1: " + point1); // Kỳ vọng: (5.0,6.0)
        System.out.println("Coordinates: " + coords[0] + "," + coords[1]); // Kỳ vọng: 5.0,6.0
    }
}

