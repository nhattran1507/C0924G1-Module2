package MVC_2;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomerController {
    private List<Customer> customers = new ArrayList<>();
    private CustomerView view;

    public CustomerController(CustomerView view) {
        this.view = view;
    }

    // Phương thức thêm khách hàng
    public void addCustomer(String id, String name, double loanAmount) throws DuplicateCustomerException {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                throw new DuplicateCustomerException("Customer with ID: " + id + " already exists.");
            }
        }
        customers.add(new Customer(id, name, loanAmount));
        view.printMessage("Customer added successfully!");
    }

    // Phương thức đọc dữ liệu từ file CSV
    public void loadCustomersFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true; // Bỏ qua dòng tiêu đề
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length != 3) {
                    throw new IllegalArgumentException("Invalid CSV format.");
                }

                String id = fields[0].trim();
                String name = fields[1].trim();
                double loanAmount = Double.parseDouble(fields[2].trim());

                try {
                    addCustomer(id, name, loanAmount);
                } catch (DuplicateCustomerException e) {
                    view.printError("Duplicate entry for customer ID: " + id);
                }
            }
            view.printMessage("Customers loaded from file successfully!");
        } catch (IOException e) {
            view.printError("Error reading file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            view.printError("Error processing file: " + e.getMessage());
        }
    }

    // Hiển thị danh sách khách hàng
    public void displayAllCustomers() {
        if (customers.isEmpty()) {
            view.printMessage("No customers available.");
        } else {
            for (Customer customer : customers) {
                view.printCustomerDetails(customer.getId(), customer.getName(), customer.getLoanAmount());
            }
        }
    }

    // Phương thức tìm khách hàng theo ID
    public void findCustomerById(String searchId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(searchId)) {
                view.printCustomerDetails(customer.getId(), customer.getName(), customer.getLoanAmount());
                return;
            }
        }
        view.printError("Customer with ID: " + searchId + " not found.");
    }

    // Phương thức xóa khách hàng theo ID
    public void deleteCustomer(String deleteId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(deleteId)) {
                customers.remove(customer);
                view.printMessage("Customer with ID: " + deleteId + " deleted successfully.");
                return;
            }
        }
        view.printError("Customer with ID: " + deleteId + " not found.");
    }

    // Phương thức cập nhật thông tin khách hàng theo ID
    public void updateCustomer(String updateId, String newName, double newLoanAmount) {
        for (Customer customer : customers) {
            if (customer.getId().equals(updateId)) {
                customer.setName(newName);
                customer.setLoanAmount(newLoanAmount);
                view.printMessage("Customer with ID: " + updateId + " updated successfully.");
                return;
            }
        }
        view.printError("Customer with ID: " + updateId + " not found.");
    }

    public boolean isCustomerIdExists(String id) {
        return false;
    }
}
