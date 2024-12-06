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
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addRealEstate();
                case 2 -> findRealEstateById();
                case 3 -> displayAllRealEstates();
                case 4 -> removeRealEstate();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
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
        System.out.println("Nhập ưu điểm: ");
        String advantages = scanner.nextLine();
        System.out.println("Nhập nhược điểm: ");
        String disadvantages = scanner.nextLine();
        System.out.println("Nhập giá bán: ");
        long price = Long.parseLong(scanner.nextLine());

        RealEstate realEstate = new RealEstate(id, address,houseDirection,advantages,disadvantages,price);
        realEstateController.addRealEstate(realEstate);
    }

    private void findRealEstateById() {
        System.out.print("Nhập ID bất động sản cần tìm: ");
        String id = scanner.nextLine();
        RealEstate realEstate = (RealEstate) realEstateController.findRealEstateById(id);
        if (realEstate != null) {
            System.out.println("Thông tin bất động sản: " + realEstate);
        }
    }

    private void displayAllRealEstates() {
        List<RealEstate> realEstates = realEstateController.getAllRealEstates();
        for (RealEstate realEstate : realEstates) {
            System.out.println(realEstate);
        }
    }

    private void removeRealEstate() {
        System.out.print("Nhập ID bất động sản cần xóa: ");
        String id = scanner.nextLine();
        realEstateController.removeRealEstate(id);
    }
}
