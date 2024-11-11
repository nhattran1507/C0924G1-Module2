package Bai_5;

public class Test {
    public static void main(String[] args) {
        // Tạo đối tượng Student
        Student student = new Student();

        // Thay đổi thông tin tên và lớp của student
        student.setName("Alice");
        student.setClasses("C01");

        // In ra thông tin của student
        System.out.println("Name: " + student.getName());
        System.out.println("Classes: " + student.getClasses());
    }
}

