package org.example.stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_FollowUs {
    @When("^user scroll down and choose \"(.*)\"$")
    public void scroll_and_choose_FollowLink(String followLink) {
// scroll down to choose facebook
        JavascriptExecutor jExecutor = (JavascriptExecutor) Hooks.driver;
        jExecutor.executeScript("arguments[0].scrollIntoView();", Hooks.driver.findElement(By.className(followLink)));
// click on the link
        Hooks.driver.findElement(By.className(followLink)).click();

    }

    @Then("^open new tab of \"(.*)\"$")
    public void open_link(String link) throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));

        System.out.println("New URL After click 0n " + link + " is " + Hooks.driver.getCurrentUrl());

        switch (link) {

            case "facebook":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.facebook.com/nopCommerce");
                break;

            case "twitter":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://twitter.com/nopCommerce");
                break;

            case "rss":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/new-online-store-is-open");
                break;

            case "youtube":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.youtube.com/user/nopCommerce");
                break;

        }

        Hooks.driver.close();

        Hooks.driver.switchTo().window(tabs.get(0));
        System.out.println("Old URL After close " + link + " tab " + Hooks.driver.getCurrentUrl());
    }

}
