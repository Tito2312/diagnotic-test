package org.main;

import model.Transaction;
import model.TransactionResult;
import model.TransactionStatus;
import model.TransactionType;
import service.WalletService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        BigDecimal initalBalance = new BigDecimal("100000");
        WalletService walletService = new WalletService(initalBalance);

        List<Transaction> testTransactions = List.of(
                new Transaction("tx-001", TransactionType.BET, new BigDecimal("20000")),
                new Transaction("tx-002", TransactionType.WIN, new BigDecimal("15000")),
                new Transaction("tx-003", TransactionType.BET, new BigDecimal("120000")),
                new Transaction("tx-001", TransactionType.BET, new BigDecimal("20000")),
                new Transaction("tx-004", TransactionType.BET, new BigDecimal("-5000")),
                new Transaction("tx-005", TransactionType.WIN, new BigDecimal("10000"))
        );

        List< TransactionResult> results = new ArrayList<>();
        int approvedCount = 0;
        int rejectedCount = 0;
        int duplicatedCount = 0;

        System.out.println("Procesando transacciones");

        for(Transaction transaction : testTransactions) {

            TransactionResult result = walletService.processTransaction(transaction);
            results.add(result);

            if (result.isIndicator()) {
                duplicatedCount++;
            } else if (result.getStatus() == TransactionStatus.APPROVED) {
                approvedCount++;
            } else if (result.getStatus() == TransactionStatus.REJECTED) {
                rejectedCount++;
            }

            System.out.println(result.toString());
        }

        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("Saldo final esperado/obtenido: " + walletService.getWallet().getBalance());
        System.out.println("Transacciones aprobadas: " + approvedCount);
        System.out.println("Transacciones rechazadas: " + rejectedCount);
        System.out.println("Solicitudes repetidas: " + duplicatedCount);
    }
}