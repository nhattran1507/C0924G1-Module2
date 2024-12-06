package case_study_2.service.impl;

import case_study_2.entity.Customer;
import case_study_2.entity.HomePurchaseDemand;
import case_study_2.repository.CustomerRepository;
import case_study_2.repository.HomePurchaseDemandRepository;
import case_study_2.service.IHomePurchaseDemandService;

import java.util.List;

public class HomePurchaseDemandService implements IHomePurchaseDemandService {
    private final HomePurchaseDemandRepository demandRepository;
    private final CustomerRepository customerRepository;

    // Constructor nhận các repository từ bên ngoài
    public HomePurchaseDemandService(HomePurchaseDemandRepository demandRepository, CustomerRepository customerRepository) {
        this.demandRepository = demandRepository;
        this.customerRepository = customerRepository;
    }

    // Thêm nhu cầu mua nhà
    @Override
    public void add(HomePurchaseDemand demand) {
        // Kiểm tra ID khách hàng
        Customer customer = customerRepository.findCustomerById(demand.getCustomerId());
        if (customer == null) {
            System.out.println("ID khách hàng không tồn tại trong hệ thống. Vui lòng nhập lại hoặc thoát.");
            return;
        }

        // Nếu ID hợp lệ, thêm nhu cầu mua nhà
        demandRepository.addHomePurchaseDemand(demand);
        System.out.println("Thêm nhu cầu mua nhà thành công.");
    }

    // Tìm nhu cầu mua nhà theo ID khách hàng
    @Override
    public HomePurchaseDemand findById(String customerId) {
        return demandRepository.findDemandByCustomerId(customerId);
    }

    @Override
    public void update(String id1, String id2, int preferenceLevel) {

    }

    @Override
    public List<HomePurchaseDemand> getAll() {
        return demandRepository.getAll();
    }

    @Override
    public void update(HomePurchaseDemand demand) {
        demandRepository.updateHomePurchaseDemand(demand);
    }

    @Override
    public boolean remove(String customerId) {
        HomePurchaseDemand existingDemand = demandRepository.findDemandByCustomerId(customerId);
        if (existingDemand != null) {
            demandRepository.removeHomePurchaseDemand(customerId);
            return true;
        }
        return false;
    }
    public boolean isCustomerExists(String customerId) {
        Customer customer = customerRepository.findCustomerById(customerId);
        return customer != null;
    }
}
