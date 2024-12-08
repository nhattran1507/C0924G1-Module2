package casestudy2.entity;

public class HomePurchaseDemand {
    private String id;
    private long budget;
    private String location;
    private String direction;
    private String purpose;

    public HomePurchaseDemand(String id, long budget, String location, String direction, String purpose) {
        this.id = id;
        this.budget = budget;
        this.location = location;
        this.direction = direction;
        this.purpose = purpose;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public long getBudget() {
        return budget;
    }
    public void setBudget(long budget) {
        this.budget = budget;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    @Override
    public String toString() {
        return "Nhu cầu mua nhà{ID: " + id +
                ", Tài chính: " + budget +
                ", Khu vực mua: " + location +
                ", Hướng : " + direction +
                ", Mục đích mua: " + purpose + "}";
    }

}
