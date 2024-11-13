package Bai_7.Resizeable;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Tạo mảng các hình với các đối tượng Circle, Rectangle, Square
        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Square(4.0);

        // Tạo đối tượng Random để sinh tỷ lệ ngẫu nhiên
        Random random = new Random();

        // Tăng kích thước mỗi hình với tỷ lệ ngẫu nhiên và hiển thị diện tích trước và sau khi thay đổi
        for (Resizeable shape : shapes) {
            double oldArea;
            System.out.println("Before resize: " + shape);

            // Lấy diện tích ban đầu
            if (shape instanceof Circle) {
                oldArea = ((Circle) shape).getArea();
            } else if (shape instanceof Rectangle) {
                oldArea = ((Rectangle) shape).getArea();
            } else {
                oldArea = ((Square) shape).getArea();
            }
            System.out.println("Area before resize: " + oldArea);

            // Sinh một tỷ lệ ngẫu nhiên từ 1-100% và áp dụng resize
            double percent = 1 + random.nextDouble() * 99;
            shape.resize(percent);
            System.out.println("Resized by " + percent + "%");

            // Tính diện tích mới
            double newArea;
            if (shape instanceof Circle) {
                newArea = ((Circle) shape).getArea();
            } else if (shape instanceof Rectangle) {
                newArea = ((Rectangle) shape).getArea();
            } else {
                newArea = ((Square) shape).getArea();
            }
            System.out.println("Area after resize: " + newArea);
            System.out.println();
        }
    }
}
