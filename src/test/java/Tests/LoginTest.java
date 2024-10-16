package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
    }

    @Test
    public void logInTest() throws InterruptedException {
        scrollToElement(homepage.cards.getLast());
        homepage.clickOnCard("Book Store Application");
        bookstorePage.clickOnLoginLink();
        loginPage.enterUsername("jejo");
        loginPage.enterPassword("sifraF22!");
        loginPage.clickOnLoginButton();
        Thread.sleep(5000);
        // asertacija
        Assert.assertTrue(loginPage.logOutIsDisplayed());
        Assert.assertEquals(loginPage.loggedInUsername.getText(), "jejo");
    }

}
