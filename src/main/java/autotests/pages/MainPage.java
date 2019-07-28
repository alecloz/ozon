package autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePageObject{

    @FindBy(xpath = "//*[contains(text(),'Войти')]/parent::div")
    public WebElement signIn;

    @FindBy(xpath = "//*[contains(text(),'Войти по почте')]")
    public WebElement signInByEmail;

    @FindBy(xpath = "//*[@data-test-id='emailField']")
    public WebElement writeYourEmail;

    @FindBy(xpath = "//*[@data-test-id='passwordField']")
    public WebElement writeYourPassword;

    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    public WebElement signInBtn;

    @FindBy(xpath = "//*[@placeholder='Искать на Ozon']")
    public WebElement searchInOzonField;

    @FindBy(xpath = "//*[@class='search-button-wrap']")
    public WebElement searchBtn;

}
