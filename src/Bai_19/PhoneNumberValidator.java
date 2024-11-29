package Bai_19;

public class PhoneNumberValidator {

    // Phương thức validate số điện thoại
    public static void validatePhoneNumber(String phoneNumber) throws IllegalArgumentException {
        String regex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";

        if (!phoneNumber.matches(regex)) {
            throw new IllegalArgumentException("Invalid phone number format: " + phoneNumber);
        }
    }
}
