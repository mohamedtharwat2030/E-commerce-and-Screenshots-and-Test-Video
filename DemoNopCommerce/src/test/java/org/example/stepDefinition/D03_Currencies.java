package org.example.stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_CurrenciesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_Currencies {

    P03_CurrenciesPage currenciesPage = new P03_CurrenciesPage();

    @When("User enter Currencies list and select Euro [€]")
    public void Change_currencies() throws InterruptedException {
        Select currency = new Select(currenciesPage.customerCurrency());
        Thread.sleep(3000);
        currency.selectByVisibleText("Euro");
    }

    @Then("Euro Symbol [€] is displayed in Home page products")
    public void display_euro() {
        int num = currenciesPage.actual_price().size();
        System.out.println("size = :" + num);
        int i;
        for (i = 1; i <= num; i++) {
            String currencyText = Hooks.driver.findElement(By.xpath("(//span[@class=\"price actual-price\"] )[" + i + "]")).getText();
            System.out.println("price of product " + i + " = " + currencyText);
            // assert that Symbol [€] is displayed in Home page products
            Assert.assertTrue(currencyText.contains("€"));

        }
    }

}