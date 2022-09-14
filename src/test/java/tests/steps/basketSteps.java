package tests.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Conditional;
import io.cucumber.java.en.And;
import tests.pages.basketPage;

import static com.codeborne.selenide.Selenide.$;

public class basketSteps {

    @And("^I should see the availability of (.*) on the Basket page$")
    public void iShouldSeeTheAvailabilityOfTheProductOnTheBasketPage(String productName) {
        basketPage basketPage = new basketPage();
        $(basketPage.inventoryItemName).shouldHave(Condition.text(productName));




    }

    @And("I should see Basket Page")
    public void iShouldSeeBasketPage() {
        basketPage basketPage = new basketPage();
        $(basketPage.pageTitleLocator).shouldHave(Condition.visible);

    }
}
