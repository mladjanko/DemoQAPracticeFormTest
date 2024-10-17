package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends BaseTest {

    public HomepagePage (){
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "card-body")
    public List<WebElement> cardsList;

    public void clickOnCard(String cardName) {
        for (WebElement webElement : cardsList) {
            scrollToElement(webElement);
            if (webElement.getText().equals(cardName)) {
                webElement.click();
                break;
            }
        }
    }
}
