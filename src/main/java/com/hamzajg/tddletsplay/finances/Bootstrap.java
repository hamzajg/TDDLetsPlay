package com.hamzajg.tddletsplay.finances;

public class Bootstrap {
    public static void main(String... args) {
        var account = new SavingsAccount();
        account.deposit(10000);
        for (int i = 0;i < 60; i++) {
            System.err.println(i + ": $" + account.getBalance());
            account = account.nextYear(10);
        }
    }
}
