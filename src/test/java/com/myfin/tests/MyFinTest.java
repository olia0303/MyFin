package com.myfin.tests;

import com.myfin.model.Currency;
import com.myfin.tests.base.BaseTest;
import org.testng.annotations.Test;

public class MyFinTest extends BaseTest {
    @Test(description = "Check weighted average exchange rates for today's trading")
    public void checkExchangeRatesTest() {
        finSteps.openPage(jsonReader.getProperties().getMy_fin_url());
        finSteps.validateAverageExRatesForTodayTrading(Currency.USD, jsonReader.getProperties().getDelta());
        finSteps.validateAverageExRatesForTodayTrading(Currency.EUR, jsonReader.getProperties().getDelta());
        finSteps.validateAverageExRatesForTodayTrading(Currency.RUB, jsonReader.getProperties().getDelta());
        finSteps.validateCompareExchangeRates(Currency.USD, jsonReader.getProperties().getUsd_id(), jsonReader.getProperties().getNb_rb_url());
        finSteps.validateCompareExchangeRates(Currency.EUR, jsonReader.getProperties().getEur_id(), jsonReader.getProperties().getNb_rb_url());
        finSteps.validateCompareExchangeRates(Currency.RUB, jsonReader.getProperties().getRub_id(), jsonReader.getProperties().getNb_rb_url());
    }
}