package com.hamzajg.tddletsplay.finances;

public class Bootstrap {
    public static void main(String... args) {
        var account = new SavingsAccountYear();
        account.deposit(10000);
        for (int i = 0;i < 60; i++) {
            System.err.println(i + ": $" + account.getStartingBalance());
            account = account.nextYear();
        }
    }
}
