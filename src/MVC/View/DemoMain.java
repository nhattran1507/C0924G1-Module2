package mvc.view;

import mvc.controller.StudentController;
import mvc.entity.Student;

import java.util.List;
import java.util.Scanner;

public class DemoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chào mừng bạn đến với trang quản lý CodeGym");

        while (true) {
            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Quản lý giáo viên");
            System.out.println("3. Thoát");
            int choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    menuStudent();
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }

    }

    public static void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();

        System.out.println("Quản lý học sinh");
        while (true) {
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm học sinh");
            System.out.println("3. Sửa thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Tìm kiếm học sinh");
            System.out.println("6. Quay lại");

            int choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    List<Student> students = studentController.display();
                    for (Student student: students) {
                        System.out.println(student);
                    }
                    break;
                case 2:
                    System.out.println("Thêm học sinh");
                    studentController.add(inputStudent());
                    System.out.println("Thêm mới thành công");
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Xóa học sinh");
                    System.out.print("Nhập id cần xóa: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Student student = studentController.findById(id);
                    if (student == null) {
                        System.out.println("Không tìm thấy học sinh có id là: "+ id);
                    } else {
                        System.out.println("Thông tin học sinh cần xóa: "+ student+". \n Bạn có chắc muốn xóa học sinh này không?. " +
                                "\nLưu ý: Hành động này không thể hoàn tác.");
                        System.out.println("Bấm y để xác nhận. Bấm phím bất kỳ để hủy.");
                        char confirm = scanner.nextLine().charAt(0);
                        if (confirm == 'y') {
                            studentController.remove(id);
                            System.out.println("Xóa thành công");
                        } else {
                            System.out.println("Hủy xóa");
                        }
                    }
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }

    }

    public static Student inputStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhâp mã học sinh:");
        int code = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên học sinh:");
        String name = scanner.nextLine();
        while (!name.matches("^([A-Z][a-z]{1,10}[ ])+[A-Z][a-z]{0,10}$")) {
            System.out.print("Nhập lại tên do sai đinh dạng: ");
            name = scanner.nextLine();
        }
        System.out.print("Nhập địa chỉ học sinh:");
        String address = scanner.nextLine();
        System.out.print("Nhập điểm học sinh: ");
        float point = Float.parseFloat(scanner.nextLine());
        Student student = new Student(code, name, address, point);
        return student;
    }

    private static int getChoice(Scanner scanner)  {
        System.out.print("Mời bạn nhập lựa chọn: ");
        int choice =0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Choice phải là số");
        } catch (Exception e) {
            System.out.println("Lỗi không xác định");
        }
        return choice;
    }
}
