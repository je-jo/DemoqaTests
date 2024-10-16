package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends BaseTest {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "card-body")
    public List<WebElement> cards;

    // metode

    public void clickOnCard(String text) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals(text)) {
                cards.get(i).click();
                break;
            }
        }
    }
}
