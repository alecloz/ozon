package autotests.pages;

import autotests.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageObject {

    private WebDriverWait wait  = new WebDriverWait(DriverManager.getDriver(), 60);

    public BasePageObject() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeys(WebElement element, String keys){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }

    public void scrollAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("return arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
