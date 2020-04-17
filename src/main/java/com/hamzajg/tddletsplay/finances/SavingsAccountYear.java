package com.hamzajg.tddletsplay.finances;

public class SavingsAccountYear {
    private double interestRate;
    private double startingBalance;

    public SavingsAccountYear() {

    }

    public SavingsAccountYear(double startingBalance, double interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public void deposit(double amount) {
        startingBalance += amount;
    }

    public void withdraw(double amount) {
        startingBalance -= amount;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(getEndingBalance(), interestRate);
    }

    public double getEndingBalance() {
        return getStartingBalance() * (1 + (interestRate / 100));
    }

    public double getStartingBalance() {
        return startingBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
