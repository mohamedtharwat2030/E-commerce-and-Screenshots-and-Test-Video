package org.example.Pages;

import org.example.stepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P05_HoverCategoriesPage {

    public WebElement parentCat() {

        return Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]"));

    }

    public WebElement subCat() {

        return Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/desktops\"]"));
    }

    public WebElement page_title() {

        return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]"));
    }

}

