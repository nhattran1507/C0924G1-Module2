package case_study_2.repository;

import case_study_2.entity.RealEstate;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class RealEstateRepository {
    private static final String FILE_PATH = "src/case_study_2/data/RealEstate.csv";

    public List<RealEstate> getAll() {
        File file = new File(FILE_PATH);
        List<RealEstate> realEstateList = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
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
                        realEstateList.add(realEstate);
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
        return realEstateList;
    }

    private void writeFile(List<RealEstate> realEstateList, boolean append) {
        File file = new File(FILE_PATH);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
            for (RealEstate realEstate : realEstateList) {
                bufferedWriter.write(realEstate.getrealEstateId() + "," +
                        realEstate.getLocation() + "," +
                        realEstate.getHouseDirection() + "," +
                        realEstate.getAdvantages() + "," +
                        realEstate.getDisadvantages() + "," +
                        realEstate.getPrice());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file");
        }
    }

    public void addRealEstate(RealEstate realEstate) {
        File file = new File(FILE_PATH);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(realEstate.getrealEstateId() + "," +
                    realEstate.getLocation() + "," +
                    realEstate.getHouseDirection() + "," +
                    realEstate.getAdvantages() + "," +
                    realEstate.getDisadvantages() + "," +
                    realEstate.getPrice());
            bufferedWriter.newLine();
            System.out.println("Ghi vào File thành công!"
            );
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }

    public RealEstate findRealEstateById(String id) {
        File file = new File(FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6 && data[0].equals(id)) {
                    return new RealEstate(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            data[4],
                            Long.parseLong(data[5])
                    );
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số trong tệp CSV.");
        }
        System.out.println("Không tìm thấy bất động sản với ID: " + id);
        return null;
    }

    public void updateRealEstate(RealEstate realEstate) {
        List<RealEstate> realEstateList = getAll();
        boolean found = false;
        for (int i = 0; i < realEstateList.size(); i++) {
            if (realEstateList.get(i).getrealEstateId().equals(realEstate.getrealEstateId())) {
                realEstateList.set(i, realEstate);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy bất động sản với ID: " + realEstate.getrealEstateId());
        } else {
            writeFile(realEstateList, false);
        }
    }

    public void removeRealEstate(String id) {
        List<RealEstate> realEstateList = getAll();
        boolean removed = realEstateList.removeIf(re -> re.getrealEstateId().equals(id));
        if (!removed) {
            System.out.println("Không tìm thấy bất động sản với ID: " + id);
        } else {
            writeFile(realEstateList, false);
        }
    }
}
