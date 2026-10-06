package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private final String id;
    private final TransactionType type;
    private final BigDecimal amount;
    private final LocalDateTime date;

    public Transaction(String id, TransactionType type, BigDecimal amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
