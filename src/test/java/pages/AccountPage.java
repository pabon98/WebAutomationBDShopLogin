package pages;

import org.openqa.selenium.By;

public class AccountPage extends BasePage {
    By user_name_email = By.xpath("//p[contains(text(),'Jahed Hossain')]");
    String account_page_url = "https://www.bdshop.com/customer/account/";
    String account_page_title = "My Account";
}
