package interview.test.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ENTER;

public class SignupPage extends BaseClass {
    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(id = "signup-email")
    WebElement signupEmailField;

    @FindBy(id = "signup-password")
    WebElement signupPassField;

    @FindBy(id = "signup-name")
    WebElement signupNameField;

    @FindBy(id = "signup-surname")
    WebElement signupSurnameField;

    @FindBy(id = "dayOfBirth")
    WebElement signupDayOfBirthSelect;

    @FindBy(id = "monthOfBirth")
    WebElement signupMonthOfBirthSelect;

    @FindBy(id = "yearOfBirth")
    WebElement signupYearOfBirthSelect;

    @FindBy(id = "country")
    WebElement signupCounrySelect;

    @FindBy(id = "signup-address")
    WebElement signupAddressField;

    @FindBy(id = "signup-city")
    WebElement signupCityField;

    @FindBy(id = "signup-postcode")
    WebElement signupPostcodeField;

    @FindBy(xpath = "//div[contains(@class, 'signup-component')]//button")
    WebElement signupCreateAccButton;

    //error messages
    @FindBy(xpath = "/html/body/app-root/div/div/div[1]/app-auth/app-auth-container/div/div/div/div/div[1]/app-signup/div/div/form/div[1]/div/div[2]")
    WebElement emailFieldErr;

    @FindBy(xpath = "/html/body/app-root/div/div/div[1]/app-auth/app-auth-container/div/div/div/div/div[1]/app-signup/div/div/form/div[2]/div/div[3]")
    WebElement passwordFieldErr;

    @FindBy(xpath = "/html/body/app-root/div/div/div[1]/app-auth/app-auth-container/div/div/div/div/div[1]/app-signup/div/div/form/div[3]/div[1]/div/div[2]")
    WebElement nameFieldErr;

    @FindBy(xpath = "/html/body/app-root/div/div/div[1]/app-auth/app-auth-container/div/div/div/div/div[1]/app-signup/div/div/form/div[3]/div[2]/div/div[2]")
    WebElement surnameFieldErr;

    @FindBy(xpath = "/html/body/app-root/div/div/div[1]/app-auth/app-auth-container/div/div/div/div/div[1]/app-signup/div/div/form/div[6]/div/div[2]")
    WebElement addressFieldErr;

    @FindBy(xpath = "/html/body/app-root/div/div/div[1]/app-auth/app-auth-container/div/div/div/div/div[1]/app-signup/div/div/form/div[7]/div[1]/div/div[2]")
    WebElement cityFieldErr;

    @FindBy(xpath = "/html/body/app-root/div/div/div[1]/app-auth/app-auth-container/div/div/div/div/div[1]/app-signup/div/div/form/div[7]/div[2]/div/div[2]")
    WebElement postcodeFieldErr;

    @FindBy(xpath = "/html/body/app-root/div/div/div[1]/app-auth/app-auth-container/div/div/div/div/div[1]/app-signup/div/div/form/div[5]")
    WebElement ageLimitedErr;



    public void inputEmail(String string) {
        signupEmailField.sendKeys(string);
    }
    public void inputPassword(String string) {
        signupPassField.sendKeys(string);
    }
    public void inputName(String string) {
        signupNameField.sendKeys(string);
    }
    public void inputSurname(String string) {
        signupSurnameField.sendKeys(string);
    }
    public void selectDayOfBirth(String string) {
        getSelect(signupDayOfBirthSelect);
        select.selectByValue(string);
    }
    public void selectMonthOfBirth(String string) {
        getSelect(signupMonthOfBirthSelect);
        select.selectByVisibleText(string);
    }
    public void selectYearOfBirth(String string) {
        getSelect(signupYearOfBirthSelect);
        select.selectByValue(string);
    }
    public void selectCountry(String string) {
        getSelect(signupCounrySelect);
        select.selectByValue(string);
    }
    public void inputAddress(String string) {
        signupAddressField.sendKeys(string);
    }
    public void inputCity(String string) {
        signupCityField.sendKeys(string);
    }
    public void inputPostcode(String string) {
        signupPostcodeField.sendKeys(string);
    }
    public void clickCreateAccBtn() {
        signupCreateAccButton.sendKeys(ENTER);
    }
    //error messages
    public void assertEmailFieldErr(String string) {
        emailFieldErr.isDisplayed();
        String act = emailFieldErr.getText();
        Assert.assertTrue(act.contains(string));
    }
    public void assertPasswordFieldErr(String string) {
        passwordFieldErr.isDisplayed();
        String act = passwordFieldErr.getText();
        Assert.assertTrue(act.contains(string));
    }
    public void assertNameFieldErr(String string) {
        nameFieldErr.isDisplayed();
        String act = nameFieldErr.getText();
        Assert.assertTrue(act.contains(string));
    }
    public void assertSurnameFieldErr(String string) {
        surnameFieldErr.isDisplayed();
        String act = surnameFieldErr.getText();
        Assert.assertTrue(act.contains(string));
    }
    public void assertAddressFieldErr(String string) {
        addressFieldErr.isDisplayed();
        String act = addressFieldErr.getText();
        Assert.assertTrue(act.contains(string));
    }
    public void assertCityFieldErr(String string) {
        cityFieldErr.isDisplayed();
        String act = cityFieldErr.getText();
        Assert.assertTrue(act.contains(string));
    }
    public void assertPostcodeFieldErr(String string) {
        postcodeFieldErr.isDisplayed();
        String act = postcodeFieldErr.getText();
        Assert.assertTrue(act.contains(string));
    }
    public void assertAgeLimitedErr(String string) {
        ageLimitedErr.isDisplayed();
        String act = ageLimitedErr.getText();
        Assert.assertTrue(act.contains(string));
    }

}
