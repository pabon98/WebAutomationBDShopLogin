package utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetup {
    private static final ThreadLocal <WebDriver> LOCAL_DRIVER = new ThreadLocal<>();
    private static String browser_name = System.getProperty("browser","Chrome");

    public static void setDriver(WebDriver driver){
        DriverSetup.LOCAL_DRIVER.set(driver);
    }
    public static WebDriver getDriver(){
        return LOCAL_DRIVER.get();
    }

    // browser open is pre requisite work for test execute
    @BeforeSuite
    public void openABrowser(){
     WebDriver driver = getBrowser(browser_name);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();
      setDriver(driver);
    }
    @AfterSuite
    public void closeBrowser(){
        // for closing full browser
        getDriver().quit();
    }
    public WebDriver getBrowser(String browser_name){
        if (browser_name.equalsIgnoreCase("chrome"))
            return new ChromeDriver();
        else if ( browser_name.equalsIgnoreCase("firefox")) {
            return  new FirefoxDriver();
        } else if (browser_name.equalsIgnoreCase("edge")) {
             return new EdgeDriver();
        }
        else {
            throw new RuntimeException("Browser is not currently available with the given name: " +browser_name);
        }

    }
}
