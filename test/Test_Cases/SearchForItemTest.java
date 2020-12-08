/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Cases;

import Base.TestBase;
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
    
    ResourceBundle resources;
    protected WebDriver driver;
    private TestBase base;
    private HomePage homePage;
    private ShopPage shopPage;
    //--------------------------------------------------------------------------
    /*
    Actions performed (navigation, object initialization) before tests.
    */
    @BeforeClass
    public void setUp() {
        resources = ResourceBundle.getBundle("Properties.GlobalVariables");
        
        base = new TestBase();
        base.openChrome(resources.getString("homePageURL"));
        driver = base.getDriver();
        
        homePage = new HomePage(driver);
        shopPage = new ShopPage(driver);
    }
    //--------------------------------------------------------------------------
    /*
    Checks whether 'Homepage' page search locators are visible and enabled before 
    executing tests.
    */
    @Test (priority = 1)
    public void assertSearchFormLocators() {
        Assert.assertTrue(homePage.getSearchTxtBox().isDisplayed());
        Assert.assertTrue(homePage.getSearchButton().isEnabled());
    }
    //--------------------------------------------------------------------------
    /*
    1) Search for unexisting item "Buritos".
    2) Check whether error message appears.
    */
    @Test (priority = 2)
    public void invalidSearch() {
        String term = "Buritos";
        homePage.searchForTerm(term);
        Assert.assertTrue(shopPage.getNoResultsFoundError().isDisplayed());
    }
    //--------------------------------------------------------------------------
    /*
    1) Search for existing item "Dress".
    2) Check whether search results match search query.
    */
    @Test (priority = 3)
    public void validSearch() {
        shopPage.getMyStoreLogo().click(); // go back to MyStore(default) page
        String term = "Dress";
        homePage.searchForTerm(term);
        Assert.assertTrue(shopPage.isFoundProductListMatchQuery(term));
    }
    //--------------------------------------------------------------------------
    /*
    Tests end.
    */
    @AfterClass
    public void closeAll() {
        base.quitChrome();
    }
}
