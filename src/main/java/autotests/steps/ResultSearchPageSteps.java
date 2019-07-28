package autotests.steps;

import autotests.pages.ResultSearchPage;
import autotests.utils.DriverManager;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ResultSearchPageSteps {

    private ResultSearchPage resultSearchPage = new ResultSearchPage();

    @When("цена ограничена до \"(.*)\" руб")
    public void priceTo(String priceTo) {
        //resultSearchPage.click(resultSearchPage.exitCookie);
        resultSearchPage.priceTo.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), priceTo + "\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("в корзину добавлены первые 8 \"(.*)\" товаров")
    public void addProductsToBasket(String chetNechet) {
        int j,k;
        if (resultSearchPage.catalog.size() > 16){
            k = 16;
        }
        else {
            k = resultSearchPage.catalog.size();
        }
        if (chetNechet.equals("нечетных")) {
            j = 0;
        } else {
            j = 1;
        }
        for (int i = j; i < k; i += 2) {

            String xpathPriceProduct = String.format("//div[@data-index='%s']//span[@data-test-id='tile-price']", i);
            int priceOfProduct = Integer.parseInt(DriverManager.getDriver().findElement(By.xpath(xpathPriceProduct)).getText().replaceAll("\\D", ""));
            String xpathNameProduct = String.format("//div[@data-index='%s']//a[@id='name']", i);
            String nameOfProduct = DriverManager.getDriver().findElement(By.xpath(xpathNameProduct)).getText();
            BaseSteps.setVariables(nameOfProduct, priceOfProduct);
            String xpathInBasket = String.format("//div[@data-index='%s']//span[contains(text(), 'В корзину')]", i);
            WebElement addToBasket = DriverManager.getDriver().findElement(By.xpath(xpathInBasket));
            resultSearchPage.scrollAndClick(addToBasket);
        }
    }

    @When("выбраны бренды \"(.*)\", \"(.*)\"")
    public void selectBrands(String beats, String samsung) {
        resultSearchPage.click(resultSearchPage.allBrands);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resultSearchPage.click(resultSearchPage.searchField);
        resultSearchPage.sendKeys(resultSearchPage.searchField, beats + "\n");
        resultSearchPage.searchField.clear();
        resultSearchPage.click(resultSearchPage.searchField);
        resultSearchPage.sendKeys(resultSearchPage.searchField, samsung + "\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("выполнен переход в корзину")
    public void goToBasket() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resultSearchPage.click(resultSearchPage.basket);
    }
}
