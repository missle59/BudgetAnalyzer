package main.java.ui;

import main.java.model.BudgetEntry;
import main.java.model.CategorySummary;
import main.java.model.SpendingEntry;
import main.java.parser.CsvParser;
import main.java.service.BudgetAnalyzer;
import main.java.service.Ledger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Cli {
    public static void main(String[] args) {
        Path budgetPath;
        Path spendingPath;
        if (args.length == 2) {
            budgetPath = Paths.get(args[0]);
            spendingPath = Paths.get(args[1]);
        } else {
            System.err.println("Usage: java -jar budget-analyzer.jar <budget.csv> <spending.csv>");
            System.exit(1);
            return;
        }

        CsvParser parser = new CsvParser();
        Ledger ledger = new Ledger();

        try {
            List<BudgetEntry> budgets = parser.readBudgets(budgetPath);
            budgets.forEach(ledger::addBudget);

            List<SpendingEntry> spends = parser.readSpendings(spendingPath);
            spends.forEach(ledger::addSpending);

        } catch (Exception e) {
            System.out.println("Error reading CSV files: " + e.getMessage());
            System.exit(2);
        }

        BudgetAnalyzer analyzer = new BudgetAnalyzer(ledger);
        List<CategorySummary> summaries = analyzer.summarize();

        ConsolePrinter printer = new ConsolePrinter();
        printer.printSummary(summaries);

    }
}
