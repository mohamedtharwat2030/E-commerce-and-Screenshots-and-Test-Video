package org.example.Pages;

import org.example.stepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P08_WishListPage {

    public List <WebElement> click_wishlist_button(){

        return  Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));

    }
public WebElement success_message(){

        return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
}
}
