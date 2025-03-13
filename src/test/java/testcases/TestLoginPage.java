package testcases;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import utilities.Datasets;
import utilities.DriverSetup;
import java.time.Duration;


public class TestLoginPage extends DriverSetup {
   HomePage homePage = new HomePage();
   LoginPage loginPage = new LoginPage();
   
 @BeforeClass
 public void setup_class() {
 homePage.NavigateToLoginPage();
}

 @AfterClass
 public void logoutUser() {
    Actions actions = new Actions(getDriver());
    actions.moveToElement(homePage.getElement(homePage.user_name)).build().perform();
    homePage.clickOneElement(loginPage.Logout_btn);
     getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

    @Test(priority = 5, description = "Test With Valid credentials")
    @Description("User is trying to login with valid credentials")
    public void LoginWithValidCredentials() {
        loginPage.WriteOneElement(loginPage.email_field, loginPage.user_email);
        loginPage.WriteOneElement(loginPage.password_field, loginPage.user_password);
        loginPage.clickOneElement(loginPage.Login_btn);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(loginPage.login_text, "Log In"));
        System.out.println(homePage.getElement(loginPage.login_text));

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test(priority = 0, description = "Test with Invalid email")
    @Description("User is trying to login with invalid email")
    public void LoginWithInvalidEmailAndValidPassword(){
        Allure.label("severity", "critical");
        loginPage.WriteOneElement(loginPage.email_field, "xohed58570@abc.com");
        loginPage.WriteOneElement(loginPage.password_field, loginPage.user_password);
        loginPage.clickOneElement(loginPage.Login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Invalid login or password.");
        loginPage.getElement(loginPage.email_field).clear();
        loginPage.getElement(loginPage.password_field).clear();
    }
    @Test(priority = 1, description = "Test with invalid credentials")
    @Description("User is trying to login with invalid credentials")
    public void LoginWithInvalidCredentials(){
        Allure.label("severity", "critical");
        loginPage.WriteOneElement(loginPage.email_field, "john@john.com");
        loginPage.WriteOneElement(loginPage.password_field, "123@123");
        loginPage.clickOneElement(loginPage.Login_btn);
        Assert.assertTrue(loginPage.getElement(loginPage.error_msg).isDisplayed());
        loginPage.getElement(loginPage.email_field).clear();
        loginPage.getElement(loginPage.password_field).clear();
    }
    @Test(priority = 2, description = "Test with valid email and invalid password")
    @Description("User is trying to login with valid mail and invalid password")
    public void LoginWithValidEmailAndInValidPassword()  {
        Allure.label("severity", "critical");
        loginPage.WriteOneElement(loginPage.email_field, "xohed58570@calmpros.com");
        loginPage.WriteOneElement(loginPage.password_field, "111111");
        loginPage.clickOneElement(loginPage.Login_btn);
        if (loginPage.Is_Element_Visible(loginPage.error_msg)){
            Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Invalid login or password.");
        }

        loginPage.getElement(loginPage.email_field).clear();
        loginPage.getElement(loginPage.password_field).clear();
    }
    @Test(priority = 3, description = "Test with invalid email and password")
    @Description("User is trying to login with invalid mail and password")
    public void LoginWithInvalidEmailAndPassword(){
        Allure.label("severity", "critical");
     loginPage.WriteOneElement(loginPage.email_field, "xohed@abc.com");
     loginPage.WriteOneElement(loginPage.password_field, "121212");
     loginPage.clickOneElement(loginPage.Login_btn);
     Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Invalid login or password.");
     loginPage.getElement(loginPage.email_field).clear();
     loginPage.getElement(loginPage.password_field).clear();
    }

    @Test(priority = 4, description = "Test with empty mail and password")
    @Description("User is trying to login with empty value")
    public void LoginWithEmptyMailAndPassword(){
        Allure.label("severity", "critical");
     loginPage.WriteOneElement(loginPage.email_field, "");
     loginPage.WriteOneElement(loginPage.password_field, "");
     loginPage.clickOneElement(loginPage.Login_btn);
     Assert.assertEquals(loginPage.getElement(loginPage.email_popup_error_msg).getText(), "This is a required field.");
     Assert.assertEquals(loginPage.getElement(loginPage.password_popup_error_msg).getText(), "This is a required field.");
     loginPage.getElement(loginPage.email_field).clear();
     loginPage.getElement(loginPage.password_field).clear();
    }
}
