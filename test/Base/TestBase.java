/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Cases;

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
    
    public void openChrome(String URL) {
        resources = ResourceBundle.getBundle("Properties.GlobalVariables");
        System.setProperty("webdriver.chrome.driver", resources.getString("pathToChromeDriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }
    
    public void quitChrome() {
        driver.quit();
    }
    
    public WebDriver getDriver() {
        return driver;
    }
}
