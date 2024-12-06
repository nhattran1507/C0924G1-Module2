package case_study_2.service.impl;

import case_study_2.entity.Status;
import case_study_2.repository.StatusRepository;
import case_study_2.service.IStatusService;

import java.util.List;

public class StatusService implements IStatusService {
    private StatusRepository statusRepository = new StatusRepository();

    @Override
    public void add(Status status) {
        statusRepository.addStatus(status);
    }

    @Override
    public List<Status> findByCustomerId(String customerId) {
        return List.of();
    }

    @Override
    public List<Status> findByRealEstateId(String realEstateId) {
        return List.of();
    }

    @Override
    public List<Status> findById(String id) {
        return statusRepository.findStatusByCustomerId(id); // Hoặc thực hiện tìm theo realEstateId
    }

    @Override
    public void update(String customerId, String realEstateId, int preferenceLevel) {
        // Cập nhật trạng thái của khách hàng đối với bất động sản
        Status status = statusRepository.findStatusByCustomerIdAndRealEstateId(customerId, realEstateId);
        if (status != null) {
            status.setPreferenceLevel(preferenceLevel);
            statusRepository.addStatus(status);
        }
    }

    @Override
    public void remove(String customerId, String realEstateId) {
        statusRepository.removeStatus(customerId, realEstateId);
    }

    @Override
    public List<Status> getAll() {
        return statusRepository.getAll();
    }
}
