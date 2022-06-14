package org.example.stepDefinition;

import io.cucumber.java.en.Given;
import org.example.Pages.P01_RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_Register {

    P01_RegisterPage registerPage = new P01_RegisterPage();

    SoftAssert soft = new SoftAssert();

    // open registration page
    @Given("user enter the registration page")
    public void enter_registration_page() {
        registerPage.go_regester_page().click();
    }

    @When("^user select gender \"(.*)\"$")
    public void user_select_gender(String type) throws InterruptedException {
        registerPage.genderElement(type).click();
        Thread.sleep(3000);
    }

    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void first_and_lastName(String fName, String Lname) {
// enter First name and last name
        registerPage.firstNameElement().sendKeys(fName);
        registerPage.lastnameElement().sendKeys(Lname);
    }

    @And("user enter date of birth")
    public void birthDate() {
// select day
        Select day = new Select(registerPage.birthDay());
        day.selectByValue("7");
// select month
        Select month = new Select(registerPage.birthmonth());
        month.selectByValue("10");
// select year
        Select year = new Select(Hooks.driver.findElement(By.name("DateOfBirthYear")));
        year.selectByValue("1980");

    }

    @And("^user enter registration email \"(.*)\"$")
    public void enter_email(String email) {
// enter Email
        registerPage.emailElement().sendKeys(email);
    }

    @And("^user enter company \"(.*)\"$")
    public void companyName(String company) {

// enter your company
        registerPage.companyElement().sendKeys("cars");

    }

    @And("^user fills Password fields \"(.*)\" and \"(.*)\"$")
    public void password_and_confirm(String password, String confirmPass) {

// enter your password and confirm password
        registerPage.passwordElement().sendKeys("P@ssw0rd");
        registerPage.confirmPassElement().sendKeys("P@ssw0rd");

    }

    @Then("user click on register button to save data")
    public void press_register() throws InterruptedException {
        registerPage.register_button().click();
        Thread.sleep(2000);
    }

    @And("user registration completed successfully")
    public void registration_successfully() {
// assert Success Message isdispaly
        soft.assertTrue(registerPage.successMsgElement().isDisplayed());

// assert Success Message is "Your registration completed""
        String actualSuccessMessage = registerPage.successMsgElement().getText();
        String expectedSuccessMessage = "Your registration completed";
        soft.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));

// assert color is green
        String expictedColor = "rgba(76, 177, 124, 1)";
        String actualColor = registerPage.successMsgElement().getCssValue("color");
        soft.assertTrue(actualColor.contains(expictedColor));

        soft.assertAll();

    }
}




