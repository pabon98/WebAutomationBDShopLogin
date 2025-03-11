package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DriverSetup;

public class BasePage extends DriverSetup {

public WebElement getElement(By Locator){
    return getDriver().findElement(Locator);
}

public void clickOneElement(By Locator){
    getElement(Locator).click();
}

public void LoadAnWebPage(String url){
     getDriver().get(url);
}
public String getPageTitle(){
   return getDriver().getTitle();
}

public String getCurrentPageUrl(){
    return getDriver().getCurrentUrl();
}
public void WriteOneElement(By Locator, String text){
    getElement(Locator).sendKeys(text);
}
public Boolean Is_Element_Visible(By Locator){
    try{
        return getElement(Locator).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

}
