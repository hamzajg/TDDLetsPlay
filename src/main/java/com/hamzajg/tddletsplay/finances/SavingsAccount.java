package com.hamzajg.tddletsplay.finances;

public class SavingsAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public SavingsAccount nextYear(double interestRate) {
        final SavingsAccount result = new SavingsAccount();
        result.deposit(getBalance() * (1 + (interestRate / 100)));
        return result;
    }
}
