package Bai_4;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    // Phương thức khởi tạo
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Getter cho a
    public double getA() {
        return a;
    }

    // Getter cho b
    public double getB() {
        return b;
    }

    // Getter cho c
    public double getC() {
        return c;
    }

    // Phương thức tính delta
    public double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    // Phương thức tính nghiệm thứ nhất
    public double getRoot1() {
        double delta = getDiscriminant();
        if (delta < 0) {
            return 0;
        }
        return (-b + Math.pow(delta, 0.5)) / (2 * a);
    }

    // Phương thức tính nghiệm thứ hai
    public double getRoot2() {
        double delta = getDiscriminant();
        if (delta < 0) {
            return 0;
        }
        return (-b - Math.pow(delta, 0.5)) / (2 * a);
    }
}
