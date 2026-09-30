package service;

import model.TransactionType;
import model.transaction;

public class transactionService {

    walletService walletService = new walletService();

    public transaction createTransaction (String id, TransactionType type, double amount) {
        transaction newTransaction = new transaction(id, type, amount);

        switch (type) {
            case BET -> betTransaction(newTransaction);
            case WIN ->  winTransaction(newTransaction);
            default -> throw  new IllegalArgumentException("Unknown transaction type");
        }

        return newTransaction;
    }

    public void betTransaction (transaction transaction) {

    }

    public void winTransaction (transaction transaction) {

    }



}
