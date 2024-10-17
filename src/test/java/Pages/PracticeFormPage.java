package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
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
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement userEmailField;

    @FindBy(className = "custom-radio")
    public List<WebElement> genderOptions;

    @FindBy(id = "userNumber")
    public WebElement userMobileNumberField;

    @FindBy(id = "dateOfBirthInput")
    public WebElement userDateOfBirthField;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearDropDown;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthDropDown;

    @FindBy(id = "subjectsInput")
    public WebElement userSubjects;

    @FindBy(className = "custom-checkbox")
    public List<WebElement> hobbiesOptions;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "state")
    public WebElement stateDropdown;

    @FindBy(id = "city")
    public WebElement cityDropdown;

    @FindBy(id = "submit")
    public WebElement submitButton;

    //--------------

    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputUserEmail(String userEmail) {
        userEmailField.clear();
        userEmailField.sendKeys(userEmail);
    }

    public void selectGender(String gender) {
        for (WebElement option : genderOptions) {
            scrollToElement(option);
            if (option.getText().equalsIgnoreCase(gender)) {
                option.click();
                break;
            }
        }
    }

    public void inputMobileNumber(String userNumber) {
        userMobileNumberField.clear();
        userMobileNumberField.sendKeys(userNumber);
    }

    public void inputUserDateOfBirth(String day, String month, String year) {
        userDateOfBirthField.click();
        yearDropDown.sendKeys(year);
        monthDropDown.sendKeys(month);
        WebElement selectDay = driver.findElement(By.cssSelector(".react-datepicker__day.react-datepicker__day--0" + day));
        selectDay.click();
    }

    public void inputOneSubject(String subject) {
        userSubjects.clear();
        userSubjects.sendKeys(subject);
        userSubjects.sendKeys(Keys.ENTER);
    }

    public void inputManySubjects(String[] subjects) {
        for (String subject : subjects) {
            userSubjects.sendKeys(subject);
            userSubjects.sendKeys(Keys.ENTER);
        }
    }

    public void selectHobbies(String hobbie) {
        for (WebElement option : hobbiesOptions) {
            scrollToElement(option);
            if (option.getText().equalsIgnoreCase(hobbie)) {
                option.click();
                break;
            }
        }
    }

    public void uploadPicture(String fileName) {
        uploadPicture.sendKeys(fileName);
    }

    public void selectStateDropdown(String state) {
        stateDropdown.click();
        WebElement stateOption = driver.findElement(By.xpath("//div[contains(text(),'" + state + "')]"));
        stateOption.click();
    }

    public void selectCityDropdown(String city) {
        cityDropdown.click();
        WebElement cityOption = driver.findElement(By.xpath("//div[contains(text(),'" + city + "')]"));
        cityOption.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void inputCurrentAddress(String userCurrentAddress) {
        currentAddress.sendKeys(userCurrentAddress);
    }
}
