package Bai_6.Circle;

public class Cylinder extends Circle {
    private double height;

    //Contructor không tham số
    public Cylinder() {
        super();
    }

    //Contructor có tham số
    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    //Getter và Setter cho chiều cao
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    //Phương thức tính thể tích
    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder [radius=" +getRadius() + ", height=" + height + ", color=" + getColor() + ", volume=" + getVolume() + "]";
    }
}
