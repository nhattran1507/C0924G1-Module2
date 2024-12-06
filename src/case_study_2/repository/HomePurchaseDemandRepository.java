package case_study_2.repository;

import case_study_2.entity.HomePurchaseDemand;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class HomePurchaseDemandRepository {
    private static final String FILE_PATH = "src/case_study_2/data/HomePurchaseDemand.csv";

    // Lấy tất cả các yêu cầu mua nhà từ file CSV
    public List<HomePurchaseDemand> getAll() {
        List<HomePurchaseDemand> demandList = new LinkedList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("File không tồn tại: " + FILE_PATH);
            return demandList;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    try {
                        long budget = Long.parseLong(data[1]);
                        demandList.add(new HomePurchaseDemand(data[0], budget, data[2], data[3], data[4]));
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng số: " + data[1]);
                    }
                } else {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + FILE_PATH + " - " + e.getMessage());
        }

        return demandList;
    }

    // Ghi danh sách yêu cầu mua nhà vào file CSV
    private void writeFile(List<HomePurchaseDemand> demandList) {
        File file = new File(FILE_PATH);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false))) {
            for (HomePurchaseDemand demand : demandList) {
                bufferedWriter.write(String.join(",", demand.getCustomerId(),
                        String.valueOf(demand.getBudget()),
                        demand.getPreferredLocation(),
                        demand.getPreferredDirection(),
                        demand.getPurpose()));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi dữ liệu vào file: " + e.getMessage());
        }
    }

    // Thêm yêu cầu mua nhà mới
    public void addHomePurchaseDemand(HomePurchaseDemand demand) {
        if (demand == null) {
            System.out.println("Dữ liệu yêu cầu mua nhà không hợp lệ.");
            return;
        }

        List<HomePurchaseDemand> demandList = getAll();
        demandList.add(demand);
        writeFile(demandList);
        System.out.println("Thêm yêu cầu mua nhà thành công.");
    }

    // Tìm yêu cầu mua nhà theo Customer ID
    public HomePurchaseDemand findDemandByCustomerId(String customerId) {
        return getAll().stream()
                .filter(demand -> demand.getCustomerId().equals(customerId))
                .findFirst()
                .orElse(null);
    }

    // Cập nhật yêu cầu mua nhà
    public void updateHomePurchaseDemand(HomePurchaseDemand demand) {
        if (demand == null || demand.getCustomerId() == null) {
            System.out.println("Dữ liệu cập nhật không hợp lệ.");
            return;
        }

        List<HomePurchaseDemand> demandList = getAll();
        boolean found = false;

        for (int i = 0; i < demandList.size(); i++) {
            if (demandList.get(i).getCustomerId().equals(demand.getCustomerId())) {
                demandList.set(i, demand);
                found = true;
                break;
            }
        }

        if (found) {
            writeFile(demandList);
            System.out.println("Cập nhật yêu cầu mua nhà thành công.");
        } else {
            System.out.println("Không tìm thấy yêu cầu mua nhà với ID khách hàng: " + demand.getCustomerId());
        }
    }

    // Xóa yêu cầu mua nhà theo Customer ID
    public void removeHomePurchaseDemand(String customerId) {
        List<HomePurchaseDemand> demandList = getAll();
        boolean removed = demandList.removeIf(demand -> demand.getCustomerId().equals(customerId));

        if (removed) {
            writeFile(demandList);
            System.out.println("Xóa yêu cầu mua nhà thành công.");
        } else {
            System.out.println("Không tìm thấy yêu cầu mua nhà với ID khách hàng: " + customerId);
        }

    }
}
