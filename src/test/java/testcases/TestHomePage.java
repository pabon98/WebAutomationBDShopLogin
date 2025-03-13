package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

import java.time.Duration;


public class TestHomePage extends DriverSetup {
   HomePage homePage = new HomePage();
    @Test(priority = 1)
    public void TestHomePageTitle(){
        homePage.LoadAnWebPage(homePage.homepage_url);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Test title
        Assert.assertEquals(homePage.getPageTitle(), homePage.homepage_title);

    }
    @Test(priority = 0)
    public void TestHomePageUrl(){
        homePage.LoadAnWebPage(homePage.homepage_url);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Test Url
        Assert.assertEquals(homePage.getCurrentPageUrl(), homePage.homepage_url);
    }
}
