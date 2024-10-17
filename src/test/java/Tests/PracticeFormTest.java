package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
    }

    @Test
    public void practiceForm() throws InterruptedException {
        homepagePage.clickOnCard("Forms");
        sidebarPage.clickOnButton("Practice Form");

        String firstName = "John", lastName = "Doe", userEmail = "john.doe@mail.com";
        String gender = "Other", mobileNumber = "1234567890";
        String day = "15", month = "Jun", year = "1985";
        String subject = "Math";
        String hobby1 = "Reading", hobby2 = "Music", hobby3 = "Sports";
        String pictureLocation = "C:\\Users\\mladj\\Desktop\\yoda.jpg";
        String currentStreet = "Street no1";
        String state = "Rajasthan", city = "Jaipur";
        practiceFormPage.inputFirstName(firstName);
        practiceFormPage.inputLastName(lastName);
        practiceFormPage.inputUserEmail(userEmail);
        practiceFormPage.selectGender("female");
        practiceFormPage.selectGender("male");
        practiceFormPage.selectGender(gender);
        practiceFormPage.inputMobileNumber(mobileNumber);
        practiceFormPage.inputUserDateOfBirth(day, month, year);
        practiceFormPage.inputOneSubject(subject);
        practiceFormPage.inputOneSubject("Computer Science");

        String[] manySubjects = {"Art", "Hist", "r"};
        practiceFormPage.inputManySubjects(manySubjects);
        practiceFormPage.uploadPicture(pictureLocation);
        practiceFormPage.selectHobbies(hobby1);
        practiceFormPage.selectHobbies(hobby2);
        practiceFormPage.selectHobbies(hobby3);
        practiceFormPage.inputCurrentAddress(currentStreet);
        practiceFormPage.selectStateDropdown(state);
        practiceFormPage.selectCityDropdown(city);
        Thread.sleep(10000);
        practiceFormPage.clickSubmitButton();

        Assert.assertEquals(practiceFormModalPage
                .getModalCellText(1), firstName + " " + lastName);
        Assert.assertEquals(practiceFormModalPage.getModalCellText(5), gender);
        Assert.assertEquals(practiceFormModalPage.getModalCellText(7), mobileNumber);
        Assert.assertTrue(practiceFormModalPage.closeButton.isEnabled());
        Thread.sleep(5000);
        practiceFormModalPage.closeButton.click();
    }
}
