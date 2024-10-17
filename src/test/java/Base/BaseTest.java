package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver driver;
    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public PracticeFormPage practiceFormPage;
    public PracticeFormModalPage practiceFormModalPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homepagePage = new HomepagePage();
        sidebarPage = new SidebarPage();
        practiceFormPage = new PracticeFormPage();
        practiceFormModalPage = new PracticeFormModalPage();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
