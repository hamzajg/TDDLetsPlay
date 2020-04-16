package com.hamzajg.tddletsplay;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SavingsAccountTest {
    @Test
    public void depositAndWithdrawal() {
        var account = new SavingsAccount();
        account.deposit(100);
        assertThat("After deposit", 100d, is(account.getBalance()));
        account.withdraw(50);
        assertThat("After withdrawal", 50d, is(account.getBalance()));
    }
    @Test
    public void negativeBalanceIsJustFine() {
        var account = new SavingsAccount();
        account.deposit(75d);
        assertThat(75d, is(account.getBalance()));
    }
}
