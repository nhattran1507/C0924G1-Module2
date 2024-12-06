package case_study_2.service.impl;

import case_study_2.entity.RealEstate;
import case_study_2.repository.RealEstateRepository;
import case_study_2.service.IRealEstateService;

import java.util.List;

public class RealEstateService implements IRealEstateService {
    private final RealEstateRepository repository = new RealEstateRepository();

    @Override
    public void add(RealEstate realEstate) {
        repository.addRealEstate(realEstate);
    }

    @Override
    public RealEstate findById(String realEstateId) {
        return repository.findRealEstateById(realEstateId);
    }

    @Override
    public void update(String id1, String id2, int preferenceLevel) {

    }

    @Override
    public void update(RealEstate realEstate) {
        repository.updateRealEstate(realEstate);
    }

    @Override
    public void remove(String realEstateId) {
        repository.removeRealEstate(realEstateId);
    }

    @Override
    public List<RealEstate> getAll() {
        return repository.getAll();
    }
}
