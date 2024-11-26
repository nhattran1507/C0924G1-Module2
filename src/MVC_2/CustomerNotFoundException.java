package MVC_2;

// Custom Exception for Business Logic
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}

