package com.xosmig.seleniumhw.pages;

import com.xosmig.seleniumhw.Issue;
import com.xosmig.seleniumhw.elements.CreateIssueForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class IssuesPage extends PageObject {

    WebElement createIssueButton;
    WebElement issuesList;

    public IssuesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public CreateIssueForm openCreateIssueForm() {
        createIssueButton.click();
        CreateIssueForm form = new CreateIssueForm(driver, wait);
        form.find();
        return form;
    }

    public void createIssue(String projectName, Issue issue) {
        openCreateIssueForm().doCreateIssue(projectName, issue);
    }

    public Issue getLastIssue() {
        WebElement issueContainer = issuesList.findElement(By.cssSelector("div[cn='l.I.c.il.i.issueContainer']"));

        WebElement expandButton = issueContainer.findElement(By.cssSelector("a[cn='l.I.c.il.i.vi.collapse']"));
        expandButton.click();

        String summary = issueContainer.findElement(By.className("issue-summary")).getText();
        String description = issueContainer.findElement(By.className("description")).getText();
        return new Issue(summary, description);
    }

    @Override
    public void load() {
        super.load();
        createIssueButton = wait.until(elementToBeClickable(By.cssSelector("a[href='#newissue=yes']")));
        issuesList = wait.until(visibilityOfElementLocated(By.id("id_l.I.c.il.issueList")));
    }

    @Override
    public String getAddr() {
        return super.getAddr() + "/issues";
    }
}
