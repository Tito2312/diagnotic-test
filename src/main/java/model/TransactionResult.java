package model;

import java.math.BigDecimal;

public class TransactionResult {

    private final String id;
    private final TransactionStatus status;
    private final BigDecimal resultBalance;
    private final String description;
    private final boolean indicator;

    public TransactionResult(String id, TransactionStatus status, BigDecimal resultBalance, String description, boolean indicator) {
        this.id = id;
        this.status = status;
        this.resultBalance = resultBalance;
        this.description = description;
        this.indicator = indicator;
    }

    public String getId() {
        return id;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public BigDecimal getResultBalance() {
        return resultBalance;
    }

    public String getDescription() {
        return description;
    }

    public boolean isIndicator() {
        return indicator;
    }

    @Override
    public String toString() {
        return "TransactionResult{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", resultBalance=" + resultBalance +
                ", description='" + description + '\'' +
                ", indicator=" + indicator +
                '}';
    }
}
