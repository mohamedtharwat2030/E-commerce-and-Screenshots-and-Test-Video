package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.stepDefinition.Hooks;

public class P01_RegisterPage {


    public WebElement go_regester_page() {
       return Hooks.driver.findElement(By.className("ico-register"));
    }
    public WebElement genderElement(String type)  {

        WebElement element = null;

        if (type.equals("male")) {
            element = Hooks.driver.findElement(By.id("gender-male"));
        }
        else if(type.equals("female")) {
            element = Hooks.driver.findElement(By.id("gender-female"));

        }
        return element;

    }

    public WebElement firstNameElement(){

        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement lastnameElement(){

        return Hooks.driver.findElement(By.id("LastName"));
    }

    public WebElement birthDay(){

        return Hooks.driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement birthmonth(){

        return Hooks.driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement birthyear(){

        return Hooks.driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement emailElement(){

        return Hooks.driver.findElement(By.cssSelector("div[class=\"inputs\"] input[type=\"email\"]"));
    }

    public WebElement companyElement(){

        return Hooks.driver.findElement(By.id("Company"));
    }
    public WebElement passwordElement(){

        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement confirmPassElement(){

        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement register_button(){
        return  Hooks.driver.findElement(By.name("register-button"));
    }
    public WebElement successMsgElement(){

        return Hooks.driver.findElement(By.className("result"));

    }

}
