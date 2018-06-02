package com.xosmig.seleniumhw;

import com.xosmig.seleniumhw.pages.CreateProjectPage;
import com.xosmig.seleniumhw.pages.EditProjectPage;
import com.xosmig.seleniumhw.pages.LoginPage;
import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class YouTrackTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void driverInit() {
        URL driverUnix = Thread.currentThread().getContextClassLoader().getResource("geckodriver");
        URL driverWindows = Thread.currentThread().getContextClassLoader().getResource("geckodriver.exe");
        URL driverUrl = driverUnix != null ? driverUnix : driverWindows;
        assertNotNull(driverUrl);

        System.setProperty("webdriver.gecko.driver", driverUrl.getPath());
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
    }

    public static void driverDeinit() {
        driver.close();
    }

    public static void login() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.load();
        loginPage.doLogin("root", "root");
    }

    public static void createProject(String name) {
        CreateProjectPage createProjectPage = new CreateProjectPage(driver, wait);
        createProjectPage.load();
        createProjectPage.doCreateProject(name, name, "root", "A project for testing.");
    }

    public static void deleteProject(String name) {
        EditProjectPage editProjectPage = new EditProjectPage(driver, wait, name);
        editProjectPage.load();
        editProjectPage.deleteProject();
    }

    @BeforeClass
    public static void init() {
        driverInit();
        login();
        createProject("testProject1");
    }

    @AfterClass
    public static void deinit() {
        deleteProject("testProject1");
        driver.close();
    }

    @Test
    public void fooTest() throws InterruptedException {
        assertEquals(1, 1);
        Thread.sleep(2000);
    }
}
