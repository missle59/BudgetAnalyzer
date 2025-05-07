package main.java.ui;

import main.java.parser.CsvParser;
import main.java.service.Ledger;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Cli {
    public static void main(String[] args) {
        Path budgetFile = Paths.get("data/budget.csv");
        Path spendingFile = Paths.get("data/spending.csv");
        CsvParser parser = new CsvParser();
        Ledger ledger = new Ledger();
    }
}
