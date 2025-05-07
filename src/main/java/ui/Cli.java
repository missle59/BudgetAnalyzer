package main.java.ui;

import main.java.model.BudgetEntry;
import main.java.model.CategorySummary;
import main.java.model.SpendingEntry;
import main.java.parser.CsvParser;
import main.java.service.BudgetAnalyzer;
import main.java.service.Ledger;

import java.io.Console;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Cli {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar budget-analyzer.jar <budgets.csv> <spendings.csv>");
            System.exit(1);
        }
        Path budgetPath = Paths.get(args[0]);
        Path spendingPath = Paths.get(args[1]);

        CsvParser parser = new CsvParser();
        Ledger ledger = new Ledger();

        try {
            List<BudgetEntry> budgets = parser.readBudgets(budgetPath);
            for (BudgetEntry budget : budgets) {
                ledger.addBudget(budget);
            }

            List<SpendingEntry> spendings = parser.readSpendings(spendingPath);
            for (SpendingEntry spending : spendings) {
                ledger.addSpending(spending);
            }
        } catch (Exception e) {
            System.out.println("Error reading CSV files: " + e.getMessage());
            System.exit(1);
        }

        List<CategorySummary> summaries = new BudgetAnalyzer(ledger).summarize();


    }
}
