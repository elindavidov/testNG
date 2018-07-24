
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class TestDemoQA {
    WebDriver driver;

    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.demoqa.com/registration");
    }

    @Test
    public void test3() {
        Faker faker = new Faker();

        String fakerName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();

        sendKeysWithJavaScript(fakerName, driver.findElement(By.id("name_3_firstname")));
        sendKeysWithJavaScript(fakerName, driver.findElement(By.id("name_3_lastname")));
        driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[3]/div/div/input[1]")).click();

        sendKeysWithJavaScript("08888888888", driver.findElement(By.id("phone_9")));
        sendKeysWithJavaScript(name, driver.findElement(By.id("username")));
        sendKeysWithJavaScript(email, driver.findElement(By.id("email_1")));
        sendKeysWithJavaScript("mypassword", driver.findElement(By.id("password_2")));
        sendKeysWithJavaScript("mypassword", driver.findElement(By.id("confirm_password_password_2")));
        WebElement clickSubmit = driver.findElement(By.cssSelector("#pie_register > li:nth-child(14) > div > input[type=\"submit\"]"));
        clickSubmit.click();


    }

    public void sendKeysWithJavaScript(String text, WebElement webElement) {
        JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
        try {
            myExecutor.executeScript("arguments[0].value='" + text + "';", webElement);
        } catch (Exception e) {
        }

    }

    @Test
    public void verifySuccess() {
        String actualString = driver.findElement(By.className("piereg_message")).getText();

        Assert.assertEquals("Thank you for your registration", actualString);
    }
//    @Test
//    public void verifyBtn() throws InterruptedException {
//        driver.findElement(By.id("waitButton")).click();
//        WaitTool.waitForElement(driver, By.id("waitButton"), 10);
//        boolean isDisplayed = driver.findElement(By.id("waitButton")).isDisplayed();
//
//
//        Assert.assertTrue(isDisplayed);
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(isDisplayed);
//
//        softAssert.assertAll();
//    }


//
//    @Test(dataProvider = "test")
//    public void sendFirstName(String name, String lastname) throws InterruptedException {
//        driver.findElement(By.id("waitButton")).click();
//        WebElement inputFirstName = WaitTool.waitForElement(driver, By.id("fname"), 10);
//        inputFirstName.sendKeys(name);
////        boolean isDisplayed = driver.findElement(By.id("fname")).isDisplayed();
//    }
//
//    @DataProvider(name = "test")
//    public Object[][] createData1() {
//         return new Object[][]{
//                {"Ivan", "Petkov"},
//                {"Tozi", "Onzi"},
//                {"Todor", "Tupoto"},
//        };
//    }

//
//    @AfterClass
//    public static void letMeSee() throws InterruptedException {
////        Thread.sleep(10000);
//    }
//    @DataProvider(name = "test2")
//    public Object[][] createData2() {
//        return new Object[][]{
//                {"Ivan", "Petkov"},
//                {"Tozi", "Onzi"},
//                {"Todor", "Tupoto"},
//        };


//    @Test
//    public void verifyErrorMessages () {
//        WebElement firstnameInput = driver.findElement(By.cssSelector("#name_3_firstname"));
//        firstnameInput.click();
//        WebElement lastnameInput = driver.findElement(By.cssSelector("#name_3_lastname"));
//        lastnameInput.click();
//       boolean isError = driver.findElement(By.cssSelector("#pie_register > li:nth-child(1) > div.fieldset.error > div.legend_txt > span")).isDisplayed();
////        Assert.assertTrue("Tuk proverqvam za error" );
//        Assert.assertTrue("Tuk proverqvam za error",isError);
//    }
//    @After
//    public void stopBrowser () throws InterruptedException {
//        Thread.sleep(5000);
//        driver.quit();
//    }
}