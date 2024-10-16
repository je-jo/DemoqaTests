package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticeFormPage extends BaseTest {

    public PracticeFormPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement inputFirstName;

    @FindBy(id = "lastName")
    public WebElement inputLastName;

    @FindBy(id = "userEmail")
    public WebElement inputUserEmail;

    @FindBy(className = "custom-control-label")
    public List<WebElement> radiosAndCheckboxes;

    @FindBy(id = "userNumber")
    public WebElement inputUserNumber;

    @FindBy(id = "dateOfBirthInput")
    public WebElement inputUserDateOfBirth;

    @FindBy(id = "subjectsInput")
    public WebElement inputSubjects;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement inputCurrAddress;

/*    @FindBy(id = "state")
    public WebElement dropdownState;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[10]/div[2]/div/div/div[2]")
    public WebElement stateOptions;*/

    @FindBy(id = "react-select-3-input")
    public WebElement inputState;

    @FindBy(id = "react-select-4-input")
    public WebElement inputCity;

    @FindBy(id = "submit")
    public WebElement btnSubmit;

    @FindBy(className = "table-responsive")
    public WebElement table;

    @FindBy(tagName = "td")
    public List<WebElement> tableCells;

    @FindBy(id = "closeLargeModal")
    public WebElement btnCloseTable;

    // ---

    public void enterFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        inputUserEmail.sendKeys(email);
    }

    public void selectRadiosAndCheckboxes(String btnValue) {
        for (int i = 0; i < radiosAndCheckboxes.size(); i++) {
            if (btnValue.equals(radiosAndCheckboxes.get(i).getText())) {
                radiosAndCheckboxes.get(i).click();
                break;
            }
        }
    }

    public void enterMobile(String userNumber) {
        inputUserNumber.sendKeys(userNumber);
    }

    public void setAttribute(WebElement elem, String attName, String attValue) {
        js = (JavascriptExecutor) driver;
        System.out.println(inputUserDateOfBirth.getAttribute("value"));
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", elem, attName, attValue);
        System.out.println(inputUserDateOfBirth.getAttribute("value"));
    }

    public void enterSubjects(String subjects) {
        inputSubjects.sendKeys(subjects);
    }

    public void sendImage(String imgLocation) {
        uploadPicture.sendKeys(imgLocation);
    }

    public void enterAddress(String address) {
        inputCurrAddress.sendKeys(address);
    }

/*    public void clickOnStateDropdown() {
        dropdownState.click();
        js.executeScript("console.log('here')");
        js.executeScript("console.log(document.querySelectorAll('.css-2613qy-menu'))");
    }*/

    public void enterState(String state) {
        inputState.sendKeys(state);
        inputState.sendKeys(Keys.ENTER);
    }

    public void enterCity(String city) {
        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ENTER);
    }


    public void clickSubmitBtn() {
        btnSubmit.click();
    }

 /*   public void printChildren() {
        for (int i = 0; i < stateOptions.size(); i++) {
            System.out.println(stateOptions.get(i));
        }
    }*/

    public void printTableCellValues() {
        for (int i = 0; i < tableCells.size(); i++) {
            System.out.println(i + " - " + tableCells.get(i).getText());
        }
    }


}
