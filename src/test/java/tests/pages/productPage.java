package tests.pages;

import org.openqa.selenium.By;

public class productPage {

    public By pageTitleLocator = By.xpath("//span[text()='Products']");


    public By filterDropdownLocator = By.cssSelector(".product_sort_container");

    public By allPricesLocator = By.cssSelector("[class='inventory_item_price']");

    public By productItemLocator = By.cssSelector(".inventory_item");

    public By firstProductToTheCartLocator = By.cssSelector("[name='add-to-cart-sauce-labs-backpack']");

    public By lastProductToTheCartLocator = By.cssSelector("button#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)");

    public By removeFirstButtonFromTheCartLocator = By.cssSelector("button#remove-sauce-labs-backpack");

    public By shoppingCartLocator = By.cssSelector(".shopping_cart_link");

    public By firstProductTitleLocator = By.linkText("Sauce Labs Backpack");

    public By lastProductTitleLocator = By.linkText("Test.allTheThings() T-Shirt (Red)");



}
