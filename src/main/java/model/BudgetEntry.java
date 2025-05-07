package main.java.model;

import java.math.BigDecimal;

public class BudgetEntry {
    private final String category;
    private final BigDecimal amount;

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
}
