package Bai_7.Colorable;

public class Main {
    public static void main(String[] args) {
        // Tạo một mảng các đối tượng hình học chỉ chứa Square
        Shape[] shapes = new Shape[2];
        shapes[0] = new Square(4.0);
        shapes[1] = new Square(7.0);

        // Duyệt qua mảng và hiển thị diện tích, nếu là Colorable thì gọi howToColor()
        for (Shape shape : shapes) {
            System.out.println(shape);

            if (shape instanceof Square) {
                System.out.println("Area: " + ((Square) shape).getArea());
            }

            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }

            System.out.println();
        }
    }
}
