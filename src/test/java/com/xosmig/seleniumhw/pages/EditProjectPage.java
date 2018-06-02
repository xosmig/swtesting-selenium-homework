package com.xosmig.seleniumhw.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class EditProjectPage extends PageObject {
    private final String projectName;

    private WebElement deleteButton;

    public EditProjectPage(WebDriver driver, WebDriverWait wait, String projectName) {
        super(driver, wait);
        this.projectName = projectName;
    }

    public void deleteProject() {
        deleteButton.click();
        driver.switchTo().alert().accept();
    }

    @Override
    public void load() {
        super.load();
        deleteButton = wait.until(elementToBeClickable(By.linkText("Delete Project")));
    }

    @Override
    public String getAddr() {
        return super.getAddr() + "/editProject/" + projectName;
    }
}
