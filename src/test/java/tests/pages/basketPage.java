package tests.pages;

import org.openqa.selenium.By;

public class basketPage {
    public By pageTitleLocator = By.cssSelector(".title");

    public By cartItemLocator = By.cssSelector(".cart_item > .cart_item_label");

    public By inventoryItemName = By.cssSelector("[class='inventory_item_name']");


}
