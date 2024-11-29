package Bai_19;

public class PhoneNumberValidatorTest {

    public static void main(String[] args) {
        String[] phoneNumbers = {
                "(84)-(0978489648)", // Hợp lệ
                "(a8)-(22222222)",   // Không hợp lệ
                "(84)-(22b22222)",   // Không hợp lệ
                "(84)-(9978489648)", // Không hợp lệ
                "(84)-(0123456789)"  // Hợp lệ
        };

        for (String phoneNumber : phoneNumbers) {
            try {
                PhoneNumberValidator.validatePhoneNumber(phoneNumber);
                System.out.println(phoneNumber + " is valid.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
