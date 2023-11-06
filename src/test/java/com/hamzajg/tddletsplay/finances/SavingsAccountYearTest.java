package com.hamzajg.tddletsplay.finances;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SavingsAccountYearTest {
    @Test
    public void startingBalance() {
        var account = new SavingsAccountYear(10000, 10);
        assertThat(10000d, is(account.getStartingBalance()));
    }
    @Test
    public void endingBalance() {
        var account = new SavingsAccountYear(10000, 10);
        assertThat(11000d, is(account.getEndingBalance()));
    }
    @Test
    public void nextYearStartingBalanceShouldEqualThisYearEndingBalance() {
        var thisYear = new SavingsAccountYear(10000, 10);
        assertThat(thisYear.getEndingBalance(), is(thisYear.nextYear().getStartingBalance()));
    }
    @Test
    public void nextYearInterestRateEqualThisYearInterestYear() {
        var thisYear = new SavingsAccountYear(10000, 10);
        assertThat(thisYear.getInterestRate(), is(thisYear.nextYear().getInterestRate()));
    }
}
