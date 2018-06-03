package com.xosmig.seleniumhw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class PageObject {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public PageObject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void load() {
        driver.get(getAddr());
        // Sometimes doesn't work without this line (causes flakiness). Might be a bug in the driver.
        driver.get(getAddr());
    }

    // Warning: not properly tested when multiple errors. Use it only when you expect exactly 1 error.
    public String expectError() {
        // Use cssSelector because By.className doesn't seem to work here
        return wait.until(visibilityOfElementLocated(By.cssSelector("div[class='message error']")))
                .findElement(By.cssSelector("li[class='errorSeverity']"))
                .getText();
    }

    public String getAddr() {
        return "http://localhost:8080";
    }
}
