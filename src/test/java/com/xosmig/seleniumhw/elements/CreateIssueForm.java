package com.xosmig.seleniumhw.elements;

import com.xosmig.seleniumhw.Issue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CreateIssueForm extends PageElement {
    private Selector projectSelector;
    private WebElement summaryInput;
    private WebElement descriptionInput;
    private WebElement submitButton;

    public CreateIssueForm(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        projectSelector = new Selector(driver, wait);
    }

    public void doCreateIssue(String projectName, Issue issue) {
        projectSelector.select(projectName);
        summaryInput.clear();
        summaryInput.sendKeys(issue.getSummary());
        descriptionInput.clear();
        descriptionInput.sendKeys(issue.getDescription());
        submitButton.click();
    }

    public WebElement getSummaryInput() {
        return summaryInput;
    }

    public WebElement getDescriptionInput() {
        return descriptionInput;
    }

    public void find() {
        projectSelector.find(By.id("id_l.I.ni.ei.eit.project"));
        summaryInput = wait.until(visibilityOfElementLocated(By.id("id_l.I.ni.ei.eit.summary")));
        descriptionInput = wait.until(visibilityOfElementLocated(By.id("id_l.I.ni.ei.eit.description")));
        submitButton = wait.until(elementToBeClickable(By.cssSelector("button[cn='l.I.ni.ei.submitButton']")));
    }
}
