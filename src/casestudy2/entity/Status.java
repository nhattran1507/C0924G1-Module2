package casestudy2.entity;

public class Status {
    private String customerId;
    private String realEstateId;
    private String level;
    public Status(String customerId, String realEstateId, String level) {
        this.customerId = customerId;
        this.realEstateId = realEstateId;
        this.level = level;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getRealEstateId() {
        return realEstateId;
    }
    public void setRealEstateId(String realEstateId) {
        this.realEstateId = realEstateId;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Tình trạng khách hàng: KHID:" + customerId +
                ", BĐSID" + realEstateId +
                ",tình trạng quan tâm " + level;
    }
}
