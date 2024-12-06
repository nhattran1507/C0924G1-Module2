package case_study_2.repository;

import case_study_2.entity.Status;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class StatusRepository {
    private static final String FILE_PATH = "src/case_study_2/data/Status.csv";

    // Lấy tất cả các trạng thái từ file
    public List<Status> getAll() {
        File file = new File(FILE_PATH);
        List<Status> statusList = new LinkedList<>();
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
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Lỗi đọc file " + FILE_PATH);
        }
        return statusList;
    }

    // Ghi các trạng thái vào file
    private void writeFile(List<Status> statusList, boolean append) {
        File file = new File(FILE_PATH);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
            for (Status status : statusList) {
                bufferedWriter.write(status.getCustomerId() + "," +
                        status.getrealEstateId() + "," +
                        status.getPreferenceLevel());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file");
        }
    }

    // Thêm một trạng thái mới
    public void addStatus(Status status) {
        File file = new File(FILE_PATH);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(status.getCustomerId() + "," +
                    status.getrealEstateId() + "," +
                    status.getPreferenceLevel());
            bufferedWriter.newLine();
            System.out.println("Thêm trạng thái thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }

    // Tìm trạng thái theo customerId
    public List<Status> findStatusByCustomerId(String customerId) {
        List<Status> result = new LinkedList<>();
        List<Status> statusList = getAll();
        for (Status st : statusList) {
            if (st.getCustomerId().equals(customerId)) {
                result.add(st);
            }
        }
        return result;
    }

    // Tìm trạng thái theo realEstateId
    public List<Status> findStatusByRealEstateId(String realEstateId) {
        List<Status> result = new LinkedList<>();
        List<Status> statusList = getAll();
        for (Status st : statusList) {
            if (st.getrealEstateId().equals(realEstateId)) {
                result.add(st);
            }
        }
        return result;
    }

    // Cập nhật trạng thái của khách hàng theo customerId và realEstateId
    public void updateStatus(String customerId, String realEstateId, int preferenceLevel) {
        List<Status> statusList = getAll();
        boolean found = false;
        for (Status st : statusList) {
            if (st.getCustomerId().equals(customerId) && st.getrealEstateId().equals(realEstateId)) {
                st.setPreferenceLevel(preferenceLevel);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy trạng thái với Customer ID và Real Estate ID tương ứng.");
        } else {
            writeFile(statusList, false);
        }
    }

    // Xóa trạng thái theo customerId và realEstateId
    public void removeStatus(String customerId, String realEstateId) {
        List<Status> statusList = getAll();
        boolean removed = statusList.removeIf(st -> st.getCustomerId().equals(customerId) && st.getrealEstateId().equals(realEstateId));
        if (!removed) {
            System.out.println("Không tìm thấy trạng thái với Customer ID và Real Estate ID tương ứng.");
        } else {
            writeFile(statusList, false);
        }
    }

    // Tìm trạng thái theo customerId và realEstateId
    public Status findStatusByCustomerIdAndRealEstateId(String customerId, String realEstateId) {
        List<Status> statusList = getAll();
        for (Status st : statusList) {
            if (st.getCustomerId().equals(customerId) && st.getrealEstateId().equals(realEstateId)) {
                return st;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
}
