/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utility methods class.
 * 
 * @author Artūras
 */
public class Utilities {
    
    /**
     * Waits for the element to appear on the screen.
     * @param driver - browser driver
     * @param selector - element selector
     * @param waitInterval - wait for ?
     * @return webelement
     */
    public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
        return element;
    }
    
    /**
     * Waits for the element to be clickable.
     * @param driver - browser driver 
     * @param selector - element selector
     * @param waitInterval - wait for ?
     * @return webelement
     */
    public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
        return element;
    }
}
