package case_study_2.view;

import case_study_2.controller.StatusController;
import case_study_2.entity.Status;
import case_study_2.repository.CustomerRepository;
import case_study_2.repository.RealEstateRepository;
import case_study_2.repository.StatusRepository;
import case_study_2.service.impl.StatusService;

import java.util.List;
import java.util.Scanner;

public class StatusView {
    private final StatusController statusController;
    private final Scanner scanner = new Scanner(System.in);

    public StatusView() {
        CustomerRepository customerRepository = new CustomerRepository();
        RealEstateRepository realEstateRepository = new RealEstateRepository();
        StatusRepository statusRepository = new StatusRepository();
        StatusService statusService = new StatusService(statusRepository, customerRepository, realEstateRepository);
        this.statusController = new StatusController(statusService);
    }

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

        if (!statusController.checkCustomerId(customerId)) {
            System.out.println("ID khách hàng không tồn tại vui lòng nhập lại");
            return;
        }
        System.out.println("Nhập ID nhà đất: ");
        String realEstateId = scanner.nextLine();
        if (!statusController.checkRealEstateId(realEstateId)) {
            System.out.println("ID nhà đất không tồn tại vui lòng nhập lại");
        }

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
        Status status = new Status(customerId, realEstateId, preferenceLevel);
        statusController.updateStatus(status);
        System.out.println("Cập nhật trạng thái thành công!");
    }

    private void displayStatuses() {
        List<Status> statuses = statusController.getAllStatus();
        System.out.println("\n--- Danh Sách Trạng Thái ---");
        if (statuses.isEmpty()) {
            System.out.println("Không có trạng thái nào.");
        } else {
            statuses.forEach(System.out::println);
        }
    }

    private void removeStatus() {
        System.out.print("Nhập ID Khách hàng: ");
        String customerId = scanner.nextLine();

        if (statusController.removeStatus(customerId)) {
            System.out.println("Xóa trạng thái thành công!");
        } else {
            System.out.println("Không tìm trạng thái với ID khách hàng" + customerId);
        }
    }
}
