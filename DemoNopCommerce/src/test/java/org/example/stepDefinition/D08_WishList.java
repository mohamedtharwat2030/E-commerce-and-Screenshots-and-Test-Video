package org.example.stepDefinition;

import org.example.Pages.P08_WishListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D08_WishList {
P08_WishListPage wishListPage = new P08_WishListPage();
    int number;

    @When("user add products to wishlist")
    public void add_to_wishlist() throws InterruptedException {
// to choose third product
      wishListPage.click_wishlist_button().get(2).click();
      Thread.sleep(3000);
    }

@Then("wishlist success message is visible")
    public void success_message(){

    Assert.assertTrue(wishListPage.success_message().isDisplayed());
}

@And("user get number of products added to wishlist")
    public void wishlist_elements_number(){
        // get prouducts count but in string ()
String textNum = Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-qty\"]")).getText();

    System.out.println("Number Of Products is : "+textNum);

    // remove ()  and  convert string to integer
   textNum = textNum.replaceAll("[^0-9]","");
     number = Integer.parseInt(textNum);


}

@Then("number of wishlist products increased")
    public void wishlist_count_increase(){
    Assert.assertTrue(number>0);
}
@And("user go to wishlist page")
    public void wishlist_page(){

    WebDriverWait wait =new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    WebElement sucsessTab = wishListPage.success_message();
    wait.until(ExpectedConditions.invisibilityOf(sucsessTab));

    Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-label\"]")).click();
}

}
