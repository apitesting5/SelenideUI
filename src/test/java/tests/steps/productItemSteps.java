package tests.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import tests.pages.productItemPage;

import static com.codeborne.selenide.Selenide.$;

public class productItemSteps {

    @Then("^I should see ProductItem Page and the name of my (.*)$")
    public void iShouldSeeProductItemPageAndTheNameOfMyXxx(String productName) {
        productItemPage productItemPage = new productItemPage();
        $(productItemPage.backToProductsBtnLocator).shouldHave(Condition.visible);
        $(productItemPage.inventoryNameLocator).shouldHave(Condition.text(productName));


    }

    @And("^I should see the following (.*)$")
    public void iShouldSeeTheFollowingDescription(String description) {
        productItemPage productItemPage = new productItemPage();
        $(productItemPage.inventoryDescriptionLocator).shouldHave(Condition.text(description));
    }
}
