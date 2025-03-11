package testcases;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;
import java.time.Duration;


public class TestLoginPage extends DriverSetup {
   HomePage homePage = new HomePage();
   LoginPage loginPage = new LoginPage();
   
 @BeforeSuite
 public void setup_class(){
 homePage.NavigateToLoginPage();
}

 @AfterSuite
 public void logoutUser() throws InterruptedException {
    Actions actions = new Actions(getDriver());
    actions.moveToElement(homePage.getElement(homePage.user_name)).build().perform();
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.textToBePresentInElement(homePage.getElement(homePage.user_name), "Jahed" ));
    homePage.clickOneElement(loginPage.Logout_btn);
//    Thread.sleep(8000);
}

    @Test(priority = 4)
    public void LoginWithValidCredentials() {

        loginPage.WriteOneElement(loginPage.email_field, loginPage.user_email);
        loginPage.WriteOneElement(loginPage.password_field, loginPage.user_password);
        loginPage.clickOneElement(loginPage.Login_btn);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(loginPage.login_text, "Log In"));
        System.out.println(homePage.getElement(loginPage.login_text));

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test(priority = 1)
    public void LoginWithInvalidEmailAndValidPassword(){
        loginPage.WriteOneElement(loginPage.email_field, "xohed58570@abc.com");
        loginPage.WriteOneElement(loginPage.password_field, loginPage.user_password);
        loginPage.clickOneElement(loginPage.Login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Invalid login or password.");
        loginPage.getElement(loginPage.email_field).clear();
        loginPage.getElement(loginPage.password_field).clear();
    }
    @Test(priority = 0)
    public void LoginWithValidEmailAndInValidPassword() throws InterruptedException {
        loginPage.WriteOneElement(loginPage.email_field, "xohed58570@calmpros.com");
        loginPage.WriteOneElement(loginPage.password_field, "111111");
        loginPage.clickOneElement(loginPage.Login_btn);
        Assert.assertTrue(loginPage.getElement(loginPage.error_msg).isDisplayed());
        loginPage.getElement(loginPage.email_field).clear();
        loginPage.getElement(loginPage.password_field).clear();
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void LoginWithInvalidEmailAndPassword(){
     loginPage.WriteOneElement(loginPage.email_field, "xohed@abc.com");
     loginPage.WriteOneElement(loginPage.password_field, "121212");
     loginPage.clickOneElement(loginPage.Login_btn);
     Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Invalid login or password.");
     loginPage.getElement(loginPage.email_field).clear();
     loginPage.getElement(loginPage.password_field).clear();
    }

    @Test(priority = 3)
    public void LoginWithEmptyMailAndPassword(){
     loginPage.WriteOneElement(loginPage.email_field, "");
     loginPage.WriteOneElement(loginPage.password_field, "");
     loginPage.clickOneElement(loginPage.Login_btn);
     Assert.assertEquals(loginPage.getElement(loginPage.email_popup_error_msg).getText(), "This is a required field.");
     Assert.assertEquals(loginPage.getElement(loginPage.password_popup_error_msg).getText(), "This is a required field.");
     loginPage.getElement(loginPage.email_field).clear();
     loginPage.getElement(loginPage.password_field).clear();
    }
}
