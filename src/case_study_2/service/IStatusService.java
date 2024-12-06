package case_study_2.service;

import case_study_2.entity.Status;

import java.util.List;

public interface IStatusService extends IService<Status, String> {
    List<Status> findByCustomerId(String customerId);

    void update(Status updatedstatus);

    boolean remove(String customerId);
}
