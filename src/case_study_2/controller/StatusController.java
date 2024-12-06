package case_study_2.controller;

import case_study_2.entity.Status;
import case_study_2.service.IStatusService;

import java.util.List;

public class StatusController {
    private IStatusService statusService;

    // Constructor để khởi tạo StatusService
    public StatusController() {
        this.statusService = statusService;
    }

    // Phương thức thêm trạng thái
    public void addStatus(String customerId, String realEstateId, int preferenceLevel) {
        Status status = new Status(customerId, realEstateId, preferenceLevel);
        statusService.add(status);
        System.out.println("Đã thêm trạng thái thành công!");
    }

    // Phương thức tìm trạng thái của khách hàng theo CustomerId
    public void findStatusByCustomerId(String customerId) {
        List<Status> statuses = statusService.findById(customerId); // Tìm trạng thái theo customerId
        if (statuses.isEmpty()) {
            System.out.println("Không tìm thấy trạng thái cho khách hàng có ID: " + customerId);
        } else {
            for (Status status : statuses) {
                System.out.println(status);
            }
        }
    }

    // Phương thức tìm trạng thái của bất động sản theo RealEstateId
    public void findStatusByRealEstateId(String realEstateId) {
        List<Status> statuses = statusService.findById(realEstateId); // Tìm trạng thái theo realEstateId
        if (statuses.isEmpty()) {
            System.out.println("Không tìm thấy trạng thái cho bất động sản có ID: " + realEstateId);
        } else {
            for (Status status : statuses) {
                System.out.println(status);
            }
        }
    }

    // Phương thức cập nhật trạng thái của khách hàng đối với bất động sản
    public void updateStatus(String customerId, String realEstateId, int preferenceLevel) {
        statusService.update(customerId, realEstateId, preferenceLevel); // Cập nhật trạng thái
        System.out.println("Đã cập nhật trạng thái thành công!");
    }

    // Phương thức xóa trạng thái của khách hàng đối với bất động sản
    public void removeStatus(String customerId, String realEstateId) {
        statusService.remove(customerId, realEstateId); // Xóa trạng thái
        System.out.println("Đã xóa trạng thái thành công!");
    }

    // Phương thức lấy tất cả trạng thái
    public List<Status> getAllStatuses() {
        return statusService.getAll(); // Giả sử IStatusService có phương thức getAll()
    }

    public void addStatus(Status status) {
    }
}
