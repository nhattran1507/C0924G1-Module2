package case_study_2.controller;

import case_study_2.entity.RealEstate;

import java.util.ArrayList;
import java.util.List;

public class RealEstateController {
    private final List<RealEstate> realEstates = new ArrayList<>();

    // Thêm bất động sản mới
    public void addRealEstate(RealEstate realEstate) {
        realEstates.add(realEstate);
        System.out.println("Bất động sản đã được thêm thành công.");
    }

    // Hiển thị tất cả bất động sản
    public List<RealEstate> getAllRealEstates() {
        if (realEstates.isEmpty()) {
            System.out.println("Không có bất động sản nào.");
        }
        return realEstates;
    }

    // Tìm bất động sản theo ID
    public RealEstate findRealEstateById(String id) {
        for (RealEstate realEstate : realEstates) {
            if (realEstate.getrealEstateId().equals(id)) {
                return realEstate;
            }
        }
        System.out.println("Không tìm thấy bất động sản với ID: " + id);
        return null;
    }

    // Xóa bất động sản theo ID
    public void removeRealEstate(String id) {
        realEstates.removeIf(realEstate -> realEstate.getrealEstateId().equals(id));
        System.out.println("Bất động sản với ID " + id + " đã được xóa.");
    }
}
