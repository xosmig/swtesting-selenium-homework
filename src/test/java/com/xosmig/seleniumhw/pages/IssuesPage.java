package com.xosmig.seleniumhw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class IssuesPage extends PageObject {

    WebElement createIssueButton;

    public IssuesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public void load() {
        createIssueButton = wait.until(elementToBeClickable(By.linkText("Create Issue")));
    }

    @Override
    public String getAddr() {
        return super.getAddr() + "/issues";
    }
}
