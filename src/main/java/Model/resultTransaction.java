package Model;

public class resultTransaction {

    String id;
    StatusTransaction status;
    int resultAmount;
    String description;
    boolean indicator;

    public resultTransaction(String id, StatusTransaction status, int resultAmount, String description, boolean indicator) {
        this.id = id;
        this.status = status;
        this.resultAmount = resultAmount;
        this.description = description;
        this.indicator = indicator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StatusTransaction getStatus() {
        return status;
    }

    public void setStatus(StatusTransaction status) {
        this.status = status;
    }

    public int getResultAmount() {
        return resultAmount;
    }

    public void setResultAmount(int resultAmount) {
        this.resultAmount = resultAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIndicator() {
        return indicator;
    }

    public void setIndicator(boolean indicator) {
        this.indicator = indicator;
    }
}
