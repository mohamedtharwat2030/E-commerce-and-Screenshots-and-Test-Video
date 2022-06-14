package org.example.stepDefinition;

import org.example.Pages.P02_LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_Login {

    P02_LoginPage login = new P02_LoginPage();
    SoftAssert soft = new SoftAssert();

    @When("user navigate to login page")
    public void user_click_login() {
        login.click_to_loginpage().click();
    }


    @And("^user enter \"(.*)\" and \"(.*)\"$")
    public void enter_valid_inputs(String username, String password) throws InterruptedException {
        login.emailElement().clear();
        login.LoginMethod(username, password);
        Thread.sleep(1000);
    }

    @Then("user click on login button")
    public void click_login() throws InterruptedException {
        login.login_to_AccountBtn().click();
        Thread.sleep(1000);
    }

    @And("user login successfully and go to home page")
    public void home_page() {
        // Assert that go to home page after lohin my account
        soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/", "error in paaaaaage");

        // check “My account” tab isDisplayed
        soft.assertTrue(login.my_account().isDisplayed());
        soft.assertAll();
    }


    @And("user could not login successfully and go to home page")
    public void invalid_login() {
        String text = login.faildMsgElement().getText();
        System.out.println(text);
        soft.assertTrue(text.contains("Login was unsuccessful."));
// assert the color is red
        String expectedColor = "rgba(228, 67, 75, 1)";
        String actualColor = login.faildMsgElement().getCssValue("color");
        soft.assertTrue(actualColor.contains(expectedColor));
// convert and print color from rgba to hex
        String hex = Color.fromString(actualColor).asHex();
        System.out.println("color after converted to hex is : " + hex);

        soft.assertAll();
    }
}

