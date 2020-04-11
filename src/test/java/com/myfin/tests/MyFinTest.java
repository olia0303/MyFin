package com.myfin.tests;

import com.myfin.model.Currency;
import com.myfin.tests.base.BaseTest;
import org.testng.annotations.Test;

public class MyFinTest extends BaseTest {
    @Test(description = "Check weighted average exchange rates for today's trading")
    public void checkExchangeRatesTest() {
        finSteps.openPage();
        finSteps.validateCompareExchangeRates(Currency.USD, "145");
        finSteps.validateCompareExchangeRates(Currency.EUR, "292");
        finSteps.validateCompareExchangeRates(Currency.RUB, "298");
        finSteps.validateAverageExRatesForTodayTrading(Currency.USD);
        finSteps.validateAverageExRatesForTodayTrading(Currency.EUR);
        finSteps.validateAverageExRatesForTodayTrading(Currency.RUB);
        finSteps.closeBrowser();
    }
}