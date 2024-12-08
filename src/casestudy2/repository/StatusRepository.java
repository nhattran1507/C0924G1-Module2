package casestudy2.repository;

import casestudy2.entity.Status;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StatusRepository {
    private static final String FILE_PATH = "src/casestudy2/data/status.csv";

    public Map<String, Status> getAll() {
        File file = new File(FILE_PATH);
        Map<String, Status> map = new HashMap<>();
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + FILE_PATH);
            return map;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Status status = new Status(
                        data[0],
                        data[1],
                        data[2]
                );
                map.put(status.getCustomerId().toLowerCase(), status);
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi fie: " + FILE_PATH + "_" + e.getMessage());
        }
        return map;
    }

    private void writeFile(Map<String, Status> map, boolean append) {
        File file = new File(FILE_PATH);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            for (Status status : map.values()) {
                bw.write(status.getCustomerId() +
                        status.getRealEstateId() +
                        status.getLevel());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi fie: " + FILE_PATH + "_" + e.getMessage());
        }
    }

    public void add(Status status) {
        Map<String, Status> map = getAll();
        map.put(status.getCustomerId().toLowerCase(), status);
        writeFile(map, true);
        System.out.println("Đã thêm trạng thái mua nhà với ID khách hàng: " + status.getCustomerId().toLowerCase());
    }

    public Status findStatusById(String customerId) {
        Map<String, Status> map = getAll();
        return map.get(customerId.toLowerCase());
    }

    public void remove(String customerId) {
        Map<String, Status> map = getAll();
        if (map.containsKey(customerId.toLowerCase())) {
            map.remove(customerId.toLowerCase());
            writeFile(map, false);
            System.out.println("Đã xóa trạng thái mua nhà với ID khách hàng: " + customerId);
        } else {
            System.out.println("Không tìm thấy trạng thái mua nhà với ID khách hàng: " + customerId);
        }
    }
    public void update(Status status) {
        Map<String, Status> map = getAll();
        String id = status.getCustomerId().toLowerCase();
        if (map.containsKey(id)) {
            map.put(id, status);
            writeFile(map, false);
            System.out.println("Cập nhật trạng thái mua nhà thành công");
        } else {
            System.out.println("Không tìm thấy trạng thái mua nhà với ID: " + status.getCustomerId());
        }
    }
}
