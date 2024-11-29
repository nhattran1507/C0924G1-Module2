package Bai_19;

public class ClassNameValidator {
    private static final String CLASS_NAME_REGEX = "^[CAP]\\d{4}[GHIK]$";

    public static boolean validate(String className) {
        return className.matches(CLASS_NAME_REGEX);
    }
}
