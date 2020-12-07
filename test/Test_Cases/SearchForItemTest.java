/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Cases;

import POM.HomePage;
import POM.ShopPage;

import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author Artūras
 */
public class SearchForItemTest {
    
    protected WebDriver driver;
    private TestBase base;
    private HomePage homePage;
    private ShopPage shopPage;
    ResourceBundle resources;
    //--------------------------------------------------------------------------
    @BeforeClass
    public void setUp() {
        base = new TestBase();
        resources = ResourceBundle.getBundle("Properties.GlobalVariables");
        base.openChrome(resources.getString("homePageURL"));
        driver = base.getDriver();
        homePage = new HomePage(driver);
        shopPage = new ShopPage(driver);
    }
    //--------------------------------------------------------------------------
    @Test (priority = 1)
    public void assertSearchFormLocators() {
        Assert.assertTrue(homePage.getSearchTxtBox().isDisplayed());
        Assert.assertTrue(homePage.getSearchButton().isEnabled());
    }
    //--------------------------------------------------------------------------
    @Test (priority = 2)
    public void search() {
        String term = "Dress";
        homePage.searchForTerm(term);
        Assert.assertTrue(shopPage.isFoundProductListMatchQuery(term));
    }
    //--------------------------------------------------------------------------
    @AfterClass
    public void tearDown() {
        base.quitChrome();
    }
}
