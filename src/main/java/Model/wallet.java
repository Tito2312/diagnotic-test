package Model;

public class wallet {

    private String id;
    private double amount;

    public wallet(String id) {
        this.id = id;
        this.amount = 100000;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
