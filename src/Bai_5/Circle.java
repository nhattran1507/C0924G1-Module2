package Bai_5;

public class Circle {
    // Thuộc tính private
    private double radius = 1.0;
    private String color = "red";

    // Hàm tạo không tham số
    public Circle() {
    }

    // Hàm tạo có tham số radius
    public Circle(double r) {
        this.radius = r;
    }

    // Phương thức getRadius với access modifier là public
    public double getRadius() {
        return radius;
    }

    // Phương thức getArea với access modifier là public
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
