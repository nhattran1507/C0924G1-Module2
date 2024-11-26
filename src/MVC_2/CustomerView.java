package MVC_2;

import java.util.Scanner;

public class CustomerView {
    private Scanner scanner = new Scanner(System.in);

    // Hiển thị chi tiết khách hàng
    public void printCustomerDetails(String customerId, String customerName, double loanAmount) {
        System.out.println("Customer Details:");
        System.out.println("ID: " + customerId);
        System.out.println("Name: " + customerName);
        System.out.println("Loan Amount: $" + loanAmount);
        System.out.println("---------------------------");
    }

    // Hiển thị thông điệp chung
    public void printMessage(String message) {
        System.out.println(message);
    }

    // Hiển thị thông báo lỗi
    public void printError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    // Phương thức yêu cầu xác nhận từ người dùng
    public boolean getConfirmation(String action) {
        System.out.print(action + " (yes/no): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("yes");
    }
}

