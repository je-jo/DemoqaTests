package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SidebarPage extends BaseTest {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-light ")
    public List<WebElement> listOfLinks;

    // -----

    public void clickOnLink(String linkText) {
        for (int i = 0; i < listOfLinks.size(); i++) {
            if (listOfLinks.get(i).getText().equals(linkText)) {
                listOfLinks.get(i).click();
                break;
            }
        }
    }


}
