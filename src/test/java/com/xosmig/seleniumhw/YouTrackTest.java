package com.xosmig.seleniumhw;

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

    @BeforeClass
    public static void driverInit() {
        URL driverUnix = Thread.currentThread().getContextClassLoader().getResource("geckodriver");
        URL driverWindows = Thread.currentThread().getContextClassLoader().getResource("geckodriver.exe");
        URL driverUrl = driverUnix != null ? driverUnix : driverWindows;
        assertNotNull(driverUrl);

        System.setProperty("webdriver.gecko.driver", driverUrl.getPath());
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public static void driverDeinit() {
        driver.close();
    }

    @Before
    public void login() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.load();
        loginPage.doLogin("root", "root");
    }

    @Test
    public void fooTest() {
        assertEquals(1, 1);
    }
}
