package model;

import java.math.BigDecimal;

public class BudgetEntry {
    private String category;
    private BigDecimal amount;

    public BudgetEntry(String category, BigDecimal amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
