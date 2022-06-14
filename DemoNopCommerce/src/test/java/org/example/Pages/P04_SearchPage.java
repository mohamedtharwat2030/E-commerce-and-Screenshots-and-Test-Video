package org.example.Pages;

import org.example.stepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P04_SearchPage {

    public WebElement searchField() {

        return Hooks.driver.findElement(By.id("small-searchterms"));

    }

    public WebElement searchButton() {
        return Hooks.driver.findElement(By.cssSelector("button[type=\"submit\"]"));

    }

    public List<WebElement> productTitels() {
        return Hooks.driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));

    }

    public WebElement enterProduct() {

        return Hooks.driver.findElement(By.cssSelector("div[class=\"product-item\"] div[class=\"picture\"]"));
    }

    public WebElement productSku() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"] span[class=\"value\"]"));


    }
}

