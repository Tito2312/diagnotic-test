package Service;

import Model.TransactionType;
import Model.transaction;

public class transactionService {

    public transaction createTransaction (String id, TransactionType type, double amount) {
        transaction newTransaction;

        if (amount <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }else{
            newTransaction = new transaction(id, type, amount);
        }

        return newTransaction;
    }

    public void betTransaction (transaction transaction) {

    }

    public void winTransaction (transaction transaction) {

    }



}
