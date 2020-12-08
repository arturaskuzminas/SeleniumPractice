/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Cases;

import Base.TestBase;
import POM.AccountPage;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductPage;
import java.util.List;
import java.util.ResourceBundle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 *
 * @author Artūras
 */
public class ProductReviewTest {
    
    protected WebDriver driver;   
    private TestBase base;
    private LoginPage loginPage;
    private AccountPage accPage;
    private HomePage homePage;
    private ProductPage productPage;
    ResourceBundle resources;
    //--------------------------------------------------------------------------
    /*
    Actions performed (navigation, object initialization) before tests.
    */
    @BeforeClass
    public void setUp() throws Exception {
        resources = ResourceBundle.getBundle("Properties.GlobalVariables");
        
        base = new TestBase();       
        base.openChrome(resources.getString("loginPageURL"));
        driver = base.getDriver();
        
        accPage = new AccountPage(driver);
        productPage = new ProductPage(driver);
        
        loginPage = new LoginPage(driver);
        loginPage.signInWith("kaunaskaunietis2@gmail.com", "Testas123"); 
        
        accPage.getMyStoreLogo().click();
        
        Actions action = new Actions(driver);
        List<WebElement> list = driver.findElements(By.className("product-container"));
        // Needed for hovering item card
        action.moveToElement(list.get(0)).perform();
        // Click first item card in 'MyStore'(default) page
        list.get(0).click();
        
        productPage.getWriteReviewButton().click();
    }
    //--------------------------------------------------------------------------
    /*
    Checks whether 'Product' page review pop up window locators are visible and 
    enabled before executing tests.
    */
    @Test (priority = 1)
    public void assertReviewWindowLocators() {
        Assert.assertTrue(productPage.getCommentTitleField().isDisplayed());
        Assert.assertTrue(productPage.getCommentContentField().isDisplayed());
        Assert.assertTrue(productPage.getSubmitMessageButton().isEnabled());
    }
    //--------------------------------------------------------------------------
    /*
    1) Check error behaviour with no title & no content.
    2) Check error behaviour with no content.
    3) Check error behaviour with no title.
    */
    @Test (priority = 2)
    public void invalidReview() {
        productPage.setReviewTitleText("");
        productPage.setReviewContentText("");
        productPage.getSubmitMessageButton().click();
        Assert.assertTrue(productPage.getTitleMissingError().isDisplayed());
        
        productPage.setReviewTitleText("ProductReview");
        productPage.setReviewContentText("");
        productPage.getSubmitMessageButton().click();
        Assert.assertTrue(productPage.getContentMissingError().isDisplayed());
        
        productPage.setReviewTitleText("");
        productPage.setReviewContentText("LorumIpsum");
        productPage.getSubmitMessageButton().click();
        Assert.assertTrue(productPage.getTitleMissingError().isDisplayed());
    }
    //--------------------------------------------------------------------------
    /*
    1) Check behaviour with valid review form details.
    */
    @Test (priority = 3) 
    public void validReview() {
        productPage.setReviewTitleText("Review title");
        productPage.setReviewContentText("Review content");
        productPage.getSubmitMessageButton().click();
        Assert.assertTrue(productPage.getReviewSuccesMessage().isDisplayed());
    }
    //--------------------------------------------------------------------------
    /*
    Tests end.
    */
    @AfterClass
    public void closeAll() throws Exception {
        base.quitChrome();
    }
}
