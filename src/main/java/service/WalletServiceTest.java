package service;
import model.Transaction;
import model.TransactionResult;
import model.TransactionStatus;
import model.TransactionType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class WalletServiceTest {

    private WalletService service;

    @BeforeEach
    void setUp(){
        service = new WalletService(new BigDecimal("100000"));
    }

    @Test
    public void testApprovedBet(){
        Transaction transaction = new Transaction("tx-1", TransactionType.BET, new BigDecimal("20000"));

        TransactionResult result = service.processTransaction(transaction);

        assertEquals(TransactionStatus.APPROVED, result.getStatus());
        assertEquals(new BigDecimal("80000"), result.getResultBalance());
        assertFalse(result.isIndicator());
    }

    @Test
    public void testRejectedBetInsufficientBalance(){
        Transaction transaction = new Transaction("tx-2", TransactionType.BET, new BigDecimal("150000"));

        TransactionResult result = service.processTransaction(transaction);

        assertEquals(TransactionStatus.REJECTED, result.getStatus());
        assertEquals(new BigDecimal("100000"), result.getResultBalance());
        assertTrue(result.getDescription().contains("insuficiente"));
    }

    @Test
    public void testApprovedWin(){
        Transaction transaction = new Transaction("tx-3", TransactionType.WIN, new BigDecimal("20000"));

        TransactionResult result = service.processTransaction(transaction);

        assertEquals(TransactionStatus.APPROVED, result.getStatus());
        assertEquals(new BigDecimal("120000"), result.getResultBalance());
    }

    @Test
    public void testNegativeTransaction(){
        Transaction transaction = new Transaction("tx-4", TransactionType.WIN, new BigDecimal("-20000"));

        TransactionResult result = service.processTransaction(transaction);

        assertEquals(TransactionStatus.REJECTED, result.getStatus());
        assertEquals(new BigDecimal("100000"), result.getResultBalance());
    }

    @Test
    public void testDuplicateTransaction(){
        Transaction transaction = new Transaction("tx-5", TransactionType.WIN, new BigDecimal("20000"));
        Transaction transaction2 = new Transaction("tx-5", TransactionType.WIN, new BigDecimal("20000"));

        service.processTransaction(transaction);
        TransactionResult result = service.processTransaction(transaction2);

        assertTrue(result.isIndicator());
    }

    @Test
    public void testDuplicateTransactionDoesNotModifyBalance(){
        Transaction transaction = new Transaction("tx-6", TransactionType.BET, new BigDecimal("20000"));
        Transaction transaction2 = new Transaction("tx-6", TransactionType.BET, new BigDecimal("20000"));

        service.processTransaction(transaction);
        BigDecimal firstBalance = service.getWallet().getBalance();

        service.processTransaction(transaction2);
        BigDecimal secondBalance = service.getWallet().getBalance();

        assertEquals(new BigDecimal("80000"), firstBalance);
        assertEquals(new BigDecimal("80000"), secondBalance);
        assertEquals(firstBalance, secondBalance);
    }
}
