package org.example.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.Pages.P05_HoverCategoriesPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D05_HoverCategories {
    P05_HoverCategoriesPage hovrPage = new P05_HoverCategoriesPage();
    Actions action =new Actions(Hooks.driver);
    String subCategoryName ;
    WebElement desktops;

    @When("user hover category and select subcategory")
public void hover_categories(){

       WebElement compCategories = hovrPage.parentCat();
       action.moveToElement(compCategories).perform();

         desktops = hovrPage.subCat();
        // this to removes whitespace from both ends will change "Desktops   " to "desktops"
        subCategoryName = desktops.getText().toLowerCase().trim();
        System.out.println(subCategoryName);



}
@And("user turned to subcategory page")
    public void subcategory_page(){
    if (subCategoryName != null) {
        desktops.click();
        System.out.println("i paaaasss");
        String actualSubCategoryName = hovrPage.page_title().getText().toLowerCase().trim();
        System.out.println("actual SubCategory Name :" + actualSubCategoryName);

        Assert.assertTrue(subCategoryName.contains(actualSubCategoryName));
    }

}

}
