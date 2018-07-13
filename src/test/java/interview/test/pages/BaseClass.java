package interview.test.pages;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    protected static WebDriver driver;
    protected static SignupPage signup;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/Desktop/driver/chromedriver");
        /*first option for mobile dimension testing
        driver.manage().window().setSize(new Dimension(375, 667));*/
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "iPhone 6/7/8");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signup = new SignupPage(driver);

    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    //general variables
    protected String domain = "https://www.lottoz.com";
    protected String random = String.valueOf((int) (Math.random() * 10000));
    protected String mail = "autotestuser" + random + "test@morpheusgames.com";

    private JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    //general methods
    protected Select select;
    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

    protected void getScreen(String name) throws Exception {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcFile, new File("/Users/admin/Desktop/" + name + ".jpg"));
    }

    protected void assertPageTitle(String string) {
        String actual = driver.getTitle();
        Assert.assertTrue(actual.contains(string));
    }

    protected void logout() {
        jsExecutor.executeScript("sessionStorage.clear();");
        jsExecutor.executeScript("localStorage.clear();");
        driver.navigate().refresh();
    }

    //pages titles
    protected String signupPageTitle = "Registration | Create your Lottoz Account";
    protected String mainPageTitle = "Play Lotto Online | Buy Lottery Tickets Online | Lottoz";

}
