package Model;

import java.util.Date;

public class transaction {

    private String id;
    private TYPE_TRANSACTION type;
    private double amount;
    private Date date;

    public transaction(String id) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }
}
