package casestudy2.repository;

import casestudy2.entity.HomePurchaseDemand;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HomePurchaseDemandRepository {
    private static final String FILE_PATH = "src/casestudy2/data/homePurchaseDemand.csv";

    public Map<String, HomePurchaseDemand> getAll() {
        File file = new File(FILE_PATH);
        Map<String, HomePurchaseDemand> homePurchaseDemandMap = new HashMap<>();
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + FILE_PATH);
            return homePurchaseDemandMap;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    try {
                        long budget = Long.parseLong(data[1].trim());
                        HomePurchaseDemand homePurchaseDemand = new HomePurchaseDemand(
                                data[0].trim(),
                                budget,
                                data[2].trim(),
                                data[3].trim(),
                                data[4].trim()
                        );
                        homePurchaseDemandMap.put(homePurchaseDemand.getId().toLowerCase(), homePurchaseDemand);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng số: " + data[1]);
                    }
                } else {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + FILE_PATH + "-" + e.getMessage());
        }
        return homePurchaseDemandMap;
    }

    private void writfle(Map<String, HomePurchaseDemand> homePurchaseDemandMap, boolean append) {
        File file = new File(FILE_PATH);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            for (HomePurchaseDemand homePurchaseDemand : homePurchaseDemandMap.values()) {
                bw.write(homePurchaseDemand.getId() +
                        "," + homePurchaseDemand.getBudget() +
                        "," + homePurchaseDemand.getLocation() +
                        "," + homePurchaseDemand.getDirection() +
                        "," + homePurchaseDemand.getPurpose());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file" + FILE_PATH + "-" + e.getMessage());
        }
    }

    public void addHomePruchaseDemand(HomePurchaseDemand homePurchaseDemand) {
        Map<String, HomePurchaseDemand> homePurchaseDemandMap = getAll();
        homePurchaseDemandMap.put(homePurchaseDemand.getId().toLowerCase(), homePurchaseDemand);
        writfle(homePurchaseDemandMap, false);
        System.out.println("Đã thêm nhu cầu mua nhà với ID Khách hàng: " + homePurchaseDemand.getId());
    }

    public HomePurchaseDemand findHomePurchaseDemandbyID(String id) {
        Map<String, HomePurchaseDemand> homePurchaseDemandMap = getAll();
        return homePurchaseDemandMap.get(id.toLowerCase());
    }

    public void removeHomePurchaseDemand(String id) {
        Map<String, HomePurchaseDemand> homePurchaseDemandMap = getAll();
        if (homePurchaseDemandMap.containsKey(id.toLowerCase())) {
            homePurchaseDemandMap.remove(id.toLowerCase());
            writfle(homePurchaseDemandMap, false);
            System.out.println("Đã xóa nhu cầu mua nhà với ID khách hàng: " + id);
        } else {
            System.out.println("Không tìm thấy nhu cầu mua nhà với ID khách hàng" + id);
        }
    }

    public void updateHomePurchaseDemand(HomePurchaseDemand updateHomePurchaseDemand) {
        Map<String, HomePurchaseDemand> homePurchaseDemandMap = getAll();
        String id = updateHomePurchaseDemand.getId().toLowerCase();
        if (homePurchaseDemandMap.containsKey(id)) {
            homePurchaseDemandMap.put(id, updateHomePurchaseDemand);
            writfle(homePurchaseDemandMap, false);
            System.out.println("Cập nhật nhu cầu mua nhà thành công");
        } else {
            System.out.println("Không tìm nhu cầu mua nhà với ID: " + updateHomePurchaseDemand.getId());
        }
    }
}

