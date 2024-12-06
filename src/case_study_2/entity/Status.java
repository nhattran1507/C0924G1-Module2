package case_study_2.entity;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Status implements List<Status> {
    private String customerId;
    private String realEstateId;
    private int preferenceLevel;

    public Status() {}

    public Status(String customerId, String realEstateId, int preferenceLevel) {
        this.customerId = customerId;
        this.realEstateId = realEstateId;
        this.preferenceLevel = preferenceLevel;
    }

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


    @Override
    public String toString() {
        return "Status{" +
                "customerId='" + customerId + '\'' +
                ", realEstateId='" + realEstateId + '\'' +
                ", preferenceLevel=" + preferenceLevel +
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
    public Iterator<Status> iterator() {
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
    public boolean add(Status status) {
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
    public boolean addAll(Collection<? extends Status> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Status> c) {
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
    public Status get(int index) {
        return null;
    }

    @Override
    public Status set(int index, Status element) {
        return null;
    }

    @Override
    public void add(int index, Status element) {

    }

    @Override
    public Status remove(int index) {
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
    public ListIterator<Status> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Status> listIterator(int index) {
        return null;
    }

    @Override
    public List<Status> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
