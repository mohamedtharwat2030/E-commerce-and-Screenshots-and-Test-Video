package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.stepDefinition.Hooks;

public class P02_LoginPage {

    public WebElement click_to_loginpage() {

        return Hooks.driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"]"));

    }

    public WebElement emailElement() {
        return Hooks.driver.findElement(By.name("Email"));
    }

    public WebElement passElement() {

        return Hooks.driver.findElement(By.id("Password"));

    }

    public void LoginMethod(String email, String password) {

        emailElement().sendKeys(email);

        passElement().sendKeys(password);
    }

    public WebElement login_to_AccountBtn() {

        return Hooks.driver.findElement(By.cssSelector("div[class=\"buttons\"] button[type=\"submit\"]"));

    }

    public WebElement my_account() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"header-links\"] a[href=\"/customer/info\"]"));
    }

    public WebElement faildMsgElement() {

        return Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }
}

