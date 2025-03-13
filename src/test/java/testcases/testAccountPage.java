package testcases;
import io.qameta.allure.Description;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;
import java.time.Duration;

public class testAccountPage extends DriverSetup {
    AccountPage accountPage = new AccountPage();
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
    @Test(priority = 0)
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
    @Test(priority = 1)
    public void testAccountPageUrl(){
        accountPage.LoadAnWebPage(accountPage.account_page_url);
        Assert.assertEquals(getDriver().getCurrentUrl(), accountPage.account_page_url);
        System.out.println(getDriver().getCurrentUrl());
    }
    @Test(priority = 2)
    public void testAccountPageTitle(){
        accountPage.LoadAnWebPage(accountPage.account_page_url);
        Assert.assertEquals(getDriver().getTitle(), accountPage.account_page_title);
    }
}
