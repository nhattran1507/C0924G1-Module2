package case_study_2.entity;

public class Status {
    private String customerId;  // ID khách hàng
    private String realEstateId;  // ID bất động sản
    private int preferenceLevel;  // Mức độ ưu tiên của khách hàng đối với bất động sản (ví dụ: 1 - cao, 2 - trung bình, 3 - thấp)

    // Constructor mặc định
    public Status() {}

    // Constructor với tham số
    public Status(String customerId, String realEstateId, int preferenceLevel) {
        this.customerId = customerId;
        this.realEstateId = realEstateId;
        this.preferenceLevel = preferenceLevel;
    }

    // Getter và Setter cho các trường
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getrealEstateId() {
        return realEstateId;
    }

    public void setRealEstateId(String realEstateId) {
        this.realEstateId = realEstateId;
    }

    public int getPreferenceLevel() {
        return preferenceLevel;
    }

    public void setPreferenceLevel(int preferenceLevel) {
        this.preferenceLevel = preferenceLevel;
    }

    // Phương thức toString() để hiển thị đối tượng dưới dạng chuỗi
    @Override
    public String toString() {
        return "Status{" +
                "customerId='" + customerId + '\'' +
                ", realEstateId='" + realEstateId + '\'' +
                ", preferenceLevel=" + preferenceLevel +
                '}';
    }
}
