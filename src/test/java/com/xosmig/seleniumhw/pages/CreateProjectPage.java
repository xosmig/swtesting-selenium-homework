package com.xosmig.seleniumhw.pages;

import com.xosmig.seleniumhw.elements.Selector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CreateProjectPage extends PageObject {
    private WebElement nameInput;
    private WebElement idInput;
    private Selector projectLeadSelector;
    private WebElement descriptionInput;
    private WebElement saveButton;

    public CreateProjectPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        projectLeadSelector = new Selector(driver, wait);
    }

    public void setLead(String lead) {
        projectLeadSelector.select(String.format("%s (%s)", lead, lead));
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
        projectLeadSelector.find(By.id("id_l.C.EditProjectMain.projectLead"));
        descriptionInput = wait.until(visibilityOfElementLocated(By.id("id_l.C.EditProjectMain.projectDescr")));
        saveButton = wait.until(elementToBeClickable(By.id("id_l.C.EditProjectMain.saveProject")));
    }

    @Override
    public String getAddr() {
        return super.getAddr() + "/createProject";
    }
}
