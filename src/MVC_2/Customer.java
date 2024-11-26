package MVC_2;

// Model: Customer.java
public class Customer {
    private String id;
    private String name;
    private double loanAmount;

    public Customer(String id, String name, double loanAmount) {
        this.id = id;
        this.name = name;
        this.loanAmount = loanAmount;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "Customer{id='" + id + "', name='" + name + "', loanAmount=" + loanAmount + "}";
    }
}

