package autotests.steps;

import autotests.pages.BasePageObject;
import autotests.utils.DriverManager;
import autotests.utils.TestProperties;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    private static Properties properties = TestProperties.getInstance().getProperties();
    public static BasePageObject pageObject;
    static HashMap<String, Integer> variables = new HashMap<>();

    public static void setVariables(String key, Integer value) {
        variables.put(key, value);
    }

    public static Integer getVariable(String key) {
        return variables.get(key);
    }

    @Before
    public void startScenario() {
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("app.url"));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @After
    public void afterMethod(Scenario scenario) {
        if(scenario.isFailed()){
            takeScreenshot();
        }
        DriverManager.quitDriver();
    }

    @Attachment(type = "image/png", value = "Скриншот в момент ошибки")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
