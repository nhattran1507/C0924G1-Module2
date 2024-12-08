package casestudy2.repository;

import casestudy2.entity.Customer;

import java.io.*;
import java.util.*;

public class CustomerRepository {
    private static final String FILE_PATH = "src/casestudy2/data/customer.csv";

    public Map<String, Customer> getAll() {
        File file = new File(FILE_PATH);
        Map<String, Customer> customerMap = new HashMap<>();
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + FILE_PATH);
            return customerMap;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Customer customer = new Customer(
                        data[0].trim(),  // ID
                        data[1].trim(),  // Name
                        data[2].trim(),  // Phone
                        data[3].trim()   // Address
                );
                customerMap.put(customer.getId().toLowerCase(), customer);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file " + FILE_PATH + "; " + e.getMessage());
        }
        return customerMap;
    }

    private void writeFile(Map<String, Customer> customerMap, boolean append) {
        File file = new File(FILE_PATH);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            for (Customer customer : customerMap.values()) {
                bw.write(customer.getId() + "," + customer.getName() + "," + customer.getPhone() + "," + customer.getAddress());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file " + FILE_PATH + "; " + e.getMessage());
        }
    }

    public void addCustomer(Customer customer) {
        Map<String, Customer> customerMap = getAll();
        customerMap.put(customer.getId().toLowerCase(), customer);
        writeFile(customerMap, false); // Ghi đè toàn bộ file
        System.out.println("Đã thêm khách hàng với ID: " + customer.getId());
    }

    public Customer findCustomerById(String id) {
        Map<String, Customer> customerMap = getAll();
        return customerMap.get(id.toLowerCase()); // Tìm kiếm nhanh bằng Map
    }

    public void removeCustomerById(String id) {
        Map<String, Customer> customerMap = getAll();
        if (customerMap.containsKey(id.toLowerCase())) {
            customerMap.remove(id.toLowerCase());
            writeFile(customerMap, false); // Ghi đè toàn bộ file
            System.out.println("Đã xóa khách hàng với ID: " + id);
        } else {
            System.out.println("Không tìm thấy khách hàng với ID: " + id);
        }
    }

    public void updateCustomer(Customer updatedCustomer) {
        Map<String, Customer> customerMap = getAll();
        String customerId = updatedCustomer.getId().toLowerCase();
        if (customerMap.containsKey(customerId)) {
            customerMap.put(customerId, updatedCustomer); // Cập nhật thông tin
            writeFile(customerMap, false); // Ghi đè toàn bộ file
            System.out.println("Cập nhật thông tin khách hàng thành công.");
        } else {
            System.out.println("Không tìm thấy khách hàng với ID: " + updatedCustomer.getId());
        }
    }
    public Customer findCustomerByDetail(String name, String phone, String address) {
        Map<String, Customer> customerMap = getAll();
        for (Customer customer : customerMap.values()) {
            if (customer.getName().equalsIgnoreCase(name.trim())&&customer.getPhone().equals(phone.trim()) && customer.getAddress().equalsIgnoreCase(address.trim())) {
                return customer;
            }
        }
        return null;
    }
}
