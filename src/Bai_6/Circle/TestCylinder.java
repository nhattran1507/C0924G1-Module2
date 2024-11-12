package Bai_6.Circle;

public class TestCylinder {
    public static void main(String[] args) {
        //  Tạo đối tượng Cylinder
        Cylinder cylinder1 = new Cylinder();
        System.out.println(cylinder1.toString());

        Cylinder cylinder2 = new Cylinder(2.5,4.0, "green");
        System.out.println(cylinder2.toString());
    }
}
