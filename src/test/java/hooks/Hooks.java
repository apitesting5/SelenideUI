package hooks;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.*;
import static org.openqa.selenium.OutputType.BYTES;

public class Hooks {
    @Before
    public void testDataSetup() {

    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver().hasWebDriverStarted()) {
            if (scenario.isFailed()) {
                TakesScreenshot camera = (TakesScreenshot) getWebDriver();
                byte[] screenshot = camera.getScreenshotAs(BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
            closeWebDriver();
        }
    }
}
