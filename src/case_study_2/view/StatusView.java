package case_study_2.view;

import case_study_2.controller.StatusController;
import case_study_2.entity.Status;

import java.util.List;
import java.util.Scanner;

public class StatusView {
    private final StatusController statusController = new StatusController();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n--- Quản Lý Trạng Thái ---");
            System.out.println("1. Thêm trạng thái");
            System.out.println("2. Cập nhật trạng thái");
            System.out.println("3. Hiển thị tất cả trạng thái");
            System.out.println("4. Xóa trạng thái");
            System.out.println("5. Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addStatus();
                case 2 -> updateStatus();
                case 3 -> displayStatuses();
                case 4 -> removeStatus();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private void addStatus() {
        System.out.print("Nhập ID Khách hàng: ");
        String customerId = scanner.nextLine();
        System.out.println("Nhập ID nhà đất: ");
        String realEstateId = scanner.nextLine();
        System.out.println("Nhập tình trạng tương thích: ");
        int preferenceLevel = Integer.parseInt(scanner.nextLine());

        Status status = new Status(customerId, realEstateId, preferenceLevel);
        statusController.addStatus(status);
        System.out.println("Thêm trạng thái thành công!");
    }

    private void updateStatus() {
        System.out.print("Nhập ID Khách hàng: ");
        String customerId = scanner.nextLine();
        System.out.print("Nhập ID nhà đất: ");
        String realEstateId = scanner.nextLine();
        System.out.print("Nhập mức độ ưu tiên mới: ");
        int preferenceLevel = Integer.parseInt(scanner.nextLine());

        // Cập nhật trạng thái bằng cách gọi controller
        statusController.updateStatus(customerId, realEstateId, preferenceLevel);
        System.out.println("Cập nhật trạng thái thành công!");
    }

    private void displayStatuses() {
        List<Status> statuses = statusController.getAllStatuses();
        System.out.println("\n--- Danh Sách Trạng Thái ---");
        if (statuses.isEmpty()) {
            System.out.println("Không có trạng thái nào.");
        } else {
            for (Status status : statuses) {
                System.out.println(status);
            }
        }
    }

    private void removeStatus() {
        System.out.print("Nhập ID Khách hàng: ");
        String customerId = scanner.nextLine();
        System.out.print("Nhập ID nhà đất: ");
        String realEstateId = scanner.nextLine();

        // Xóa trạng thái bằng cách gọi controller
        statusController.removeStatus(customerId, realEstateId);
        System.out.println("Xóa trạng thái thành công!");
    }
}
