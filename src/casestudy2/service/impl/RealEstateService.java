package casestudy2.service.impl;

import casestudy2.entity.RealEstate;
import casestudy2.repository.RealEstateRepository;
import casestudy2.service.IRealEstateService;

import java.util.Map;

public class RealEstateService implements IRealEstateService {
    private final RealEstateRepository realEstateRepository = new RealEstateRepository();

    @Override
    public void add(RealEstate realEstate) {

    }

    @Override
    public void update(RealEstate realEstate) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public RealEstate findById(String id) {
        return null;
    }

    @Override
    public Map<String, RealEstate> getAll() {
        return Map.of();
    }
}
