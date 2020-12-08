/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import Base.Utilities;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Home page class.
 * 
 * @author Artūras
 */
public class HomePage {
    
    protected WebDriver driver;
    
    //--------------------------------------------------------------------------
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //--------------------------------------------------------------------------
    /**
     * Searches for an item in MyStore(default) page.
     * @param itemName - name of an item
     */
    public void searchForTerm(String itemName) {
        getSearchTxtBox().clear();
        getSearchTxtBox().sendKeys(itemName);
        getSearchButton().click();
    }
    //--------------------------------------------------------------------------
    /***** LOCATORS GETTERS *****/
    
    public WebElement getSearchTxtBox() {
        return Utilities.waitToBeClickable(driver, By.id("search_query_top"), 5);
    }

    public WebElement getSearchButton() {
        return Utilities.waitToBeClickable(driver, By.name("submit_search"), 5);
    }
}
