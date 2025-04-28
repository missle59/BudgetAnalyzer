package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SpendingEntry {
    private LocalDate date;
    private String category;
    private BigDecimal amount;

    public SpendingEntry(LocalDate date, String category, BigDecimal amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
