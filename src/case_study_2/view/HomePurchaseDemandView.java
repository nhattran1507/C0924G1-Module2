package case_study_2.view;

import case_study_2.controller.HomePurchaseDemandController;
import case_study_2.entity.HomePurchaseDemand;
import case_study_2.repository.CustomerRepository;
import case_study_2.repository.HomePurchaseDemandRepository;
import case_study_2.service.impl.HomePurchaseDemandService;

import java.util.List;
import java.util.Scanner;

public class HomePurchaseDemandView {
    private final HomePurchaseDemandController homePurchaseDemandController;
    private final Scanner scanner = new Scanner(System.in);

    public HomePurchaseDemandView() {
        CustomerRepository customerRepository = new CustomerRepository();
        HomePurchaseDemandRepository homePurchaseDemandRepository = new HomePurchaseDemandRepository();
        HomePurchaseDemandService homePurchaseDemandService = new HomePurchaseDemandService(homePurchaseDemandRepository, customerRepository);
        this.homePurchaseDemandController = new HomePurchaseDemandController(homePurchaseDemandService);
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Quản Lý Nhu Cầu Mua Nhà ---");
            System.out.println("1. Thêm nhu cầu mua nhà");
            System.out.println("2. Cập nhật nhu cầu mua nhà");
            System.out.println("3. Hiển thị tất cả nhu cầu");
            System.out.println("4. Xóa nhu cầu mua nhà");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ!");
                continue;
            }

            switch (choice) {
                case 1 -> addHomePurchaseDemand();
                case 2 -> updateHomePurchaseDemand();
                case 3 -> displayAllHomePurchaseDemands();
                case 4 -> removeHomePurchaseDemand();
                case 5 -> {
                    System.out.println("Thoát chương trình quản lý nhu cầu mua nhà.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
    }

    private void addHomePurchaseDemand() {
        System.out.print("Nhập ID khách hàng: ");
        String customerId = scanner.nextLine();

        // Kiểm tra ID khách hàng có trong hệ thống không
        while (!homePurchaseDemandController.checkCustomerId(customerId)) {
            System.out.print("ID khách hàng chưa có trong hệ thống. Nhập lại ID khách hàng (hoặc gõ 'exit' để thoát): ");
            customerId = scanner.nextLine();
            if (customerId.equalsIgnoreCase("exit")) {
                System.out.println("Bạn đã yêu cầu thoát. Quay lại menu chính...");
                return;
            }
        }

        // Kiểm tra ID khách hàng trong file HomePurchaseDemand.csv
        if (homePurchaseDemandController.checkId(customerId)) {
            System.out.println("Khách hàng đã có nhu cầu mua nhà trong hệ thống. Dưới đây là thông tin:");
            HomePurchaseDemand existingDemand = homePurchaseDemandController.findHomePurchaseById(customerId);
            System.out.println(existingDemand);

            System.out.print("Bạn có muốn cập nhật thông tin không? (y/n): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                updateHomePurchaseDemand();
            } else {
                System.out.println("Không thực hiện cập nhật. Quay lại menu chính...");
            }
            return;
        } else {
            System.out.println("ID khách hàng hợp lệ nhưng chưa có trong danh sách nhu cầu mua nhà.");
        }

        // Thu thập thông tin mới từ người dùng
        System.out.print("Nhập tài chính mua nhà: ");
        long budget;
        try {
            budget = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Số tiền không hợp lệ. Vui lòng nhập lại.");
            return;
        }

        System.out.print("Nhập khu vực khách muốn mua: ");
        String preferredLocation = scanner.nextLine();

        System.out.print("Nhập hướng khách muốn mua: ");
        String preferredDirection = scanner.nextLine();

        System.out.print("Nhập mục đích mua nhà: ");
        String purpose = scanner.nextLine();

        HomePurchaseDemand demand = new HomePurchaseDemand(customerId, budget, preferredLocation, preferredDirection, purpose);
        homePurchaseDemandController.addHomePurchaseDemand(demand);
    }


    private void displayAllHomePurchaseDemands() {
        List<HomePurchaseDemand> demands = homePurchaseDemandController.getAllHomePurchaseDemands();
        System.out.println("\n--- Danh sách nhu cầu mua nhà ---");
        if (demands.isEmpty()) {
            System.out.println("Không có nhu cầu mua nhà nào.");
        } else {
            demands.forEach(System.out::println);
        }
    }

    private void updateHomePurchaseDemand() {
        System.out.print("Nhập ID khách hàng cần cập nhật: ");
        String customerId = scanner.nextLine();

        HomePurchaseDemand existingDemand = homePurchaseDemandController.findHomePurchaseById(customerId);
        if (existingDemand == null) {
            System.out.println("Không tìm thấy nhu cầu mua nhà với ID khách hàng này.");
            return;
        }

        System.out.println("Cập nhật nhu cầu mua nhà (bỏ trống để giữ nguyên):");

        System.out.print("Tài chính mới (Hiện tại: " + existingDemand.getBudget() + "): ");
        String newBudgetInput = scanner.nextLine();
        if (!newBudgetInput.isEmpty()) {
            try {
                existingDemand.setBudget(Long.parseLong(newBudgetInput));
            } catch (NumberFormatException e) {
                System.out.println("Số tiền không hợp lệ. Cập nhật bỏ qua.");
            }
        }

        System.out.print("Khu vực mới (Hiện tại: " + existingDemand.getPreferredLocation() + "): ");
        String newLocation = scanner.nextLine();
        if (!newLocation.isEmpty()) {
            existingDemand.setPreferredLocation(newLocation);
        }

        System.out.print("Hướng mới (Hiện tại: " + existingDemand.getPreferredDirection() + "): ");
        String newDirection = scanner.nextLine();
        if (!newDirection.isEmpty()) {
            existingDemand.setPreferredDirection(newDirection);
        }

        System.out.print("Mục đích mới (Hiện tại: " + existingDemand.getPurpose() + "): ");
        String newPurpose = scanner.nextLine();
        if (!newPurpose.isEmpty()) {
            existingDemand.setPurpose(newPurpose);
        }

        homePurchaseDemandController.updateHomePurchaseDemand(existingDemand);
    }

    private void removeHomePurchaseDemand() {
        System.out.print("Nhập ID khách hàng muốn xóa: ");
        String customerId = scanner.nextLine();

        if (homePurchaseDemandController.removeHomePurchaseDemand(customerId)) {
            System.out.println("Xóa nhu cầu mua nhà thành công.");
        } else {
            System.out.println("Không tìm thấy nhu cầu mua nhà với ID khách hàng: " + customerId);
        }
    }
}