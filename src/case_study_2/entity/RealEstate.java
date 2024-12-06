package case_study_2.entity;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RealEstate implements List<RealEstate> {
    private String realEstateId;
    private String address;
    private String houseDirection;
    private String advantages;
    private String disadvantages;
    private long price;

    public RealEstate(String propertyId, String location, String houseDirection, String advantages, String disadvantages, long price) {
        this.realEstateId = propertyId;
        this.address = location;
        this.houseDirection = houseDirection;
        this.advantages = advantages;
        this.disadvantages = disadvantages;
        this.price = price;
    }

    public String getrealEstateId() {
        return realEstateId;
    }

    public void setPropertyId(String propertyId) {
        this.realEstateId = propertyId;
    }

    public String getLocation() {
        return address;
    }

    public void setLocation(String location) {
        this.address = location;
    }

    public String getHouseDirection() {
        return houseDirection;
    }

    public void setHouseDirection(String houseDirection) {
        this.houseDirection = houseDirection;
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
        this.price = (long) price;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "propertyId='" + realEstateId + '\'' +
                ", location='" + address + '\'' +
                ", houseDirection='" + houseDirection + '\'' +
                ", advantages='" + advantages + '\'' +
                ", disadvantages='" + disadvantages + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<RealEstate> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(RealEstate realEstate) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends RealEstate> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends RealEstate> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public RealEstate get(int index) {
        return null;
    }

    @Override
    public RealEstate set(int index, RealEstate element) {
        return null;
    }

    @Override
    public void add(int index, RealEstate element) {

    }

    @Override
    public RealEstate remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<RealEstate> listIterator() {
        return null;
    }

    @Override
    public ListIterator<RealEstate> listIterator(int index) {
        return null;
    }

    @Override
    public List<RealEstate> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
