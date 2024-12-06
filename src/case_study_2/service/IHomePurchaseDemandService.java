package case_study_2.service;

import case_study_2.entity.HomePurchaseDemand;

public interface IHomePurchaseDemandService extends IService<HomePurchaseDemand, String> {
    void update(HomePurchaseDemand demand);

    boolean remove(String customerId);
}
