package casestudy2.entity;

public class RealEstate {
    private String id;
    private String address;
    private String direction;
    private String advantages;
    private String disadvantages;
    private long price;

    public RealEstate(String id, String address, String direction, String advantages, String disadvantages, long price) {
        this.id = id;
        this.address = address;
        this.direction = direction;
        this.advantages = advantages;
        this.disadvantages = disadvantages;
        this.price = price;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getAdvantages() {
        return advantages;
    }
    public void setAdvantages(String advantages) {
        this.advantages = advantages;
    }
    public String getDisadvantages() {
        return disadvantages;
    }
    public void setDisadvantages(String disadvantages) {
        this.disadvantages = disadvantages;
    }
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Bất động sản{ID: " + id +
                "Địa chỉ: " + address +
                "Hướng: " + direction +
                "Ưu điểm: " + advantages +
                "Nhược điểm: " + disadvantages +
                "Giá: " + price;
    }
}
