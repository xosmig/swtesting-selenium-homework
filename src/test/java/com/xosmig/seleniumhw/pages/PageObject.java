package com.xosmig.seleniumhw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public PageObject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void load() {
        driver.get(getAddr());
    }

    public String getAddr() {
        return "http://localhost:8080";
    }
}
