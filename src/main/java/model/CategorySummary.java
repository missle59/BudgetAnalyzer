package main.java.model;

import java.math.BigDecimal;

public class CategorySummary {
    private final String category;
    private final BigDecimal budgeted;
    private final BigDecimal spent;
    private final BigDecimal difference;

    public CategorySummary(String category, BigDecimal budgeted, BigDecimal spent, BigDecimal difference) {
        this.category = category;
        this.budgeted = budgeted;
        this.spent = spent;
        this.difference = difference;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getBudgeted() {
        return budgeted;
    }

    public BigDecimal getSpent() {
        return spent;
    }

    public BigDecimal getDifference() {
        return difference;
    }
}
