package service;

import model.Transaction;
import model.TransactionResult;
import model.TransactionStatus;
import model.Wallet;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class WalletService {

    private final Wallet wallet;
    private final Map<String, TransactionResult> processedTransactions = new HashMap<>();

    public WalletService(BigDecimal initialBalance) {
        this.wallet = new Wallet("wallet", initialBalance);
    }

    public TransactionResult processTransaction(Transaction transaction) {
        String transactionId = transaction.getId();

        if (processedTransactions.containsKey(transactionId)) {
            TransactionResult originalResult = processedTransactions.get(transactionId);

            return new TransactionResult(
                    originalResult.getId(),
                    originalResult.getStatus(),
                    originalResult.getResultBalance(),
                    "Transaccion duplicada: "+ originalResult.getDescription(),
                    true
            );
        }

        if (transaction.getAmount() == null || transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0){
            return recordResult(transactionId, TransactionStatus.REJECTED, "El monto debe ser mayor que cero", false);
        }

        if (transaction.getType() == null) {
            return recordResult(transactionId, TransactionStatus.REJECTED, "Tipo de transaccion no soportado", false);
        }

        switch (transaction.getType()) {
            case BET:
                if (wallet.getBalance().compareTo(transaction.getAmount()) <= 0) {
                    return recordResult(transactionId, TransactionStatus.REJECTED, "Saldo insuficiente", false);
                }
                // Descuento del saldo
                wallet.setBalance(wallet.getBalance().subtract(transaction.getAmount()));
                return recordResult(transactionId, TransactionStatus.APPROVED, "Apuesta aprobada", false);

            case WIN:
                wallet.setBalance(wallet.getBalance().add(transaction.getAmount()));
                return recordResult(transactionId, TransactionStatus.APPROVED, "Premio acreditado", false);

            default:
                return recordResult(transactionId, TransactionStatus.REJECTED, "Tipo de transaccion no soportado", false);
        }
    }

    private TransactionResult recordResult(String transactionId, TransactionStatus status, String description, boolean isDuplicated) {
        TransactionResult result = new TransactionResult(transactionId, status, wallet.getBalance(), description, isDuplicated);

        if(!isDuplicated) {
            processedTransactions.put(transactionId, result);
        }
        return result;
    }

    public  Wallet getWallet() {
        return wallet;
    }

}
