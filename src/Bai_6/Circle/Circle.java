package Bai_6.Circle;

public class Circle {
    // Thuộc tính
    private double radius;
    private String color;

    //Constructor không tham số
    public Circle() {
        this.radius = 1.0;
        this.color = "black";
    }

    //Construtor có tham số
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    //Getter và Setter cho bán kính
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", color=" + color + ", area=" + getArea() + "]";
    }

}
