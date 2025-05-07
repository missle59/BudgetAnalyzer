package main.java.ui;

import main.java.model.CategorySummary;

import java.util.List;

public class ConsolePrinter {
    public ConsolePrinter() {}

    public void printSummary(List<CategorySummary> summaries) {
        if (summaries.isEmpty()) {
            System.out.println("No data to print");
            return;
        } else {

        }
    }
}
