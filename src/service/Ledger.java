package service;

import model.BudgetEntry;
import model.SpendingEntry;

import java.util.ArrayList;
import java.util.List;

public class Ledger {
    List<BudgetEntry> budgets = new ArrayList<>();
    List<SpendingEntry> spendings = new ArrayList<>();

    public void addBudget(BudgetEntry budget) {
        budgets.add(budget);
    }

    public void addSpending(SpendingEntry spending) {
        spendings.add(spending);
    }

    public List<BudgetEntry> getBudgets() {
        return budgets;
    }

    public List<SpendingEntry> getSpendings() {
        return spendings;
    }
}
