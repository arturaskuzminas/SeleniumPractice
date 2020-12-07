/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
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
    public void searchForTerm(String itemName) {
        getSearchTxtBox().sendKeys(itemName);
        getSearchButton().click();
    }
    //--------------------------------------------------------------------------
    public WebElement getSearchTxtBox() {
        return driver.findElement(By.id("search_query_top"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.name("submit_search"));
    }
}
