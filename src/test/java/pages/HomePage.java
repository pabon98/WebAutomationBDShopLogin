package pages;

import org.openqa.selenium.By;

import java.time.Duration;



public class HomePage extends BasePage{

   public By home_login_btn = By.xpath("//a[normalize-space()='Log In']");
   public String homepage_title = "BD SHOP | Online Shopping BD | YouTube Gadget & Gear Shop";
   public String homepage_url = "https://www.bdshop.com/";
   public String loginPage_url = "https://www.bdshop.com/customer/account/login";
   public By user_name = By.xpath("//div[@class='name']");

   public void NavigateToLoginPage(){
       LoadAnWebPage(homepage_url);
       getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       clickOneElement(home_login_btn);
   }

}
