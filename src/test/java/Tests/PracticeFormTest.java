package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {
    @BeforeClass
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
    }

    @Test
    public void userCanSubmitValidData() {
        String firstName = "Petar";
        String lastName = "Panic";
        String email = "petar@panic.com";
        String genderOption = "Male";
        String mobile = "0123456789";
//        String dateOfBirth = "13 Oct 1977";
//        String subjects = "Flying";
        String hobbiesOption = "Reading";
        String address = "Neverland";
        String state = "NCR";
        String city = "Delhi";
        homepage.clickOnCard("Forms");
        sidebarPage.clickOnLink("Practice Form");
        practiceFormPage.enterFirstName(firstName);
        practiceFormPage.enterLastName(lastName);
        practiceFormPage.enterEmail(email);
        practiceFormPage.selectRadiosAndCheckboxes(genderOption);
        practiceFormPage.enterMobile(mobile);
        // practiceFormPage.setAttribute(practiceFormPage.inputUserDateOfBirth, "value", dateOfBirth);
        // practiceFormPage.enterSubjects(subjects);
        scrollToElement(practiceFormPage.btnSubmit);
        practiceFormPage.selectRadiosAndCheckboxes(hobbiesOption);
        practiceFormPage.sendImage(imgLocation);
        practiceFormPage.enterAddress(address);
        // practiceFormPage.clickOnStateDropdown();
        //practiceFormPage.printChildren();
        practiceFormPage.enterState(state);
        practiceFormPage.enterCity(city);
        practiceFormPage.clickSubmitBtn();

        // asertacija
        Assert.assertTrue(isElemDisplayed(practiceFormPage.table));
        // practiceFormPage.printTableCellValues();
        Assert.assertEquals(practiceFormPage.tableCells.get(1).getText(), firstName + " " + lastName);
        Assert.assertEquals(practiceFormPage.tableCells.get(3).getText(), email);
        Assert.assertEquals(practiceFormPage.tableCells.get(5).getText(), genderOption);
        Assert.assertEquals(practiceFormPage.tableCells.get(7).getText(), mobile);
        Assert.assertEquals(practiceFormPage.tableCells.get(13).getText(), hobbiesOption);
        Assert.assertEquals(practiceFormPage.tableCells.get(15).getText(), imgFileName);
        Assert.assertEquals(practiceFormPage.tableCells.get(17).getText(), address);
        Assert.assertEquals(practiceFormPage.tableCells.get(19).getText(), state + " " + city);
        Assert.assertTrue(isElemDisplayed(practiceFormPage.btnCloseTable));

    }

    @Test
    public void userCannotSubmitFormWithoutData() {
        homepage.clickOnCard("Forms");
        sidebarPage.clickOnLink("Practice Form");
        scrollToElement(practiceFormPage.btnSubmit);
//        practiceFormPage.clickOnStateDropdown();
//        System.out.println(practiceFormPage.stateOptions.getClass());
        // practiceFormPage.clickSubmitBtn();
        // asertacija
        Assert.assertFalse(isElemDisplayed(practiceFormPage.table));
        Assert.assertFalse(isElemDisplayed(practiceFormPage.btnCloseTable));
    }

    @Test
    public void userCannotSubmitFormWithIncorrectMobileFormat() {
        String firstName = "Petar";
        String lastName = "Panic";
        String email = "petar@panic.com";
        String genderOption = "Male";
        String mobile = "1234";
        String hobbiesOption = "Reading";
        String address = "Neverland";
        homepage.clickOnCard("Forms");
        sidebarPage.clickOnLink("Practice Form");
        practiceFormPage.enterFirstName(firstName);
        practiceFormPage.enterLastName(lastName);
        practiceFormPage.enterEmail(email);
        practiceFormPage.selectRadiosAndCheckboxes(genderOption);
        practiceFormPage.enterMobile(mobile);
        scrollToElement(practiceFormPage.btnSubmit);
        practiceFormPage.selectRadiosAndCheckboxes(hobbiesOption);
        practiceFormPage.sendImage(imgLocation);
        practiceFormPage.enterAddress(address);
        practiceFormPage.clickSubmitBtn();

        // asertacija
        Assert.assertFalse(isElemDisplayed(practiceFormPage.table));
        Assert.assertFalse(isElemDisplayed(practiceFormPage.btnCloseTable));
    }


    // pomocne

    public boolean isElemDisplayed(WebElement elem) {
        boolean isDisplayed = false;
        try {
            isDisplayed = elem.isDisplayed();
        } catch (Exception e) {
        }
        return isDisplayed;
    }

/*    public void getElemClasses(WebElement elem) {
        String classes = elem.getAttribute("classes");
        System.out.println(classes);
    }*/

    @AfterMethod
    public void closeTable() {
        if (isElemDisplayed(practiceFormPage.btnCloseTable)) {
            practiceFormPage.btnCloseTable.click();
        }
    }

/*    @AfterClass
    public void tearDown() {
        driver.quit();
    }*/
}
