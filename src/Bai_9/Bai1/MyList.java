package Bai_9.Bai1;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    // Constructor mặc định với dung lượng 10
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Constructor với dung lượng do người dùng chỉ định
    public MyList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        elements = new Object[capacity];
    }

    // Đảm bảo dung lượng tối thiểu
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            elements = Arrays.copyOf(elements, minCapacity);
        }
    }

    // Thêm phần tử vào cuối danh sách
    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity(elements.length * 2);
        }
        elements[size++] = e;
        return true;
    }

    // Thêm phần tử vào vị trí chỉ định
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (size == elements.length) {
            ensureCapacity(elements.length * 2);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Lấy phần tử tại vị trí chỉ định
    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
        return (E) elements[i];
    }

    // Xóa phần tử tại vị trí chỉ định
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        E removedElement = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Xóa tham chiếu để dọn dẹp bộ nhớ
        return removedElement;
    }

    // Trả về số lượng phần tử hiện tại
    public int size() {
        return size;
    }

    // Kiểm tra xem danh sách có chứa phần tử không
    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    // Trả về vị trí của phần tử, -1 nếu không tìm thấy
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    // Tạo một bản sao của danh sách
    public E clone() {
        MyList<E> cloneList = new MyList<>(elements.length);
        cloneList.size = this.size;
        cloneList.elements = Arrays.copyOf(this.elements, this.size);
        return (E) cloneList;
    }

    // Xóa toàn bộ phần tử
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}

