package tests.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import tests.pages.loginPage;
import tests.pages.productPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class productSteps {
    @Then("I should see Products page")
    public void iShouldSeeProductsPage() {
        productPage productPage = new productPage();
        $(productPage.pageTitleLocator).shouldHave(Condition.visible);
    }

    @Then("I login with correct credentials and click login button")
    public void iLoginWithCorrectCredentialsAndClickLoginButton(DataTable loginDataTable) {
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
        $(loginPage.loginButtonLocator).click();

    }
    @When("^I sort products by (.*)$")
    public void iSortProductsByXxx(String sortType) {
        productPage productPage = new productPage();
        $(productPage.filterDropdownLocator).selectOptionContainingText(sortType);
    }
    @Then("I should see that the price of the first product is (.*) and the price the last product is (.*)")
    public void iShouldSeeTheFirstProductWithTheLowestPrice(String price1, String price6) {
        productPage productPage = new productPage();
        $$(productPage.allPricesLocator).get(0).shouldHave(Condition.text(price1));
        $$(productPage.allPricesLocator).get(5).shouldHave(Condition.text(price6));
//        ArrayList<Double> currentOrderInt = new ArrayList<>();
//        ArrayList<Double> expectedOrderInt = new ArrayList<>();
//
//        for(SelenideElement x : currentOrder){
//            currentOrderInt.add(Double.parseDouble(x.getText().substring(1)));
//            expectedOrderInt.add(Double.parseDouble(x.getText().substring(1)));
//        }
//        Collections.sort(expectedOrderInt);
//
//        if((currentOrderInt.get(0) == expectedOrderInt.get(0)) &&
//                (currentOrderInt.get(currentOrderInt.size() - 1) == expectedOrderInt.get(expectedOrderInt.size() - 1)) ){
//            Assert.assertTrue(true);
//        }

    }


    @Then("^I should see (.*) products on the Products page$")
    public void iShouldSeeXxxProductsOnTheProductsPage(int numberOfProducts) {
        productPage productPage = new productPage();
        $$(productPage.productItemLocator).shouldHave(size(numberOfProducts));

    }

    @Then("^I take (.*) and press Add to Cart button on the Products Page$")
    public void iTakeTheFirstProductAndPressButton(String productName) {
        productPage productPage = new productPage();
        if($(productPage.firstProductTitleLocator).getText().equalsIgnoreCase(productName)){
            $(productPage.firstProductToTheCartLocator).click();
        } else if ($(productPage.lastProductTitleLocator).getText().equalsIgnoreCase(productName)){
            $(productPage.lastProductToTheCartLocator).click();

        }

    }

    @And("I should see Remove button except Add to Cart button")
    public void iShouldSeeRemoveButtonExceptAddToCartButton() {
        productPage productPage = new productPage();
        $(productPage.removeFirstButtonFromTheCartLocator).shouldHave(Condition.visible);
    }

    @Then("I press Basket Icon on the Products page")
    public void iPressBasketIconOnTheProductsPage() {
        productPage productPage = new productPage();
        $(productPage.shoppingCartLocator).click();
    }

    @Then("^I click on (.*) on the Products page$")
    public void iClickOnProductOnTheProductsPage(String productName) {
        productPage productPage = new productPage();
        if($(productPage.firstProductTitleLocator).getText().equalsIgnoreCase(productName)){
            $(productPage.firstProductTitleLocator).click();
        } else if ($(productPage.lastProductTitleLocator).getText().equalsIgnoreCase(productName)){
            $(productPage.lastProductTitleLocator).click();

        }
    }





}
