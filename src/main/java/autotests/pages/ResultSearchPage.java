package autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ResultSearchPage extends BasePageObject{

    @FindBy(xpath = "//button[@aria-label='Закрыть сообщение']")
    public WebElement exitCookie;

    @FindBy(xpath = "//*[contains(text(),'Цена')]/parent::div//input[contains(@id,'to')]")
    public WebElement priceTo;

    @FindBy(xpath = "//div[@class='tiles']/div[@data-index]")
    public List<WebElement> catalog;

    @FindBy(xpath = "//*[contains(text(),'Бренды')]/parent::div[1]//span[contains(text(),'Посмотреть все')]")
    public WebElement allBrands;

    @FindBy(xpath = "//*[@class='search-form']//input")
    public WebElement searchField;

    @FindBy(xpath = "//*[@data-test-id='filter-block-brand']//label//span[@class='checkmark']")
    public WebElement checkboxBrand;

    @FindBy(xpath = "//*[contains(text(),'Корзина')]/parent::a")
    public WebElement basket;
}
