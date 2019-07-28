package autotests.steps;

import autotests.pages.MainPage;
import cucumber.api.java.en.When;

public class MainPageSteps {

    private MainPage mainPage = new MainPage();

    @When("выполнена авторизация на сервисе с логином - \"(.*)\" и паролем - \"(.*)\"")
    public void logIn(String login, String password) {
        mainPage.click(mainPage.signIn);
        mainPage.click(mainPage.signInByEmail);
        mainPage.click(mainPage.writeYourEmail);
        mainPage.sendKeys(mainPage.writeYourEmail, login);
        mainPage.click(mainPage.writeYourPassword);
        mainPage.sendKeys(mainPage.writeYourPassword, password);
        mainPage.click(mainPage.signInBtn);
    }

    @When("выполнен поиск по \"(.*)\"")
    public void searchByWord(String searchWord) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.click(mainPage.searchInOzonField);
        mainPage.sendKeys(mainPage.searchInOzonField, searchWord + "\n");
        //mainPage.click(mainPage.searchBtn);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
