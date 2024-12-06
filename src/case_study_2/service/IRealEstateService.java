package case_study_2.service;

import case_study_2.entity.RealEstate;

public interface IRealEstateService extends IService<RealEstate, String> {
    void update(RealEstate realEstate);

    void remove(String realEstateId);
}
