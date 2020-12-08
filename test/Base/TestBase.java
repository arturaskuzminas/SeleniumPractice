/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Artūras
 */
public class TestBase {
    
    protected WebDriver driver;
    ResourceBundle resources;
    //--------------------------------------------------------------------------
    /**
     * Initializes Chrome browser driver, maximizes window and opens a web page.
     * @param URL - web page to get
     */
    public void openChrome(String URL) {
        resources = ResourceBundle.getBundle("Properties.GlobalVariables");
        System.setProperty("webdriver.chrome.driver", resources.getString("pathToChromeDriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }
    //--------------------------------------------------------------------------
    /**
     * Quits test.
     */
    public void quitChrome() {
        driver.quit();
    }
    //--------------------------------------------------------------------------
    /**
     * Gets chrome browser driver.
     * @return chrome driver
     */
    public WebDriver getDriver() {
        return driver;
    }
}
