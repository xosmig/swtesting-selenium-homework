package com.xosmig.seleniumhw.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Selector extends PageElement {
    private WebElement openButton;

    public Selector(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void select(String title) {
        openButton.click();
        wait.until(elementToBeClickable(By.cssSelector(String.format("li[title='%s']", title))))
                .click();
    }

    public void find(By by) {
        openButton = wait.until(elementToBeClickable(by));
    }
}
