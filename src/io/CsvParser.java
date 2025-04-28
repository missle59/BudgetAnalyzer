package io;

import model.BudgetEntry;
import model.SpendingEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    List<BudgetEntry> readBudgets(Path csvFile) throws IOException {
        List<BudgetEntry> budgets = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(csvFile)) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cols = line.split(",", 2);
                budgets.add(new BudgetEntry(
                        cols[0].trim(),
                        new BigDecimal( cols[1].trim())
                ));
            }
        }
        return budgets;
    }

    List<SpendingEntry> readSpendings(Path csvFile) throws IOException {
        List<SpendingEntry> spendings = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(csvFile)) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cols = line.split(",", 3);
                spendings.add(new SpendingEntry(
                        LocalDate.parse(cols[0].trim()),
                        cols[1].trim(),
                        new BigDecimal( cols[2].trim())
                ));
            }
        }
        return spendings;
    }
}
