package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.ls.LSOutput;

public class BaseTest {


    public static WebDriver driver;
    public static JavascriptExecutor js;
    public Homepage homepage;
    public SidebarPage sidebarPage;
    public BookstorePage bookstorePage;
    public LoginPage loginPage;
    public PracticeFormPage practiceFormPage;
    public String imgFileName;
    public String imgLocation;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        homepage = new Homepage();
        sidebarPage = new SidebarPage();
        bookstorePage = new BookstorePage();
        loginPage = new LoginPage();
        practiceFormPage = new PracticeFormPage();
        imgFileName = "vlcsnap-000434.jpg";
        imgLocation = System.getProperty("user.dir") + "\\" + imgFileName;
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
