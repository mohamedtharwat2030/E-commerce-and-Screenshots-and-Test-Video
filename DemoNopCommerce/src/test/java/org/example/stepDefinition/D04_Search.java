package org.example.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_SearchPage;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class D04_Search {
    P04_SearchPage searchPage =new P04_SearchPage();
    SoftAssert soft = new SoftAssert();
    String searchKey = null;

    @When("user click on search field in Home page")
    public void click_search_field() {

        searchPage.searchField().click();
    }

    @And("^user enter product name in search field \"(.*)\"$")
    public void search_with_product_name(String productNames) {
        searchPage.searchField().sendKeys(productNames);
        searchKey = productNames;
    }

    @Then("user click on search button")
    public void click_searsh_button() throws InterruptedException {
        searchPage.searchButton().click();
        Thread.sleep(3000);
    }

    @And("user could turned to search page")
    public void search_page() {
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));

    }


    @And("user see products of search result")
    public void assert_search_results() {
        int productsCount =searchPage.productTitels().size();
        System.out.println("Number of search results is " + productsCount);

        // String searchKey = Hooks.driver.findElement(By.cssSelector("input[class=\"search-text\"]")).getText();
        System.out.println("keeeeeeeeeeeeey = " + searchKey);
        int i;
        for (i = 1; i <= productsCount; i++) {
            String productName = Hooks.driver.findElement(By.xpath("(//h2[@class=\"product-title\"])[" + i + "]")).getText();
            System.out.println("Name of product " + i + " is " + productName);
            // assert that all results contain search key
            soft.assertTrue(productName.contains(searchKey));

        }

    }

    @And("^user enter product sku  in search field \"(.*)\"$")
    public void search_with_sku(String Sku) {
        searchPage.searchField().sendKeys(Sku);
        searchKey = Sku;

    }

    @And("user enter to the product detail")
    public void product_detail() throws InterruptedException {
// enter the product details
        System.out.println("searsh key " + searchKey);
        searchPage.enterProduct().click();

        Thread.sleep(2000);
        String productSku = searchPage.productSku().getText();
        System.out.println("Name of product is " + productSku);
        soft.assertTrue(productSku.contains(searchKey));

    }

}

