package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    // First Name: Jahed
    // Last Name: Hossain
    // Email: xohed58570@calmpros.com
    // password: 1234@123ab

  public By email_field = By.xpath("//input[@id='email-login']");
  public By password_field = By.xpath("//input[@id='pass-popup']");
  public By Login_btn = By.xpath("//button[@id='btn-social-login-authentication']");
  public By login_text = By.xpath("//h2[normalize-space()='Log In']");
  public By Logout_btn = By.xpath("//span[normalize-space()='Log Out']");
  public By error_msg = By.xpath("//div[contains(text(),'Invalid login or password.')]");
  public By password_popup_error_msg = By.xpath("//div[@id='pass-popup-error']");
  public By email_popup_error_msg = By.xpath("//div[@id='email-login-error']");
  public String user_email = "xohed58570@calmpros.com";
  public String user_password = "1234@123ab";



}
