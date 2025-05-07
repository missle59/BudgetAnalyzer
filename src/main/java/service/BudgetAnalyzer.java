package main.java.service;

import main.java.model.BudgetEntry;
import main.java.model.CategorySummary;
import main.java.model.SpendingEntry;

import java.math.BigDecimal;
import java.util.*;

public class BudgetAnalyzer {
    private final Ledger ledger;

    public BudgetAnalyzer(Ledger ledger) {
        this.ledger = ledger;
    }

    public List<CategorySummary> summarize() {
        List<CategorySummary> summaries = new ArrayList<>();
        Map<String, BigDecimal> spendCategory = new HashMap<>();
        for (SpendingEntry spendingEntry : ledger.getSpendings()) {
            spendCategory.merge(spendingEntry.getCategory(), spendingEntry.getAmount(), BigDecimal::add);
        }
        Map<String, BigDecimal> budgetCategory = new HashMap<>();
        for (BudgetEntry budgetEntry : ledger.getBudgets()) {
            budgetCategory.put(budgetEntry.getCategory(), budgetEntry.getAmount());
        }
        Set<String> allCategories = new HashSet<>(spendCategory.keySet());
        allCategories.addAll(budgetCategory.keySet());
        for (String category : allCategories) {
            BigDecimal spent = spendCategory.getOrDefault(category, BigDecimal.ZERO);
            BigDecimal budget = budgetCategory.getOrDefault(category, BigDecimal.ZERO);
            BigDecimal difference = spent.subtract(budget);
            summaries.add(new CategorySummary(category, budget, spent, difference));
        }
        return summaries;
    }
}
