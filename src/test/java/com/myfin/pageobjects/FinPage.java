package com.myfin.pageobjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.PropertyManager;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public  class FinPage {
  
    public static final String MAIN_PAGE = new PropertyManager().get("application.url.myfin");
    public static final String ACTIVE_TABLE_XPATH = "//div[@class='content_i converter rates-table']";
    private SelenideElement el;
    private SelenideElement table;

    public FinPage openPage(){
        open(MAIN_PAGE);
        return this;
    }

    public void isPageOpened() {
        $(By.id("workarea")).waitUntil(Condition.visible, 30000);
    }
    
    public String getValueByColumnName(String columnName) {
        table = $(By.xpath(String.format(ACTIVE_TABLE_XPATH + "//th[contains(text(),'%s')]", columnName))).scrollTo();
        return columnName;
    }
    
    public String getCellValue(String rowName) {
        el = $(By.xpath(String.format(ACTIVE_TABLE_XPATH + "//a[contains(text(),'%s')]/../../following-sibling::td//div", rowName))).scrollTo();
        return el.getText();
    }
    
    public double getWeightedAverageCourses(String rowName){
        getValueByColumnName("Валюта");
        return Double.parseDouble(getCellValue(rowName));
    }
}