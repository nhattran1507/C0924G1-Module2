package case_study_2.controller;

import case_study_2.entity.Status;
import case_study_2.service.impl.StatusService;

import java.util.List;

public class StatusController {
    private final StatusService statusService;

    // Constructor để khởi tạo StatusService
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    // Phương thức thêm trạng thái
    public void addStatus(Status status) {
        if (status != null) {
            statusService.add(status);
            System.out.println("Đã thêm trạng thái thành công!");
        } else {
            System.out.println("Trạng thái nhập không hợp lệ");
        }
    }

    public List<Status> getAllStatus() {
        List<Status> statusList = statusService.getAll();
        if (statusList.isEmpty()) {
            System.out.println("Chưa có khách hàng nào coi nhà");
        }
        return statusList;
    }

    // Phương thức tìm trạng thái của khách hàng theo CustomerId
    public List<Status> findStatusByCustomerId(String customerId) {
        List<Status> statuses = statusService.findByCustomerId(customerId);
        if (statuses == null) {
            System.out.println("Không tìm thấy trạng thái cho khách hàng có ID: " + customerId);
        }
        return statuses;
    }

    // Phương thức cập nhật trạng thái của khách hàng đối với bất động sản
    public void updateStatus(Status updatedstatus) {
        if (updatedstatus == null || updatedstatus.getCustomerId() == null || updatedstatus.getrealEstateId() == null) {
            System.out.println("Dữ liệu cập nhật không hợp lệ");
            return;
        }
        Status existStatus = (Status) statusService.findById(updatedstatus.getCustomerId());
        if (existStatus != null) {
            statusService.update(updatedstatus);
            System.out.println("Đã cập nhật trạng thái thành công");
        } else {
            System.out.println("Không tìm thấy trạng thái khách hàng với ID: " + updatedstatus.getCustomerId());
        }
    }

    public boolean removeStatus(String customerId) {
        if (statusService.remove(customerId)) {
            System.out.println("Trạng thái đã được xóa");
        } else {
            System.out.println("Không tìm thấy trạng thái với ID: " + customerId);
        }
        return false;
    }
    public boolean checkCustomerId(String customerId) {
        return statusService.isCustomerExists(customerId);
    }
    public boolean checkRealEstateId(String realEstateId) {
        return statusService.isRealEstateExists(realEstateId);
    }
}
