package tests.steps;

import com.codeborne.selenide.Condition;

import com.codeborne.selenide.Selenide;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import tests.pages.loginPage;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class loginSteps {

    @Then("^I (.*) see (.*) element on the login page$")
    public void iXxxSeeXxxElementOnTheLoginPage(String state, String elementName) {
        loginPage loginPage = new loginPage();
        Condition expectedCondition = state.equalsIgnoreCase("should") ? Condition.visible : Condition.hidden;
        if (elementName.equalsIgnoreCase("logo")) {
            $(loginPage.logoFieldLocator).shouldHave(expectedCondition);
        } else if (elementName.equalsIgnoreCase("login button")) {
            $(loginPage.loginButtonLocator).shouldHave(expectedCondition);
        } else throw new IllegalArgumentException(String.format("Wrong element name - %s", elementName));
    }

    @When("^I fill login page with next data:$")
    public void iFillLoginPageWithNextData(DataTable loginDataTable) {
        loginPage loginPage = new loginPage();
        List<Map<String,String>> rows = loginDataTable.asMaps(String.class, String.class);
        for (Map<String,String> loginData : rows) {
            if (loginData.containsKey("userName")) {
                $(loginPage.userNameInputLocator).sendKeys(Keys.CONTROL + "A");
                $(loginPage.userNameInputLocator).sendKeys(Keys.BACK_SPACE);
                $(loginPage.userNameInputLocator).sendKeys(loginData.get("userName"));
            }
            if (loginData.containsKey("password")) {
                $(loginPage.passwordInputLocator).sendKeys(Keys.CONTROL + "A");
                $(loginPage.passwordInputLocator).sendKeys(Keys.BACK_SPACE);
                $(loginPage.passwordInputLocator).sendKeys(loginData.get("password"));
            }
        }
    }

    @And("^I press login button on the login page$")
    public void iPressLoginButtonOnTheLoginPage() {
        loginPage loginPage = new loginPage();
        $(loginPage.loginButtonLocator).click();
    }

    @Then("^I should see '(.*)' error message below password field on the login page$")
    public void iShouldSeeXxxErrorMessageBelowPasswordFieldOnTheLoginPage(String errorMessage) {
        loginPage loginPage = new loginPage();
        $(loginPage.errorMessageFieldLocator).shouldHave(Condition.exactText(errorMessage));
    }


}
