package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SpendingEntry {
    private final LocalDate date;
    private final String category;
    private final BigDecimal amount;

    public SpendingEntry(LocalDate date, String category, BigDecimal amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
