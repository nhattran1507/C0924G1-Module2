package case_study_2.view;

import case_study_2.controller.CustomerController;
import case_study_2.entity.Customer;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private final CustomerController customerController = new CustomerController();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n--- Quản Lý Khách Hàng ---");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Tìm kiếm khách hàng theo ID");
            System.out.println("3. Hiển thị tất cả khách hàng");
            System.out.println("4. Xóa khách hàng theo ID");
            System.out.println("5. Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> findCustomerById();
                case 3 -> displayAllCustomers();
                case 4 -> removeCustomer();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void addCustomer() {
        System.out.print("Nhập ID khách hàng: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(id, name, phone, address);
        customerController.addCustomer(customer);
    }

    private void findCustomerById() {
        System.out.print("Nhập ID khách hàng cần tìm: ");
        String id = scanner.nextLine();
        Customer customer = customerController.findCustomerById(id);
        if (customer != null) {
            System.out.println("Thông tin khách hàng: " + customer);
        }
    }

    private void displayAllCustomers() {
        List<Customer> customers = customerController.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void removeCustomer() {
        System.out.print("Nhập ID khách hàng cần xóa: ");
        String id = scanner.nextLine();
        customerController.removeCustomer(id);
    }
}
