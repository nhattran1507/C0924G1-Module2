package Bai_9.Bai2;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    // Constructor mặc định
    public MyLinkedList() {
    }

    // Thêm phần tử vào đầu danh sách
    public void addFirst(E element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    // Thêm phần tử vào cuối danh sách
    public void addLast(E element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        numNodes++;
    }

    // Thêm phần tử tại vị trí index
    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) {
            addFirst(element);
        } else {
            Node newNode = new Node(element);
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            numNodes++;
        }
    }

    // Xóa phần tử tại vị trí index
    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node temp = head;
        if (index == 0) {
            head = head.next;
            numNodes--;
            return (E) temp.getData();
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node removedNode = temp.next;
        temp.next = removedNode.next;
        numNodes--;
        return (E) removedNode.getData();
    }

    // Xóa phần tử dựa trên giá trị
    public boolean remove(Object element) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.getData().equals(element)) {
                if (prev == null) {
                    head = head.next;
                } else {
                    prev.next = temp.next;
                }
                numNodes--;
                return true;
            }
            prev = temp;
            temp = temp.next;
        }
        return false;
    }

    // Lấy phần tử tại vị trí index
    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    // Lấy phần tử đầu tiên
    public E getFirst() {
        if (head == null) {
            return null;
        }
        return (E) head.getData();
    }

    // Lấy phần tử cuối cùng
    public E getLast() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    // Trả về số lượng phần tử
    public int size() {
        return numNodes;
    }

    // Kiểm tra danh sách có chứa phần tử không
    public boolean contains(E element) {
        Node temp = head;
        while (temp != null) {
            if (temp.getData().equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Trả về vị trí của phần tử
    public int indexOf(E element) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.getData().equals(element)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    // In danh sách
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Xóa toàn bộ danh sách
    public void clear() {
        head = null;
        numNodes = 0;
    }
}
