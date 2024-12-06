package case_study_2.service.impl;

import case_study_2.entity.Customer;
import case_study_2.entity.RealEstate;
import case_study_2.entity.Status;
import case_study_2.repository.CustomerRepository;
import case_study_2.repository.RealEstateRepository;
import case_study_2.repository.StatusRepository;
import case_study_2.service.IStatusService;

import java.util.List;

public class StatusService implements IStatusService {
    private final StatusRepository statusRepository;
    private final CustomerRepository customerRepository;
    private final RealEstateRepository realEstateRepository;
    public StatusService(StatusRepository statusRepository, CustomerRepository customerRepository,RealEstateRepository realEstateRepository) {
        this.statusRepository = statusRepository;
        this.customerRepository = customerRepository;
        this.realEstateRepository = realEstateRepository;
    }

    @Override
    public void add(Status status) {
        statusRepository.addStatus(status);
    }

    @Override
    public List<Status> findByCustomerId(String customerId) {
        return List.of();
    }

    @Override
    public void update(Status updatedstatus) {

    }

    @Override
    public List<Status> findById(String id) {
        return statusRepository.findStatusByCustomerId(id); // Hoặc thực hiện tìm theo realEstateId
    }

    @Override
    public void update(String customerId, String realEstateId, int preferenceLevel) {
        // Cập nhật trạng thái của khách hàng đối với bất động sản
        Status status = statusRepository.findStatusByCustomerId(customerId);
        if (status != null) {
            status.setPreferenceLevel(preferenceLevel);
            statusRepository.addStatus(status);
        }
    }



    @Override
    public boolean remove(String customerId) {
        statusRepository.removeStatus(customerId);
        return false;
    }

    @Override
    public List<Status> getAll() {

        return statusRepository.getAll();
    }
    public boolean isCustomerExists(String customerId) {
        Customer customer = customerRepository.findCustomerById(customerId);
        return customer != null;
    }
    public boolean isRealEstateExists(String realEstateId) {
        RealEstate realEstate = realEstateRepository.findRealEstateById(realEstateId);
        return realEstate != null;
    }

}
