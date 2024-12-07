package case_study_2.controller;

import case_study_2.entity.RealEstate;
import case_study_2.repository.RealEstateRepository;

import java.util.List;

public class RealEstateController {
    private final RealEstateRepository realEstatesRepository = new RealEstateRepository();


    public void addRealEstate(RealEstate realEstate) {
        realEstatesRepository.addRealEstate(realEstate);
        System.out.println("Bất động sản đã được thêm thành công.");
    }

    public List<RealEstate> getAllRealEstates() {
        List<RealEstate> realEstates = realEstatesRepository.getAll();
        if (realEstates.isEmpty()) {
            System.out.println("Không có bất động sản nào.");
        }
        return realEstates;
    }

    public List<RealEstate> findRealEstateById(String id) {
        List<RealEstate> realEstates = realEstatesRepository.findRealEstateById(id);
        if (realEstates == null) {
        System.out.println("Không tìm thấy bất động sản với ID: " + id);
        }
        return realEstates;
    }

    public boolean removeRealEstate(String id) {
        realEstatesRepository.removeRealEstate(id);
        System.out.println("Bất động sản với ID " + id + " đã được xóa.");
        return false;
    }
}
