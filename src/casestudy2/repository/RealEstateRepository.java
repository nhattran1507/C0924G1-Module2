package casestudy2.repository;

import casestudy2.entity.RealEstate;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RealEstateRepository {
    private static final String FILE_PATH = "src/casestudy2/data/realestate.csv";

    public Map<String, RealEstate> getAll() {
        File file = new File(FILE_PATH);
        Map<String, RealEstate> realEstateMap = new HashMap<>();
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + FILE_PATH);
            return realEstateMap;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    try {
                        long price = Long.parseLong(data[5]);
                        RealEstate realEstate = new RealEstate(
                                data[0],
                                data[1],
                                data[2],
                                data[3],
                                data[4],
                                price
                        );
                        realEstateMap.put(realEstate.getId().toLowerCase(), realEstate);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng số: " + line);
                    }
                } else {
                    System.out.println("Dữ liệu không hợp lệ: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc ghi file" + FILE_PATH);
        }
        return realEstateMap;
    }
    public void writeFile(Map<String, RealEstate> realEstateMap, boolean append) {
        File file = new File(FILE_PATH);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))){
            for (RealEstate realEstate: realEstateMap.values()) {
                bw.write(realEstate.getId() +
                        "," + realEstate.getAddress() +
                        "," + realEstate.getDirection() +
                        "," + realEstate.getAdvantages() +
                        "," + realEstate.getDisadvantages() +
                        "," + realEstate.getPrice());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file" + FILE_PATH + ";" + e.getMessage());
        }
    }
    public void addRealEstate(RealEstate realEstate) {
        Map<String, RealEstate> realEstateMap = getAll();
        realEstateMap.put(realEstate.getId().toLowerCase(), realEstate);
        writeFile(realEstateMap, false);
        System.out.println("Đã thêm bất động sản với ID" + realEstate.getId());
    }
    public RealEstate findRealEstateById(String id) {
        Map<String, RealEstate> realEstateMap = getAll();
        return realEstateMap.get(id.toLowerCase());
    }
    public void removeRealEstateById(String id) {
        Map<String, RealEstate> realEstateMap = getAll();
        if (realEstateMap.containsKey(id.toLowerCase())) {
            realEstateMap.remove(id.toLowerCase());
            writeFile(realEstateMap, false);
            System.out.println("Đã xóa khách hàng với ID" + id);
        } else {
            System.out.println("Không tìm thấy khách hàng với ID" + id);
        }
    }
    public void updateRealEstate(RealEstate realEstate) {
        Map<String, RealEstate> realEstateMap = getAll();
        String id = realEstate.getId().toLowerCase();
        if (realEstateMap.containsKey(id)) {
            realEstateMap.put(id, realEstate);
            writeFile(realEstateMap, false);
            System.out.println("Cập nhật thông tin Bất động sản thành công");
        } else {
            System.out.println("Không tìm thấy Bất động sản với ID " + realEstate.getId());
        }
    }
}
