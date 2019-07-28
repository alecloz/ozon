package autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends BasePageObject{

    @FindBy(xpath = "//div[@class='cart-list']//*[@data-test-id='cart-item-title']")
    public List<WebElement> listOfProducts;

    @FindBy(xpath = "//div[@class='row m-big']//span[@class='price-number']")
    public WebElement resultPrice;

    @FindBy(xpath = "//button[contains(text(), 'Удалить выбранные')]")
    public WebElement deleteProducts;

    @FindBy(xpath = "//div[contains(text(), 'Вы точно хотите')]/following-sibling::div[1]/button")
    public WebElement acceptDeleteProducts;

    @FindBy(xpath = "//*[contains(text(),'Кабинет')]/parent::div")
    public WebElement cabinet;

    @FindBy(xpath = "//*[@class='_327ec']//button[contains(text(),'Выйти')]")
    public WebElement logOut;

    @FindBy(xpath = "//h1[text()='Корзина пуста']")
    public WebElement basketIsEmpty;
}
