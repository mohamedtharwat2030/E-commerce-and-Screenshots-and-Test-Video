package org.example.Pages;

import org.example.stepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_CurrenciesPage {

    public WebElement customerCurrency(){
        return Hooks.driver.findElement(By.name("customerCurrency"));
    }

    public List  actual_price(){
        return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }


}
