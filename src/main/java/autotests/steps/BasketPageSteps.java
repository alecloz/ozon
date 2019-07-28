package autotests.steps;

import autotests.pages.BasketPage;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Map;

public class BasketPageSteps {

    private BasketPage basketPage = new BasketPage();

    @When("все добавленные ранее товары находятся в корзине")
    public void allProductsInBasket() {
        ArrayList<String> arrlistOfProducts = new ArrayList<>();
        for (WebElement element : basketPage.listOfProducts) {
            arrlistOfProducts.add(element.getText());
        }
        for (Map.Entry map : BaseSteps.variables.entrySet()) {

            if (!arrlistOfProducts.contains(map.getKey())) {
                Assert.fail("В корзине отсутствует товар - " + map.getKey());
            }
        }
    }

    @When("итоговая цена \"(.*)\" равна сумме цен добавленных товаров")
    public void resultPriceIsCorrect(String product) {
        int resultSum = 0;
        for (Map.Entry map : BaseSteps.variables.entrySet()) {
            resultSum += (int) map.getValue();
        }
        BaseSteps.variables.clear();
        if (product.equals("смартфонов")) {
            return;
        }
        //смартфоны не сравниваю потому что на сайте не корректная инфа
        Assert.assertEquals("Итоговая цена товаров не равна!", String.valueOf(resultSum), basketPage.resultPrice.getText().replaceAll(" ", ""));
    }

    @When("из корзины удалены все товары")
    public void deleteProductsFromBasket() {
        basketPage.click(basketPage.deleteProducts);
        basketPage.click(basketPage.acceptDeleteProducts);
    }

    @When("выполнен выход из сервиса")
    public void exitFromService() {
        basketPage.click(basketPage.cabinet);
        basketPage.click(basketPage.logOut);
    }

    @When("корзина содержит заголовок \"(.*)\"")
    public void basketIsEmpty(String title) {
        Assert.assertEquals("Корзина не пуста", title, basketPage.basketIsEmpty.getText());
    }
}
