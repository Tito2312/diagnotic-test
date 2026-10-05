package model;

import java.math.BigDecimal;

public class Wallet {

    private final String id;
    private BigDecimal balance;

    public Wallet(String id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
