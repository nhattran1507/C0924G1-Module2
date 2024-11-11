package Bai_5;

public class Student {
    // Thuộc tính private
    private String name = "John";
    private String classes = "C02";

    // Hàm tạo không tham số
    public Student() {
    }

    // Phương thức setName có access modifier là public
    public void setName(String name) {
        this.name = name;
    }

    // Phương thức setClasses có access modifier là public
    public void setClasses(String classes) {
        this.classes = classes;
    }

    // Các phương thức getter để hiển thị thông tin (nếu cần thiết)
    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }
}

