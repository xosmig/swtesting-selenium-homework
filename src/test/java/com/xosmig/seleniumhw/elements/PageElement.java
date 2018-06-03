package com.xosmig.seleniumhw.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageElement {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public PageElement(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
