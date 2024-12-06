package case_study_2.repository;

import case_study_2.entity.Status;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class StatusRepository {
    private static final String FILE_PATH = "src/case_study_2/data/Status.csv";

    // Lấy tất cả các trạng thái từ file
    public List<Status> getAll() {
        List<Status> statusList = new LinkedList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("File không tồn tại");
            return statusList;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    try {
                        int preferenceLevel = Integer.parseInt(data[2]);
                        Status status = new Status(data[0], data[1], preferenceLevel);
                        statusList.add(status);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng số: " + line);
                    }
                } else {
                    System.out.println("Dữ liệu không hợp lệ: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file " + FILE_PATH);
        }
        return statusList;
    }

    // Ghi các trạng thái vào file
    private void writeFile(List<Status> statusList) {
        File file = new File(FILE_PATH);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false))) {
            for (Status status : statusList) {
                bufferedWriter.write(status.getCustomerId() + "," +
                        status.getrealEstateId() + "," +
                        status.getPreferenceLevel());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file" + e.getMessage());
        }
    }

    // Thêm một trạng thái mới
    public void addStatus(Status status) {
        if (status == null) {
            System.out.println("Dữ liệu cập nhật không hợp lệ");
            return;
        }
        List<Status> statusList = getAll();
        statusList.add(status);
        writeFile(statusList);
        System.out.println("Thêm trạng thái thành công");
    }

    // Tìm trạng thái theo customerId
    public Status findStatusByCustomerId(String customerId) {
        return getAll().stream()
                .filter(status -> status.getCustomerId().equals(customerId))
                .findFirst()
                .orElse(null);
    }

    // Cập nhật trạng thái của khách hàng theo customerId và realEstateId
    public void updateStatus(Status upstatus) {
        if (upstatus == null || upstatus.getCustomerId() == null || upstatus.getrealEstateId() == null) {
            System.out.println("Dữ liệu cập nhật không thành công");
            return;
        }

        List<Status> statusList = getAll();
        boolean found = false;
        for (int i = 0; i < statusList.size(); i++) {
            if (statusList.get(i).getCustomerId().equals(upstatus.getCustomerId())) {
                statusList.set(i, upstatus);
                found = true;
                break;
            }
        }
        if (found) {
            writeFile(statusList);
            System.out.println("Cập nhật trạng thái thành công.");
        } else {
            System.out.println("Không tìm thấy yêu cầu trạng thái với ID khách hàng: " + upstatus.getCustomerId());
        }
    }

    // Xóa trạng thái theo customerId và realEstateId
    public void removeStatus(String customerId) {
        List<Status> statusList = getAll();
        boolean removed = statusList.removeIf(status-> status.getCustomerId().equals(customerId) );
        if (removed) {
            writeFile(statusList);
            System.out.println("Xóa thành công.");
        } else {
            System.out.println("Không tìm thấy yêu cầu mua nhà với ID khách hàng: " + customerId);
        }
    }
}
