package model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

    private String id;
    private TransactionType type;
    private BigDecimal amount;
    private Date date;

    public Transaction(String id, TransactionType type, BigDecimal amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
