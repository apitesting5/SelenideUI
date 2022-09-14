package tests.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.When;
import tests.pages.loginPage;
import tests.pages.productPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class commonSteps {
    @When("^I visit (.*) site$")
    public void iVisitXxxSite(String siteUrl) {
        open(siteUrl);
    }

    @When("I Login with Standard User")
    public void iLoginWithStandardUser() {
        loginPage loginPage = new loginPage();
        productPage productPage = new productPage();

        open("https://www.saucedemo.com/");
        $(loginPage.userNameInputLocator).sendKeys("standard_user");
        $(loginPage.passwordInputLocator).sendKeys("secret_sauce");
        $(loginPage.loginButtonLocator).click();
        $(productPage.pageTitleLocator).shouldHave(Condition.visible);

    }
}
