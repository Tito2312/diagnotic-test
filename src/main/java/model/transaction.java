package model;

import java.util.Date;

public class transaction {

    private String id;
    private TransactionType type;
    private double amount;
    private Date date;

    public transaction(String id,  TransactionType type, double amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }


}
