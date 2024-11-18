package Bai_9.Bai2;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();

        // Thêm phần tử
        linkedList.addFirst("A");
        linkedList.addLast("B");
        linkedList.addLast("C");
        linkedList.add(1, "D");

        // In danh sách
        System.out.println("Danh sách ban đầu:");
        linkedList.printList();

        // Xóa phần tử
        System.out.println("Xóa phần tử tại index 2: " + linkedList.remove(2));
        linkedList.printList();

        // Kiểm tra chứa phần tử
        System.out.println("Danh sách có chứa 'B': " + linkedList.contains("B"));

        // Lấy phần tử
        System.out.println("Phần tử đầu tiên: " + linkedList.getFirst());
        System.out.println("Phần tử cuối cùng: " + linkedList.getLast());

        // Lấy kích thước danh sách
        System.out.println("Kích thước danh sách: " + linkedList.size());

        // Xóa toàn bộ danh sách
        linkedList.clear();
        System.out.println("Kích thước danh sách sau khi xóa: " + linkedList.size());
    }
}
