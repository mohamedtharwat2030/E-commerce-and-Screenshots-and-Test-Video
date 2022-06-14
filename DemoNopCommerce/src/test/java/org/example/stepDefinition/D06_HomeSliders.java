package org.example.stepDefinition;

import org.example.Pages.P06_HomeSlidersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D06_HomeSliders {

    P06_HomeSlidersPage slidersPage = new P06_HomeSlidersPage();

    // Scenario 1 & 2
    @When("^enter slider number \"(.*)\"$")
    public void clickSlider(String sliderNo) {
        slidersPage.homeSliders(sliderNo).click();
    }

    // Scenario 1
    @And("user go to first slider detail page")
    public void first_slider_detail() {

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        boolean check = wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/nokia-lumia-1020"));
        Assert.assertTrue(check);
        System.out.println("current URL is : >>>>" + Hooks.driver.getCurrentUrl());

    }


    // Scenario 2
    @And("user go to second slider detail page")
    public void second_slider_detail() {

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        boolean check = wait.until(ExpectedConditions.urlContains(" https://demo.nopcommerce.com/iphone-6"));
        Assert.assertTrue(check);
        System.out.println("current URL is : >>>>" + Hooks.driver.getCurrentUrl());
    }
}