package tests.pages;

import org.openqa.selenium.By;

public class loginPage {
    public By loginButtonLocator = By.cssSelector("#login-button");
    public By logoFieldLocator = By.cssSelector(".login_logo");
    public By passwordInputLocator = By.cssSelector("#password");
    public By userNameInputLocator = By.cssSelector("#user-name");

    public By errorMessageFieldLocator = By.cssSelector("[data-test='error']");
}
