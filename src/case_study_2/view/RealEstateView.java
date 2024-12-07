package case_study_2.view;

import case_study_2.controller.RealEstateController;
import case_study_2.entity.RealEstate;

import java.util.List;
import java.util.Scanner;

public class RealEstateView {
    private final RealEstateController realEstateController = new RealEstateController();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n--- Quản Lý Bất Động Sản ---");
            System.out.println("1. Thêm bất động sản");
            System.out.println("2. Tìm kiếm bất động sản theo ID");
            System.out.println("3. Hiển thị tất cả bất động sản");
            System.out.println("4. Xóa bất động sản theo ID");
            System.out.println("5. Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addRealEstate();
                    case 2 -> findRealEstateById();
                    case 3 -> displayAllRealEstates();
                    case 4 -> removeRealEstate();
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

    private void addRealEstate() {
        System.out.print("Nhập ID bất động sản: ");
        String id = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập hướng nhà: ");
        String houseDirection = scanner.nextLine();
        System.out.print("Nhập ưu điểm: ");
        String advantages = scanner.nextLine();
        System.out.print("Nhập nhược điểm: ");
        String disadvantages = scanner.nextLine();
        System.out.print("Nhập giá bán: ");
        long price;
        try {
            price = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Giá bán không hợp lệ. Hủy thao tác thêm bất động sản.");
            return;
        }

        RealEstate realEstate = new RealEstate(id, address, houseDirection, advantages, disadvantages, price);
        realEstateController.addRealEstate(realEstate);
    }

    private void findRealEstateById() {
        System.out.print("Nhập ID bất động sản cần tìm: ");
        String id = scanner.nextLine();
        RealEstate realEstate = (RealEstate) realEstateController.findRealEstateById(id);
        if (realEstate != null) {
            System.out.println("Thông tin bất động sản: " + realEstate);
        } else {
            System.out.println("Không tìm thấy bất động sản với ID: " + id);
        }
    }

    private void displayAllRealEstates() {
        List<RealEstate> realEstates = realEstateController.getAllRealEstates();
        if (realEstates.isEmpty()) {
            System.out.println("Không có bất động sản nào trong danh sách.");
        } else {
            for (RealEstate realEstate : realEstates) {
                System.out.println(realEstate);
            }
        }
    }

    private void removeRealEstate() {
        System.out.print("Nhập ID bất động sản cần xóa: ");
        String id = scanner.nextLine();
        boolean isRemoved = realEstateController.removeRealEstate(id);
        if (isRemoved) {
            System.out.println("Đã xóa bất động sản với ID: " + id);
        } else {
            System.out.println("Không tìm thấy bất động sản với ID: " + id);
        }
    }
}
