package com.xosmig.seleniumhw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public final class LoginPage extends PageObject {
    private WebElement loginInput;
    private WebElement passwordInput;
    private WebElement loginButton;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void doLogin(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    @Override
    public void load() {
        super.load();
        loginInput = wait.until(visibilityOfElementLocated(By.id("id_l.L.login")));
        passwordInput = wait.until(visibilityOfElementLocated(By.id("id_l.L.password")));
        loginButton = wait.until(elementToBeClickable(By.id("id_l.L.loginButton")));
    }

    @Override
    public String getAddr() {
        return super.getAddr() + "/login";
    }
}
