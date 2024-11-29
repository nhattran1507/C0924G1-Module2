package Bai_19;

public class ClassNameValidatorTest {
    public static void main(String[] args) {
        String[] validClassNames = {"C0223G", "A0323K"};
        String[] invalidClassNames = {"M0318G", "P0323A"};
        System.out.println("==== KIỂM TRA TÊN LỚP ====\n");
        System.out.println("Danh sách hợp lệ:");
        for (String className : validClassNames) {
            boolean isValid = ClassNameValidator.validate(className);
            System.out.println("Tên lớp \"" + className + "\" hợp lệ: " + isValid);
        }
        System.out.println("\nDanh sách không hợp lệ:");
        for (String className : invalidClassNames) {
            boolean isValid = ClassNameValidator.validate(className);
            System.out.println("Tên lớp \"" + className + "\" hợp lệ: " + isValid);
        }
    }
}
