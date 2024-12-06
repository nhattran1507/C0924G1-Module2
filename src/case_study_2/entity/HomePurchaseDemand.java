package case_study_2.entity;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class HomePurchaseDemand implements List<HomePurchaseDemand> {
    private String customerId;
    private long budget;
    private String preferredLocation;
    private String preferredDirection;
    private String purpose;

    public HomePurchaseDemand() {}

    public HomePurchaseDemand(String customerId, long budget, String preferredLocation, String preferredDirection, String purpose) {
        this.customerId = customerId;
        this.budget = budget;
        this.preferredLocation = preferredLocation;
        this.preferredDirection = preferredDirection;
        this.purpose = purpose;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public String getPreferredDirection() {
        return preferredDirection;
    }

    public void setPreferredDirection(String preferredDirection) {
        this.preferredDirection = preferredDirection;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "HomePurchaseDemand{" +
                "customerId='" + customerId + '\'' +
                ", budget=" + budget +
                ", preferredLocation='" + preferredLocation + '\'' +
                ", preferredDirection='" + preferredDirection + '\'' +
                ", purpose='" + purpose + '\'' +
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
    public Iterator<HomePurchaseDemand> iterator() {
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
    public boolean add(HomePurchaseDemand homePurchaseDemand) {
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
    public boolean addAll(Collection<? extends HomePurchaseDemand> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends HomePurchaseDemand> c) {
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
    public HomePurchaseDemand get(int index) {
        return null;
    }

    @Override
    public HomePurchaseDemand set(int index, HomePurchaseDemand element) {
        return null;
    }

    @Override
    public void add(int index, HomePurchaseDemand element) {

    }

    @Override
    public HomePurchaseDemand remove(int index) {
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
    public ListIterator<HomePurchaseDemand> listIterator() {
        return null;
    }

    @Override
    public ListIterator<HomePurchaseDemand> listIterator(int index) {
        return null;
    }

    @Override
    public List<HomePurchaseDemand> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
