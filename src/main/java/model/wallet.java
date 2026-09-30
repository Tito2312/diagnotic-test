package model;

import java.math.BigDecimal;

public class wallet {

    private final String id;
    private BigDecimal balance;

    public wallet(String id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }
    public BigDecimal getAmount() {
        return balance;
    }
    public void setAmount(BigDecimal balance) {
        this.balance = balance;
    }
}
