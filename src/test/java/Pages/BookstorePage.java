package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookstorePage extends BaseTest {

    public BookstorePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login")
    public WebElement linkLogin;

    @FindBy(className = "mr-2")
    public List<WebElement> booklist;

    // --- metode

    public void clickOnLoginLink() {
        linkLogin.click();
    }

//    public void clickOnFirstBook() {
//        booklist.get(1).click();
//    }
//
//    public void printElements(List list) {
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//    }

}
