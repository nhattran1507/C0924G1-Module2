package Bai_5.Circle;

import Bai_5.Circle.Circle;

public class TestCircle {
    public static void main(String[] args) {
        // Tạo đối tượng Circle không tham số
        Circle circle1 = new Circle();
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Area: " + circle1.getArea());

        // Tạo đối tượng Circle có tham số radius
        Circle circle2 = new Circle(2.5);
        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Area: " + circle2.getArea());
    }
}

