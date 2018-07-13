package interview.test.tests;

import interview.test.pages.BaseClass;
import org.junit.Test;


public class SignupTests extends BaseClass {

    String registrationPageTitle = "Registration | Create your Lottoz Account";
    String mainPageTitle = "Play Lotto Online | Buy Lottery Tickets Online | Lottoz";


    //positive test
    @Test
    public void userCanSignupWithValidData() throws Exception {
        try {
            driver.navigate().to(domain + "/signup");
            Thread.sleep(2000);
            assertPageTitle(registrationPageTitle);
            signup.inputEmail(mail);
            signup.inputPassword("12345678PASS");
            signup.inputName("Name");
            signup.inputSurname("Surname");
            signup.selectDayOfBirth("1");
            signup.selectMonthOfBirth("September");
            signup.selectYearOfBirth("1990");
            signup.selectCountry("Ukraine");
            signup.inputAddress("Test street, test number");
            signup.inputCity("City");
            signup.inputPostcode("456");
            signup.clickCreateAccBtn();
            Thread.sleep(2000);
            assertPageTitle(mainPageTitle);
            logout();
        } catch (Error e) {
            e.printStackTrace();
            getScreen("test_userCanSignupWithValidData");
        }
    }

    //negative tests
    @Test
    public void userUnder18CantSignup() throws Exception {
        try {
            driver.navigate().to(domain + "/signup");
            Thread.sleep(2000);
            assertPageTitle(registrationPageTitle);
            signup.inputEmail(mail);
            signup.inputPassword("12345678PASS");
            signup.inputName("Name");
            signup.inputSurname("Surname");
            signup.selectDayOfBirth("31");
            signup.selectMonthOfBirth("December");
            signup.selectYearOfBirth("2000");
            signup.assertAgeLimitedErr("You must be above 18");
            signup.selectCountry("Ukraine");
            signup.inputAddress("Test street, test number");
            signup.inputCity("City");
            signup.inputPostcode("456");
            signup.clickCreateAccBtn();
            Thread.sleep(2000);
            signup.assertAgeLimitedErr("You must be above 18");
            logout();
        } catch (Error e) {
            e.printStackTrace();
            getScreen("test_userUnder18CantSignup");
        }
    }

    @Test
    public void checkSignupFormFieldsRevalidation() throws Exception {
        try {
            driver.navigate().to(domain + "/signup");
            Thread.sleep(2000);
            assertPageTitle(registrationPageTitle);
            signup.clickCreateAccBtn();
            //check error messages is present
            signup.assertEmailFieldErr("Please provide a valid email address");
            signup.assertPasswordFieldErr("Your password must have a minimum of 8 characters & contain at least 1 letter and 1 number");
            signup.assertNameFieldErr("Your name should be at least 2 characters long");
            signup.assertSurnameFieldErr("Your surname should be at least 2 characters long");
            signup.assertAddressFieldErr("Please enter your home address");
            signup.assertCityFieldErr("Please enter your city/county of residence");
            signup.assertPostcodeFieldErr("Please Provide a valid postal code");
            //input valid data
            signup.inputEmail(mail);
            signup.inputPassword("12345678PASS");
            signup.inputName("Name");
            signup.inputSurname("Surname");
            signup.selectCountry("Ukraine");
            signup.inputAddress("Test street, test number");
            signup.inputCity("City");
            signup.inputPostcode("456");
            signup.clickCreateAccBtn();
            Thread.sleep(2000);
            assertPageTitle(mainPageTitle);
            logout();
        } catch (Error e) {
            e.printStackTrace();
            getScreen("test_checkSignupFormFieldsRevalidation");
        }
    }

    @Test
    public void userCantSignupWithNotValidEmail() throws Exception {
        try {
            driver.navigate().to(domain + "/signup");
            Thread.sleep(2000);
            assertPageTitle(registrationPageTitle);
            signup.inputEmail("testmail");
            signup.inputPassword("12345678PASS");
            signup.inputName("Name");
            signup.inputSurname("Surname");
            signup.selectDayOfBirth("1");
            signup.selectMonthOfBirth("September");
            signup.selectYearOfBirth("1990");
            signup.selectCountry("Ukraine");
            signup.inputAddress("Test street, test number");
            signup.inputCity("City");
            signup.inputPostcode("456");
            signup.clickCreateAccBtn();
            signup.assertEmailFieldErr("Please provide a valid email address");
            logout();
        } catch (Error e) {
            e.printStackTrace();
            getScreen("test_userCantSignupWithNotValidEmail");
        }
    }

    @Test
    public void userCantSignupWithNotUniqueEmail() throws Exception {
        try {
            driver.navigate().to(domain + "/signup");
            Thread.sleep(2000);
            assertPageTitle(registrationPageTitle);
            signup.inputEmail(mail);
            signup.inputPassword("12345678PASS");
            signup.inputName("Name");
            signup.inputSurname("Surname");
            signup.selectCountry("Ukraine");
            signup.inputAddress("Test street, test number");
            signup.inputCity("City");
            signup.inputPostcode("456");
            signup.clickCreateAccBtn();
            Thread.sleep(2000);
            assertPageTitle("Play Lotto Online | Buy Lottery Tickets Online | Lottoz");
            //logout from account
            logout();
            //creating another acc with same email
            driver.navigate().to(domain + "/signup");
            Thread.sleep(2000);
            assertPageTitle(registrationPageTitle);
            signup.inputEmail(mail);
            signup.inputPassword("12345678PASS");
            signup.inputName("Name");
            signup.inputSurname("Surname");
            signup.selectCountry("Ukraine");
            signup.inputAddress("Test street, test number");
            signup.inputCity("City");
            signup.inputPostcode("456");
            signup.clickCreateAccBtn();
            signup.assertEmailFieldErr("Customer name already taken");
            logout();
        } catch (Error e) {
            e.printStackTrace();
            getScreen("test_userCantSignupWithNotUniqueEmail");
        }
    }

    @Test
    public void userCantSignupWhenPasswordLess8Symbols() throws Exception {
        try {
            driver.navigate().to(domain + "/signup");
            Thread.sleep(2000);
            assertPageTitle(registrationPageTitle);
            signup.inputEmail(mail);
            signup.inputPassword("12345P");
            signup.inputName("Name");
            signup.inputSurname("Surname");
            signup.selectDayOfBirth("1");
            signup.selectMonthOfBirth("September");
            signup.selectYearOfBirth("1990");
            signup.selectCountry("Ukraine");
            signup.inputAddress("Test street, test number");
            signup.inputCity("City");
            signup.inputPostcode("456");
            signup.clickCreateAccBtn();
            Thread.sleep(2000);
            signup.assertPasswordFieldErr("Your password must have a minimum of 8 characters & contain at least 1 letter and 1 number");
            logout();
        } catch (Error e) {
            e.printStackTrace();
            getScreen("test_userCantSignupWhenPasswordLess8Symbols");
        }
    }

    @Test
    public void userCantSignupWhenPasswordOnlyFromNumbers() throws Exception {
        try {
            driver.navigate().to(domain + "/signup");
            Thread.sleep(2000);
            assertPageTitle(registrationPageTitle);
            signup.inputEmail(mail);
            signup.inputPassword("12345678");
            signup.inputName("Name");
            signup.inputSurname("Surname");
            signup.selectDayOfBirth("1");
            signup.selectMonthOfBirth("September");
            signup.selectYearOfBirth("1990");
            signup.selectCountry("Ukraine");
            signup.inputAddress("Test street, test number");
            signup.inputCity("City");
            signup.inputPostcode("456");
            signup.clickCreateAccBtn();
            Thread.sleep(2000);
            signup.assertPasswordFieldErr("Your password must have a minimum of 8 characters & contain at least 1 letter and 1 number");
            logout();
        } catch (Error e) {
            e.printStackTrace();
            getScreen("test_userCantSignupWhenPasswordOnlyFromNumbers");
        }
    }
}

