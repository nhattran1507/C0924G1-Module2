package Bai_6.Point;

public class TestMovablePoint {
    public static void main(String[] args) {
        // Kiểm thử constructor không tham số
        MovablePoint point1 = new MovablePoint();
        System.out.println("point1: " + point1); // Kỳ vọng: (0.0,0.0), speed=(0.0,0.0)

        // Kiểm thử constructor với tham số
        MovablePoint point2 = new MovablePoint(3.5f, 4.5f, 1.5f, 2.5f);
        System.out.println("point2: " + point2); // Kỳ vọng: (3.5,4.5), speed=(1.5,2.5)

        // Kiểm thử getter và setter cho xSpeed và ySpeed
        point1.setXSpeed(1.0f);
        point1.setYSpeed(1.5f);
        System.out.println("point1: " + point1); // Kỳ vọng: (0.0,0.0), speed=(1.0,1.5)

        // Kiểm thử phương thức setSpeed và getSpeed
        point1.setSpeed(2.0f, 3.0f);
        float[] speed = point1.getSpeed();
        System.out.println("Speed: " + speed[0] + "," + speed[1]); // Kỳ vọng: 2.0,3.0

        // Kiểm thử phương thức move
        point1.move();
        System.out.println("After move, point1: " + point1); // Kỳ vọng: (2.0,3.0), speed=(2.0,3.0)
        point1.move();
        System.out.println("After move again, point1: " + point1); // Kỳ vọng: (4.0,6.0), speed=(2.0,3.0)
    }
}
