package main.java.ui;

import main.java.model.CategorySummary;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConsolePrinter {
    public ConsolePrinter() {}

    public void printSummary(List<CategorySummary> summaries) {
        if (summaries.isEmpty()) {
            System.out.println("No data to print");
            return;
        }

        summaries.sort(Comparator.comparing(CategorySummary::getCategory));

        int catWidth = "Category".length();
        int budgetWidth = "Budgeted".length();
        int spentWidth = "Spent".length();
        int diffWidth = "Difference".length();

        for (CategorySummary summary : summaries) {
            catWidth = Math.max(catWidth, summary.getCategory().length());
            budgetWidth = Math.max(budgetWidth, String.format("%.2f", summary.getBudgeted()).length());
            spentWidth = Math.max(spentWidth, String.format("%.2f", summary.getSpent()).length());
            diffWidth = Math.max(diffWidth, String.format("%.2f", summary.getDifference()).length());
        }

        String format = String.format("%%-%ds %%%ds %%%ds %%%ds", catWidth, budgetWidth, spentWidth, diffWidth);

        System.out.printf((format) + "%n", "Category", "Budgeted", "Spent", "Difference");

        int totalWidth = catWidth + budgetWidth + spentWidth + diffWidth + 6;
        System.out.println(String.join("", Collections.nCopies(totalWidth, "-")));

        for (CategorySummary summary : summaries) {
            System.out.printf(
                    (format) + "%n",
                    summary.getCategory(),
                    format(summary.getBudgeted()),
                    format(summary.getSpent()),
                    format(summary.getDifference())
            );
        }
    }

    private String format(BigDecimal amount) {
        return amount.setScale(2, RoundingMode.HALF_UP).toString();
    }
}
