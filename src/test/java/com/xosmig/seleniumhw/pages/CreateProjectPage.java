package com.xosmig.seleniumhw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CreateProjectPage extends PageObject {
    public CreateProjectPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private WebElement nameInput;
    private WebElement idInput;
    private WebElement projectLeadSelector;
    private WebElement descriptionInput;
    private WebElement saveButton;

    public void setLead(String lead) {
        projectLeadSelector.click();
        WebElement leadButton = wait.until(elementToBeClickable(
                By.cssSelector(String.format("li[title='%s (%s)']", lead, lead))));
        leadButton.click();
    }

    public void save() {
        saveButton.click();
    }

    public void doCreateProject(String name, String id, String lead, String description) {
        nameInput.sendKeys(name);
        idInput.sendKeys(id);
        setLead(lead);
        descriptionInput.sendKeys(description);
        save();
    }

    @Override
    public void load() {
        super.load();
        nameInput = wait.until(visibilityOfElementLocated(By.id("id_l.C.EditProjectMain.projectName")));
        idInput = wait.until(visibilityOfElementLocated(By.id("id_l.C.EditProjectMain.shortName")));
        projectLeadSelector = wait.until(elementToBeClickable(By.id("id_l.C.EditProjectMain.projectLead")));
        descriptionInput = wait.until(visibilityOfElementLocated(By.id("id_l.C.EditProjectMain.projectDescr")));
        saveButton = wait.until(elementToBeClickable(By.id("id_l.C.EditProjectMain.saveProject")));
    }

    @Override
    public String getAddr() {
        return super.getAddr() + "/createProject";
    }
}
