/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Artūras
 */
public class ShopPage {

    protected WebDriver driver;
    //--------------------------------------------------------------------------
    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }
    //--------------------------------------------------------------------------
    public boolean isFoundProductListMatchQuery(String searchQuery) {
        List<WebElement> itemNames = driver.findElements(getItemName());
        for (WebElement element : itemNames) {
            if (element.getText().toLowerCase().contains(searchQuery.toLowerCase())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    //--------------------------------------------------------------------------
    public By getItemName() {
        return By.cssSelector(".product-container");
    }
    //--------------------------------------------------------------------------
}
