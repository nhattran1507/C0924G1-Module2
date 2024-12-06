package case_study_2.repository;

import case_study_2.entity.Customer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CustomerRepository {
    private static final String FILE_PATH = "src/case_study_2/data/Customer.csv";

    // Lấy danh sách tất cả khách hàng
    public List<Customer> getAll() {
        File file = new File(FILE_PATH);
        List<Customer> customers = new LinkedList<>();
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + FILE_PATH);
            return customers;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    Customer customer = new Customer(
                            data[0].trim(), // ID
                            data[1].trim(), // Họ tên
                            data[2].trim(), // Số điện thoại
                            data[3].trim()  // Địa chỉ
                    );
                    customers.add(customer);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file " + FILE_PATH + ": " + e.getMessage());
        }

        return customers;
    }

    // Ghi danh sách khách hàng vào file (overwrite hoặc append)
    private void writeFile(List<Customer> customers, boolean append) {
        File file = new File(FILE_PATH);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
            for (Customer customer : customers) {
                bufferedWriter.write(customer.getId() + "," + customer.getFullName() + ","
                        + customer.getPhoneNumber() + "," + customer.getAddress());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file " + FILE_PATH + ": " + e.getMessage());
        }
    }

    // Thêm một khách hàng mới
    public void addCustomer(Customer customer) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bufferedWriter.write(customer.getId() + "," + customer.getFullName() + ","
                    + customer.getPhoneNumber() + "," + customer.getAddress());
            bufferedWriter.newLine();
            System.out.println("Thêm khách hàng mới thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi thêm khách hàng mới: " + e.getMessage());
        }
    }

    // Tìm khách hàng bằng ID
    public Customer findCustomerById(String id) {
        List<Customer> customers = getAll();
        for (Customer customer : customers) {
            if (customer.getId().equalsIgnoreCase(id)) {
                return customer;
            }
        }
        return null;
    }

    // Xóa khách hàng theo ID
    public void removeCustomer(String id) {
        List<Customer> customers = getAll();
        boolean removed = customers.removeIf(customer -> customer.getId().equalsIgnoreCase(id));
        if (removed) {
            writeFile(customers, false);
            System.out.println("Đã xóa khách hàng với ID: " + id);
        } else {
            System.out.println("Không tìm thấy khách hàng với ID: " + id);
        }
    }

    // Cập nhật thông tin khách hàng
    public void updateCustomer(Customer updatedCustomer) {
        List<Customer> customers = getAll();
        boolean found = false;

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equalsIgnoreCase(updatedCustomer.getId())) {
                customers.set(i, updatedCustomer);
                found = true;
                break;
            }
        }

        if (found) {
            writeFile(customers, false);
            System.out.println("Cập nhật thông tin khách hàng thành công.");
        } else {
            System.out.println("Không tìm thấy khách hàng với ID: " + updatedCustomer.getId());
        }
    }
}
