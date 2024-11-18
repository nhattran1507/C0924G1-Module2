package Bai_9.Bai1;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();

        // Thêm phần tử vào danh sách
        list.add("Java");
        list.add("Python");
        list.add("C++");
        System.out.println("Danh sách sau khi thêm: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Thêm phần tử vào vị trí chỉ định
        list.add(1, "JavaScript");
        System.out.println("Danh sách sau khi thêm tại vị trí 1:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Kiểm tra phần tử có tồn tại
        System.out.println("Danh sách có chứa 'Python': " + list.contains("Python"));

        // Xóa phần tử
        System.out.println("Xóa phần tử tại vị trí 2: " + list.remove(2));
        System.out.println("Danh sách sau khi xóa:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Lấy kích thước danh sách
        System.out.println("Kích thước danh sách: " + list.size());

        // Xóa toàn bộ danh sách
        list.clear();
        System.out.println("Danh sách sau khi xóa toàn bộ: " + list.size());
    }
}

