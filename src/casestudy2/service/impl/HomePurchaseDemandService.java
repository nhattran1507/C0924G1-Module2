package casestudy2.service.impl;

import casestudy2.entity.HomePurchaseDemand;
import casestudy2.repository.HomePurchaseDemandRepository;
import casestudy2.service.IHomePurchaseDemandService;

import java.util.Map;

public class HomePurchaseDemandService implements IHomePurchaseDemandService {
    private final HomePurchaseDemandRepository homePurchaseDemandRepository = new HomePurchaseDemandRepository();

    @Override
    public void add(HomePurchaseDemand homePurchaseDemand) {
        homePurchaseDemandRepository.addHomePruchaseDemand(homePurchaseDemand);

    }

    @Override
    public void update(HomePurchaseDemand homePurchaseDemand) {
        homePurchaseDemandRepository.updateHomePurchaseDemand(homePurchaseDemand);
    }

    @Override
    public void remove(String id) {
        homePurchaseDemandRepository.removeHomePurchaseDemand(id);
    }

    @Override
    public HomePurchaseDemand findById(String id) {
        return homePurchaseDemandRepository.findHomePurchaseDemandbyID(id);
    }

    @Override
    public Map<String, HomePurchaseDemand> getAll() {
        return homePurchaseDemandRepository.getAll();
    }
}
