package case_study_2.view;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Hệ Thống Quản Lý Bất Động Sản ---");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý bất động sản");
            System.out.println("3. Quản lý nhu cầu mua nhà");
            System.out.println("4. Quản lý trạng thái");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> new CustomerView().menu();
                    case 2 -> new RealEstateView().menu();
                    case 3 -> new HomePurchaseDemandView().menu();
                    case 4 -> new StatusView().menu();
                    case 5 -> {
                        System.out.println("Đã thoát chương trình. Hẹn gặp lại!");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        }
    }
}
