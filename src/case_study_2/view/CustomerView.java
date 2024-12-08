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
            System.out.println("\n--- Quản lý khách hàng ---");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Sửa khách hàng");
            System.out.println("3. Xóa khách hàng");
            System.out.println("4. Hiển thị danh sách khách hàng");
            System.out.println("5. Quay lại menu chính");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addCustomer();
                    case 2 -> updateCustomer();
                    case 3 -> removeCustomer();
                    case 4 -> displayAllCustomers();
                    case 5 -> {
                        System.out.println("Quay lại menu chính...");
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        }
    }

    private void addCustomer() {
        String id;
        while (true) {
            System.out.print("Nhập ID khách hàng: ");
            id = scanner.nextLine();
            if (customerController.findCustomerById(id) != null) {
                System.out.println("ID đã tồn tại trong hệ thống. Vui lòng nhập lại.");
            } else {
                break;
            }
        }
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số điện thoại (10 chữ số): ");
        String phone;
        while (true) {
            phone = scanner.nextLine();
            if (phone.matches("\\d{10}")) {
                break;
            } else {
                System.out.print("Số điện thoại không hợp lệ. Vui lòng nhập lại (10 chữ số): ");
            }
        }
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();


        Customer existingCustomer = customerController.checkCustomer(name, phone, address);
        if (existingCustomer != null) {
            System.out.println("Khách hàng đã tồn tại trong hệ thống với ID: " + existingCustomer.getId());
            return;
        }
        Customer customer = new Customer(id, name, phone, address);
        customerController.addCustomer(customer);
    }

    private void updateCustomer() {
        System.out.print("Nhập ID khách hàng cần sửa: ");
        String id = scanner.nextLine();
        Customer existingCustomer = customerController.findCustomerById(id);
        if (existingCustomer == null) {
            System.out.println("Không tìm thấy khách hàng với ID này.");
            return;
        }
        System.out.println("Thông tin khách hàng hiện tại: ");
        System.out.println(existingCustomer);
        System.out.print("Nhập tên khách hàng mới (bỏ qua để giữ nguyên): ");
        String name = scanner.nextLine();
        if (!name.trim().isEmpty()) {
            existingCustomer.setFullName(name);
        }
        System.out.print("Nhập số điện thoại mới (10 chữ số)(bỏ qua để giữ nguyên: ");
        String phone;
        while (true) {
            phone = scanner.nextLine();
            if (phone.matches("\\d{10}")) {
                break;
            } else {
                System.out.print("Số điện thoại không hợp lệ. Vui lòng nhập lại (10 chữ số): ");
            }
        }
        if (!phone.trim().isEmpty()) {
            existingCustomer.setPhoneNumber(phone);
        }
        System.out.print("Nhập địa chỉ mới (bỏ qua để giữ nguyên): ");
        String address = scanner.nextLine();
        if (!address.trim().isEmpty()) {
            existingCustomer.setAddress(address);
        }
        customerController.updateCustomer(existingCustomer);
        System.out.println("Thông tin khách hàng đã được cập nhật.");
    }

    private void removeCustomer() {
        System.out.print("Nhập ID khách hàng cần xóa: ");
        String id = scanner.nextLine();
        customerController.removeCustomer(id);
    }

    private void displayAllCustomers() {
        List<Customer> customers = customerController.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
