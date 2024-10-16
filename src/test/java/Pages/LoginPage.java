package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "login")
    public WebElement btnLogin;

    @FindBy(id = "userName-value")
    public WebElement loggedInUsername;

    @FindBy(id = "submit")
    public WebElement btnLogout;

    // --- metode

    public void enterUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickOnLoginButton() {
        btnLogin.click();
    }

    public boolean logOutIsDisplayed() {
        if (btnLogout.isDisplayed()) {
            return true;
        }
        return false;
    }
}
