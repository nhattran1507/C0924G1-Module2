package case_study_2.controller;

import case_study_2.entity.HomePurchaseDemand;
import case_study_2.service.impl.HomePurchaseDemandService;

import java.util.List;

public class HomePurchaseDemandController {
    private final HomePurchaseDemandService homePurchaseDemandService;

    // Constructor nhận đối tượng HomePurchaseDemandService từ bên ngoài
    public HomePurchaseDemandController(HomePurchaseDemandService homePurchaseDemandService) {
        this.homePurchaseDemandService = homePurchaseDemandService;
    }

    // Thêm một nhu cầu mua nhà mới
    public void addHomePurchaseDemand(HomePurchaseDemand homePurchaseDemand) {
        if (homePurchaseDemand != null) {
            homePurchaseDemandService.add(homePurchaseDemand);
            System.out.println("Thêm nhu cầu mua nhà thành công.");
        } else {
            System.out.println("Nhu cầu mua nhà không hợp lệ.");
        }
    }

    // Lấy danh sách tất cả các nhu cầu mua nhà
    public List<HomePurchaseDemand> getAllHomePurchaseDemands() {
        List<HomePurchaseDemand> demands = homePurchaseDemandService.getAll();
        if (demands.isEmpty()) {
            System.out.println("Không có nhu cầu mua nhà nào.");
        }
        return demands;
    }

    public HomePurchaseDemand findHomePurchaseById(String id) {
        HomePurchaseDemand demand = homePurchaseDemandService.findById(id);
        if (demand == null) {
            System.out.println("Không tìm thấy nhu cầu mua nhà với ID khách hàng: " + id);
        }
        return demand;
    }

    public void updateHomePurchaseDemand(HomePurchaseDemand updatedDemand) {
        if (updatedDemand == null || updatedDemand.getCustomerId() == null) {
            System.out.println("Dữ liệu cập nhật không hợp lệ.");
            return;
        }
        HomePurchaseDemand existingDemand = homePurchaseDemandService.findById(updatedDemand.getCustomerId());
        if (existingDemand != null) {
            homePurchaseDemandService.update(updatedDemand);
            System.out.println("Nhu cầu mua nhà đã được cập nhật thành công.");
        } else {
            System.out.println("Không tìm thấy nhu cầu mua nhà với ID khách hàng: " + updatedDemand.getCustomerId());
        }
    }

    public boolean checkCustomerId(String customerId) {
        return homePurchaseDemandService.isCustomerExists(customerId);
    }

    public boolean removeHomePurchaseDemand(String customerId) {
        if (homePurchaseDemandService.remove(customerId)) {
            System.out.println("Nhu cầu mua nhà đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy nhu cầu mua nhà với ID khách hàng: " + customerId);
        }
        return false;
    }
}
