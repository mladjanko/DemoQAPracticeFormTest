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

    @FindBy(className = "text")
    public List<WebElement> bookStoreAplicationMenu;

    //-------------

    public void clickOnButton(String buttonName) {
        for (WebElement option : bookStoreAplicationMenu) {
            scrollToElement(option);
            if (option.getText().equals(buttonName)) {
                option.click();
                break;
            }
        }
    }
}
